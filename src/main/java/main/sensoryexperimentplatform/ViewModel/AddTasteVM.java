package main.sensoryexperimentplatform.ViewModel;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class AddTasteVM {
    private StringProperty txt_inital;
    private BooleanProperty cbox;
    private StringProperty txt_help;
    private StringProperty txt_endInstruction;
    private StringProperty txt_timetowait;
    private  BooleanProperty checkbox_randomfood;
    private  BooleanProperty checkbox_randomrate;
    private  BooleanProperty checkbox_playalert;
    private StringProperty txt_howtaste;
    private StringProperty txt_consumpins;
    private StringProperty txt_lowanchortext;
    private StringProperty txt_highanchortext;
    private StringProperty txt_lowacnhorvalue;
    private StringProperty txt_highacnhorvalue;
    private StringProperty txt_buttontext;
    private  BooleanProperty checkbox_swappole;
    public AddTasteVM(){
        txt_buttontext = new SimpleStringProperty();
        txt_consumpins = new SimpleStringProperty();
        txt_inital = new SimpleStringProperty();
        txt_highacnhorvalue = new SimpleStringProperty();
        txt_highanchortext = new SimpleStringProperty();
        txt_endInstruction = new SimpleStringProperty();
        txt_lowacnhorvalue = new SimpleStringProperty();
        txt_howtaste = new SimpleStringProperty();
        txt_timetowait = new SimpleStringProperty();
        txt_help = new SimpleStringProperty();
        txt_lowanchortext = new SimpleStringProperty();
        checkbox_playalert = new SimpleBooleanProperty(false);
        checkbox_randomfood = new SimpleBooleanProperty(false);
        checkbox_swappole = new SimpleBooleanProperty(false);
        checkbox_randomrate = new SimpleBooleanProperty(false);
        cbox = new SimpleBooleanProperty(false);
    }

    public String getTxt_inital() {
        return txt_inital.get();
    }

    public StringProperty txt_initalProperty() {
        return txt_inital;
    }

    public boolean isCbox() {
        return cbox.get();
    }

    public BooleanProperty cboxProperty() {
        return cbox;
    }

    public String getTxt_help() {
        return txt_help.get();
    }

    public StringProperty txt_helpProperty() {
        return txt_help;
    }

    public boolean isCheckbox_randomrate() {
        return checkbox_randomrate.get();
    }

    public BooleanProperty checkbox_randomrateProperty() {
        return checkbox_randomrate;
    }

    public String getTxt_howtaste() {
        return txt_howtaste.get();
    }

    public StringProperty txt_howtasteProperty() {
        return txt_howtaste;
    }

    public String getTxt_lowacnhorvalue() {
        return txt_lowacnhorvalue.get();
    }

    public StringProperty txt_lowacnhorvalueProperty() {
        return txt_lowacnhorvalue;
    }

    public String getTxt_lowanchortext() {
        return txt_lowanchortext.get();
    }

    public StringProperty txt_lowanchortextProperty() {
        return txt_lowanchortext;
    }

    public String getTxt_highanchortext() {
        return txt_highanchortext.get();
    }

    public StringProperty txt_highanchortextProperty() {
        return txt_highanchortext;
    }

    public boolean isCheckbox_playalert() {
        return checkbox_playalert.get();
    }

    public BooleanProperty checkbox_playalertProperty() {
        return checkbox_playalert;
    }

    public String getTxt_consumpins() {
        return txt_consumpins.get();
    }

    public StringProperty txt_consumpinsProperty() {
        return txt_consumpins;
    }

    public boolean isCheckbox_swappole() {
        return checkbox_swappole.get();
    }

    public BooleanProperty checkbox_swappoleProperty() {
        return checkbox_swappole;
    }

    public boolean isCheckbox_randomfood() {
        return checkbox_randomfood.get();
    }

    public BooleanProperty checkbox_randomfoodProperty() {
        return checkbox_randomfood;
    }

    public String getTxt_highacnhorvalue() {
        return txt_highacnhorvalue.get();
    }

    public StringProperty txt_highacnhorvalueProperty() {
        return txt_highacnhorvalue;
    }

    public String getTxt_timetowait() {
        return txt_timetowait.get();
    }

    public StringProperty txt_timetowaitProperty() {
        return txt_timetowait;
    }

    public String getTxt_buttontext() {
        return txt_buttontext.get();
    }

    public StringProperty txt_buttontextProperty() {
        return txt_buttontext;
    }

    public String getTxt_endInstruction() {
        return txt_endInstruction.get();
    }

    public StringProperty txt_endInstructionProperty() {
        return txt_endInstruction;
    }
}
