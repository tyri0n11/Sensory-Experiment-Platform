package main.sensoryexperimentplatform.models;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import main.sensoryexperimentplatform.SensoryExperimentPlatform;
import main.sensoryexperimentplatform.ViewModel.inputStage_VM;
import main.sensoryexperimentplatform.controllers.InputStageController;

import java.io.IOException;

public class Input extends Stage{
    private String buttonText;
    private boolean alert;
    public Input(String title, String content) {
        super(title, content);
    }
    public Input(String title, String content,String buttonText, boolean alert) {
        super(title, content);
        this.buttonText = buttonText;
        this.alert = alert;
    }

    public boolean isAlert() {
        return alert;
    }

    public void setAlert(boolean alert) {
        this.alert = alert;
    }

    public String getButtonText() {
        return buttonText;
    }

    public void setButtonText(String buttonText) {
        this.buttonText = buttonText;
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
    public String getType(){
        return "Input";
    }

    @Override
    public String toString() {
        return "inputStage(\"" + title + "\",\"" + content + "\",\"" +
                buttonText + "\",\""+ alert + "\")";
    }

}