package main.sensoryexperimentplatform.arduino;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fazecast.jSerialComm.SerialPort;

public class TestArduino {
    public static void main(String[] args) {
        final SerialPort comPort = SerialPort.getCommPort("/dev/cu.usbserial-130"); // Assign COM Port accordingly

        if (comPort == null) {
            System.out.println("COM not found");
            return;
        }

        comPort.setBaudRate(9600);

        if (comPort.openPort()) {
            System.out.println("Port connected successfully!");
        } else {
            System.out.println("Unable to connect");
            return;
        }

        // Add a short delay after opening the port
        try {
            Thread.sleep(2000); // 2 seconds delay
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Open file writer to save data
        try (FileWriter writer = new FileWriter("scale_data.txt", true)) {
            StringBuilder scale1Data = new StringBuilder();
            StringBuilder scale2Data = new StringBuilder();
            final String[] calibrationFactor = {""};

            comPort.addDataListener(new com.fazecast.jSerialComm.SerialPortDataListener() {
                @Override
                public int getListeningEvents() {
                    return SerialPort.LISTENING_EVENT_DATA_AVAILABLE;
                }

                public void serialEvent(com.fazecast.jSerialComm.SerialPortEvent event) {
                    if (event.getEventType() != SerialPort.LISTENING_EVENT_DATA_AVAILABLE) {
                        return;
                    }

                    byte[] newData = new byte[comPort.bytesAvailable()];
                    comPort.readBytes(newData, newData.length);

                    String receivedData = new String(newData);
                    System.out.print(receivedData);

                    // Parse the received data
                    String[] lines = receivedData.split("\n");
                    for (String line : lines) {
                        if (line.contains("Scale 1 Reading")) {
                            scale1Data.setLength(0);
                            scale1Data.append(line.trim());
                        } else if (line.contains("Scale 2 Reading")) {
                            scale2Data.setLength(0);
                            scale2Data.append(line.trim());
                        } else if (line.contains("calibration_factor")) {
                            calibrationFactor[0] = line.trim();
                        }

                        // If both scale data are received, write them to the file
                        if (scale1Data.length() > 0 && scale2Data.length() > 0 && !calibrationFactor[0].isEmpty()) {
                            String formattedData = String.format("%s %s \\ %s\n", calibrationFactor[0], scale1Data, scale2Data);
                            try {
                                writer.write(formattedData);
                                writer.flush();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            scale1Data.setLength(0);
                            scale2Data.setLength(0);
                        }
                    }
                }
            });

            Scanner scanner = new Scanner(System.in);

            try {
                while (true) {
                    System.out.println("Enter 's' or 'e' to start or end counting");
                    String input = scanner.nextLine();

                    if (input.equalsIgnoreCase("s")) {
                        comPort.getOutputStream().write("s\n".getBytes());
                        comPort.getOutputStream().flush();
                        System.out.println("Sent 's' command!");
                    } else if (input.equalsIgnoreCase("e")) {
                        comPort.getOutputStream().write("e\n".getBytes());
                        comPort.getOutputStream().flush();
                        System.out.println("Sent 'e' command!");
                    } else if (input.equalsIgnoreCase("exit")) {
                        System.out.println("Exiting program.");
                        break;
                    } else {
                        System.out.println("Invalid command. Please enter 's', 'e', or 'exit'.");
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                comPort.closePort();
                scanner.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
