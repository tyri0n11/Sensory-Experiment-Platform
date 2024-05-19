package main.sensoryexperimentplatform.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

import java.io.IOException;

public class DashBoardController {

    @FXML
    private AnchorPane DashBoard;

    @FXML
    private AnchorPane DashBoard1;

    @FXML
    private StackPane DashBoardStackPane;

    @FXML
    private ComboBox<?> DropDown;

    @FXML
    private Label EntriesLabel;

    @FXML
    private AnchorPane SenseXPBar;

    @FXML
    private Label ShowLabel;

    @FXML
    private AnchorPane SideBar;

    @FXML
    private Button btn_AddExperiment;

    @FXML
    private Button btn_DashBoard;

    @FXML
    private Button btn_Logout;

    @FXML
    private Button btn_config;

    @FXML
    private Button btn_dashboard_left;

    @FXML
    private Button btn_export;

    @FXML
    private Button btn_import;

    @FXML
    private Button btn_menu;

    @FXML
    private Button btn_share_experiment;

    @FXML
    private TableColumn<?, ?> lbl_Option;

    @FXML
    private Label lbl_SenseXP;

    @FXML
    private TableColumn<?, ?> lbl_createDate;

    @FXML
    private TableColumn<?, ?> lbl_creator;

    @FXML
    private TableColumn<?, ?> lbl_currentVersion;

    @FXML
    private TableColumn<?, ?> lbl_experimentName;

    @FXML
    private TableColumn<?, ?> lbl_iD;

    @FXML
    private TableColumn<?, ?> lbl_result;

    @FXML
    private TextField searchBar;

    @FXML
    private AnchorPane sidebar_left;

    @FXML
    void btn_addEx(ActionEvent event) {

    }

    @FXML
    void btn_dashboard(ActionEvent event) throws IOException {
        new ScenseSwitch(DashBoardStackPane,"/fxml/general.fxml");

        }

    }


