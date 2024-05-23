package main.sensoryexperimentplatform.controllers;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import main.sensoryexperimentplatform.ViewModel.RunNotice_VM;


public class RunNoticeController {
    @FXML
    private Label titleTxt, contentTxt;
    private RunNotice_VM viewModel;
    public void setViewModel(RunNotice_VM viewModel){
        this.viewModel = viewModel;
        bindViewModel();
    }
    private void bindViewModel(){
        titleTxt.textProperty().bind(viewModel.getTitle());
        contentTxt.textProperty().bind(viewModel.getContent());

    }
}
