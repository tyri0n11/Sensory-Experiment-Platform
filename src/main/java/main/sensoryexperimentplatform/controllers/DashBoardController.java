package main.sensoryexperimentplatform.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import main.sensoryexperimentplatform.SensoryExperimentPlatform;
import main.sensoryexperimentplatform.ViewModel.RunExperiment_VM;
import main.sensoryexperimentplatform.ViewModel.dashBoard_VM;
import main.sensoryexperimentplatform.models.Experiment;

import javax.swing.text.View;
import java.io.IOException;
import java.util.Date;
import java.util.Map;

import static javafx.scene.control.PopupControl.USE_COMPUTED_SIZE;

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
        contentTable.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, selectedExperiment) -> {
            if (selectedExperiment != null) {
                try {
                    runExperiment(selectedExperiment);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }
        });


    }

    private void runExperiment(Experiment experiment) throws IOException {
        FXMLLoader loader = new FXMLLoader(SensoryExperimentPlatform.class.getResource("RunExperiment.fxml"));
        Parent root = loader.load();

        RunController controller = loader.getController(); // Get the controller from the loader
        RunExperiment_VM viewModel = new RunExperiment_VM(experiment);
        controller.setViewModel(viewModel);

        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();

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