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

    public noticeStage_VM(Notice noticeStage) {
        this.noticeStage = noticeStage;
        this.buttonText = new SimpleStringProperty();
        this.helpText = new SimpleStringProperty();
        this.alert = new SimpleBooleanProperty();
    }
    public void addNoticeStage() {

        String title = this.title.get();
        String content = this.content.get();
        String buttonText = this.buttonText.get();
        String helpText = this.helpText.get();
        boolean alert = this.alert.get();
        Notice stage = new Notice(title, content, buttonText,helpText, alert);
        experiment.addInputStage(title, content, buttonText, alert);
//        stages.add(stage);

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

    public BooleanProperty alertProperty() {
        return alert;
    }


    public Notice getNoticeStage() {
        return noticeStage;
    }

    public StringProperty titleProperty() {
        return title;
    }

    public StringProperty contentProperty() {
        return content;
    }



}
