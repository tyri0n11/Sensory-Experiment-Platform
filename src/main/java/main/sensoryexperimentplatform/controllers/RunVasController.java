package main.sensoryexperimentplatform.controllers;

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


        mySlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            double value = newValue.doubleValue();
            int percentValue = (int) value;
            result_label.setText(percentValue + "%");
            viewModel.setResult((int) value);
            mySlider.applyCss();
            var thumb = mySlider.lookup(".thumb");
            if (thumb != null) {
                result_label.setLayoutX(thumb.getLayoutX() + mySlider.getLayoutX() - mySlider.getWidth() / 2);
            }
        });

        mySlider.applyCss();
        var thumb = mySlider.lookup(".thumb");
        if (thumb != null) {
            result_label.setLayoutX((thumb.getLayoutX() + mySlider.getLayoutX()) / 2);
        }
    }
}