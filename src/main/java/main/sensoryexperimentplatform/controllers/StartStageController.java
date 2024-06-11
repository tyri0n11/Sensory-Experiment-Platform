package main.sensoryexperimentplatform.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import main.sensoryexperimentplatform.viewmodel.StartVM;

public class StartStageController {
    private StartVM startVM;

    @FXML
    private ColorPicker backGroundColor;

    @FXML
    private Button btn_DisableColor;

    @FXML
    private Button btn_changeColor;

    @FXML
    private Button btn_font;

    @FXML
    private Button btn_textColor;
    @FXML
    private ColorPicker disablebuttoncolor;


    @FXML
    private CheckBox cbx_balance;

    @FXML
    private ChoiceBox<?> chx_change;

    @FXML
    private ChoiceBox<?> chx_disableColor;

    @FXML
    private ColorPicker textColor;

    @FXML
    private TextField txt_ButtonText;

    @FXML
    private TextField txt_EndtimeDelay;

    @FXML
    private TextField txt_StarttimeDelay;

    @FXML
    private TextArea txt_content;

    @FXML
    private TextField txt_title;

    @FXML
    void btn_DisableColor(ActionEvent event) {

    }

    @FXML
    void btn_changeColor(ActionEvent event) {

    }

    @FXML
    void btn_font(ActionEvent event) {

    }

    @FXML
    void btn_textColor(ActionEvent event) {

    }

    @FXML
    void txt_question(MouseEvent event) {

    }

    public void setViewModel(StartVM startVM) {
        this.startVM = startVM;
    }
}
