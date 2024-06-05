package main.sensoryexperimentplatform.ViewModel;

import javafx.beans.Observable;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import main.sensoryexperimentplatform.models.DataAccess;
import main.sensoryexperimentplatform.models.Experiment;
import main.sensoryexperimentplatform.models.listOfExperiment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static javafx.beans.binding.Bindings.bindBidirectional;

public class dashBoard_VM {
    private  ListProperty<Experiment> items = new SimpleListProperty<>(FXCollections.observableArrayList());
    //id, creator, name, version
    private final Map<String, Object> objectsMap = new HashMap<>();
    private ArrayList<Experiment> experiments;
    private listOfExperiment ListOfExperiment;



    public dashBoard_VM() {
        // Load items on instantiation
     reload();
    }
    public void reload(){
        // Load items on instantiation
        try {
            loadItems();
            System.out.println(listOfExperiment.getInstance());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void addListExperiment(Experiment e) throws Exception {


        reload();


    }

    void loadItems() throws Exception {
        listOfExperiment.getInstance();
        items.setAll(listOfExperiment.getInstance());


    }


    public ObservableList<Experiment> getItems() {
        return items;
    }
    public ListProperty<Experiment> itemsProperty() {
        return items;
    }

    public Map<String, Object> getObjectsMap() {
        return objectsMap;
    }

}
