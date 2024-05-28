package main.sensoryexperimentplatform.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import main.sensoryexperimentplatform.ViewModel.inputStage_VM;
import main.sensoryexperimentplatform.models.Experiment;

public class InputStageController {
    private inputStage_VM viewModel;

    @FXML
    private CheckBox cbx_alert;

    @FXML
    private TextField txt_buttonText;

    @FXML
    private TextArea txt_helptext;

    @FXML
    private TextField txt_question;
    public void initialize(){
        viewModel = new inputStage_VM();
        bindViewModel();

    }
    public void setViewModel(inputStage_VM viewModel){
        this.viewModel = viewModel;
    }

    public void bindViewModel(){
        txt_buttonText.textProperty().bindBidirectional(viewModel.buttonTextProperty());
        txt_helptext.textProperty().bindBidirectional(viewModel.contentProperty());
        txt_question.textProperty().bindBidirectional(viewModel.titleProperty());
        cbx_alert.selectedProperty().bindBidirectional(viewModel.alertProperty());

        // Add listeners for immediate update
        txt_buttonText.textProperty().addListener((observable, oldValue, newValue) -> {
            viewModel.setButtonText(newValue);
        });

        txt_helptext.textProperty().addListener((observable, oldValue, newValue) -> {
            viewModel.setHelpText(newValue);
        });

        txt_question.textProperty().addListener((observable, oldValue, newValue) -> {
            viewModel.setQuestion(newValue);
        });

        cbx_alert.selectedProperty().addListener((observable, oldValue, newValue) -> {
            viewModel.setAlert(newValue);
        });
    }
    /*public void initialize() {
        txt_buttonText.textProperty().bindBidirectional(inputStage_vm.buttonTextProperty());
        txt_helptext.textProperty().bindBidirectional(inputStage_vm.contentProperty());
        txt_question.textProperty().bindBidirectional(inputStage_vm.titleProperty());
        cbx_alert.selectedProperty().bindBidirectional(inputStage_vm.alertProperty());

    }*/


    @FXML
    void cbx_alert(ActionEvent event) {

    }

    @FXML
    void txt_buttonText(ActionEvent event) {



    }

    @FXML
    void txt_helptext(MouseEvent event) {


    }

    @FXML
    void txt_question(MouseEvent event) {


    }



}
