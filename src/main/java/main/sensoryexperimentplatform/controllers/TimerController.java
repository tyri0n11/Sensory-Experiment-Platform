package main.sensoryexperimentplatform.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

import java.io.IOException;

public class TimerController {

    @FXML
    private TextField txt_instruction;

    @FXML
    private TextField txt_time;

    @FXML
    private StackPane TimerStackPane;
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
        new ScenseSwitch(TimerStackPane,"/fxml/AssignSound.fxml");



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
