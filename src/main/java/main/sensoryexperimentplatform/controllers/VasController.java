package main.sensoryexperimentplatform.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

import java.io.IOException;

public class VasController {

    @FXML
    private AnchorPane Properties;

    @FXML
    private StackPane VasStackPane;

    @FXML
    private Button addInputButton;

    @FXML
    private Label avatarLabel;

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
    private Button btn_addAudibleInstruction;

    @FXML
    private Button btn_addFoodAndTaste;

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
    private Button btn_noticeStage;

    @FXML
    private TextArea buttonTxtField;

    @FXML
    private CheckBox checkBoxSwap;

    @FXML
    private ChoiceBox<?> choiceBoxAvail;

    @FXML
    private Button crossButton;

    @FXML
    private Button downButton;

    @FXML
    private TextArea highAncTxtField;

    @FXML
    private TextArea highAncValField;

    @FXML
    private Label lbl_EditExperiment;

    @FXML
    private Label lbl_SenseXP;

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
    private TextArea lowAncTxtField;

    @FXML
    private TextArea lowAncValField;

    @FXML
    private Button menuButton;

    @FXML
    private TextArea questionField;

    @FXML
    private RadioButton radioButtonAvailable;

    @FXML
    private RadioButton radioButtonYes;

    @FXML
    private TextArea textFrame;

    @FXML
    private Button upButton;

    @FXML
    private TextArea yesField;

    @FXML
    void AddGLMSButton(ActionEvent event) throws IOException {
        new ScenseSwitch(VasStackPane,"/fxml/GLMS.fxml");
    }

    @FXML
    void AddInputButton(ActionEvent event) throws IOException {
        new ScenseSwitch(VasStackPane,"/fxml/InputStage.fxml");
    }

    @FXML
    void AddNoticeButton(ActionEvent event) throws IOException {
        new ScenseSwitch(VasStackPane,"/fxml/NoticeStage_1.fxml");


    }

    @FXML
    void AddTimerButton(ActionEvent event) throws IOException {
        new ScenseSwitch(VasStackPane,"/fxml/TimerStage.fxml");



    }


    @FXML
    void AddTastTestButton(ActionEvent event) throws IOException {
        new ScenseSwitch(VasStackPane,"/fxml/AddTasteTest.fxml");


    }
    @FXML
    void AssignSoundButton(ActionEvent event) throws IOException {
        new ScenseSwitch(VasStackPane,"/fxml/AddSound.fxml");


    }

    @FXML
    void AddQuestionStage(ActionEvent event) throws IOException {
        new ScenseSwitch(VasStackPane,"/fxml/QuestionStage.fxml");



    }
    @FXML
    void btn_menu(ActionEvent event) throws IOException {
        new ScenseSwitch(VasStackPane,"/fxml/EditExperiment_UI.fxml");

    }

}
