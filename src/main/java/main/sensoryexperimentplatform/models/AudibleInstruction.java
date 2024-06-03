package main.sensoryexperimentplatform.models;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class AudibleInstruction {
    private String title;
    private String content;
    private String soundFilePath;
    public AudibleInstruction(String title, String content){
        this.title=title;
        this.content = content;


    }
    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }
    public String getSoundFilePath() {
        return soundFilePath;
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
