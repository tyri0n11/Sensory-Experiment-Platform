package main.sensoryexperimentplatform.controllers;

import javafx.beans.binding.Bindings;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;

import main.sensoryexperimentplatform.viewmodel.RunGLMS_VM;

public class RunGLMSController {

    @FXML
    private Slider mySlider;
    @FXML
    private Label questionlbl, helpText;
    private BooleanProperty isRecorded;

    private RunGLMS_VM viewModel;

    public void setViewModel(RunGLMS_VM viewModel) {
        this.viewModel = viewModel;
        isRecorded = new SimpleBooleanProperty(false);

        bindViewModel();
        mySlider.valueProperty().addListener(((observableValue, oldValue, newValue) ->{
            isRecorded.set(true);
        }));
    }

    public BooleanProperty isRecordedProperty() {
        return isRecorded;
    }

    private void bindViewModel() {
        // Bind viewModel properties to the labels
        questionlbl.textProperty().bind(viewModel.questionProperty());
        helpText.textProperty().bind(viewModel.helpProperty());

        mySlider.setMin(0);
        mySlider.setMax(100);

        // Two-way binding between slider value and viewModel.sliderValueProperty()
        Bindings.bindBidirectional(mySlider.valueProperty(), viewModel.sliderValueProperty());
    }

}
