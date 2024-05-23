package main.sensoryexperimentplatform.controllers;

import javafx.beans.property.Property;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.util.converter.NumberStringConverter;
import main.sensoryexperimentplatform.ViewModel.vasStage_VM;

import java.io.IOException;

public class VasController {
    private vasStage_VM vasStageVM;

    @FXML
    private StackPane VasStackPane;


    @FXML
    private Button btn_menu;

    @FXML
    private Button btn_noticeStage;

    @FXML
    private CheckBox checkB_sound;

    @FXML
    private CheckBox checkB_swap;

    @FXML
    private ChoiceBox<?> choiceB_avail;


    @FXML
    private RadioButton radioBtn_Yes;

    @FXML
    private RadioButton radioBtn_available;

    @FXML
    private TextArea textFrame;

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
    private Button upButton;

    public void initialize(vasStage_VM vasStageVM){
        this.vasStageVM = vasStageVM;
        NumberStringConverter converter = new NumberStringConverter();
        txt_question.textProperty().bindBidirectional(vasStageVM.questionTextProperty());
        txt_LowAncTxt.textProperty().bindBidirectional(vasStageVM.lowAnchorTextProperty());
        txt_HighAncTxt.textProperty().bindBidirectional(vasStageVM.highAnchorTextProperty());
        txt_LowAncTxt.textProperty().bindBidirectional(vasStageVM.lowAnchorTextProperty());
        txt_LowAncVal.textProperty().bindBidirectional(vasStageVM.lowAnchorValueProperty(), converter);
        txt_HighAncVal.textProperty().bindBidirectional(vasStageVM.highAnchorValueProperty(), converter);
        txt_BtnTxt.textProperty().bindBidirectional(vasStageVM.buttonTextProperty());

    }

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
