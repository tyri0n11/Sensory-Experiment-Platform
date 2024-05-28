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
    private StringProperty title;
    private StringProperty content;
    private Notice noticeStage;
    private Experiment experiment;

    public noticeStage_VM(Notice noticeStage) {
        this.noticeStage = noticeStage;
        this.titleText = new SimpleStringProperty(noticeStage.getTitle());
        this.contentText = new SimpleStringProperty(noticeStage.getContent());
        this.buttonText = new SimpleStringProperty(noticeStage.getButtonText());
        this.helpText = new SimpleStringProperty(noticeStage.getHelpText());
        this.alert = new SimpleBooleanProperty(noticeStage.isAlert());
    }



    public StringProperty buttonTextProperty() {
        return buttonText;
    }

    public void setButtonText(String buttonText) {
        this.buttonText.set(buttonText);
    }


    public StringProperty helpTextProperty() {
        return helpText;
    }

    public boolean isAlert() {
        return alert.get();
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



}
