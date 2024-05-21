package main.sensoryexperimentplatform.ViewModel;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import main.sensoryexperimentplatform.models.DataAccess;
import main.sensoryexperimentplatform.models.Experiment;
import main.sensoryexperimentplatform.models.RatingContainer;
import main.sensoryexperimentplatform.models.Vas;
import main.sensoryexperimentplatform.models.gLMS;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class RunExperiment_VM {

    private ListProperty<String> items = new SimpleListProperty<>(FXCollections.observableArrayList());

    public ObservableList<String> getItems() {
        return items.get();
    }

    public ListProperty<String> itemsProperty() {
        return items;
    }

    public void loadItems() throws IOException {
        Experiment experiment = DataAccess.getExperimentIndividually();
        if (experiment != null) {
            Set<String> stringSet = new HashSet<>();
            ArrayList<Object> stages = experiment.getStages();
            for (Object o : stages) {
                if (o instanceof RatingContainer) {
                    for (Object subO : ((RatingContainer) o).container) {
                        if (subO instanceof Vas) {
                            stringSet.add(subO.toString());
                        }
                        if (subO instanceof gLMS) {
                            stringSet.add(subO.toString());
                        }
                    }
                } else {
                    stringSet.add(o.toString());
                }
            }
            items.setAll(stringSet);
        }
    }
}
