package main.sensoryexperimentplatform.ViewModel;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import main.sensoryexperimentplatform.models.Experiment;

public class newEx_VM {
    private StringProperty experimentName;
    private StringProperty creatorName;
    private StringProperty additionNote;
    private StringProperty description;
    private Experiment experiment;

    public newEx_VM() {
        this.experiment = new Experiment();
        this.experimentName = new SimpleStringProperty(experiment.getExperimentName());
        this.creatorName = new SimpleStringProperty(experiment.getCreatorName());
        this.additionNote = new SimpleStringProperty(experiment.getNote());
        this.description = new SimpleStringProperty(experiment.getNote());

    }
    public StringProperty ExperimentNameProperty() {
        return experimentName;
    }
    public StringProperty CreatorNameProperty() {
        return creatorName;
    }
    public StringProperty noteProperty() {
        return additionNote;
    }
    public StringProperty DescriptionProperty() {
        return description;
    }

    public void setExperimentName(String newValue) {
        experiment.setExperimentName(newValue);
    }
    public void setCreatorName(String newValue) {
        experiment.setCreatorName(newValue);
    }
    public void setDescription(String newValue) {
        experiment.setDescription(newValue);
    }


    public void setNote(String newValue) {
        experiment.setNote(newValue);
    }
    public String getExperimentName(){
        return experimentName.get();
    }
    public String getCreatorName(){
        return creatorName.get();
    }
    public String getNote(){
        return additionNote.get();
    }
    public String getDescription(){
        return description.get();
    }







}