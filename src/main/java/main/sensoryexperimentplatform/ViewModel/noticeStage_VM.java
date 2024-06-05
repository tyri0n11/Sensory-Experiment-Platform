package main.sensoryexperimentplatform.ViewModel;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import main.sensoryexperimentplatform.SensoryExperimentPlatform;
import main.sensoryexperimentplatform.controllers.NoticeStageController;
import main.sensoryexperimentplatform.models.Experiment;
import main.sensoryexperimentplatform.models.Input;
import main.sensoryexperimentplatform.models.Notice;

import java.io.IOException;

public class noticeStage_VM implements choose{
    private StringProperty buttonText ;

    private StringProperty helpText ;

    private BooleanProperty alert;
    private StringProperty title;
    private StringProperty content;
    private Notice noticeStage;
    private Experiment experiment;
    private Notice notice;

    public noticeStage_VM() {
        this.notice = new Notice("User input", "This is question","this is button", "hell00",false);
        this.buttonText = new SimpleStringProperty(notice.getButtonText());
        this.helpText = new SimpleStringProperty(notice.getHelpText());
        this.alert = new SimpleBooleanProperty(notice.isAlert());
        this.title = new SimpleStringProperty(notice.getTitle());
        this.content = new SimpleStringProperty(notice.getContent());

    }
    public void addNoticeStage() {
        String title = this.title.get();
        String content = this.content.get();
        String buttonText = this.buttonText.get();
        String helpText = this.helpText.get();
        boolean alert = this.alert.get();
        Notice stage = new Notice(title, content, buttonText,helpText, alert);
        experiment.addNoticeStage(title, content, buttonText,helpText, alert);
    }


    public String getButtonText() {
        return buttonText.get();
    }
    public String getHelpText() {
        return helpText.get();
    }
    public String getContentText() {
        return content.get();
    }
    public String getTitleText() {
        return title.get();
    }
    public boolean getAlert(){
        return alert.get();
    }



    public StringProperty buttonTextProperty() {
        return buttonText;
    }

//
    public StringProperty helpTextProperty() {
        return helpText;
    }



    public BooleanProperty alertProperty() {
        return alert;
    }


    public StringProperty titleProperty() {
        return title;
    }

    public StringProperty contentProperty() {
        return content;
    }
    public void setHelpText(String newValue) {
        notice.setContent(newValue);
    }
    public void setTitle(String newValue) {
        notice.setTitle(newValue);
    }
    public void setContent(String newValue) {
        notice.setTitle(newValue);
    }


    public void setButtonText(String newValue) {
        notice.setButtonText(newValue);
    }
    public void setAlert(Boolean newValue) {
        notice.setAlert(newValue);
    }
    public Notice getNotice(){
        return notice;
    }


    @Override
    public void modify(AnchorPane anchorPane) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(SensoryExperimentPlatform.class.getResource("AddNoticeStage.fxml"));
        AnchorPane newContent = fxmlLoader.load();
        anchorPane.getChildren().setAll(newContent);
        NoticeStageController controller = new NoticeStageController();
        noticeStage_VM viewModel = new noticeStage_VM();
        controller.setNoticeStage_vm(viewModel);

    }

    @Override
    public void modifyWithButton(AnchorPane anchorPane, Button button1, Button button2, Button button3, Button button4, Button button5, Button button6, Button button7, Button button8, Button button9, Button button10, Button button11, Button button12, Button button13) throws IOException {

    }
}
