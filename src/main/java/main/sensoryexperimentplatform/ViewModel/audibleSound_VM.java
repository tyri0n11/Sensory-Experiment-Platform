package main.sensoryexperimentplatform.ViewModel;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import main.sensoryexperimentplatform.models.AudibleInstruction;

public class audibleSound_VM {
    private StringProperty title;
    private StringProperty content;
    private StringProperty helpText;
    private StringProperty buttonText;
    private AudibleInstruction audibleInstruction;

    public audibleSound_VM(){
        this.audibleInstruction = new AudibleInstruction("Hello","hello","hello","hello");
        title = new SimpleStringProperty(audibleInstruction.getTitle());
        content = new SimpleStringProperty(audibleInstruction.getContent());
        buttonText = new SimpleStringProperty(audibleInstruction.getButtonText());
        helpText = new SimpleStringProperty(audibleInstruction.getButtonText());
    }
    public StringProperty titleProperty() {
        return title;
    }

    public StringProperty contentProperty() {
        return content;
    }

    public StringProperty buttonTextProperty() {
        return buttonText;
    }
    public StringProperty helpTextProperty() {
        return helpText;
    }

    public String getTitle(){
        return title.get();
    }
    public String getContent(){
        return content.get();
    }
    public String getButton(){
        return buttonText.get();
    }
    public String getHelpText(){
        return helpText.get();
    }
    public void setHelpText(String newValue) {
        audibleInstruction.setContent(newValue);
    }
    public void setQuestion(String newValue) {
        audibleInstruction.setTitle(newValue);
    }
    public void setButtonText(String newValue) {
        audibleInstruction.setButtonText(newValue);
    }
    public void setTitle(String newValue) {
        audibleInstruction.setTitle(newValue);
    }
    public void setContent(String newValue) {
        audibleInstruction.setContent(newValue);
    }
    public AudibleInstruction getAudibleInstruction(){
        return audibleInstruction;
    }



}
