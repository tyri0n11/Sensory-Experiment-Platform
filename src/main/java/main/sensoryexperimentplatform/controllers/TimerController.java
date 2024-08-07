package main.sensoryexperimentplatform.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.StackPane;
import main.sensoryexperimentplatform.viewmodel.timerStage_VM;

import java.io.IOException;

public class TimerController {
    private timerStage_VM timerVM;

    @FXML
    private CheckBox cb_alertSound;


    @FXML
    private TextField txt_instruction;

    @FXML
    private TextField txt_timewait;

    @FXML
    private StackPane TimerStackPane;

    @FXML
    void AddGLMSbutton(ActionEvent event) throws IOException {
        new ScenseSwitch(TimerStackPane, "/fxml/GLMS.fxml");
    }

    public void setViewModel(timerStage_VM timerVM){
        this.timerVM = timerVM;
        bind();
    }

    private void bind() {
        txt_instruction.textProperty().bindBidirectional(timerVM.txt_instructionProperty());
        txt_timewait.textProperty().bindBidirectional(timerVM.txt_timewaitProperty());
        cb_alertSound.selectedProperty().bindBidirectional(timerVM.cb_alertSoundProperty());
    }
}
