package main.sensoryexperimentplatform.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import main.sensoryexperimentplatform.ViewModel.addSoundVM;

import java.io.File;

public class addSoundController {

    private addSoundVM viewModel;

    @FXML
    private Label FileLabel;

    @FXML
    private Label ImportSoundLabel;

    @FXML
    private AnchorPane ImportSoundPane;

    @FXML
    private Label NameLabel;

    @FXML
    private Button btn_browse;

    @FXML
    private Button btn_cancel;

    @FXML
    private Button btn_save;

    @FXML
    private TextField txt_file;

    @FXML
    private TextField txt_name;

    public void initialize() {
        viewModel = new addSoundVM();
        bindViewModel();
    }

    public void setViewModel(addSoundVM viewModel) {
        this.viewModel = viewModel;
    }

    private void bindViewModel() {
        txt_file.textProperty().bindBidirectional(viewModel.fileProperty());
        txt_name.textProperty().bindBidirectional(viewModel.nameProperty());
    }

    @FXML
    void btn_browse(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        File selectedFile = fileChooser.showOpenDialog(btn_browse.getScene().getWindow());
        if (selectedFile != null) {
            viewModel.setFile(selectedFile.getAbsolutePath());
        }
    }

    @FXML
    void btn_cancel(ActionEvent event) {
        // Handle cancel button action
    }

    @FXML
    void btn_save(ActionEvent event) {
        // Handle save button action
    }

    @FXML
    void txt_file(ActionEvent event) {
        // Handle text field action
    }

    @FXML
    void txt_name(ActionEvent event) {
        // Handle text field action
    }
}
