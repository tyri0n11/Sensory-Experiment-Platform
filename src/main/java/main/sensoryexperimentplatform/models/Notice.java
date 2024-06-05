package main.sensoryexperimentplatform.models;

<<<<<<< HEAD
=======
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import main.sensoryexperimentplatform.SensoryExperimentPlatform;
import main.sensoryexperimentplatform.ViewModel.noticeStage_VM;
import main.sensoryexperimentplatform.controllers.NoticeStageController;

import java.io.IOException;

>>>>>>> 7a2212825dec188091988102bf0da9285f466266
public class Notice extends Stage {
    private String buttonText;
    private String content;
    private String helpText;
    private boolean alert;

    public Notice(String title, String content) {
        super(title,content);

    }
    public Notice(String title, String content, String buttonText, String helpText, boolean alert){
        super(title,content);
        this.content = content;
        this.buttonText = buttonText;
        this.helpText = helpText;
        this.alert = alert;
    }

    public boolean isAlert() {
        return alert;
    }

    public void setAlert(boolean alert) {
        this.alert = alert;
    }

    public String getHelpText() {
        return helpText;
    }

    public void setHelpText(String helpText) {
        this.helpText = helpText;
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
        return "Notice";
    }
    @Override
    public String toString() {
        return "noticeStage(\"" + title + "\",\"" + content + "\",\"" +
                buttonText + "\",\"" + helpText + "\",\"" + alert+ "\")";
    }


}


