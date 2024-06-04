package main.sensoryexperimentplatform.ViewModel;

import javafx.beans.property.*;
import main.sensoryexperimentplatform.models.gLMS;

import java.text.SimpleDateFormat;
import java.util.Date;

public class RunGLMS_VM {
    private gLMS stage;
    private StringProperty question, help;
    private DoubleProperty sliderValue;
    private StringProperty button;
    private IntegerProperty time;

    public RunGLMS_VM(gLMS stage){
        this.stage = stage;
        help = new SimpleStringProperty(stage.getHelpText());
        question = new SimpleStringProperty(stage.getQuestionText());
        button = new SimpleStringProperty(stage.getButtonText());
        sliderValue = new SimpleDoubleProperty(stage.getResult());

        sliderValue.addListener(((observableValue, oldValue, newValue) ->{
            setResult(newValue.doubleValue());
            System.out.println(newValue + "\t" +time);
            setDate();
        } ));

    }
    public String getCurrentFormattedTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss.SSS");
        Date now = new Date();
        return sdf.format(now);
    }
    public void setDate(){
        stage.setConducted(getCurrentFormattedTime());
    }
    public void setResult(double result){
        stage.setResult(result);
    }
    public IntegerProperty timeProperty(){
        return time;
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
}
