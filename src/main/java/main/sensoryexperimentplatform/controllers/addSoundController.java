package main.sensoryexperimentplatform.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import main.sensoryexperimentplatform.viewmodel.addSoundVM;
import main.sensoryexperimentplatform.viewmodel.assignSoundVM;

import javax.swing.*;
import java.io.File;

public class addSoundController {


    private assignSoundVM viewModel;
    private notiAddSound NotiAddSound;



    @FXML
    private Button btn_browse;

    @FXML
    private TextField txt_file;

    @FXML
    private TextField txt_name;



    public void setViewModel(assignSoundVM viewModel, assignSoundController AssignSoundController ) {
       this.viewModel = viewModel;
       NotiAddSound = new notiAddSound(AssignSoundController);
    }

//    private void bindViewModel() {
//        txt_file.textProperty().bindBidirectional(viewModel.fileProperty());
//        txt_name.textProperty().bindBidirectional(viewModel.nameProperty());
//
//
//    }

    @FXML
    void btn_browse(ActionEvent event) {
//        FileChooser fileChooser = new FileChooser();
//        File selectedFile = fileChooser.showOpenDialog(btn_browse.getScene().getWindow());
//        if (selectedFile != null) {
//            viewModel.setFile(selectedFile.getAbsolutePath());
//        }
    }

    @FXML
    void btn_cancel(ActionEvent event) {
        // Handle cancel button action
    }

    @FXML
    void btn_save(ActionEvent event) {
        viewModel.addListSoundshow(txt_name.getText());
        viewModel.addSound(txt_name.getText(),txt_file.getText());
        NotiAddSound.notifyObject();
        System.out.println(viewModel.getSoundMap());
    }

    @FXML
    void txt_file(ActionEvent event) {
    }

    @FXML
    void txt_name(ActionEvent event) {
    }
}
