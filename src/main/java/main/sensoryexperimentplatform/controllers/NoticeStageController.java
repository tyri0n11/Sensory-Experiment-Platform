package main.sensoryexperimentplatform.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import main.sensoryexperimentplatform.viewmodel.noticeStage_VM;

public class NoticeStageController {
    private noticeStage_VM noticeStage_vm;
    private noticeStage_VM viewModel;

    @FXML
    private TextField txt_buttonText;

    @FXML
    private TextArea txt_content;

    @FXML
    private TextArea txt_helptext;

    @FXML
    private TextField txt_title;



    @FXML
    void txt_buttonText(MouseEvent event) {

    }

    @FXML
    void txt_content(MouseEvent event) {

    }

    @FXML
    void txt_helptext(MouseEvent event) {

    }



    public void setNoticeStage_vm( noticeStage_VM viewModel){
        this.viewModel = viewModel;
        bindViewModel();
    }


    public void bindViewModel(){
        txt_helptext.textProperty().bindBidirectional(viewModel.helpTextProperty());
        txt_buttonText.textProperty().bindBidirectional(viewModel.buttonTextProperty());
        txt_title.textProperty().bindBidirectional(viewModel.titleProperty());
        txt_content.textProperty().bindBidirectional(viewModel.contentProperty());
        txt_buttonText.textProperty().addListener((observable, oldValue, newValue) -> {
            viewModel.setButtonText(newValue);
        });

        txt_helptext.textProperty().addListener((observable, oldValue, newValue) -> {
            viewModel.setHelpText(newValue);
        });

        txt_content.textProperty().addListener((observable, oldValue, newValue) -> {
            viewModel.setContent(newValue);
        });
        txt_title.textProperty().addListener((observable, oldValue, newValue) -> {
            viewModel.setTitle(newValue);
        });




    }
    @FXML
    void txt_title(MouseEvent event) {

    }

}
