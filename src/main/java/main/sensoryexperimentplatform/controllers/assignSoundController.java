package main.sensoryexperimentplatform.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import main.sensoryexperimentplatform.SensoryExperimentPlatform;
import main.sensoryexperimentplatform.View.ViewHandler;
import main.sensoryexperimentplatform.ViewModel.addSoundVM;

import main.sensoryexperimentplatform.models.AudibleInstruction;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class  assignSoundController {
    @FXML
    private VBox ShowSound;
    private ToggleGroup toggleGroup;
    private List<String> soundName;
    private AudibleInstruction audibleInstruction;



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

    public assignSoundController(){
        this.soundName=new ArrayList<>();
        soundName.add("good");

    }
    public void initialize() {

        loadSoundRadioButtons();
    }
    @FXML
    void AddButton(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(SensoryExperimentPlatform.class.getResource("addSound.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("Add Sound");
        Scene scene = new Scene(root);
        stage.setScene(scene);
        addSoundController addSoundController = fxmlLoader.getController();
        addSoundVM addSoundVM = new addSoundVM();
        stage.show();

    }

    private void loadSoundRadioButtons() {
        toggleGroup = new ToggleGroup();

        for (String soundNames:soundName) {
            RadioButton radioButton = new RadioButton(soundNames); // Create a radio button for each sound name
            radioButton.setToggleGroup(toggleGroup); // Add the radio button to the toggle group
            ShowSound.getChildren().add(radioButton); // Add the radio button to the VBox
            }
    }


//    public void addRadioButton(String text) {
//        RadioButton radioButton = new RadioButton(text);
//
//        VBox.setMargin(radioButton, new Insets(5, 0, 0, 0)); // Adjust margins as needed
//        ((VBox)AddsoundPane.getChildren().get(0)).getChildren().add(radioButton);
//    }

}
