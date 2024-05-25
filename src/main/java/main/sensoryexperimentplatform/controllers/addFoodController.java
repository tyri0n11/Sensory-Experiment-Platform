package main.sensoryexperimentplatform.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import main.sensoryexperimentplatform.ViewModel.addFoodVM;

import java.net.URL;
import java.util.ResourceBundle;

public class addFoodController implements Initializable {
    @FXML
    private TextField txt_nameFood;

    @FXML
    private Label AddFoodLabel;

    @FXML
    private AnchorPane AddFoodPane;

    @FXML
    private Button CancelButton1;

    @FXML
    private Button SaveButton1;

    @FXML
    private AnchorPane SenseXPBar;

    @FXML
    private AnchorPane SideBar;

    @FXML
    private Button btn_AddConditionalStatement;

    @FXML
    private Button btn_AddCourse;

    @FXML
    private Button btn_AddGLMS;

    @FXML
    private Button btn_AddPeriodicStage;

    @FXML
    private Button btn_AddQuestionStage;

    @FXML
    private Button btn_Logout;

    @FXML
    private Button btn_addAudibleInstruction;

    @FXML
    private Button btn_addFoodAndTaste;

    @FXML
    private Button btn_addInput;

    @FXML
    private Button btn_addRatingContainer;

    @FXML
    private Button btn_addTasteTest;

    @FXML
    private Button btn_addTimer;

    @FXML
    private Button btn_addVasStage;

    @FXML
    private Button btn_assignSound;

    @FXML
    private Button btn_config;

    @FXML
    private Button btn_dashboard_left;

    @FXML
    private Button btn_edit;

    @FXML
    private Button btn_export;

    @FXML
    private Button btn_import;

    @FXML
    private Button btn_noticeStage;

    @FXML
    private Button btn_share_experiment;

    @FXML
    private Label lbl_EditExperiment;

    @FXML
    private Label lbl_EditExperiment1;

    @FXML
    private Label lbl_SenseXP;

    @FXML
    private Label lbl_TasteTestItemLable;

    @FXML
    private AnchorPane mainBar;

    @FXML
    private Label please1Label;

    @FXML
    private AnchorPane sidebar_left;
    private addFoodVM addVM;

    @FXML
    void btn_AddConditionalStatement(ActionEvent event) {

    }

    @FXML
    void btn_AddCourse(ActionEvent event) {

    }

    @FXML
    void btn_AddGLMS(ActionEvent event) {

    }

    @FXML
    void btn_AddPeriodicStage(ActionEvent event) {

    }

    @FXML
    void btn_AddQuestionStage(ActionEvent event) {

    }

    @FXML
    void btn_addAudibleInstruction(ActionEvent event) {

    }

    @FXML
    void btn_addFoodAndTaste(ActionEvent event) {

    }

    @FXML
    void btn_addInput(ActionEvent event) {

    }

    @FXML
    void btn_addRatingContainer(ActionEvent event) {

    }

    @FXML
    void btn_addTasteTest(ActionEvent event) {

    }

    @FXML
    void btn_addTimer(ActionEvent event) {

    }

    @FXML
    void btn_addVasStage(ActionEvent event) {

    }

    @FXML
    void btn_assignSound(ActionEvent event) {

    }

    @FXML
    void btn_noticeStage(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addVM = new addFoodVM();
        txt_nameFood.textProperty().bindBidirectional(addVM.nameProperty());
    }
}
