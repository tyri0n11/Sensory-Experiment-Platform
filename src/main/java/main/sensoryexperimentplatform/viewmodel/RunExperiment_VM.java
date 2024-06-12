package main.sensoryexperimentplatform.viewmodel;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import main.sensoryexperimentplatform.models.*;
import main.sensoryexperimentplatform.models.Timer;

import java.util.*;

public class RunExperiment_VM {
    private Experiment experiment;
    public double count = 0.0;
    private String file_name;
    private final ListProperty<String> items = new SimpleListProperty<>(FXCollections.observableArrayList());
    private final Map<String, Object> objectsMap = new HashMap<>();
    private final List<Object> objectList = new ArrayList<>();
    private ArrayList<Object> stages = new ArrayList<>();

    public RunExperiment_VM(Experiment experiment, String file_name){
        this.experiment = experiment;
        this.file_name = file_name;
        loadItems();
    }

    public String getFileName() {
        return file_name;
    }

    public void loadItems() {
        stages = experiment.getStages();
        Set<String> stringSet = new LinkedHashSet<>();
        ArrayList<Object> stages = experiment.getStages();
        int index = 0;

        for (Object o : stages) {
            if (o instanceof Stage) {
                if (o instanceof Timer) {
                    String key = index + " Wait";
                    objectsMap.put(key, o);
                    stringSet.add(key);
                    objectList.add(o); // Thêm đối tượng vào objectList
                    index++;
                    count++;
                } else {
                    String temp = " ";
                    if (o instanceof Vas)
                        temp = "Vas";
                    if (o instanceof gLMS)
                        temp = "GLMS";
                    if (o instanceof Notice)
                        temp = "Notice";

                    String key = index + " " + temp;
                    objectsMap.put(key, o);
                    stringSet.add(key);
                    objectList.add(o);
                    index++;
                    count++;
                }
            }
            if (o instanceof RatingContainer) {
                int i = 0;
                for (Object subO : ((RatingContainer) o).container) {
                    if (subO instanceof Vas) {
                        String subKey = "\t" + index + "." + i;
                        objectsMap.put(subKey, subO);
                        stringSet.add(subKey);
                        objectList.add(subO); // Thêm đối tượng con vào objectList
                        i++;
                        count++;
                    }
                    if (subO instanceof gLMS) {
                        String subKey = "\t" + index + "." + i;
                        objectsMap.put(subKey, subO);
                        stringSet.add(subKey);
                        objectList.add(subO); // Thêm đối tượng con vào objectList
                        i++;
                        count++;
                    }
                }
            }
        }
        items.setAll(stringSet);
    }
    public String getExperimentName(){
        return experiment.getExperimentName();
    }

    public ObservableList<String> getItems() {
        return items.get();
    }

    public ListProperty<String> itemsProperty() {
        return items;
    }

    public ArrayList<Object> getStages() {
        return stages;
    }

    public Object getObjectByKey(String key) {
        return objectsMap.get(key);
    }

    public int getIndexOfObject(Object obj) {
        return objectList.indexOf(obj);
    }
    public Experiment getExperiment(){
        return experiment;
    }

}