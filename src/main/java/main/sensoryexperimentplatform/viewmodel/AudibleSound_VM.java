package main.sensoryexperimentplatform.viewmodel;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import main.sensoryexperimentplatform.SensoryExperimentPlatform;
import main.sensoryexperimentplatform.controllers.AddAudibleSoundController;
import main.sensoryexperimentplatform.controllers.SoundSingleton;
import main.sensoryexperimentplatform.models.AudibleInstruction;
import main.sensoryexperimentplatform.models.Experiment;
import main.sensoryexperimentplatform.models.Sound;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Stack;

public class AudibleSound_VM implements Stages {
    private StringProperty title;
    private StringProperty content;
    private StringProperty helpText;
    private StringProperty buttonText;
    private StringProperty soundName;
    private AudibleInstruction audibleInstruction;
    private Sound sound;
    private AssignSoundVM assignSoundVM;
    private Experiment experiment;

    public AudibleSound_VM(Experiment experiment) throws UnsupportedAudioFileException, LineUnavailableException, IOException, URISyntaxException {
        this.experiment = experiment;
        this.audibleInstruction = new AudibleInstruction("Default Notice Stage", null, null,null,null);
        this.sound = new Sound();
        this.title = new SimpleStringProperty(audibleInstruction.getTitle());
        this.content = new SimpleStringProperty(audibleInstruction.getContent());
        this.buttonText = new SimpleStringProperty(audibleInstruction.getButtonText());
        this.helpText = new SimpleStringProperty(audibleInstruction.getHelpText());
        this.soundName = new SimpleStringProperty(audibleInstruction.getSoundName());
        this.sound = SoundSingleton.getInstance();
        experiment.addAudibleInstruction(audibleInstruction);

    }
    public AudibleSound_VM(AudibleInstruction audibleInstruction) throws UnsupportedAudioFileException, LineUnavailableException, IOException, URISyntaxException {
        this.audibleInstruction = audibleInstruction;
        this.title = new SimpleStringProperty(audibleInstruction.getTitle());
        this.content = new SimpleStringProperty(audibleInstruction.getContent());
        this.buttonText = new SimpleStringProperty(audibleInstruction.getButtonText());
        this.helpText = new SimpleStringProperty(audibleInstruction.getHelpText());
        this.soundName = new SimpleStringProperty(audibleInstruction.getSoundName());
        this.sound = sound;

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

    public String getContent(){
        return content.get();
    }
    public String getButton(){
        return buttonText.get();
    }
    public String getHelpText(){
        return helpText.get();
    }
    public void setHelpText(String newValue) {audibleInstruction.setHelpText(newValue);

    }


    public void setButtonText(String newValue) {;
        audibleInstruction.setButtonText(newValue);
    }
    public void setTitle(String newValue) {
        audibleInstruction.setTitle(newValue);
    }
    public void setContent(String newValue) {
        audibleInstruction.setContent(newValue);
    }

    public void setSoundName(String name) {
        audibleInstruction.setSoundName(name);
    }
    public String getSoundName(){
        return audibleInstruction.getSoundName();
    }
    public StringProperty soundNameProperty() {
        return soundName;
    }

    public AudibleInstruction getAudibleInstruction(){
        return audibleInstruction;
    }






    @Override
    public void loadInterface(AnchorPane anchorPane,Stack<AddTasteVM> stack, Stack <AddCourseVM> add) throws IOException {

    }

    @Override
    public void handleMenuButtons(AnchorPane anchorPane, Stack<AddTasteVM> stack, Stack <AddCourseVM> add, Button button1, Button button2, Button btn_assignSound, Button button4, Button button5, Button button6, Button button7, Button button8, Button button9, Button button10, Button button11, Button button12, Stack<ratingContainer_VM> ratingContainerVm) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(SensoryExperimentPlatform.class.getResource("AddAudibleSound.fxml"));
        AnchorPane newContent = fxmlLoader.load();
        anchorPane.getChildren().setAll(newContent);
        AddAudibleSoundController controller = fxmlLoader.getController();
        controller.setViewModel(this);
               btn_assignSound.setDisable(false);
    }
    @Override
    public String toString() {
        return "[Audio] " + audibleInstruction.getTitle();
    }

}
