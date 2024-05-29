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
    private Vas vas;

    public vasStage_VM(Vas stage) {
        this.vas = stage;
        lowAnchorText = new SimpleStringProperty(vas.getLowAnchorText());
        highAnchorText = new SimpleStringProperty(vas.getHighAnchorText());
        buttonText = new SimpleStringProperty(vas.getButtonText());
        helpText = new SimpleStringProperty(vas.getHelpText());
        lowAnchorValue = new SimpleStringProperty(String.valueOf(vas.getLowAnchorValue()));
        highAnchorValue= new SimpleStringProperty(String.valueOf(vas.getHighAnchorValue()));
        questionText = new SimpleStringProperty(vas.getTitle());
        checkB_sound = new SimpleBooleanProperty(vas.getAlert());
        checkB_swap = new SimpleBooleanProperty(vas.getIsSwap());
        questionText.addListener((observableValue, oldValue, newValue) -> onQuestionTextChange(newValue));
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

    private void onQuestionTextChange(String s){
        vas.setTitle(s);
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
        System.out.println(vas.getHighAnchorText());
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

    public void setLowAnchorValue(String lowAnchorValue) {
        this.lowAnchorValue.set(lowAnchorValue);
    }

    public void setHighAnchorValue(String highAnchorValue) {
        this.highAnchorValue.set(highAnchorValue);
    }

    public void save(){
        //vas.setValue();
    }
}
