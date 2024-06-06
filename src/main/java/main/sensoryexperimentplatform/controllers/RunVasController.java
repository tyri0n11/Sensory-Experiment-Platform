package main.sensoryexperimentplatform.controllers;

import javafx.beans.binding.Bindings;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import main.sensoryexperimentplatform.ViewModel.RunVas_VM;

public class RunVasController {
    @FXML
    private Label highAnchor_label;
    @FXML
    private Label lowAnchor_label;
    @FXML
    private Label questionlbl;
    @FXML
    private Slider mySlider;

    private RunVas_VM viewModel;
    private BooleanProperty isRecorded;

    public void setViewModel(RunVas_VM viewModel) {
        this.viewModel = viewModel;
        isRecorded = new SimpleBooleanProperty(false);
        bindViewModel();

        mySlider.valueProperty().addListener((observableValue, oldValue, newValue) -> {
            if (!newValue.equals(oldValue)){
                isRecorded.set(false);

            }else
                isRecorded.set(true);

            System.out.println(isRecorded.get());
        });
    }

    public BooleanProperty isRecordedProperty() {
        return isRecorded;
    }

    private void bindViewModel() {
        highAnchor_label.textProperty().bind(viewModel.highAnchorTextProperty());
        lowAnchor_label.textProperty().bind(viewModel.lowAnchorTextProperty());
        questionlbl.textProperty().bind(viewModel.questionTextProperty());
        mySlider.setMax(viewModel.getHighAnchorValue());
        mySlider.setMin(viewModel.getLowAnchorValue());

        // Binding hai chiều giữa mySlider.valueProperty() và viewModel.sliderValueProperty()
        Bindings.bindBidirectional(mySlider.valueProperty(),viewModel.sliderValueProperty());

    }


}