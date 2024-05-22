package main.sensoryexperimentplatform.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.Font;
import main.sensoryexperimentplatform.models.DataAccess;
import main.sensoryexperimentplatform.models.Experiment;

import java.io.InputStream;

import static java.awt.font.TextAttribute.FONT;

public class RunVasController {

    @FXML
    private Label highAnchor_label;

    @FXML
    private Label lowAnchor_label;

    @FXML
    private TextArea questionTxt;

    @FXML
    private Label result_label;
    @FXML Slider mySlider;
    @FXML
    public void initialize() throws Exception {

    sliderHandler();



    }
    private void sliderHandler(){
        // Set initial label text
        result_label.setText((int) mySlider.getValue() + "%");

        // Add listener to slider value changes
        mySlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            double value = newValue.doubleValue();
            int percentValue = (int) value;

            // Update the label text
            result_label.setText(percentValue + "%");

            // Access the thumb and set the label's position
            mySlider.applyCss(); // Ensure CSS is applied
            var thumb = mySlider.lookup(".thumb");
            if (thumb != null) {
                result_label.setLayoutX(thumb.getLayoutX() + mySlider.getLayoutX() - mySlider.getWidth() / 2);
            }
        });

        // Initial position of the label
        mySlider.applyCss();
        var thumb = mySlider.lookup(".thumb");
        if (thumb != null) {
            result_label.setLayoutX((thumb.getLayoutX() + mySlider.getLayoutX()) / 2);
        }
    }
}
