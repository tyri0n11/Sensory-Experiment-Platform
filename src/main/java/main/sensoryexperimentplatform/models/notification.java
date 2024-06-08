package main.sensoryexperimentplatform.models;

import main.sensoryexperimentplatform.ViewModel.dashBoard_VM;
import main.sensoryexperimentplatform.controllers.DashBoardController;

public class notification {
    private dashBoard_VM dashBoard_vm;


    public notification(dashBoard_VM dashBoard_vm){
        this.dashBoard_vm = dashBoard_vm;
    }
    public void notify(Experiment e) throws Exception {
        //dashBoard_vm.addExperiment(e);
    }
}
