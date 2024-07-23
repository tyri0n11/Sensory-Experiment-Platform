package main.sensoryexperimentplatform.models;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Sound {
    private String soundFilePath;
    private String name;

    public Sound(String name, String soundFilePath){
        this.name = name;
        this.soundFilePath = soundFilePath;

    }


    public String getSoundFilePath() {
        return soundFilePath;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    public void setSoundFilePath(String soundFilePath) {
        this.soundFilePath = soundFilePath;
    }
    public void playSound() {
        if (soundFilePath != null) {
            try {
                File soundPath = new File(soundFilePath);
                AudioInputStream audioStream = AudioSystem.getAudioInputStream(soundPath);
                Clip clip = AudioSystem.getClip();
                clip.open(audioStream);
                clip.start();
                // Wait for the sound to finish playing
                Thread.sleep(clip.getMicrosecondLength() / 1000);
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException | InterruptedException e) {
                System.out.println("Error playing sound: " + e.getMessage());
            }
        } else {
            System.out.println("No sound file assigned.");
        }
    }
}
