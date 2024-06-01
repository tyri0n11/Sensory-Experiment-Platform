package main.sensoryexperimentplatform.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import main.sensoryexperimentplatform.ViewModel.AddCourseVM;
import main.sensoryexperimentplatform.ViewModel.vasStage_VM;

public class AddCourseController {
    @FXML
    private TextField txt_button;

    @FXML
    private TextField txt_content;

    @FXML
    private Label txt_courseDuration;

    @FXML
    private TextArea txt_help;

    @FXML
    private TextField txt_quantity;

    @FXML
    private TextField txt_refill;

    @FXML
    private TextField txt_title;
    private AddCourseVM view;
    /*private void bind(){

        txt_question.textProperty().bindBidirectional(view.questionTextProperty());
        txt_LowAncTxt.textProperty().bindBidirectional(view.lowAnchorTextProperty());
        txt_HighAncTxt.textProperty().bindBidirectional(view.highAnchorTextProperty());
        txt_LowAncTxt.textProperty().bindBidirectional(view.lowAnchorTextProperty());
        txt_LowAncVal.textProperty().bindBidirectional(view.lowAnchorValueProperty());
        txt_HighAncVal.textProperty().bindBidirectional(view.highAnchorValueProperty());
        txt_BtnTxt.textProperty().bindBidirectional(view.buttonTextProperty());
        txt_help.textProperty().bindBidirectional(view.helpTextProperty());
        //txt_yes.textProperty().bindBidirectional(vasStageVM.txt_yesProperty());
        checkB_sound.selectedProperty().bindBidirectional(vasStageVM.checkB_soundProperty());
        checkB_swap.selectedProperty().bindBidirectional(vasStageVM.checkB_swapProperty());
    }
    public void setViewModel(AddCourseVM view){
        this.view = view;
        bind();

    }*/

}
