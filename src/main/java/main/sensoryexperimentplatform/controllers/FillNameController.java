package main.sensoryexperimentplatform.controllers;

import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import main.sensoryexperimentplatform.SensoryExperimentPlatform;
import main.sensoryexperimentplatform.ViewModel.FillName_VM;
import main.sensoryexperimentplatform.ViewModel.RunExperiment_VM;
import main.sensoryexperimentplatform.models.Experiment;

import java.io.IOException;

public class FillNameController {
    private FillName_VM viewModel;

    @FXML
    private Button approve_btn;

    @FXML
    private AnchorPane btm_pane;

    @FXML
    private Button cancel_btn;

    @FXML
    private ImageView cross_img;

    @FXML
    private TextField file_name;

    @FXML
    private Label instruction_lbl;

    @FXML
    private Label top_lbl;
    public void setViewModel(FillName_VM viewModel){
        this.viewModel = viewModel;
        Bindings.bindBidirectional(file_name.textProperty(), viewModel.fileName());
    }

    @FXML
    void handleApproveBtn(MouseEvent event) throws IOException {
        runExperiment(viewModel.getExperiment(), viewModel.getFileName());
        close();
    }

    @FXML
    void handleCancelBtn(MouseEvent event) {
        close();
    }
    void close(){
        Stage stage = (Stage) file_name.getScene().getWindow();
        stage.close();
    }
    public String getFileName(){
        return file_name.getText();
    }

    private void runExperiment(Experiment experiment, String file_name) throws IOException {
        FXMLLoader loader = new FXMLLoader(SensoryExperimentPlatform.class.getResource("RunExperiment.fxml"));
        Parent root = loader.load();

        RunController controller = loader.getController(); // Get the controller from the loader
        RunExperiment_VM viewModel = new RunExperiment_VM(experiment, file_name);
        controller.setViewModel(viewModel);

        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();

    }

}
