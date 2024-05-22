package main.sensoryexperimentplatform.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import main.sensoryexperimentplatform.ViewModel.addFood2VM;

import java.net.URL;
import java.util.ResourceBundle;

public class addFoodController2 implements Initializable {
    private addFood2VM addVM;
    @FXML
    private TextField txt_nameFood;
    @FXML
    private void btn_noticeStage(){
        
    }

    public void btn_addAudibleInstruction(ActionEvent event) {
    }

    public void btn_assignSound(ActionEvent event) {
    }

    public void btn_addInput(ActionEvent event) {
    }

    public void btn_addTimer(ActionEvent event) {
    }

    public void btn_addTasteTest(ActionEvent event) {
    }

    public void btn_addFoodAndTaste(ActionEvent event) {
    }

    public void btn_addRatingContainer(ActionEvent event) {
    }

    public void btn_addVasStage(ActionEvent event) {
    }

    public void btn_AddGLMS(ActionEvent event) {
    }

    public void btn_AddCourse(ActionEvent event) {
    }

    public void btn_AddPeriodicStage(ActionEvent event) {
    }

    public void btn_AddConditionalStatement(ActionEvent event) {
    }

    public void btn_AddQuestionStage(ActionEvent event) {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addVM= new addFood2VM();
        txt_nameFood.textProperty().bindBidirectional(addVM.nameProperty());
    }
}
