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
    //soundNameList
    private ArrayList<String> soundNamesList;

    private ArrayList<String> soundFilePaths;


    private Map<String, String> soundMap;
    //sound name for showing
    private ArrayList<String> soundNameshow; // for the appearance of sound


    public AudibleInstruction(String title, String content, String buttonText,String helpText){
      super(title, content);
      this.content=content;
      this.title= title;
        this.buttonText= buttonText;
        this.helpText = helpText;
        soundMap = new HashMap<>();
        soundFilePaths = new ArrayList<>();
        soundNameshow = new ArrayList<>();
        soundNameshow.add("Whispering Wind");
        soundNameshow.add("Ocean Waves");
        soundNameshow.add("Forest Rain");
        soundNameshow.add("City Ambiance");
        soundNameshow.add("Rustling Leaves");
        soundNameshow.add("Rusty Doorbell");
        soundNameshow.add("Thunderstorm");
        soundNameshow.add("Crackling Fire");
        soundNameshow.add("Gentle Stream");
        soundNameshow.add("Birdsong at Dawn");
        soundNameshow.add("Heartbeat");
        soundNameshow.add("Clock Ticking");
        soundNameshow.add("Humming Engine");
        soundNameshow.add("Keyboard Typing");
        soundNameshow.add("Footsteps on Gravel");
        soundNameshow.add("Distant Thunder");
        soundNameshow.add("Running Water");
        soundNameshow.add("Church Bells");
        soundNameshow.add("Campfire");
        soundNameshow.add("Birds Chirping");
        soundNameshow.add("Sizzling Bacon");
        soundNameshow.add("Breeze Through Trees");
        soundNameshow.add("Crashing Waves");
        soundNameshow.add("Coffee Brewing");
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





