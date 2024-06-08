package main.sensoryexperimentplatform.models;

import java.util.ArrayList;

public class listOfExperiment {
    private static ArrayList<Experiment> experiments;


    public static ArrayList<Experiment> getInstance() throws Exception {
        if (experiments == null){
            experiments = new ArrayList<Experiment>();
        }
        return experiments;
    }

    public void add(Experiment experiment) {
        experiments.add(experiment);
    }

    public static void deleteExperiment(Experiment experiment) throws Exception {
        if (experiments.remove(experiment)) {
            DataAccess.updateFile();
        }
    }

}
