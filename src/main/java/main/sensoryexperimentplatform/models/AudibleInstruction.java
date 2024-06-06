package main.sensoryexperimentplatform.models;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class AudibleInstruction extends Stage {
    private String title;
    private String content;
    private String soundFilePath;
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

            return "Audio(\"" + title + "\",\"" + content +
                    "\",\"" + buttonText + "\",\"" + helpText + "\")";
        }
    }




//=======
//public class AudibleInstruction extends Stage{
//    private String title, content;
//    public AudibleInstruction(String title, String content){
//        super(title,content);
//        this.title = title;
//        this.content = content;
//    }
//}
//>>>>>>> b8828f0cd3a06a5502e2c2f6763efb2aef9a577c
