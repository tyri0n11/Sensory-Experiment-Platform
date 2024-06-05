package main.sensoryexperimentplatform.controllers;

import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.util.StringConverter;
import main.sensoryexperimentplatform.ViewModel.RunGLMS_VM;

public class RunGLMSController {

    @FXML
    private Slider mySlider;
    @FXML
    private Label questionlbl, helpText;

    private RunGLMS_VM viewModel;

    public void setViewModel(RunGLMS_VM viewModel) {
        this.viewModel = viewModel;
        bindViewModel();
    }

    private void bindViewModel() {
        // Bind viewModel properties to the labels
        questionlbl.textProperty().bind(viewModel.questionProperty());
        helpText.textProperty().bind(viewModel.helpProperty());

        // Slider configuration
        mySlider.setShowTickLabels(true);
        mySlider.setShowTickMarks(true);
        mySlider.setMin(0);
        mySlider.setMax(100); // We have 7 specific labels, indexed 0 to 6

        // Custom tick labels and value conversion
        mySlider.setLabelFormatter(new StringConverter<Double>() {
            @Override
            public String toString(Double n) {
                return getLabelForValue(n.intValue());
            }

            @Override
            public Double fromString(String s) {
                return getValueForLabel(s);
            }
        });

        // Two-way binding between slider value and viewModel.sliderValueProperty()
        Bindings.bindBidirectional(mySlider.valueProperty(), viewModel.sliderValueProperty());

    }

    private String getLabelForValue(int index) {
        switch (index) {
            case 0: return "No Sensation";
            case 1: return "Barely detectable";
            case 10: return "Weak";
            case 20: return "Moderate";
            case 30: return "Strong";
            case 50: return "Very Strong";
            case 90: return "Strongest imaginable";
            default: return "";
        }
    }

    private double getValueForLabel(String label) {
        switch (label) {
            case "No Sensation": return 0;
            case "Barely detectable": return 1;
            case "Weak": return 5;
            case "Moderate": return 16;
            case "Strong": return 33;
            case "Very Strong": return 50;
            case "Strongest imaginable": return 95;
            default: return 0;
        }
    }
}
