package main.sensoryexperimentplatform.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

import java.io.IOException;

public class NoticeStageController {

    @FXML
    private StackPane NoticeStagePane;



    @FXML
    void btn_AddConditionalStatement(ActionEvent event) {

    }

    @FXML
    void btn_AddCourse(ActionEvent event) {

    }

    @FXML
    void btn_AddGLMS(ActionEvent event) throws IOException {
        new ScenseSwitch(NoticeStagePane,"/fxml/GLMS.fxml");


    }

    @FXML
    void btn_AddPeriodicStage(ActionEvent event) {

    }

    @FXML
    void btn_AddQuestionStage(ActionEvent event) throws IOException {
        new ScenseSwitch(NoticeStagePane,"/fxml/QuestionStage.fxml");


    }

    @FXML
    void btn_addAudibleInstruction(ActionEvent event) {

    }

    @FXML
    void btn_addFoodAndTaste(ActionEvent event) {

    }

    @FXML
    void btn_addInput(ActionEvent event) throws IOException {
        new ScenseSwitch(NoticeStagePane,"/fxml/InputStage.fxml");


    }

    @FXML
    void btn_addRatingContainer(ActionEvent event) {

    }

    @FXML
    void btn_addTasteTest(ActionEvent event) {

    }

    @FXML
    void btn_addTimer(ActionEvent event) throws IOException {
        new ScenseSwitch(NoticeStagePane,"/fxml/TimerStage.fxml");


    }

    @FXML
    void btn_assignSound(ActionEvent event) {

    }

    @FXML
    void btn_changeBackGroudcolor(ActionEvent event) {

    }

    @FXML
    void btn_menu(ActionEvent event) {

    }

    @FXML
    void btn_noticeStage(ActionEvent event) throws IOException {
        new ScenseSwitch(NoticeStagePane,"/fxml/NoticeStage_1.fxml");


    }
    @FXML
    void btn_addVasStage(ActionEvent event) throws IOException {
        new ScenseSwitch(NoticeStagePane,"/fxml/NoticeStage_1.fxml");


    }

}
