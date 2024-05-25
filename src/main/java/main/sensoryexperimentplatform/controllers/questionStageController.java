package main.sensoryexperimentplatform.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import main.sensoryexperimentplatform.ViewModel.questionStage_VM;

public class questionStageController {
    private questionStage_VM questionStage_vm;

    @FXML
    private Label fontLabel;

    @FXML
    private Label lbl_helpText;

    @FXML
    private Label lbl_leftbutton;

    @FXML
    private Label lbl_leftbuttonValue;

    @FXML
    private Label lbl_question;

    @FXML
    private AnchorPane lbl_righbutton;

    @FXML
    private Label lbl_rightButtonValue;

    @FXML
    private Label lbl_storeResponse;

    @FXML
    private TextArea txt_helpText;

    @FXML
    private TextField txt_leftText;

    @FXML
    private TextField txt_leftValue;

    @FXML
    private TextField txt_question;

    @FXML
    private TextField txt_rightText;

    @FXML
    private TextField txt_rightvalue;

    @FXML
    private CheckBox cbx_alert;

    @FXML
    void txt_question(ActionEvent event) {

    }

    @FXML
    void txt_rightvalue(ActionEvent event) {

    }
    public void initialize(){
        txt_helpText.textProperty().bindBidirectional(questionStage_vm.helpTextProperty());
        txt_leftText.textProperty().bindBidirectional(questionStage_vm.leftTextProperty());
        txt_rightText.textProperty().bindBidirectional(questionStage_vm.rightTextProperty());
        txt_question.textProperty().bindBidirectional(questionStage_vm.questionProperty());
        txt_leftValue.textProperty().bindBidirectional(questionStage_vm.leftValueProperty());
        txt_rightvalue.textProperty().bindBidirectional(questionStage_vm.rightValueProperty());
        cbx_alert.selectedProperty().bindBidirectional(questionStage_vm.alertProperty());




    }

}
