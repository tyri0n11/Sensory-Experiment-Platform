package main.sensoryexperimentplatform.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import main.sensoryexperimentplatform.SensoryExperimentPlatform;
import main.sensoryexperimentplatform.View.ViewHandler;
import main.sensoryexperimentplatform.ViewModel.addSoundVM;

import java.io.IOException;

public class  assignSoundController {

    @FXML
    private AnchorPane AddsoundPane;

    @FXML
    private Label SoundSelectTionLabel;

    @FXML
    private Button btn_add;

    @FXML
    private Button btn_play;

    @FXML
    private Button btn_refresh;

    @FXML
    private Button btn_remove;

    @FXML
    private Button btn_save2;

    @FXML
    private Button btn_stop;

    @FXML
    void AddButton(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(SensoryExperimentPlatform.class.getResource("addSound.fxml"));
        Parent root = fxmlLoader.load();

        // Create a new stage
        Stage stage = new Stage();
        stage.setTitle("Add Sound");

        // Set the scene for the new stage
        Scene scene = new Scene(root);
        stage.setScene(scene);

        // Show the new stage
        stage.show();

    }

    public void init(addSoundVM addSoundVM, ViewHandler viewHandler) {
    }
//    public void addRadioButton(String text) {
//        RadioButton radioButton = new RadioButton(text);
//
//        VBox.setMargin(radioButton, new Insets(5, 0, 0, 0)); // Adjust margins as needed
//        ((VBox)AddsoundPane.getChildren().get(0)).getChildren().add(radioButton);
//    }
}
