package main.sensoryexperimentplatform.ViewModel;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import main.sensoryexperimentplatform.models.RatingContainer;
import main.sensoryexperimentplatform.models.Vas;
import main.sensoryexperimentplatform.models.gLMS;

public class ratingContainer_VM {
    private RatingContainer ratingContainer;
    private IntegerProperty minTime;
    private BooleanProperty isRandomize;
    private Vas vas;
    private gLMS glms;
    public ratingContainer_VM(){
        this.ratingContainer = new RatingContainer(false,5);
        minTime = new SimpleIntegerProperty(ratingContainer.getMinTime());
        isRandomize = new SimpleBooleanProperty(ratingContainer.isRandomize());

    }
    public IntegerProperty minTimeProperty(){
        return minTime;
    }
    public BooleanProperty randomProperty(){
        return isRandomize;
    }
    public int getMinTime(){
        return minTime.get();
    }
    public boolean getIsRandomize(){
        return isRandomize.get();

    }
    public void setMinTime(int newValue){
        ratingContainer.setMinTime(newValue);
    }
    public void setIsRandomize(boolean newValue){
        ratingContainer.setRandomize(newValue);
    }
    public void addVasStage(String title, String lowAnchorText, String highAnchorText, int lowAnchorValue, int highAnchorValue, String buttonText, String content, String helpText, boolean isSwap, boolean alert) {
        ratingContainer.addVasStageContainer(title, lowAnchorText, highAnchorText, lowAnchorValue, highAnchorValue, buttonText, content, helpText, isSwap, alert);
    }

    // Method to add gLMS stage
    public void addGlmsStage(String question, String buttonText, String content, String helpText, boolean alert) {
        ratingContainer.addGlmsStageContainer(question, buttonText, content, helpText, alert);
    }
    public void addVasStage_newExperiment(){
        ratingContainer.addVasStageTest_newExperiment(vas);
    }
    public void addGlmsStage_newExperiment(){
        ratingContainer.addGlms_newExperiment(glms);
    }
    public RatingContainer getRatingContainer(){
        return ratingContainer;
    }


}
