package main.sensoryexperimentplatform.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import main.sensoryexperimentplatform.ViewModel.questionStage_VM;
import main.sensoryexperimentplatform.ViewModel.vasStage_VM;
import main.sensoryexperimentplatform.models.Question;

public class questionStageController {
    private questionStage_VM viewModel;

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
    private Question question;


    @FXML
    void txt_question(ActionEvent event) {

    }

    @FXML
    void txt_rightvalue(ActionEvent event) {

    }


    public void setQuestionStage_vm( questionStage_VM viewModel){
        this.viewModel = viewModel;
        bindViewModel();
    }
    public void bindViewModel(){
        txt_helpText.textProperty().bindBidirectional(viewModel.helpTextProperty());
        txt_leftText.textProperty().bindBidirectional(viewModel.leftTextProperty());
        txt_rightText.textProperty().bindBidirectional(viewModel.rightTextProperty());
        txt_question.textProperty().bindBidirectional(viewModel.questionProperty());
        txt_leftValue.textProperty().bindBidirectional(viewModel.leftValueProperty());
        txt_rightvalue.textProperty().bindBidirectional(viewModel.rightValueProperty());
        cbx_alert.selectedProperty().bindBidirectional(viewModel.alertProperty());

        txt_helpText.textProperty().addListener((observable, oldValue, newValue) -> {
            viewModel.setHelpText(newValue);
            System.out.println(viewModel.getHelpText());
//
//
        });
        cbx_alert.selectedProperty().addListener((observable, oldValue, newValue) -> {
            viewModel.setAlert(newValue);

        });

    }

}
