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


import main.sensoryexperimentplatform.models.AudibleInstruction;
import main.sensoryexperimentplatform.viewmodel.addSoundVM;
import main.sensoryexperimentplatform.viewmodel.assignSoundVM;

import java.io.IOException;

public class  assignSoundController {

    private ObservableList<String> SoundName;
    private ToggleGroup group = new ToggleGroup();

    private assignSoundVM viewModel;
    @FXML
    private ListView<String> SoundList;

    public void setViewModel(assignSoundVM viewModel){
        this.viewModel = viewModel;
        SoundName = FXCollections.observableArrayList();
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
       addSoundController.setViewModel(viewModel,this);
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
                radioButton.setToggleGroup(group);
                setGraphic(radioButton);
            }
        }
    }


}
