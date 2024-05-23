package main.sensoryexperimentplatform.ViewModel;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import main.sensoryexperimentplatform.models.*;

import java.io.IOException;
import java.util.*;

public class RunExperiment_VM {

    private ListProperty<String> items = new SimpleListProperty<>(FXCollections.observableArrayList());
    private Map<String, Object> objectsMap = new HashMap<>();

    public ObservableList<String> getItems() {
        return items.get();
    }

    public ListProperty<String> itemsProperty() {
        return items;
    }

    public void loadItems() throws IOException {
        Experiment experiment = DataAccess.getExperimentIndividually();
        if (experiment != null) {


            Set<String> stringSet = new LinkedHashSet<>();
            ArrayList<Object> stages = experiment.getStages();
            int index = 1;
            for (Object o : stages) {
                if (o instanceof Stage){
                    String key = index + " "+ ((Stage) o).getTitle();
                    objectsMap.put(key,o);
                    stringSet.add(key);
                    index++;
                }
                if (o instanceof RatingContainer) {
                    int i = 1;
                    String key = index + " "+ ((RatingContainer) o).getType();
                    objectsMap.put(key,o);
                    stringSet.add(key);
                    for (Object subO : ((RatingContainer) o).container) {
                        if (subO instanceof Vas) {
                            String subKey = index + "." + i + " "+((Vas) subO).getTitle();
                            objectsMap.put(subKey,subO);
                            stringSet.add(subKey);
                            i++;
                        }
                        if (subO instanceof gLMS) {
                            String subKey = index + "." + i + " "+((gLMS) subO).getTitle();
                            objectsMap.put(subKey,subO);
                            stringSet.add(subKey);
                            i++;
                        }
                    }
                    index++;
                }
            }
            items.setAll(stringSet);
        }
    }
    public Object getObjectByKey(String key) {
        return objectsMap.get(key);
    }
}


