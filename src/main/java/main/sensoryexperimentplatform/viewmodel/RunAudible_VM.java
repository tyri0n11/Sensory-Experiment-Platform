package main.sensoryexperimentplatform.viewmodel;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;
import main.sensoryexperimentplatform.models.AudibleInstruction;
import main.sensoryexperimentplatform.models.Notice;
import main.sensoryexperimentplatform.models.Sound;

public class RunAudible_VM {
    private AudibleInstruction audibleInstruction;
    private StringProperty title, content, button,helpText;
    private StringProperty soundName;


    public RunAudible_VM(AudibleInstruction audibleInstruction){
        this.audibleInstruction = audibleInstruction;
        button = new SimpleStringProperty(audibleInstruction.getButtonText());
        title = new SimpleStringProperty(audibleInstruction.getTitle());
        content = new SimpleStringProperty(audibleInstruction.getContent());
        soundName = new SimpleStringProperty(audibleInstruction.getSoundName());

        helpText = new SimpleStringProperty(audibleInstruction.getHelpText());

    }
    public StringProperty getTitle(){
        return title;
    }
    public StringProperty getContent(){
        return content;
    }
    public StringProperty getHelpText(){
        return helpText;
    }
    public StringProperty getSoundName(){
        return soundName;
    }
    public  void playSound(){
        audibleInstruction.playSound(audibleInstruction.getSoundName());
    }

    public StringProperty buttonProperty() {
        return button;
    }


}
