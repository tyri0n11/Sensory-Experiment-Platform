package main.sensoryexperimentplatform.ViewModel;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import main.sensoryexperimentplatform.SensoryExperimentPlatform;
import main.sensoryexperimentplatform.controllers.addAudibleSoundController;
import main.sensoryexperimentplatform.models.AudibleInstruction;

import java.io.IOException;
import java.util.Stack;

public class audibleSound_VM implements choose {
    private StringProperty title;
    private StringProperty content;
    private StringProperty helpText;
    private StringProperty buttonText;
    private AudibleInstruction audibleInstruction;

    public audibleSound_VM(){
        this.audibleInstruction = new AudibleInstruction("Hello","hello","hello","hello");
        this.title = new SimpleStringProperty(audibleInstruction.getTitle());
        this.content = new SimpleStringProperty(audibleInstruction.getContent());
        this.buttonText = new SimpleStringProperty(audibleInstruction.getButtonText());
        this.helpText = new SimpleStringProperty(audibleInstruction.getButtonText());

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



    @Override
    public void modify(AnchorPane anchorPane,Stack<AddTasteVM> stack) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(SensoryExperimentPlatform.class.getResource("AddAudibleSound.fxml"));
               AnchorPane newContent = fxmlLoader.load();
                 anchorPane.getChildren().setAll(newContent);
                addAudibleSoundController controller = fxmlLoader.getController();
                controller.setViewModel(this);
//               btn_assignSound.setDisable(false);
    }

    @Override
    public void modifyWithButton(AnchorPane anchorPane, Stack<AddTasteVM> stack, Button button1, Button button2, Button button3, Button button4, Button button5, Button button6, Button button7, Button button8, Button button9, Button button10, Button button11, Button button12) throws IOException {

    }
    @Override
    public String getTitle(){
        return "[Audio] "+ audibleInstruction.getTitle();
    }
}
