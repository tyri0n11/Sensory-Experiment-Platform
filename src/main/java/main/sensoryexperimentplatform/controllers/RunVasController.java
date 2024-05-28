package main.sensoryexperimentplatform.controllers;

import javafx.beans.binding.Bindings;
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
    private Label result_label;
    @FXML
    private Slider mySlider;

    private RunVas_VM viewModel;

    public void setViewModel(RunVas_VM viewModel) {
        this.viewModel = viewModel;
        bindViewModel();
    }

    private void bindViewModel() {
        highAnchor_label.textProperty().bind(viewModel.highAnchorTextProperty());
        lowAnchor_label.textProperty().bind(viewModel.lowAnchorTextProperty());
        questionlbl.textProperty().bind(viewModel.questionTextProperty());


        // Binding hai chiều giữa mySlider.valueProperty() và viewModel.sliderValueProperty()
        Bindings.bindBidirectional(mySlider.valueProperty(),viewModel.sliderValueProperty());

        mySlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            result_label.textProperty().bind(viewModel.resultTextProperty());
            result_label.setLayoutX(mySlider.getLayoutX() + (newValue.intValue()*mySlider.getPrefWidth())/100);
        });


        // Binding một chiều từ viewModel.resultTextProperty() đến result_label.textProperty()
        result_label.textProperty().bind(viewModel.resultTextProperty());

        mySlider.applyCss();
        var thumb = mySlider.lookup(".thumb");
        if (thumb != null) {
            result_label.setLayoutX((thumb.getLayoutX() + mySlider.getLayoutX()) / 2);
        }
    }
}