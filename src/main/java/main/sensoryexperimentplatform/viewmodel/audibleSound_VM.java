package main.sensoryexperimentplatform.viewmodel;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import main.sensoryexperimentplatform.SensoryExperimentPlatform;
import main.sensoryexperimentplatform.controllers.AudibleInstructionSingleton;
import main.sensoryexperimentplatform.controllers.addAudibleSoundController;
import main.sensoryexperimentplatform.models.AudibleInstruction;
import main.sensoryexperimentplatform.models.Experiment;

import java.io.IOException;
import java.util.Stack;

public class audibleSound_VM implements choose {
    private StringProperty title;
    private StringProperty content;
    private StringProperty helpText;
    private StringProperty buttonText;
    private AudibleInstruction audibleInstruction;
    private Experiment experiment;

    public audibleSound_VM(Experiment experiment){
        this.experiment = experiment;
        this.audibleInstruction = AudibleInstructionSingleton.getInstance();
        this.title = new SimpleStringProperty(AudibleInstructionSingleton.getInstance().getTitle());
        this.content = new SimpleStringProperty(AudibleInstructionSingleton.getInstance().getContent());
        this.buttonText = new SimpleStringProperty(AudibleInstructionSingleton.getInstance().getButtonText());
        this.helpText = new SimpleStringProperty(AudibleInstructionSingleton.getInstance().getButtonText());

        buttonText.addListener((observable, oldValue, newValue) -> {
            setButtonText(newValue);

        });

        helpText.addListener((observable, oldValue, newValue) -> {
            setHelpText(newValue);
        });
        title.addListener((observable, oldValue, newValue) -> {
           setTitle(newValue);

        });
        content.addListener((observable, oldValue, newValue) -> {
            setTitle(newValue);
        });
    }
//    public audibleSound_VM(Experiment experiment){
//        this.experiment = experiment;
//        this.audibleInstruction = new AudibleInstruction("Hello","hello","hello","hello");
//        this.title = new SimpleStringProperty(audibleInstruction.getTitle());
//        this.content = new SimpleStringProperty(audibleInstruction.getContent());
//        this.buttonText = new SimpleStringProperty(audibleInstruction.getButtonText());
//        this.helpText = new SimpleStringProperty(audibleInstruction.getButtonText());
//
//        buttonText.addListener((observable, oldValue, newValue) -> {
//            setButtonText(newValue);
//
//        });
//
//        helpText.addListener((observable, oldValue, newValue) -> {
//            setHelpText(newValue);
//        });
//        title.addListener((observable, oldValue, newValue) -> {
//            setTitle(newValue);
//
//        });
//        content.addListener((observable, oldValue, newValue) -> {
//            setTitle(newValue);
//        });
//        experiment.addAudibleInstruction(audibleInstruction);
//
//    }

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
    public void setHelpText(String newValue) {audibleInstruction.setContent(newValue);
    }
//    public void setQuestion(String newValue) {
//        this.audibleInstruction.setTitle(newValue);
//    }
    public void setButtonText(String newValue) {
        AudibleInstructionSingleton.getInstance().setButtonText(newValue);
    }
    public void setTitle(String newValue) {
        AudibleInstructionSingleton.getInstance().setTitle(newValue);
    }
    public void setContent(String newValue) {
        AudibleInstructionSingleton.getInstance().setContent(newValue);
    }
    public AudibleInstruction getAudibleInstruction(){
        return AudibleInstructionSingleton.getInstance();
    }



    @Override
    public void modify(AnchorPane anchorPane,Stack<AddTasteVM> stack, Stack <AddCourseVM> add) throws IOException {

    }

    @Override
    public void modifyWithButton(AnchorPane anchorPane, Stack<AddTasteVM> stack, Stack <AddCourseVM> add, Button button1, Button button2, Button btn_assignSound, Button button4, Button button5, Button button6, Button button7, Button button8, Button button9, Button button10, Button button11, Button button12, Stack<ratingContainer_VM> ratingContainerVm) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(SensoryExperimentPlatform.class.getResource("AddAudibleSound.fxml"));
        AnchorPane newContent = fxmlLoader.load();
        anchorPane.getChildren().setAll(newContent);
        addAudibleSoundController controller = fxmlLoader.getController();
        controller.setViewModel(this);
               btn_assignSound.setDisable(false);
    }
    @Override
    public String getTitle(){
        return "[Audio] "+ AudibleInstructionSingleton.getInstance().getTitle();
    }
}
