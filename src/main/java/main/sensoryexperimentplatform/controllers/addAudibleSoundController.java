package main.sensoryexperimentplatform.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import main.sensoryexperimentplatform.ViewModel.audibleSound_VM;
import main.sensoryexperimentplatform.ViewModel.inputStage_VM;

public class addAudibleSoundController  {
    private audibleSound_VM viewModel;


    @FXML
    private TextField txt_buttonText;

    @FXML
    private TextArea txt_content;

    @FXML
    private TextArea txt_helpText;

    @FXML
    private TextField txt_title;

    public void intialize(){
        viewModel = new audibleSound_VM();
        bindViewModel();

    }
    public void bindViewModel(){
        txt_buttonText.textProperty().bindBidirectional(viewModel.buttonTextProperty());
        txt_helpText.textProperty().bindBidirectional(viewModel.contentProperty());
        txt_content.textProperty().bindBidirectional(viewModel.helpTextProperty());
        txt_title.textProperty().bindBidirectional(viewModel.titleProperty());


    }
    public void setViewModel(audibleSound_VM viewModel){
        this.viewModel = viewModel;
    }


}
