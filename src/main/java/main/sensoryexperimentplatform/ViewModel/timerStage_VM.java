package main.sensoryexperimentplatform.ViewModel;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

public class timerStage_VM {
    private StringProperty txt_instruction;
    private StringProperty txt_timewait;
    private BooleanProperty cb_alertSound;
    public timerStage_VM(){
        txt_instruction = new SimpleStringProperty();
        txt_timewait = new SimpleStringProperty();
        cb_alertSound = new SimpleBooleanProperty(false);
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

    public String getTxt_timewait() {
        return txt_timewait.get();
    }

    public StringProperty txt_timewaitProperty() {
        return txt_timewait;
    }
}
