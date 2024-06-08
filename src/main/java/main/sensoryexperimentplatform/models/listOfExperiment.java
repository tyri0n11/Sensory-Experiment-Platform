package main.sensoryexperimentplatform.models;

import main.sensoryexperimentplatform.utilz.Observable;
import main.sensoryexperimentplatform.utilz.Observer;

import java.util.ArrayList;
import java.util.List;

public class listOfExperiment extends Observable {
    private static ArrayList<Experiment> experiments;
    private List<Observer> observers = new ArrayList<Observer>();


    public static ArrayList<Experiment> getInstance() {
        if (experiments == null){
            experiments = new ArrayList<Experiment>();
        }
        return experiments;
    }

    public static void addExperiment(Experiment experiment) throws Exception {
        listOfExperiment.getInstance().add(experiment);
        notifyAllObservers();
    }

    public static void deleteExperiment(Experiment experiment) throws Exception {
        if (experiments.remove(experiment)) {
            DataAccess.updateFile();
            notifyAllObservers();
        }

    }


}
