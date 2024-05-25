package main.sensoryexperimentplatform.ViewModel;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import main.sensoryexperimentplatform.models.DataAccess;
import main.sensoryexperimentplatform.models.Experiment;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

public class StageTree {
    private StringProperty name;
    private ObservableList<StageTree> children;
    private RunExperiment_VM viewModel;

    public StageTree(String name) {
        this.name = new SimpleStringProperty(name);
        this.children = FXCollections.observableArrayList();

        viewModel = new RunExperiment_VM();


    }


    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public StringProperty nameProperty() {
        return name;
    }

    public ObservableList<StageTree> getChildren() {
        return children;
    }
}
