package main.sensoryexperimentplatform.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import main.sensoryexperimentplatform.ViewModel.RunNotice_VM;

import java.awt.*;

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