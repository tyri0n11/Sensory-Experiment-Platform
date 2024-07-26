package main.sensoryexperimentplatform.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import main.sensoryexperimentplatform.viewmodel.vasStage_VM;

public class VasController {
    private vasStage_VM vasStageVM;

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
    private Label lbl_highAnchorText;

    @FXML
    private Label lbl_highAnchorValue;

    @FXML
    private Label lbl_highAnchortext;

    @FXML
    private Label lbl_lowAnchorValue;

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
    private TextField txt_BtnTxt;

    @FXML
    private TextField txt_HighAncTxt;

    @FXML
    private TextField txt_HighAncVal;

    @FXML
    private TextField txt_LowAncTxt;

    @FXML
    private TextField txt_LowAncVal;

    @FXML
    private TextField txt_help;

    @FXML
    private TextField txt_question;

    @FXML
    private TextField txt_yes;
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private AnchorPane outterPane;
    @FXML
    private AnchorPane innerPane;
    @FXML
    private void initialize() {
        scrollPane.prefWidthProperty().bind(outterPane.widthProperty());
        scrollPane.prefHeightProperty().bind(outterPane.heightProperty());
        // Bind the innerPane's size to the scrollPane's viewport size
        innerPane.prefWidthProperty().bind(scrollPane.widthProperty());
        innerPane.prefHeightProperty().bind(scrollPane.heightProperty());
    }



    private void bind(){
        txt_question.textProperty().bindBidirectional(vasStageVM.questionTextProperty());
        txt_LowAncTxt.textProperty().bindBidirectional(vasStageVM.lowAnchorTextProperty());
        txt_HighAncTxt.textProperty().bindBidirectional(vasStageVM.highAnchorTextProperty());
        txt_LowAncTxt.textProperty().bindBidirectional(vasStageVM.lowAnchorTextProperty());
        txt_LowAncVal.textProperty().bindBidirectional(vasStageVM.lowAnchorValueProperty());
        txt_HighAncVal.textProperty().bindBidirectional(vasStageVM.highAnchorValueProperty());
        txt_BtnTxt.textProperty().bindBidirectional(vasStageVM.buttonTextProperty());
        txt_help.textProperty().bindBidirectional(vasStageVM.helpTextProperty());
        //txt_yes.textProperty().bindBidirectional(vasStageVM.txt_yesProperty());
        checkB_sound.selectedProperty().bindBidirectional(vasStageVM.checkB_soundProperty());
        checkB_swap.selectedProperty().bindBidirectional(vasStageVM.checkB_swapProperty());
    }
    public void setViewModel(vasStage_VM vas){
        this.vasStageVM = vas;
        bind();

    }

}