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
    private StringProperty titleText;
    private StringProperty contentText;

    private BooleanProperty alert;

    private Notice notice;
    private Experiment experiment;
    public noticeStage_VM(Notice noticeStage) {
        this.notice = noticeStage;
        this.titleText = new SimpleStringProperty(noticeStage.getTitle());
        this.contentText = new SimpleStringProperty(noticeStage.getContent());
        this.buttonText = new SimpleStringProperty(noticeStage.getButtonText());
        this.helpText = new SimpleStringProperty(noticeStage.getHelpText());
        this.alert = new SimpleBooleanProperty(noticeStage.isAlert());
    }
    public noticeStage_VM() {
        this.notice = new Notice("User input", "This is question","this is button", "hell00",false);
        this.buttonText = new SimpleStringProperty(notice.getButtonText());
        this.helpText = new SimpleStringProperty(notice.getHelpText());
        this.alert = new SimpleBooleanProperty(notice.isAlert());
        this.titleText = new SimpleStringProperty(notice.getTitle());
        this.contentText = new SimpleStringProperty(notice.getContent());

    }
//    public void addNoticeStage(Notice ) {
//        String title = this.titleText.get();
//        String content = this.contentText.get();
//        String buttonText = this.buttonText.get();
//        String helpText = this.helpText.get();
//        boolean alert = this.alert.get();
//        Notice stage = new Notice(title, content, buttonText,helpText, alert);
//        experiment.addNoticeStage(title, content, buttonText,helpText, alert);
//    }

    public void setNotice(Notice notice) {
        this.notice = notice;
    }

    public String getButtonText() {
        return buttonText.get();
    }
    public String getHelpText() {
        return helpText.get();
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

    public StringProperty titleProperty() {
        return titleText;
    }

    public StringProperty contentProperty() {
        return contentText;
    }
    public void setHelpText(String newValue) {
        notice.setHelpText(newValue);
    }
    public void setTitle(String newValue) {
        notice.setTitle(newValue);
    }
    public void setContent(String newValue) {
        notice.setContent(newValue);
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
        controller.setViewModel(viewModel);

    }

    @Override
    public void modifyWithButton(AnchorPane anchorPane, Button button1, Button button2, Button button3, Button button4, Button button5, Button button6, Button button7, Button button8, Button button9, Button button10, Button button11, Button button12, Button button13) throws IOException {

    }
}
