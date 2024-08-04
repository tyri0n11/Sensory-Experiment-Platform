package main.sensoryexperimentplatform.models;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Sound {
    private ArrayList<String> soundFilePaths;


    private Map<String, Clip> soundMap;
    //sound name for showing
    private java.util.ArrayList<String> soundNameshow; // for the appearance of sound


    public Sound(){
        soundMap = new HashMap<>();
        soundNameshow = new ArrayList<>();
        soundNameshow.add("boop");
        loadSound("boop","src/main/java/main/sensoryexperimentplatform/sound/boop-741-mhz-39314.wav");
        loadSound("stomp","src/main/java/main/sensoryexperimentplatform/sound/stompwav-14753.wav");
        soundNameshow.add("stomp");

    }
    public ArrayList<String> getSoundNameshow() {
        return soundNameshow;
    }
    public void addSoundShow(String name){
        soundNameshow.add(name);
    }


    public  ArrayList<String>getSoundFilePath(){
        return soundFilePaths;
    }
    public void addSoundFilePath(String sound){
        soundFilePaths.add(sound);
    }
    public Map<String, Clip> getSoundMap() {
        return soundMap;
    }

    public void loadSound(String name, String filePath) {
        try {
            File soundFile = new File(filePath);

            if (!soundFile.exists()) {
                throw new IllegalArgumentException("Sound file not found: " + filePath);
            }

            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            soundMap.put(name, clip);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }


    public void playSound(String name) {
        Clip clip = soundMap.get(name);
        if (clip != null) {
            stopAllSounds();
            clip.start();
        }
    }

    public void stopSound(String name) {
        Clip clip = soundMap.get(name);
        if (clip != null) {
            clip.stop();
            clip.setFramePosition(0);
        }
    }

    public void stopAllSounds() {
        for (Clip clip : soundMap.values()) {
            if (clip.isRunning()) {
                clip.stop();
            }
        }
    }




}
