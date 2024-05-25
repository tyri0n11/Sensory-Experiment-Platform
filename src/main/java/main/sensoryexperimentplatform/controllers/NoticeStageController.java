package main.sensoryexperimentplatform.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import main.sensoryexperimentplatform.ViewModel.noticeStage_VM;

public class NoticeStageController {

    public void initialize(){
        txt_buttonText.textProperty().bindBidirectional(noticeStage_vm.buttonTextProperty());
        txt_content.textProperty().bindBidirectional(noticeStage_vm.contentProperty());
        txt_title.textProperty().bindBidirectional(noticeStage_vm.titleProperty());
        txt_helptext.textProperty().bindBidirectional(noticeStage_vm.helpTextProperty());
    }
    private noticeStage_VM noticeStage_vm;

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

    @FXML
    void txt_title(MouseEvent event) {

    }

}
