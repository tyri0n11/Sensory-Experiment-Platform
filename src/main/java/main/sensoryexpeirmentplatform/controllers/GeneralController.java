package main.sensoryexpeirmentplatform.controllers;

import main.sensoryexpeirmentplatform.ViewModel.general_VM;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

import java.io.IOException;

public class GeneralController {
    private general_VM generalVM;

    @FXML
    private AnchorPane DashBoard;

    @FXML
    private StackPane GeneralStackPane;

    @FXML
    private Label UserName;

    @FXML
    private Button btn_AddExperiment;

    @FXML
    private MenuButton btn_dropDown;

    @FXML
    private Button btn_menu;

    @FXML
    private AnchorPane dashboardPanel;

    @FXML
    private AnchorPane headPanel;

    @FXML
    private Label lbl_DashBoard;

    @FXML
    private TableColumn<?, ?> lbl_Option;

    @FXML
    private Label lbl_SenseXP;

    @FXML
    private TableColumn<?, ?> lbl_createDate;

    @FXML
    private TableColumn<?, ?> lbl_currentVersion;

    @FXML
    private Label lbl_entries;

    @FXML
    private TableColumn<?, ?> lbl_experimentName;

    @FXML
    private TableColumn<?, ?> lbl_iD;

    @FXML
    private TableColumn<?, ?> lbl_result;

    @FXML
    private Label lbl_show;

    @FXML
    private TextField txt_searchBar;
    @FXML
    private TableColumn<?, ?> lbl_creator;



    @FXML
    void DashBoardButtonClick(ActionEvent event) throws IOException {
      new ScenseSwitch(GeneralStackPane,"/fxml/DashBoard.fxml");

    }
    @FXML
    void searchQuery(InputMethodEvent event) {
        UserName.setText(txt_searchBar.getText());

    }
//    public void initialize(GeneralVM generalVM){
//        txt_searchBar.textProperty().bindBidirectional();
//
//    }
}
