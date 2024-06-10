package main.sensoryexperimentplatform.controllers;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;
import main.sensoryexperimentplatform.SensoryExperimentPlatform;
import main.sensoryexperimentplatform.viewmodel.FillName_VM;
import main.sensoryexperimentplatform.viewmodel.RunExperiment_VM;
import main.sensoryexperimentplatform.viewmodel.dashBoard_VM;
import main.sensoryexperimentplatform.models.Experiment;
import main.sensoryexperimentplatform.models.listOfExperiment;

import java.io.IOException;
import java.util.Stack;

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
    private TableColumn<Experiment, String> lbl_createDate;

    @FXML
    private TableColumn<Experiment, String> lbl_Option;
    
    private Stack<Experiment> deletedExp = new Stack<>();


    private Experiment selectedExperiment;
    private Base base;

    public void initialize() {
        //this.base = base;
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

        contentTable.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, selectedExperiment) -> {
            this.selectedExperiment = selectedExperiment;
        });
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



//
                            delete.setOnAction((ActionEvent event) -> {
                                selectedExperiment = getTableView().getItems().get(getIndex());
                                try {
                                    deleteEx(selectedExperiment);
                                } catch (Exception e) {
                                    throw new RuntimeException(e);
                                }
                            });
                            edit.setOnAction((ActionEvent event) -> {
                                selectedExperiment = getTableView().getItems().get(getIndex());
                                editExperiment(selectedExperiment);
                            });
                            run.setOnAction((ActionEvent) ->{
                                Experiment selectedExperiment = getTableView().getItems().get(getIndex());
                                try {
                                    FXMLLoader fillNameLoader = new FXMLLoader(getClass().getResource("/main/sensoryexperimentplatform/fill_name.fxml"));
                                    Parent root = fillNameLoader.load();

                                    FillNameController controller = fillNameLoader.getController();
                                    FillName_VM viewModel = new FillName_VM(selectedExperiment);
                                    controller.setViewModel(viewModel);

                                    Stage dialog = new Stage();
                                    dialog.initStyle(StageStyle.TRANSPARENT);
                                    Scene dialogScene = new Scene(root);
                                    dialogScene.setFill(Color.TRANSPARENT);
                                    dialog.setScene(dialogScene);

                                    dialog.showAndWait();
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

        contentTable.setItems(dashBoard_vm.getExperiments());


    }

    private void deleteEx(Experiment e) throws Exception {
        deletedExp.push(e);
        listOfExperiment.deleteExperiment(e);
    }

    public void redo() throws Exception {
        listOfExperiment.addExperiment(deletedExp.pop());
    }


    private void editExperiment(Experiment c) {
        c.updateVersion();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/main/sensoryexperimentplatform/Test.fxml"));
        Parent root =null;
        try{
            root = loader.load();
            TestController view = loader.getController();
            view.setExperiment(c);
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


    @FXML
    void btn_addEx(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(SensoryExperimentPlatform.class.getResource("NewExperiment.fxml"));
        Parent root = fxmlLoader.load();

        Stage stage = new Stage();
        stage.setTitle("Add Sound");
        newExController controller = fxmlLoader.getController();
        controller.initialize();

        Scene scene = new Scene(root);
        stage.setScene(scene);

        stage.show();

    }




}