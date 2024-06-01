package main.sensoryexperimentplatform.ViewModel;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import main.sensoryexperimentplatform.models.Experiment;
import main.sensoryexperimentplatform.models.Input;
import main.sensoryexperimentplatform.models.Notice;

public class noticeStage_VM {
    private StringProperty titleText;
    private StringProperty contentText;
    private StringProperty buttonText ;

    private StringProperty helpText ;

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



}
