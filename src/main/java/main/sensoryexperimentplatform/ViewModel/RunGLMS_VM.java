package main.sensoryexperimentplatform.ViewModel;

import javafx.beans.property.*;
import main.sensoryexperimentplatform.models.gLMS;

public class RunGLMS_VM {
    private gLMS stage;
    private StringProperty question, result, help;
    private DoubleProperty sliderValue;
    private StringProperty button;

    public RunGLMS_VM(gLMS stage){
        this.stage = stage;
        help = new SimpleStringProperty(stage.getHelpText());
        result = new SimpleStringProperty(String.format("%.2f",stage.getResult()));
        question = new SimpleStringProperty(stage.getQuestionText());
        button = new SimpleStringProperty(stage.getButtonText());
        sliderValue = new SimpleDoubleProperty(stage.getResult());

        sliderValue.addListener(((observableValue, oldValue, newValue) ->{
            setResult(newValue.doubleValue());
            result.set(String.format("%.2f",newValue.doubleValue()));
        } ));

    }
    public void setResult(double result){
        stage.setResult(result);
    }

    public StringProperty helpProperty(){
        return help;
    }
    public StringProperty questionProperty() {
        return question;
    }

    public StringProperty resultTextProperty() {
        return result;
    }


    public StringProperty buttonProperty() {
        return button;
    }

    public DoubleProperty sliderValueProperty() {
        return sliderValue;
    }
}
