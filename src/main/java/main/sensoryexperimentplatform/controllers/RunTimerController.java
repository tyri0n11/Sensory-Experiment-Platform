package main.sensoryexperimentplatform.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import main.sensoryexperimentplatform.ViewModel.RunTimer_VM;
import main.sensoryexperimentplatform.ViewModel.RunVas_VM;

public class RunTimerController {
    @FXML
    private Label titleTxt, contentTxt;
    private RunTimer_VM viewModel;
    public void setViewModel(RunTimer_VM viewModel){
        this.viewModel = viewModel;

    }
    void bindViewModel(){

    }


}
