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
    private CheckBox cbx_balance;

    @FXML
    private ChoiceBox<?> chx_change;

    @FXML
    private ColorPicker disablebuttoncolor;

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
        bindi();
    }

    private void bindi() {
        txt_title.textProperty().bindBidirectional(startVM.titleProperty());
        txt_content.textProperty().bindBidirectional(startVM.contentProperty());
        backGroundColor.valueProperty().bindBidirectional(startVM.colorBackGroundProperty());
        cbx_balance.selectedProperty().bindBidirectional(startVM.balanceProperty());
        disablebuttoncolor.valueProperty().bindBidirectional(startVM.colorDisableProperty());
        txt_EndtimeDelay.textProperty().bindBidirectional(startVM.endOfStageDelayProperty());
        txt_StarttimeDelay.textProperty().bindBidirectional(startVM.startOfStageDelayProperty());
        txt_ButtonText.textProperty().bindBidirectional(startVM.buttonTextProperty());
        textColor.valueProperty().bindBidirectional(startVM.textColorProperty());
    }
}
