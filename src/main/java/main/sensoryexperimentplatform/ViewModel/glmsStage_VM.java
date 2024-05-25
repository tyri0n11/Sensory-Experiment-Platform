package main.sensoryexperimentplatform.ViewModel;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class glmsStage_VM {
    private StringProperty txt_question;
    private StringProperty txt_LowAncTxt;
    private StringProperty txt_yes;
    private BooleanProperty checkB_swap;
    private StringProperty txt_help;
    private BooleanProperty checkB_sound;
    public glmsStage_VM(){
        txt_help = new SimpleStringProperty();
        txt_LowAncTxt = new SimpleStringProperty();
        txt_question = new SimpleStringProperty();
        checkB_sound = new SimpleBooleanProperty();
        checkB_swap  = new SimpleBooleanProperty();
        txt_yes= new SimpleStringProperty();
    }

    public String getTxt_question() {
        return txt_question.get();
    }

    public StringProperty txt_questionProperty() {
        return txt_question;
    }

    public String getTxt_LowAncTxt() {
        return txt_LowAncTxt.get();
    }

    public StringProperty txt_LowAncTxtProperty() {
        return txt_LowAncTxt;
    }

    public String getTxt_yes() {
        return txt_yes.get();
    }

    public StringProperty txt_yesProperty() {
        return txt_yes;
    }

    public boolean isCheckB_swap() {
        return checkB_swap.get();
    }

    public BooleanProperty checkB_swapProperty() {
        return checkB_swap;
    }

    public String getTxt_help() {
        return txt_help.get();
    }

    public StringProperty txt_helpProperty() {
        return txt_help;
    }

    public boolean isCheckB_sound() {
        return checkB_sound.get();
    }

    public BooleanProperty checkB_soundProperty() {
        return checkB_sound;
    }
}
