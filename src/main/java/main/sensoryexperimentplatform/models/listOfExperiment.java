package main.sensoryexperimentplatform.models;

import java.util.ArrayList;

public class listOfExperiment {
    private static ArrayList<Experiment> experiments;

    public static ArrayList<Experiment> getInstance() throws Exception {
        if (experiments == null){
            experiments = DataAccess.importExperiment();
        }
        return experiments;
    }

//    public void add(Experiment e) throws Exception{
//        experiments.add(e);
//        DataAccess.saveData(experiments);
//    }

}
