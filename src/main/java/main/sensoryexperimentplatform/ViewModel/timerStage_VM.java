package main.sensoryexperimentplatform.ViewModel;

<<<<<<< HEAD
import javafx.beans.property.*;
=======
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
>>>>>>> 7a2212825dec188091988102bf0da9285f466266
import main.sensoryexperimentplatform.models.Timer;

public class timerStage_VM {
    private Timer timer;
    private StringProperty txt_instruction;
    private StringProperty txt_timewait;
    private BooleanProperty cb_alertSound;
    public timerStage_VM(Timer timer){
        this.timer = timer;
        txt_instruction = new SimpleStringProperty(timer.getInstruction());
<<<<<<< HEAD
        txt_timewait = new SimpleStringProperty(String.valueOf(timer.getTimeToWait()));
        cb_alertSound = new SimpleBooleanProperty(timer.isAlert());
=======
        txt_timewait = new SimpleStringProperty(timer.getFormattedElapsed());
        cb_alertSound = new SimpleBooleanProperty(timer.isAlert());
        cb_alertSound.addListener((observableValue, oldValue, newValue) -> onAlert(newValue));
        txt_timewait.addListener((observableValue, oldValue, newValue) -> onTimeWait(newValue));
        txt_instruction.addListener((observableValue, oldValue, newValue) -> onInstruction(newValue));
    }
    public timerStage_VM(){
        this.timer = timer;
        txt_instruction = new SimpleStringProperty(timer.getInstruction());
        txt_timewait = new SimpleStringProperty(timer.getFormattedElapsed());
        cb_alertSound = new SimpleBooleanProperty(timer.isAlert());
        cb_alertSound.addListener((observableValue, oldValue, newValue) -> onAlert(newValue));
        txt_timewait.addListener((observableValue, oldValue, newValue) -> onTimeWait(newValue));
        txt_instruction.addListener((observableValue, oldValue, newValue) -> onInstruction(newValue));
    }

    private void onAlert(Boolean newValue) {
        timer.setAlert(newValue);
    }

    private void onInstruction(String newValue) {
        timer.setInstruction(newValue);
    }

    private void onTimeWait(String newValue) {
        timer.setTime(newValue);
>>>>>>> 7a2212825dec188091988102bf0da9285f466266
    }

    public String getTxt_instruction() {
        return txt_instruction.get();
    }

    public StringProperty txt_instructionProperty() {
        return txt_instruction;
    }

    public boolean isCb_alertSound() {
        return cb_alertSound.get();
    }

    public BooleanProperty cb_alertSoundProperty() {
        return cb_alertSound;
    }


    public Property<String> txt_timewaitProperty() {
        return txt_timewait;
    }

    public String getTxt_timewait() {
        return txt_timewait.get();
    }

    public void setTxt_timewait(String txt_timewait) {
        this.txt_timewait.set(txt_timewait);
    }

    public Timer getTimer() {
        return timer;
    }
}
