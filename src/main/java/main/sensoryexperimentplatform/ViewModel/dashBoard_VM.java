package main.sensoryexperimentplatform.ViewModel;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import main.sensoryexperimentplatform.models.DataAccess;
import main.sensoryexperimentplatform.models.Experiment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class dashBoard_VM {
    private final ListProperty<Experiment> items = new SimpleListProperty<>(FXCollections.observableArrayList());
    //id, creator, name, version
    private final Map<String, Object> objectsMap = new HashMap<>();
    private ArrayList<Experiment> experiments;

    public dashBoard_VM() {
        // Load items on instantiation
        try {
            loadItems();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void loadItems() throws Exception {
        experiments = DataAccess.importExperiment();
        items.setAll(experiments); // Populate the items property
    }

    public ListProperty<Experiment> itemsProperty() {
        return items;
    }

    public Map<String, Object> getObjectsMap() {
        return objectsMap;
    }

}
