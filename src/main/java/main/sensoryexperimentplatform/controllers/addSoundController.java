package main.sensoryexperimentplatform.controllers;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import main.sensoryexperimentplatform.viewmodel.assignSoundVM;
import java.io.File;

public class addSoundController {


    private assignSoundVM viewModel;
    private notiAddSound NotiAddSound;
    private assignSoundController AssignSoundController;



    @FXML
    private Button btn_browse;
    @FXML
    private Button btn_cancel;

    @FXML
    private TextField txt_file;

    @FXML
    private TextField txt_name;



    public void setViewModel(assignSoundVM viewModel, assignSoundController AssignSoundController ) {
       this.viewModel = viewModel;
       this.AssignSoundController = AssignSoundController;
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

        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("MP3 Files","*.mp3")
        );
        File selectedFile = fileChooser.showOpenDialog(btn_browse.getScene().getWindow());
        if (selectedFile != null) {

            txt_file.setText(selectedFile.getAbsolutePath());
        }
    }

    @FXML
    void btn_cancel(ActionEvent event) {
        Stage currentStage = (Stage) btn_cancel.getScene().getWindow();
        currentStage.close();
    }

    @FXML
    void btn_save(ActionEvent event) {
        viewModel.addListSoundshow(txt_name.getText());
        viewModel.addSound(txt_name.getText(),txt_file.getText());
        NotiAddSound.notifyObject();
        AssignSoundController.addNewSound(txt_name.getText());
        Stage currentStage = (Stage) btn_cancel.getScene().getWindow();
        currentStage.close();
        System.out.println(viewModel.getListNameshow());

    }

    @FXML
    void txt_file(ActionEvent event) {
    }

    @FXML
    void txt_name(ActionEvent event) {
    }
}
