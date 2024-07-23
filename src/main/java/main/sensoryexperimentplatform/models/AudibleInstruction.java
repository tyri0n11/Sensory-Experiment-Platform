package main.sensoryexperimentplatform.models;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AudibleInstruction extends Stage {
    private String title;
    private String content;

    private String buttonText;
    private String helpText;
    private ArrayList<String> soundNamesList;

    private ArrayList<String> soundFilePaths;


    private Map<String, String> soundMap;
    private ArrayList<String> soundNameshow;


    public AudibleInstruction(String title, String content, String buttonText,String helpText){
      super(title, content);
      this.content=content;
      this.title= title;
        this.buttonText= buttonText;
        this.helpText = helpText;
        soundMap = new HashMap<>();
        soundFilePaths = new ArrayList<>();
        soundNameshow = new ArrayList<>();
        soundNameshow.add("music");
        soundNameshow.add("gud morning");
        soundNameshow.add("quynh anh");
        soundNameshow.add("quynh anh");
        soundNameshow.add("quynh anh");
        soundNameshow.add("skylar");
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


    public List<String> getSoundFilePaths() {
        return soundFilePaths;
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
    public Map<String, String> getSoundMap() {
        return soundMap;
    }
    public void addSound(String name, String filePath) {
        soundMap.put(name, filePath);
    }


//    public String getSoundFilePath(String name) {
//        return soundMap.get(name);
//    }


    public String toString() {

            return "Audio(\"" + title + "\",\"" + content +
                    "\",\"" + buttonText + "\",\"" + helpText + "\")";
        }
    }





