
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
    private String soundFilePath;
    private String buttonText;
    private String helpText;
    private List<String> soundNames;
    private List<String> soundFilePaths;
    //    private Map<String, String> soundMap;
    private List<String> soundNameshow;

    public AudibleInstruction(String title, String content, String buttonText,String helpText){
        super(title, content);
        this.content=content;
        this.title= title;
        this.buttonText= buttonText;
        this.helpText = helpText;
        soundNames = new ArrayList<>();
        soundFilePaths = new ArrayList<>();
        soundNames.add("hello");
        soundNames.add("1");
        soundNames.add("2");
        soundNames.add("3");
        soundNames.add("aaaaaa");

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
    public List<String> getSoundNames() {
        System.out.println("hello");
        return soundNames;
    }

    public List<String> getSoundFilePaths() {
        return soundFilePaths;
    }

    public void addSound(String name, String soundFilePath) {
        soundNames.add(name);
        soundFilePaths.add(soundFilePath);
//        soundMap.put(name, soundFilePath);
    }



    public String toString() {

        return "Audio(\"" + title + "\",\"" + content +
                "\",\"" + buttonText + "\",\"" + helpText + "\")";
    }
}