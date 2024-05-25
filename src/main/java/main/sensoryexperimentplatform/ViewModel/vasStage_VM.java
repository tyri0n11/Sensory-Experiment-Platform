package main.sensoryexperimentplatform.ViewModel;

import javafx.beans.property.*;
import main.sensoryexperimentplatform.models.Vas;

public class vasStage_VM {
    private StringProperty questionText;
    private StringProperty lowAnchorText;
    private StringProperty highAnchorText;
    private StringProperty helpText;
    private StringProperty buttonText;
    private StringProperty lowAnchorValue ;
    private StringProperty highAnchorValue;
    private StringProperty txt_BtnTxt;
    private StringProperty  txt_yes;
    private BooleanProperty checkB_sound;
    private BooleanProperty checkB_swap;
    private final BooleanProperty alert = new SimpleBooleanProperty(true);

    public vasStage_VM() {
        lowAnchorText = new SimpleStringProperty();
        highAnchorText = new SimpleStringProperty();
        buttonText = new SimpleStringProperty();
        helpText = new SimpleStringProperty();
        lowAnchorValue = new SimpleStringProperty();
        highAnchorValue= new SimpleStringProperty();
        questionText = new SimpleStringProperty();
        txt_BtnTxt = new SimpleStringProperty();
        txt_yes= new SimpleStringProperty();
        checkB_sound = new SimpleBooleanProperty(false);
        checkB_swap = new SimpleBooleanProperty(false);
        questionText.addListener((observableValue, oldValue, newValue) -> onQuestionTextChange());
    }

    public boolean isCheckB_swap() {
        return checkB_swap.get();
    }

    public BooleanProperty checkB_swapProperty() {
        return checkB_swap;
    }

    public boolean isCheckB_sound() {
        return checkB_sound.get();
    }

    public BooleanProperty checkB_soundProperty() {
        return checkB_sound;
    }

    public String getHighAnchorValue() {
        return highAnchorValue.get();
    }

    public StringProperty highAnchorValueProperty() {
        return highAnchorValue;
    }

    public String getLowAnchorValue() {
        return lowAnchorValue.get();
    }

    public StringProperty lowAnchorValueProperty() {
        return lowAnchorValue;
    }

    public String getTxt_yes() {
        return txt_yes.get();
    }

    public StringProperty txt_yesProperty() {
        return txt_yes;
    }

    public String getTxt_BtnTxt() {
        return txt_BtnTxt.get();
    }

    public StringProperty txt_BtnTxtProperty() {
        return txt_BtnTxt;
    }

    private void onQuestionTextChange(){
        System.out.println(questionTextProperty());
    }

    public String getQuestionText() {
        return questionText.get();
    }

    public StringProperty questionTextProperty() {
        return questionText;

    }

    public void setQuestionText(String questionText) {
        this.questionText.set(questionText);
    }

    public String getLowAnchorText() {
        return lowAnchorText.get();
    }

    public StringProperty lowAnchorTextProperty() {
        return lowAnchorText;
    }

    public void setLowAnchorText(String lowAnchorText) {
        this.lowAnchorText.set(lowAnchorText);
    }

    public String getHighAnchorText() {
        return highAnchorText.get();
    }

    public StringProperty highAnchorTextProperty() {
        return highAnchorText;
    }

    public void setHighAnchorText(String highAnchorText) {
        this.highAnchorText.set(highAnchorText);
    }

    public String getHelpText() {
        return helpText.get();
    }

    public StringProperty helpTextProperty() {
        return helpText;
    }

    public void setHelpText(String helpText) {
        this.helpText.set(helpText);
    }

    public String getButtonText() {
        return buttonText.get();
    }

    public StringProperty buttonTextProperty() {
        return buttonText;
    }

    public void setButtonText(String buttonText) {
        this.buttonText.set(buttonText);
    }


    public boolean isAlert() {
        return alert.get();
    }

    public BooleanProperty alertProperty() {
        return alert;
    }

    public void setAlert(boolean alert) {
        this.alert.set(alert);
    }
}
