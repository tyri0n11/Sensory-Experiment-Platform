package main.sensoryexperimentplatform.ViewModel;

import javafx.beans.property.*;
import main.sensoryexperimentplatform.models.Vas;

public class vasStage_VM {
    private StringProperty questionText;
    private final StringProperty lowAnchorText = new SimpleStringProperty();
    private final StringProperty highAnchorText = new SimpleStringProperty();
    private final StringProperty helpText = new SimpleStringProperty();
    private final StringProperty buttonText = new SimpleStringProperty();
    private final IntegerProperty lowAnchorValue = new SimpleIntegerProperty();
    private final IntegerProperty highAnchorValue = new SimpleIntegerProperty();
    private StringProperty txt_BtnTxt;

    private final BooleanProperty isSwap = new SimpleBooleanProperty(true);
    private final BooleanProperty alert = new SimpleBooleanProperty(true);

    public vasStage_VM() {
        questionText = new SimpleStringProperty();
        questionText.addListener((observableValue, oldValue, newValue) -> onQuestionTextChange());
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

    public int getLowAnchorValue() {
        return lowAnchorValue.get();
    }

    public IntegerProperty lowAnchorValueProperty() {
        return lowAnchorValue;
    }

    public void setLowAnchorValue(int lowAnchorValue) {
        this.lowAnchorValue.set(lowAnchorValue);
    }

    public int getHighAnchorValue() {
        return highAnchorValue.get();
    }

    public IntegerProperty highAnchorValueProperty() {
        return highAnchorValue;
    }

    public void setHighAnchorValue(int highAnchorValue) {
        this.highAnchorValue.set(highAnchorValue);
    }

    public boolean isIsSwap() {
        return isSwap.get();
    }

    public BooleanProperty isSwapProperty() {
        return isSwap;
    }

    public void setIsSwap(boolean isSwap) {
        this.isSwap.set(isSwap);
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
