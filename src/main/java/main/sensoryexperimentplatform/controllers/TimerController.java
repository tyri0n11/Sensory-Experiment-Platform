package main.sensoryexperimentplatform.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

import java.io.IOException;

public class TimerController {



    @FXML
    private AnchorPane Properties;

    @FXML
    private StackPane TimerStackPane;

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
    private Button btn_cross;

    @FXML
    private Button btn_down;

    @FXML
    private Button btn_menu;

    @FXML
    private Button btn_noticeStage;

    @FXML
    private Button btn_up;

    @FXML
    private Label lbl_EditExperiment;

    @FXML
    private Label lbl_SenseXP;

    @FXML
    private Label lbl_instruction;

    @FXML
    private Label lbl_soundDisplay;

    @FXML
    private Label lbl_timeToWait;

    @FXML
    private TextArea textField1;

    @FXML
    private TextArea textFrame;

    @FXML
    void AddGLMSbutton(ActionEvent event) throws IOException {
        new ScenseSwitch(TimerStackPane,"/fxml/GLMS.fxml");



    }

    @FXML
    void AddInputStageButton(ActionEvent event) throws IOException {
        new ScenseSwitch(TimerStackPane,"/fxml/InputStage.fxml");



    }

    @FXML
    void AddNoticeButton(ActionEvent event) throws IOException {
        new ScenseSwitch(TimerStackPane,"/fxml/NoticeStage_1.fxml");



    }

    @FXML
    void AddTasteTestButton(ActionEvent event) throws IOException {
        new ScenseSwitch(TimerStackPane,"/fxml/AddTasteTest.fxml");



    }

    @FXML
    void AddTimerStageButton(ActionEvent event) {


    }

    @FXML
    void AddVasButton(ActionEvent event) throws IOException {
        new ScenseSwitch(TimerStackPane,"/fxml/VasStage.fxml");


    }

    @FXML
    void AssignSoundButton(ActionEvent event) throws IOException {
        new ScenseSwitch(TimerStackPane,"/fxml/AddSound.fxml");



    }

    @FXML
    void AddQuestionButton(ActionEvent event) throws IOException {
        new ScenseSwitch(TimerStackPane,"/fxml/QuestionStage.fxml");



    }
    @FXML
    void btn_menu(ActionEvent event) throws IOException {
        new ScenseSwitch(TimerStackPane,"/fxml/EditExperiment_UI.fxml");

    }


}
