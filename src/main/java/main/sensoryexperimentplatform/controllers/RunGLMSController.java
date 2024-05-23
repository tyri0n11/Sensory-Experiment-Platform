package main.sensoryexperimentplatform.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import main.sensoryexperimentplatform.ViewModel.RunGLMS_VM;

public class RunGLMSController {
    @FXML
    private Slider mySlider;


    @FXML
    private Label questionlbl, result;
    private RunGLMS_VM viewModel;
    public void setViewModel(RunGLMS_VM viewModel){
        this.viewModel = viewModel;
        bindViewModel();
    }
    private void bindViewModel(){
        questionlbl.textProperty().bind(viewModel.questionProperty());
        result.textProperty().bind(viewModel.resultProperty());
        mySlider.valueProperty().addListener(((observableValue, oldValue, newValue) -> {
            viewModel.setResult(newValue.intValue());
            result.textProperty().unbind();
            result.setText(String.valueOf(viewModel.resultProperty()));
            result.textProperty().bind(viewModel.resultProperty());

        }));

    }
}
