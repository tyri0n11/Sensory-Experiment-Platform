package main.sensoryexperimentplatform.ViewModel;

import javafx.beans.property.*;
import main.sensoryexperimentplatform.models.Timer;

public class timerStage_VM {
    private Timer timer;
    private StringProperty txt_timewait;
    private StringProperty txt_instruction;
    private BooleanProperty cb_alertSound;
    public timerStage_VM(Timer timer){
        this.timer = timer;
        txt_timewait = new SimpleStringProperty(timer.getFormattedElapsed());
        cb_alertSound = new SimpleBooleanProperty(timer.isAlert());
        bind();
    }
    public timerStage_VM(){
        this.timer = new Timer(null, null);
        txt_instruction = new SimpleStringProperty(timer.getInstruction());
        txt_timewait = new SimpleStringProperty(timer.getFormattedElapsed());
        cb_alertSound = new SimpleBooleanProperty(timer.isAlert());
        bind();
    }

    private void bind(){
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
