package main.sensoryexperimentplatform.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import main.sensoryexperimentplatform.ViewModel.dashBoard_VM;
import main.sensoryexperimentplatform.models.Experiment;

import java.io.IOException;
import java.util.Date;
import java.util.Map;

public class DashBoardController {
    private dashBoard_VM viewModel;

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
    private TableView<Experiment> contentTable;

    @FXML
    private TableColumn<Experiment, String> lbl_createDate;

    @FXML
    private TableColumn<Experiment, String> lbl_creator;

    @FXML
    private TableColumn<Experiment, String> lbl_currentVersion;

    @FXML
    private TableColumn<Experiment, String> lbl_experimentName;

    @FXML
    private TableColumn<Experiment, String> lbl_iD;

    @FXML
    private TableColumn<Experiment, String> lbl_result;

    @FXML
    private TextField searchBar;

    @FXML
    private AnchorPane sidebar_left;

    public void initialize() {
        viewModel = new dashBoard_VM();
        bindViewModel();
    }

    public void bindViewModel() {

        lbl_iD.setCellValueFactory(new PropertyValueFactory<>("id"));

        lbl_creator.setCellValueFactory(new PropertyValueFactory<>("creatorName"));

        lbl_experimentName.setCellValueFactory(new PropertyValueFactory<>("experimentName"));

        lbl_currentVersion.setCellValueFactory(new PropertyValueFactory<>("version"));


        // Bind the TableView items to the ViewModel items
        contentTable.setItems(viewModel.itemsProperty());

        // Add listener for row selection
        contentTable.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                updateSelectedExperimentDetails(newSelection);
            }
        });

        // Debugging: Print items to verify they are loaded
        System.out.println("Items loaded: " + viewModel.itemsProperty().size());
        for (Experiment experiment : viewModel.itemsProperty()) {
            System.out.println(experiment.getExperimentName());
        }
    }

    private void updateSelectedExperimentDetails(Experiment experiment) {
        Map<String, Object> objectsMap = viewModel.getObjectsMap();
        objectsMap.put("id", experiment.getId());
        objectsMap.put("creator", experiment.getCreatorName());
        objectsMap.put("name", experiment.getExperimentName());
        objectsMap.put("version", experiment.getVersion());
    }

    @FXML
    void btn_addEx(ActionEvent event) {
        // Implement action for adding an experiment
    }

    @FXML
    void btn_dashboard(ActionEvent event) throws IOException {
        new ScenseSwitch(DashBoardStackPane, "/fxml/general.fxml");
    }
}