package main.sensoryexperimentplatform.models;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class AudibleInstruction extends Stage {
    private String title;
    private String content;

    private String buttonText;
    private String helpText;
    //soundNameList
    private ArrayList<String> soundNamesList;

    private ArrayList<String> soundFilePaths;


    private Map<String, Clip> soundMap;
    //sound name for showing
    private ArrayList<String> soundNameshow; // for the appearance of sound


    public AudibleInstruction(String title, String content, String buttonText,String helpText){
      super(title, content);
      this.content=content;
      this.title= title;
        this.buttonText= buttonText;
        this.helpText = helpText;
        soundMap = new HashMap<>();
        soundNameshow = new ArrayList<>();
        soundNameshow.add("boop");
        soundNamesList = new ArrayList<>();

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
    public String getButtonText() {
        return buttonText;
    }

    public void setButtonText(String buttonText) {
        this.buttonText = buttonText;
    }

    public String getHelpText() {
        return helpText;
    }

    public void setHelpText(String helpText) {
        this.helpText = helpText;
    }


    public ArrayList<String> getSoundNameshow() {
        return soundNameshow;
    }
    public void addSoundShow(String name){
        soundNameshow.add(name);
    }
    public ArrayList<String>getSoundNameList(){
        return soundNamesList;
    }
    public void addSoundNameList(String name){
        soundNamesList.add(name);
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


    public void playSound(String name) {
        Clip clip = soundMap.get(name);
        if (clip != null) {
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

    public String toString() {

            return "Audio(\"" + title + "\",\"" + content +
                    "\",\"" + buttonText + "\",\"" + helpText + "\")";
        }
    }





