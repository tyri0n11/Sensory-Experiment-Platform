package main.sensoryexperimentplatform.ViewModel;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import main.sensoryexperimentplatform.models.gLMS;

public class RunGLMS_VM {
    private gLMS stage;
    private StringProperty question;
    private StringProperty result;
    private StringProperty button;

    public RunGLMS_VM(gLMS stage){
        this.stage = stage;
        question = new SimpleStringProperty(stage.getQuestionText());
        button = new SimpleStringProperty(stage.getButtonText());
        result = new SimpleStringProperty(null);
    }

    public StringProperty questionProperty() {
        return question;
    }

    public StringProperty resultProperty() {
        return result;
    }


    public StringProperty buttonProperty() {
        return button;
    }

    //0 : barely detectable
    //<10 : weak
    //<30: moderate
    //<70: strong
    //>90: very strong
    public void setResult(int value){
        if(value>=90) {
            stage.setResult("VeryStrong");
            result = new SimpleStringProperty("Very Strong");
        }
        else if (value >= 70) {
            stage.setResult("Strong");
            result = new SimpleStringProperty("Strong");
        }
        else if (value >= 30) {
            stage.setResult("Moderate");
            result = new SimpleStringProperty("Moderate");
        }
        else if (value >= 10) {
            stage.setResult("Weak");
            result = new SimpleStringProperty("Weak");
        }
        else {
            stage.setResult("Barely Detectable");
            result = new SimpleStringProperty("Barely Detectable");
        }
    }
}
