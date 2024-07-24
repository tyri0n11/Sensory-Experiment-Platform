package main.sensoryexperimentplatform.viewmodel;

import javafx.beans.property.*;
import main.sensoryexperimentplatform.models.DataAccess;
import main.sensoryexperimentplatform.models.gLMS;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class RunGLMS_VM {
    private gLMS stage;
    private StringProperty question, help, conducted;
    private DoubleProperty sliderValue;
    private StringProperty button;

    public RunGLMS_VM(gLMS stage){
        this.stage = stage;
        help = new SimpleStringProperty(stage.getHelpText());
        question = new SimpleStringProperty(stage.getQuestionText());
        button = new SimpleStringProperty(stage.getButtonText());
        sliderValue = new SimpleDoubleProperty(stage.getResult());
        conducted = new SimpleStringProperty(stage.getConducted());

        sliderValue.addListener(((observableValue, oldValue, newValue) ->{
            setResult(newValue.intValue());
            conducted.set(DataAccess.getCurrentFormattedTime());
            setDate();
        } ));

    }

    public void setDate(){
        stage.setConducted(DataAccess.getCurrentFormattedTime());
    }
    public void setResult(int result){
        stage.setResult(result);
    }

    public StringProperty helpProperty(){
        return help;
    }
    public StringProperty questionProperty() {
        return question;
    }

    public StringProperty buttonProperty() {
        return button;
    }

    public DoubleProperty sliderValueProperty() {
        return sliderValue;
    }

    public StringProperty conductedTextProperty() {
        return conducted;
    }
}
