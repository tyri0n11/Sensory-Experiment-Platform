package main.sensoryexperimentplatform.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import main.sensoryexperimentplatform.ViewModel.dashBoard_VM;
import main.sensoryexperimentplatform.ViewModel.newEx_VM;

public class newExController {
    newEx_VM viewModel;

    @FXML
    private AnchorPane NewExPane;

    @FXML
    private Button btn_cancel;

    @FXML
    private Button btn_save;

    @FXML
    private Label lbl_additionNote;

    @FXML
    private Label lbl_creator;

    @FXML
    private Label lbl_experimentDes;

    @FXML
    private Label lbl_experimentName;

    @FXML
    private Label lbl_newEx;

    @FXML
    private TextField txt_ExperimentName;


    @FXML
    private TextArea txt_description;

    @FXML
    private TextArea txt_additionNote;

    @FXML
    private TextField txt_creatorName;

    @FXML
    void btn_cancel(ActionEvent event) {

    }

    @FXML
    void btn_save(ActionEvent event) {

    }
    public void initialize() {
        viewModel = new newEx_VM();
        bindViewModel();
    }

    public void bindViewModel(){
        txt_ExperimentName.textProperty().bindBidirectional(viewModel.ExperimentNameProperty());
        txt_creatorName.textProperty().bindBidirectional(viewModel.CreatorNameProperty());
        txt_additionNote.textProperty().bindBidirectional(viewModel.noteProperty());
        txt_description.textProperty().bindBidirectional(viewModel.DescriptionProperty());



        txt_ExperimentName.textProperty().addListener((observable, oldValue, newValue) -> {
            viewModel.setExperimentName(newValue);
        });

        txt_creatorName.textProperty().addListener((observable, oldValue, newValue) -> {
            viewModel.setCreatorName(newValue);
        });

        txt_additionNote.textProperty().addListener((observable, oldValue, newValue) -> {
            viewModel.setNote(newValue);
        });

        txt_description.textProperty().addListener((observable, oldValue, newValue) -> {
            viewModel.setDescription(newValue);
        });
    }
    public void setViewModel(newEx_VM viewModel){
        this.viewModel = viewModel;
    }

}
