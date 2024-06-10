package main.sensoryexperimentplatform.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import main.sensoryexperimentplatform.viewmodel.addSoundVM;

import javax.swing.*;
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
        bindViewModel();
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

         if (txt_name.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Name and Sound file are not imported yet","The sound was not sucessfully imported",
                    JOptionPane.ERROR_MESSAGE);

        }
        else if (txt_file.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"The sound was not sucessfully impoerted  ","File Name and Sound are not imported yet",
                    JOptionPane.ERROR_MESSAGE);
        }
        else if (txt_file.getText().isEmpty()&& txt_name.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"The sound was not sucessfully impoerted  ","File Name and Sound are not imported yet",
                    JOptionPane.ERROR_MESSAGE);
        }
        else{
             JOptionPane.showInternalConfirmDialog(null, "The sound was successfully imported","IMPORT SOUND SUCESSFULLY",
                    JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
//             FXMLLoader loader = new FXMLLoader(getClass().getResource("main/sensoryexperimentplatform/AssignSound.fxml"));
//             try {
//                 Parent parent = loader.load();
//                 assignSoundController controller = loader.getController();
//                 controller.addRadioButton(txt_name.getText());
//             } catch (IOException e) {
//                 e.printStackTrace();
//             }

        }


    }

    @FXML
    void txt_file(ActionEvent event) {
    }

    @FXML
    void txt_name(ActionEvent event) {
    }
}
