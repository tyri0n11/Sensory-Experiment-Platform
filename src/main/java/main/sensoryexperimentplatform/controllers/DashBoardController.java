package main.sensoryexperimentplatform.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Callback;
import main.sensoryexperimentplatform.SensoryExperimentPlatform;
import main.sensoryexperimentplatform.ViewModel.RunExperiment_VM;
import main.sensoryexperimentplatform.ViewModel.dashBoard_VM;
import main.sensoryexperimentplatform.ViewModel.inputStage_VM;
import main.sensoryexperimentplatform.ViewModel.newEx_VM;
import main.sensoryexperimentplatform.models.Experiment;

import java.io.IOException;

public class DashBoardController {
    private dashBoard_VM dashBoard_vm;


    @FXML
    private TableView<Experiment> contentTable;

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
    private TableColumn<Experiment, String> lbl_Option;

    @FXML
    private TableColumn<Experiment, String> lbl_createDate;

    @FXML
    private TextField searchBar;

    @FXML
    private AnchorPane sidebar_left;


    public void initialize() {
       dashBoard_vm = new dashBoard_VM();
        bindViewModel();


    }

    public void bindViewModel() {

        lbl_iD.setCellValueFactory(new PropertyValueFactory<>("id"));

        lbl_creator.setCellValueFactory(new PropertyValueFactory<>("creatorName"));

        lbl_experimentName.setCellValueFactory(new PropertyValueFactory<>("experimentName"));

        lbl_currentVersion.setCellValueFactory(new PropertyValueFactory<>("version"));

        lbl_result.setCellValueFactory(new PropertyValueFactory<>("number_of_results"));

        lbl_createDate.setCellValueFactory(new PropertyValueFactory<>("created_date"));
        Callback<TableColumn<Experiment, String>, TableCell<Experiment, String>> cellFactory = new Callback<TableColumn<Experiment, String>, TableCell<Experiment, String>>() {
            @Override
            public TableCell<Experiment, String> call(final TableColumn<Experiment, String> param) {
                final TableCell<Experiment, String> cell = new TableCell<Experiment, String>() {
                    @Override
                    public void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null); //empty rows do not get buttons
                            setText(null);
                        } else {
                            FXMLLoader runloader = new FXMLLoader(getClass().getResource("/main/sensoryexperimentplatform/runButton.fxml"));
                            FXMLLoader editloader = new FXMLLoader(getClass().getResource("/main/sensoryexperimentplatform/editButton.fxml"));
                            FXMLLoader deleteloader = new FXMLLoader(getClass().getResource("/main/sensoryexperimentplatform/deleteButton.fxml"));
                            //FXMLLoader editloader = new FXMLLoader(getClass().getResource("EditButton.fxml"));
                            final Button delete;
                            //final Button add;
                            final Button edit;
                            final Button run;
                            try {
                                run = runloader.load();
                                edit = editloader.load();
                                delete = deleteloader.load();
//                                edit = editloader.load();
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                            run.setStyle(
                                    " -fx-cursor: hand ;"
                                            + "-glyph-size:28px;"
                                            +"-fx-background-color: transparent"
                            );
                            edit.setStyle(
                                    " -fx-cursor: hand ;"
                                            + "-glyph-size:28px;"
                                            + "-fx-background-color: transparent"
                            );
                            delete.setStyle(
                                    " -fx-cursor: hand ;"
                                            + "-glyph-size:28px;"
                                            + "-fx-background-color: transparent"
                            );
//                            edit.setStyle( " -fx-cursor: hand ;"
//                                    + "-glyph-size:28px;"
//                                    + "-fx-background-color: transparent");
//                            add.setOnAction((ActionEvent event) -> {
//                                Patient c = getTableView().getItems().get(getIndex());
//                                addTreatment(c);
//                            });
                            delete.setOnAction((ActionEvent event) -> {
                                Experiment c = getTableView().getItems().get(getIndex());
                                deleteEx(c);
                            });
                            edit.setOnAction((ActionEvent event) -> {
                                Experiment c = getTableView().getItems().get(getIndex());
                                editExperiment(c);
                            });
                            run.setOnAction((ActionEvent) ->{
                                Experiment selectedExperiment = getTableView().getItems().get(getIndex());
                                try {
                                    runExperiment(selectedExperiment);
                                } catch (IOException e) {
                                    throw new RuntimeException(e);
                                }
                            });
                            HBox managebtn = new HBox(run, edit,delete);
                            managebtn.setStyle("-fx-alignment:center");
                            HBox.setMargin(run, new Insets(2, 2, 0, 3));
                            HBox.setMargin(edit, new Insets(2, 3, 0, 2));
                              HBox.setMargin(delete, new Insets(2, 4, 0, 2));
//                            HBox.setMargin(edit, new Insets(2, 5, 0, 3));
                            setGraphic(managebtn);
                        }
                    }
                };
                return cell;
            }
        };
        lbl_Option.setCellFactory(cellFactory);


        // Bind the TableView items to the ViewModel items
        contentTable.setItems(dashBoard_vm.getItems());



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

    private void deleteEx(Experiment c) {
    }

    private void editExperiment(Experiment c) {
        c.updateVersion();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/main/sensoryexperimentplatform/Test.fxml"));
        Parent root =null;
        try{
            root = loader.load();
            TestController view=  loader.getController();
            view.setExperiment (c);
        }
        catch (IOException e){
            e.printStackTrace();
        }

        Stage stage = new Stage();
        stage.setTitle("Edit experiment");

        Scene scene = new Scene(root);
        stage.setScene(scene);

        stage.show();

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
    void btn_addEx(ActionEvent event) throws IOException {
//        viewModel.addExperiment()

        // Implement action for adding an experiment
        FXMLLoader fxmlLoader = new FXMLLoader(SensoryExperimentPlatform.class.getResource("NewExperiment.fxml"));
        Parent root = fxmlLoader.load();

        Stage stage = new Stage();
        stage.setTitle("Add Sound");
        newExController controller = fxmlLoader.getController();
        controller.initialize(dashBoard_vm);

        Scene scene = new Scene(root);
        stage.setScene(scene);

        stage.show();

    }



}