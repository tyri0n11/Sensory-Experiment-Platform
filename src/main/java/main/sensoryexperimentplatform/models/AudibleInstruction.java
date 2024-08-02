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



    public AudibleInstruction(String title, String content, String buttonText,String helpText){
      super(title, content);
      this.content=content;
      this.title= title;
        this.buttonText= buttonText;
        this.helpText = helpText;


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



    public String toString() {

            return "audio(\"" + title + "\",\"" + content +
                    "\",\"" + buttonText + "\",\"" + helpText + "\")";
        }
    }





