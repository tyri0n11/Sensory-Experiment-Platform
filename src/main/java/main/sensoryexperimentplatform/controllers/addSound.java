package main.sensoryexperimentplatform.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import main.sensoryexperimentplatform.View.ViewHandler;
import main.sensoryexperimentplatform.ViewModel.addFood2VM;
import main.sensoryexperimentplatform.ViewModel.addSoundVM;

import java.net.URL;
import java.util.ResourceBundle;

public class addSound{
    private addSoundVM addSound;
    @FXML
    public TextField txt_file;
    @FXML
    public TextField txt_name;
    private ViewHandler viewHandler;
    private addSoundVM addSoundVM;

    public void btn_AddQuestionStage(){
        
    }

    public void btn_AddConditionalStatement(ActionEvent event) {
    }

    public void btn_AddPeriodicStage(ActionEvent event) {
    }

    public void btn_AddCourse(ActionEvent event) {
    }

    public void btn_AddGLMS(ActionEvent event) {
    }

    public void btn_addVasStage(ActionEvent event) {
    }

    public void btn_addRatingContainer(ActionEvent event) {
    }

    public void btn_addFoodAndTaste(ActionEvent event) {
    }

    public void btn_addTasteTest(ActionEvent event) {
    }

    public void btn_addTimer(ActionEvent event) {
    }

    public void btn_addInput(ActionEvent event) {
    }

    public void btn_assignSound(ActionEvent event) {
    }

    public void btn_addAudibleInstruction(ActionEvent event) {
    }

    public void btn_noticeStage(ActionEvent event) {
    }

    public void init(addSoundVM addSoundVM, ViewHandler viewHandler) {
        this.viewHandler = viewHandler;
        this.addSoundVM = addSoundVM;
        txt_file.textProperty().bindBidirectional(addSound.fileProperty());
        txt_name.textProperty().bindBidirectional(addSound.nameProperty());
    }
}
