package main.sensoryexperimentplatform.controllers;

import javafx.beans.binding.Bindings;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;

import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import main.sensoryexperimentplatform.viewmodel.RunGLMS_VM;

public class RunGLMSController {

    @FXML
    private Slider mySlider;
    @FXML
    private Button help_icon;
    @FXML
    private Label questionlbl, helpText;

    private RunGLMS_VM viewModel;
    private Runnable sliderValueListener;

    public void setViewModel(RunGLMS_VM viewModel) {
        this.viewModel = viewModel;

        Tooltip helpTooltip = new Tooltip(viewModel.helpProperty().get());
        help_icon.setTooltip(helpTooltip);

        bindViewModel();

        // Enable the Next button when the slider is interacted with
        mySlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            if (sliderValueListener != null) {
                sliderValueListener.run();
            }
        });
    }

    public void setSliderValueListener(Runnable listener) {
        this.sliderValueListener = listener;
    }



    private void bindViewModel() {
        // Bind viewModel properties to the labels
        questionlbl.textProperty().bind(viewModel.questionProperty());
        helpText.textProperty().bind(viewModel.helpProperty());


        // Two-way binding between slider value and viewModel.sliderValueProperty()
        Bindings.bindBidirectional(mySlider.valueProperty(), viewModel.sliderValueProperty());

    }

}
