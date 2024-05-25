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
    private inputStage_VM inputStage_vm;

    @FXML
    private CheckBox cbx_playsound;

    @FXML
    private TextField txt_buttonText;

    @FXML
    private TextArea txt_helptext;

    @FXML
    private TextField txt_question;
    
    public void setInputStageViewModel(inputStage_VM viewModel) {
        Experiment experiment = new Experiment();
        this.inputStage_vm = viewModel;
        txt_buttonText.textProperty().bindBidirectional(inputStage_vm.buttonTextProperty());
        txt_helptext.textProperty().bindBidirectional(inputStage_vm.contentProperty());
        txt_question.textProperty().bindBidirectional(inputStage_vm.titleProperty());
        cbx_playsound.selectedProperty().bindBidirectional(inputStage_vm.alertProperty());
    }

    @FXML
    void cbx_playsound(ActionEvent event) {

    }

    @FXML
    void txt_buttonText(ActionEvent event) {

    }

    @FXML
    void txt_helptext(MouseEvent event) {


    }

    @FXML
    void txt_question(ActionEvent event) {

    }


}
