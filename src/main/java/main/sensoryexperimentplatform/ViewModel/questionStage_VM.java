package main.sensoryexperimentplatform.ViewModel;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class questionStage_VM {
    //Notice can chinh lai
    private StringProperty question ;
    private StringProperty leftText ;
    private StringProperty rightText ;
    private StringProperty leftValue;
    private StringProperty rightValue;
    private StringProperty helpText;
    private BooleanProperty alert;

    public questionStage_VM(){
        this.question = new SimpleStringProperty();
        this.leftText = new SimpleStringProperty();
        this.rightText = new SimpleStringProperty();
        this.leftValue = new SimpleStringProperty();
        this.rightValue = new SimpleStringProperty();
       this.helpText = new SimpleStringProperty();
       this.alert= new SimpleBooleanProperty();
    }
    public String getQuestion(){
        return question.get();

    }
    public String getLeftText(){
        return leftText.get();

    }
    public String getRightText(){
        return rightText.get();

    }
    public boolean getAlert(){
        return alert.get();

    }
    public String getRightValue(){
        return rightValue.get();

    }
    public String getLeftValue(){
        return leftValue.get();

    }
    public String getHelpText(){
        return helpText.get();

    }
    public StringProperty helpTextProperty() {
        return helpText;
    }
    public StringProperty leftTextProperty() {
        return leftText;
    }
    public StringProperty rightTextProperty() {
        return rightText;
    }
    public StringProperty leftValueProperty() {
        return leftValue;
    }
    public StringProperty rightValueProperty() {
        return rightValue;
    }
    public StringProperty questionProperty() {
        return question;
    }
    public BooleanProperty alertProperty() {
        return alert;
    }











}
