package main.sensoryexperimentplatform.controllers;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage; // Explicit import for JavaFX Stage
import main.sensoryexperimentplatform.SensoryExperimentPlatform;
import main.sensoryexperimentplatform.ViewModel.*;
import main.sensoryexperimentplatform.models.*;
import main.sensoryexperimentplatform.models.Timer;

import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;



public class RunController {
    private static String FILE_NAME;
    double pivot = 0.0;
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



    public void setViewModel(RunExperiment_VM viewModel){
        this.viewModel = viewModel;
        FILE_NAME = JOptionPane.showInputDialog("Enter your name, please!");
        bindViewModel();
    }
    private void updateProgress(double processed){
        if(processed > pivot){
            pivot = processed;
            progress_bar.setProgress(pivot/(viewModel.count - 1));
        }
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
    }
    @FXML
    void handleBtnBack(MouseEvent event) {
        updateProgress(processed);
        int selectedIndex = showList.getSelectionModel().getSelectedIndex();
        showList.getSelectionModel().select(selectedIndex - 1);

    }

    @FXML
    void handleBtnNext(MouseEvent event) throws IOException {

        int selectedIndex = showList.getSelectionModel().getSelectedIndex();
        if (selectedIndex == -1){
            showList.getSelectionModel().select(0);
        }
        if (selectedIndex >= 0 && selectedIndex < showList.getItems().size() - 1) {
            showList.getSelectionModel().select(selectedIndex + 1);
            quickSave();
        }
    }

    private void showDetailView(String item) {
        Object selectedObject = viewModel.getObjectByKey(item);

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
                    content.getChildren().setAll(newContent);

                    RunVasController controller = loader.getController();
                    RunVas_VM vm = new RunVas_VM((Vas) selectedObject);
                    controller.setViewModel(vm);
                    btn_Next.textProperty().bind(vm.buttonProperty());

                }
                // glms view display
                if (selectedObject instanceof gLMS) {
                    loader = new FXMLLoader(SensoryExperimentPlatform.class.getResource("RunGLMS.fxml"));
                    AnchorPane newContent = loader.load();
                    content.getChildren().setAll(newContent);

                    RunGLMSController controller = loader.getController();
                    RunGLMS_VM vm = new RunGLMS_VM((gLMS) selectedObject);
                    controller.setViewModel(vm);
                    btn_Next.textProperty().bind(vm.buttonProperty());

                }
                if (selectedObject instanceof Notice) {
                    loader = new FXMLLoader(SensoryExperimentPlatform.class.getResource("RunNotice.fxml"));
                    AnchorPane newContent = loader.load();
                    content.getChildren().setAll(newContent);

                    RunNoticeController controller = loader.getController();
                    RunNotice_VM vm = new RunNotice_VM((Notice) selectedObject);
                    controller.setViewModel(vm);
                    btn_Next.textProperty().bind(vm.buttonProperty());
                }
                if (selectedObject instanceof Timer) {
                    loader = new FXMLLoader(SensoryExperimentPlatform.class.getResource("RunTimer.fxml"));
                    AnchorPane newContent = loader.load();
                    content.getChildren().setAll(newContent);

                    RunTimerController controller = loader.getController();
                    RunTimer_VM viewModel = new RunTimer_VM((Timer) selectedObject);
                    controller.setViewModel(viewModel);
                    btn_back.setVisible(controller.getTimeLineCheck());
                    btn_Next.setVisible(controller.getTimeLineCheck());
                    controller.timelineFullProperty().addListener(((observableValue, oldValue, newValue) ->{
                        btn_back.setVisible(newValue);
                        btn_Next.setVisible(newValue);
                        showList.getSelectionModel().select(showList.getSelectionModel().getSelectedIndex() + 1);
                    } ));

                }
                if (selectedObject instanceof RatingContainer) {
                    int selectedIndex = showList.getSelectionModel().getSelectedIndex();
                    if (selectedIndex >= 0 && selectedIndex < showList.getItems().size() - 1) {
                        showList.getSelectionModel().select(selectedIndex + 1);
                    }
                    return;
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
        quickSave();
        autoClose();
    }

    private void autoClose() {
        // Get a handle to the stage
        Stage stage = (Stage) content.getScene().getWindow();
        // Close the stage
        stage.close();
    }
    private void quickSave() throws IOException {
        // Create directory for the experiment results if it doesn't exist
        File resultsDirectory = new File("results");
        if (!resultsDirectory.exists()) {
            resultsDirectory.mkdirs(); // Automatically creates the directory and any necessary parent directories
        }

        // Create directory for the experiment if it doesn't exist
        String experimentName = viewModel.getExperimentName();
        File experimentDirectory = new File("results/" + experimentName);
        if (!experimentDirectory.exists()) {
            experimentDirectory.mkdirs(); // Automatically creates the directory and any necessary parent directories
        }

        // Create file for saving results
        FileWriter writer = new FileWriter("results/" + experimentName + "/" + FILE_NAME + ".csv", false);

        writer.write("Heading,Time,Vas/GLMS Result,Question,Low Anchor, High Anchor, Low Value, High Value\n");

        for (Object o : viewModel.getStages()) {
            if(o instanceof RatingContainer){
                for(Object subO : ((RatingContainer) o).getContainer()){
                    saveResult(writer,subO);
                }
            }
            saveResult(writer,o);
        }

        writer.flush();
        writer.close();
    }
    private void saveResult(Writer writer, Object subO) throws IOException {
        if( subO instanceof Vas){
            writer.append("Vas,")
                    .append(((Vas) subO).getConducted())
                    .append(",")
                    .append(String.valueOf(((Vas) subO).getResult()).trim())
                    .append(",")
                    .append(((Vas) subO).getTitle())
                    .append(",")
                    .append(((Vas) subO).getLowAnchorText())
                    .append(",")
                    .append(((Vas) subO).getHighAnchorText())
                    .append(",")
                    .append(String.valueOf(((Vas) subO).getLowAnchorValue()))
                    .append(",")
                    .append(String.valueOf(((Vas) subO).getHighAnchorValue()));
            writer.append("\n");
        }
        if( subO instanceof gLMS){
            writer.append("GLMS ,")
                    .append(((gLMS) subO).getConducted())
                    .append(",")
                    .append(String.format("%.4f",((gLMS) subO).getResult()))
                    .append(",")
                    .append(((gLMS) subO).getTitle());
            writer.append("\n");
        }
    }

}