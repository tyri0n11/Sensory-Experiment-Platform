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
    private Button btnBack;

    @FXML
    private Button btnText;

    @FXML
    private Label highAnchorLbl1;

    @FXML
    private ListView<?> list;

    @FXML
    private Label lowAnchorLbl;

    @FXML
    private ProgressBar progressBar;

    @FXML
    private Label resultLbl;

    @FXML
    private Label runLbl;

    @FXML
    private Label senseXPlbl;

    @FXML
    private Slider slider;
    @FXML
    public void initialize() throws Exception {
        Font customFont = Font.loadFont(getClass().getResourceAsStream("/static/fonts/CustomFont.ttf"), 32);
        senseXPlbl.setFont(customFont);

        sliderHandler();

        Experiment experiment = DataAccess.getExperimentIndividually();




    }
    private void sliderHandler(){
        // Set initial label text
        resultLbl.setText((int) slider.getValue() + "%");

        // Add listener to slider value changes
        slider.valueProperty().addListener((observable, oldValue, newValue) -> {
            double value = newValue.doubleValue();
            int percentValue = (int) value;
            String color = "#397E82";

            // Update the label text
            resultLbl.setText(percentValue + "%");

            // Access the thumb and set the label's position
            slider.applyCss(); // Ensure CSS is applied
            var thumb = slider.lookup(".thumb");
            if (thumb != null) {
                resultLbl.setLayoutX(thumb.getLayoutX() + slider.getLayoutX() - resultLbl.getWidth() / 2);
            }
        });

        // Initial position of the label
        slider.applyCss();
        var thumb = slider.lookup(".thumb");
        if (thumb != null) {
            resultLbl.setLayoutX((thumb.getLayoutX() + slider.getLayoutX()) / 2);
        }
    }
}
