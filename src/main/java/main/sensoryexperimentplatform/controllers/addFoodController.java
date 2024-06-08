package main.sensoryexperimentplatform.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import main.sensoryexperimentplatform.ViewModel.FoodTasteVM;

public class addFoodController {
    private FoodTasteVM viewModel;
    @FXML
    private Label FileLabel;

    @FXML
    private Label ImportSoundLabel;

    @FXML
    private AnchorPane ImportSoundPane;

    @FXML
    private Button btn_cancel;

    @FXML
    private Button btn_save;

    @FXML
    private TextField txt_file;

    @FXML
    void btn_cancel(ActionEvent event) {

    }

    @FXML
    void btn_save(ActionEvent event) {
        viewModel.addListFoodsShow(txt_file.getText());
    }
    public void setViewModel(FoodTasteVM viewModel) {
        this.viewModel = viewModel;

    }
}
