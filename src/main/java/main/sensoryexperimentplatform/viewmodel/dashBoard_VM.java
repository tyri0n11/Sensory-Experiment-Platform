package main.sensoryexperimentplatform.viewmodel;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import main.sensoryexperimentplatform.utilz.Observer;
import main.sensoryexperimentplatform.models.DataAccess;
import main.sensoryexperimentplatform.models.Experiment;
import main.sensoryexperimentplatform.models.listOfExperiment;

public class dashBoard_VM implements Observer {
    private ObservableList<Experiment> experiments;

    public dashBoard_VM() {
        listOfExperiment.attach(this);
        experiments = FXCollections.observableArrayList();
        reload();
    }

    public void reload() {
        try {
            loadItems();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    public void addExperiment(Experiment e) throws Exception {
//        listOfExperiment.getInstance().add(e);
//        experiments.add(e);
//    }
//    public void importExperiment(Experiment e){
//        experiments.add(e);
//    }
//
//    public void deleteExperiment(Experiment e) throws Exception {
//        listOfExperiment.deleteExperiment(e);
//        experiments.remove(e);
//    }

    public void loadItems() throws Exception {
        DataAccess.loadExperiments();
        experiments.setAll(listOfExperiment.getInstance());
        System.out.println(experiments);
    }

    public ObservableList<Experiment> getExperiments() {
        return experiments;
    }

    @Override
    public void update() {
        try {
            experiments.setAll(listOfExperiment.getInstance());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
