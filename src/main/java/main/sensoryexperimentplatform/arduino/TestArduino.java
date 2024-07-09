package main.sensoryexperimentplatform.arduino;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import com.fazecast.jSerialComm.SerialPort;
public class TestArduino {
    public static void main(String[] args) {
        final SerialPort comPort = SerialPort.getCommPort("/dev/cu.usbserial-1130"); // Assign COM Port accordingly

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
        try (FileWriter writer = new FileWriter("/Users/macbook/Documents/VS code/Sensory-Experiment-Platform/src/main/java/main/sensoryexperimentplatform/arduino/scale_data.txt", true)) {
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

                    // Write received data to file
                    try {
                        writer.write(receivedData);
                        writer.flush();
                    } catch (IOException e) {
                        e.printStackTrace();
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