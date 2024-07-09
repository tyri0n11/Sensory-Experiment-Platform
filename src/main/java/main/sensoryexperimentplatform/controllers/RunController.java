package main.sensoryexperimentplatform.controllers;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage; // Explicit import for JavaFX Stage
import main.sensoryexperimentplatform.SensoryExperimentPlatform;
import main.sensoryexperimentplatform.viewmodel.*;
import main.sensoryexperimentplatform.models.*;
import main.sensoryexperimentplatform.models.Timer;

import javax.swing.*;
import java.io.IOException;


public class RunController {
    private String FILE_NAME;
    double processed = 0.0;
    @FXML
    private AnchorPane content;

    @FXML
    private Button btn_Next;

    @FXML
    private Button btn_back;

    @FXML
    private ProgressBar progress_bar;

    @FXML
    private ListView<String> showList;

    private RunExperiment_VM viewModel;
    private Experiment experiment;

    public void setViewModel(RunExperiment_VM viewModel){
        this.viewModel = viewModel;
        this.experiment = viewModel.getExperiment();
        this.FILE_NAME = viewModel.getFileName()+"_"+DataAccess.getCurrentFormattedTime();;
        //viewModel.getFileName()+"_"+DataAccess.getCurrentFormattedTime();
        bindViewModel();
    }
    private void updateProgress(double processed){

        progress_bar.setProgress(processed/(viewModel.count - 1));
    }

    private void bindViewModel() {

        showList.itemsProperty().bind(viewModel.itemsProperty());
        showList.setVisible(false);

        // Add selection listener
        showList.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                // Handle item selection (e.g., show detail view)
                showDetailView(newValue);
            }
        });
        if (!showList.getItems().isEmpty()) {
            showList.getSelectionModel().selectFirst();
            showDetailView(showList.getItems().get(0));
        }
    }
    @FXML
    void handleBtnBack(MouseEvent event) {
        int selectedIndex = showList.getSelectionModel().getSelectedIndex();
        showList.getSelectionModel().select(selectedIndex - 1);
        updateProgress(showList.getSelectionModel().getSelectedIndex());
    }

    @FXML
    void handleBtnNext(MouseEvent event) throws IOException {

        int selectedIndex = showList.getSelectionModel().getSelectedIndex();
        if (selectedIndex == -1){
            showList.getSelectionModel().select(0);
        }
        if (selectedIndex >= 0 && selectedIndex < showList.getItems().size() - 1) {
            showList.getSelectionModel().select(selectedIndex + 1);
            DataAccess.quickSave(experiment, FILE_NAME);
        }
        updateProgress(showList.getSelectionModel().getSelectedIndex());
    }

    private void showDetailView(String item) {
        Object selectedObject = viewModel.getObjectByKey(item);
        updateProgress(showList.getSelectionModel().getSelectedIndex());
        if (selectedObject != null) {
            int currentIndex = viewModel.getIndexOfObject(selectedObject);
            if (currentIndex >= 0) {
                if (currentIndex > processed) {
                    processed = currentIndex;
                    updateProgress(currentIndex);
                }
            } else {
                processed++;
                updateProgress(processed);
            }
            content.getChildren().clear();

            try {
                FXMLLoader loader;
                // Vas view display
                if (selectedObject instanceof Vas) {
                    loader = new FXMLLoader(SensoryExperimentPlatform.class.getResource("RunVas.fxml"));
                    AnchorPane newContent = loader.load();
                    AnchorPane.setTopAnchor(newContent, 0.0);
                    AnchorPane.setBottomAnchor(newContent, 0.0);
                    AnchorPane.setLeftAnchor(newContent, 0.0);
                    AnchorPane.setRightAnchor(newContent, 0.0);
                    content.getChildren().setAll(newContent);


                    RunVasController controller = loader.getController();
                    RunVas_VM vm = new RunVas_VM((Vas) selectedObject);
                    controller.setViewModel(vm);
                    btn_Next.textProperty().bind(vm.buttonProperty());

                    if (vm.conductedTextProperty().get() == null){
                        btn_Next.setDisable(true);
                    }else btn_Next.setDisable(false);

                    vm.conductedTextProperty().addListener((observable, oldValue, newValue) -> {
                        System.out.println(newValue);
                        if (newValue != null) {
                            btn_Next.setDisable(false);
                        }
                    });

                }
                // glms view display
                if (selectedObject instanceof gLMS) {
                    loader = new FXMLLoader(SensoryExperimentPlatform.class.getResource("RunGLMS.fxml"));
                    AnchorPane newContent = loader.load();
                    AnchorPane.setTopAnchor(newContent, 0.0);
                    AnchorPane.setBottomAnchor(newContent, 0.0);
                    AnchorPane.setLeftAnchor(newContent, 0.0);
                    AnchorPane.setRightAnchor(newContent, 0.0);
                    content.getChildren().setAll(newContent);

                    RunGLMSController controller = loader.getController();
                    RunGLMS_VM vm = new RunGLMS_VM((gLMS) selectedObject);
                    controller.setViewModel(vm);
                    btn_Next.textProperty().bind(vm.buttonProperty());

                    if (vm.conductedTextProperty().get() == null){
                        btn_Next.setDisable(true);
                    }else btn_Next.setDisable(false);

                    vm.conductedTextProperty().addListener((observable, oldValue, newValue) -> {
                        System.out.println(newValue);
                        if (newValue != null) {
                            btn_Next.setDisable(false);
                        }
                    });


                }
                if (selectedObject instanceof Notice) {
                    loader = new FXMLLoader(SensoryExperimentPlatform.class.getResource("RunNotice.fxml"));
                    AnchorPane newContent = loader.load();
                    AnchorPane.setTopAnchor(newContent, 0.0);
                    AnchorPane.setBottomAnchor(newContent, 0.0);
                    AnchorPane.setLeftAnchor(newContent, 0.0);
                    AnchorPane.setRightAnchor(newContent, 0.0);
                    content.getChildren().setAll(newContent);
                    btn_Next.setDisable(false);

                    RunNoticeController controller = loader.getController();
                    RunNotice_VM vm = new RunNotice_VM((Notice) selectedObject);
                    controller.setViewModel(vm);
                    btn_Next.textProperty().bind(vm.buttonProperty());
                }
                if (selectedObject instanceof Timer) {
                    loader = new FXMLLoader(SensoryExperimentPlatform.class.getResource("RunTimer.fxml"));
                    AnchorPane newContent = loader.load();
                    AnchorPane.setTopAnchor(newContent, 0.0);
                    AnchorPane.setBottomAnchor(newContent, 0.0);
                    AnchorPane.setLeftAnchor(newContent, 0.0);
                    AnchorPane.setRightAnchor(newContent, 0.0);
                    content.getChildren().setAll(newContent);


                    RunTimerController controller = loader.getController();
                    RunTimer_VM viewModel = new RunTimer_VM((Timer) selectedObject);
                    controller.setViewModel(viewModel);
                    btn_back.setVisible(controller.getTimeLineCheck());
                    btn_Next.setVisible(controller.getTimeLineCheck());
                    btn_Next.setDisable(false);

                    controller.timelineFullProperty().addListener(((observableValue, oldValue, newValue) ->{
                        btn_back.setVisible(newValue);
                        btn_Next.setVisible(newValue);
                        showList.getSelectionModel().select(showList.getSelectionModel().getSelectedIndex() + 1);
                    } ));

                }
                if (currentIndex == viewModel.count - 1) {
                    btn_Next.setOnAction(event -> {
                        try {
                            handleFinalNext();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    });
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    private void handleFinalNext() throws IOException {

        DataAccess.quickSave(experiment, FILE_NAME);
        autoClose();
    }

    private void autoClose() {
        // Get a handle to the stage
        Stage stage = (Stage) content.getScene().getWindow();
        // Close the stage
        stage.close();
    }


}