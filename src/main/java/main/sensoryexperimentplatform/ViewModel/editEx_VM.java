package main.sensoryexperimentplatform.ViewModel;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import main.sensoryexperimentplatform.models.*;

import java.io.IOException;
import java.util.*;

public class editEx_VM {

    private ObservableList<String> items = FXCollections.observableArrayList();
    private Map<String, Object> displayedItems = new HashMap<>();


    public ObservableList<String> getItems() {
        return items;
    }

    public void setItems(ObservableList<String> items) {
        this.items = items;
    }

    public editEx_VM() throws IOException {
        loadItems();
    }
    public void loadItems() throws IOException {
        Experiment experiment = DataAccess.getExperimentIndividually();
        if (experiment != null) {
            Set<String> str = new LinkedHashSet<>();
            ArrayList<Object> stages = experiment.getStages();
            for (Object o : stages) {
                if (o instanceof Vas || o instanceof gLMS) {
                    String key = "[" + o.getClass().getSimpleName() + "] " + ((Stage) o).getTitle();
                    System.out.println(key);
                    displayedItems.put(key, o);
                    str.add(key);
                }
                items.setAll(str);
            }
        }
    }
    public Object getObjectByKey(String key) {
        return displayedItems.get(key);
    }
}


