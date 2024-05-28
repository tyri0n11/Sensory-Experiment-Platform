package main.sensoryexperimentplatform.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import main.sensoryexperimentplatform.ViewModel.glmsStage_VM;
import main.sensoryexperimentplatform.models.gLMS;

import java.io.IOException;

public class GLMSController {

    private glmsStage_VM glmsStageVm;
    @FXML
    private CheckBox checkB_sound;

    @FXML
    private CheckBox checkB_swap;

    @FXML
    private ChoiceBox<?> choiceB_avail;

    @FXML
    private Label lbl_buttonText;

    @FXML
    private Label lbl_help;

    @FXML
    private Label lbl_playSound;

    @FXML
    private Label lbl_storeResponse;

    @FXML
    private Label lbl_swapPole;

    @FXML
    private RadioButton radioBtn_Yes;

    @FXML
    private RadioButton radioBtn_available;

    @FXML
    private TextField txt_LowAncTxt;

    @FXML
    private TextField txt_help;

    @FXML
    private TextField txt_question;

    @FXML
    private TextField txt_yes;


    private void bind() {
        txt_LowAncTxt.textProperty().bindBidirectional(glmsStageVm.txt_LowAncTxtProperty());
        txt_help.textProperty().bindBidirectional(glmsStageVm.txt_helpProperty());
        txt_question.textProperty().bindBidirectional(glmsStageVm.txt_questionProperty());
        txt_yes.textProperty().bindBidirectional(glmsStageVm.txt_yesProperty());
        checkB_sound.selectedProperty().bindBidirectional(glmsStageVm.checkB_soundProperty());
        checkB_swap.selectedProperty().bindBidirectional(glmsStageVm.checkB_swapProperty());
    }

    public void setViewModel(glmsStage_VM glms) {
        this.glmsStageVm = glms;
        bind();
    }
}
