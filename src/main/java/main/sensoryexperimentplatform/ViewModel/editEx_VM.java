package main.sensoryexperimentplatform.ViewModel;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import main.sensoryexperimentplatform.models.*;

import java.io.IOException;
import java.util.*;

public class editEx_VM {

    private ObservableList<String> items = FXCollections.observableArrayList();
    private ObservableList<String> scales = FXCollections.observableArrayList();
    private Map<String, Object> displayedItems = new HashMap<>();
    private Map<String, Object> displayedScales = new HashMap<>();
    private final Experiment currentExperiment;


    public ObservableList<String> getItems() {
        return items;
    }

    public void setItems(ObservableList<String> items) {
        this.items = items;
    }

    public ObservableList<String> getScales() {
        return scales;
    }

    public void setScales(ObservableList<String> scales) {
        this.scales = scales;
    }

    public editEx_VM() throws IOException {
        this.currentExperiment = DataAccess.getExperimentIndividually();
        loadItems();
    }
    public void loadItems() throws IOException {
        if (currentExperiment != null) {
            Set<String> str = new LinkedHashSet<>();
            Set<String> set = new LinkedHashSet<>();
            ArrayList<Object> stages = currentExperiment.getStages();
            for (Object o : stages) {
                   if(o instanceof Stage) {
                           String key = "[" + o.getClass().getSimpleName() + "] " + ((Stage) o).getTitle();
                           System.out.println(key);
                           displayedItems.put(key, o);
                           str.add(key);
                           items.setAll(str);
                   } else if (o instanceof RatingContainer) {
//                       String key = "[" + o.getClass().getSimpleName() + "] " + ((Stage) o).getTitle();
//                       System.out.println(key);
//                       displayedItems.put(key, o);
//                       str.add(key);
                       for (Object subO : ((RatingContainer) o).container) {
                           if (subO instanceof Vas) {
                               String key = "[VAS]" + ((Vas) subO).getTitle();
                               System.out.println(key);
                               displayedScales.put(key, o);
                               set.add(key);
                           } else if (subO instanceof gLMS) {
                               String key = "[GLMS]" + ((gLMS) subO).getTitle();
                               System.out.println(key);
                               displayedScales.put(key, o);
                               set.add(key);
                           }
                       }
                       scales.setAll(set);
                   }
            }

        }
    }

    public Object getObjectByKey(String key) {
        return displayedItems.get(key);
    }

    public Object getScaleByKey(String key) {
        return displayedScales.get(key);
    }

    public Experiment getCurrentExperiment() {
        return currentExperiment;
    }
}


