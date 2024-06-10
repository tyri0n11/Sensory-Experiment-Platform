package main.sensoryexperimentplatform.viewmodel;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import main.sensoryexperimentplatform.models.Experiment;

public class FillName_VM {
    private StringProperty file_name;
    private Experiment experiment;
    public FillName_VM (Experiment experiment){
        this.experiment = experiment;
        file_name = new SimpleStringProperty("");

    }

    public StringProperty fileName(){
        return file_name;
    }

    public String getFileName() {
        return file_name.get();
    }

    public Experiment getExperiment() {
        return experiment;
    }
}
