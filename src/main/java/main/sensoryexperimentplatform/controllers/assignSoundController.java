package main.sensoryexperimentplatform.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import main.sensoryexperimentplatform.SensoryExperimentPlatform;


import main.sensoryexperimentplatform.ViewModel.assignSoundVM;
import main.sensoryexperimentplatform.models.AudibleInstruction;
import main.sensoryexperimentplatform.viewmodel.addSoundVM;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class  assignSoundController {
    @FXML
    private VBox ShowSound;
    private ToggleGroup toggleGroup;
    private List<String> soundName;
    private AudibleInstruction audibleInstruction;
    private assignSoundVM viewModel;



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
        this.soundName = new ArrayList<>();
        soundName.add("good");

    }
    public void initialize() {

     //   loadSoundRadioButtons();
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

//    private void loadSoundRadioButtons() {
//        //soundName.addAll(viewModel.getSoundName());
//        toggleGroup = new ToggleGroup();
//
//        for (String soundNames:soundName) {
//            RadioButton radioButton = new RadioButton(soundNames);
//            radioButton.setToggleGroup(toggleGroup);
//            ShowSound.getChildren().add(radioButton);
//
//        }
//    }
    void setViewModel(assignSoundVM viewModel){
        this.viewModel = viewModel;
    }


//    public void addRadioButton(String text) {
//        RadioButton radioButton = new RadioButton(text);
//
//        VBox.setMargin(radioButton, new Insets(5, 0, 0, 0)); // Adjust margins as needed
//        ((VBox)AddsoundPane.getChildren().get(0)).getChildren().add(radioButton);
//    }

}
