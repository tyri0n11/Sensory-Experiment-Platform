package main.sensoryexperimentplatform.ViewModel;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import main.sensoryexperimentplatform.models.Experiment;
import main.sensoryexperimentplatform.models.Input;
import main.sensoryexperimentplatform.models.Notice;

public class noticeStage_VM {
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



}
