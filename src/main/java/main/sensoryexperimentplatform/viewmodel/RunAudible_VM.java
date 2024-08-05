package main.sensoryexperimentplatform.viewmodel;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import main.sensoryexperimentplatform.models.AudibleInstruction;

public class RunAudible_VM {
    private AudibleInstruction audibleInstruction;
    private StringProperty title, content, button,helpText;
    public RunAudible_VM(AudibleInstruction audibleInstruction) {
        this.audibleInstruction = audibleInstruction;
        title = new SimpleStringProperty(audibleInstruction.getTitle());
        content = new SimpleStringProperty(audibleInstruction.getContent());
        button = new SimpleStringProperty(audibleInstruction.getButtonText());
        helpText = new SimpleStringProperty(audibleInstruction.getHelpText());


    }
    public void setAudibleInstruction(AudibleInstruction audibleInstruction) {
     this.audibleInstruction = audibleInstruction;
    }
    public void playSound(){
        audibleInstruction.playSound(audibleInstruction.getSoundName());
        System.out.println(audibleInstruction.getSoundName());
    }
    public String test(){
        System.out.println(audibleInstruction.getSoundName());
        return audibleInstruction.getSoundName();
    }

    public StringProperty getTitle(){
        return title;
    }
    public StringProperty getContent(){
        return content;
    }
    public StringProperty getHelpText(){ return helpText;
    }

    public StringProperty getButton(){ return button; }
}
