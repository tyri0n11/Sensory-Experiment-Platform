package main.sensoryexperimentplatform.controllers;

import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.util.StringConverter;
import main.sensoryexperimentplatform.ViewModel.RunGLMS_VM;

import java.awt.*;

public class RunGLMSController {
    @FXML
    private Slider mySlider;
    @FXML
    private Label questionlbl, result, helpText;
    private RunGLMS_VM viewModel;
    public void setViewModel(RunGLMS_VM viewModel){
        this.viewModel = viewModel;
        bindViewModel();
    }
    private void bindViewModel(){
        questionlbl.textProperty().bind(viewModel.questionProperty());
        helpText.textProperty().bind(viewModel.helpProperty());

        mySlider.setShowTickLabels(true);
        mySlider.setMajorTickUnit(5); // Hiển thị nhãn tại các điểm chính

        mySlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            result.textProperty().bind(viewModel.resultTextProperty());
            result.setLayoutY(mySlider.getLayoutY()+ mySlider.getHeight()- result.getHeight() - (newValue.intValue()*mySlider.getPrefHeight())/100);
        });
        mySlider.setLabelFormatter(new StringConverter<Double>() {
            @Override
            public String toString(Double n) {
                if (n >= 95.499) return "Strongest imaginable";
                else if (n >= 50.119) return "Very Strong";
                else if (n >= 33.13) return "Strong";
                else if (n >= 16.218) return "Moderate";
                else if (n >= 5.754) return "Weak";
                else if (n >= 1.380) return "Barely detectable";
                else if (n >= 0.00) return   "No Sensation";
                else return "Unknown";

            }

            @Override
            public Double fromString(String s) {
                switch (s){
                    case "No Sensation":
                        return 0d;
                    case "Barely detectable":
                        return 1d;
                    case "Weak":
                        return 2d;
                    case "Moderate":
                        return 3d;
                    case "Strong":
                        return 4d;
                    case "Very Strong":
                        return 5d;
                    case "Strongest imaginable":
                        return 6d;

                    default:
                        return 6d;
                }
            }
        });
        // Binding hai chiều giữa mySlider.valueProperty() và viewModel.sliderValueProperty()
        Bindings.bindBidirectional(mySlider.valueProperty(), viewModel.sliderValueProperty());

        // Binding một chiều từ viewModel.resultTextProperty() đến result_label.textProperty()
        result.textProperty().bind(viewModel.resultTextProperty());

    }
}
