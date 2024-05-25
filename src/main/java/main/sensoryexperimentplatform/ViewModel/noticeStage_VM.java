package main.sensoryexperimentplatform.ViewModel;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import main.sensoryexperimentplatform.models.Notice;

public class noticeStage_VM {
    private String titleText;
    private String contentText;
    private SimpleStringProperty buttonText = new SimpleStringProperty();

    private SimpleStringProperty helpText = new SimpleStringProperty();

    private SimpleBooleanProperty alert = new SimpleBooleanProperty();
    private Notice noticeStage;

    public noticeStage_VM(Notice noticeStage) {
        this.titleText = "Default title text";
        this.contentText = "Default content text";
        this.noticeStage = noticeStage;
        this.buttonText = new SimpleStringProperty();
        this.helpText = new SimpleStringProperty();
        this.alert = new SimpleBooleanProperty();
    }

    public String getButtonText() {
        return buttonText.get();
    }

    public SimpleStringProperty buttonTextProperty() {
        return buttonText;
    }

    public void setButtonText(String buttonText) {
        this.buttonText.set(buttonText);
    }

    public String getHelpText() {
        return helpText.get();
    }

    public SimpleStringProperty helpTextProperty() {
        return helpText;
    }

    public void setHelpText(String helpText) {
        this.helpText.set(helpText);
    }

    public boolean isAlert() {
        return alert.get();
    }

    public SimpleBooleanProperty alertProperty() {
        return alert;
    }

    public void setAlert(boolean alert) {
        this.alert.set(alert);
    }

    public Notice getNoticeStage() {
        return noticeStage;
    }

    public void setNoticeStage(Notice noticeStage) {
        this.noticeStage = noticeStage;
    }
}
