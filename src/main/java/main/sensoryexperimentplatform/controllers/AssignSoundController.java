package main.sensoryexperimentplatform.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import main.sensoryexperimentplatform.SensoryExperimentPlatform;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;


import main.sensoryexperimentplatform.viewmodel.AddSoundVM;
import main.sensoryexperimentplatform.viewmodel.AssignSoundVM;

import java.io.IOException;

public class AssignSoundController {
    @FXML
    private VBox ShowSound;


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



    private ObservableList<String> SoundName;
    private ToggleGroup group = new ToggleGroup();

    private AssignSoundVM viewModel;
    @FXML
    private ListView<String> SoundList;
    private RadioButton selectedRadioButton;;


    public void setViewModel(AssignSoundVM viewModel){
        this.viewModel = viewModel;
        SoundName = FXCollections.observableArrayList(viewModel.getListNameshow());
        loadSoundRadioButtons();
    }

    @FXML
    void AddButton(ActionEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(SensoryExperimentPlatform.class.getResource("addSound.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("Add Sound");
        Scene scene = new Scene(root);
        AddSoundVM addSoundVM = new AddSoundVM();
        stage.setScene(scene);
        AddSoundController addSoundController = fxmlLoader.getController();
       addSoundController.setViewModel(addSoundVM,this);
        stage.show();
    }

    public void loadSoundRadioButtons() {
        SoundList.setCellFactory(param -> new RadioListCell());
        SoundName.clear();
        SoundList.getItems().clear();
        SoundName.addAll(viewModel.getListNameshow());
        SoundList.getItems().addAll(SoundName);
    }
    class RadioListCell extends ListCell<String> {
        @Override
        public void updateItem(String obj, boolean empty) {
            super.updateItem(obj, empty);
            if (empty) {
                setText(null);
                setGraphic(null);
            } else {
                RadioButton radioButton = new RadioButton(obj);
                radioButton.setOnAction(event ->
                    selectedRadioButton = radioButton
                );
                radioButton.setToggleGroup(group);
                setGraphic(radioButton);
            }
        }
    }

    @FXML
    void btn_play(ActionEvent event) {
        if (selectedRadioButton != null) {
            String soundName = selectedRadioButton.getText();
            viewModel.playSound(soundName);
        }


    }

    @FXML
    void btn_refesh(ActionEvent event) {
        loadSoundRadioButtons();

    }

    @FXML
    void btn_remove(ActionEvent event) {
        if (selectedRadioButton != null) {
            String soundName = selectedRadioButton.getText();
            viewModel.removeSound(soundName);
            SoundName.remove(soundName);
            loadSoundRadioButtons();

        }

    }

    @FXML
    void btn_save(ActionEvent event) {
        Stage currentStage = (Stage) btn_save2.getScene().getWindow();
        currentStage.close();
       }

    @FXML
    void btn_stop(ActionEvent event) {
        if (selectedRadioButton != null) {
            String soundName = selectedRadioButton.getText();
            viewModel.stopSound(soundName);
        }

    }


}