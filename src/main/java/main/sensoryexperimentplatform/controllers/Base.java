package main.sensoryexperimentplatform.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.*;

import javafx.stage.FileChooser;
import main.sensoryexperimentplatform.models.*;
import main.sensoryexperimentplatform.controllers.*;

import javax.swing.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import static main.sensoryexperimentplatform.utilz.Constants.DEFAULT_DIRECTORY;


public class Base implements Initializable {
    private boolean isSidebarVisible = true;
    @FXML
    private HBox mainBox;

    @FXML
    private AnchorPane mainContent;

    @FXML
    private VBox sideMenu;
    private DashBoardController controller;
    private Experiment selectedExp;

    public void setSelectedExp(Experiment selectedExp) {
        this.selectedExp = selectedExp;
    }

    @FXML
    void OpenDashBoard(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/main/sensoryexperimentplatform/DashBoard.fxml"));
        AnchorPane newContent = null;

        try{
            newContent = loader.load();
            AnchorPane.setTopAnchor(newContent, 0.0);
            AnchorPane.setBottomAnchor(newContent, 0.0);
            AnchorPane.setLeftAnchor(newContent, 0.0);
            AnchorPane.setRightAnchor(newContent, 0.0);
            mainContent.getChildren().setAll(newContent);
            DashBoardController controller = new DashBoardController();
            //this.controller = loader.getController();
           // controller.initialize(this);
        }
        catch (IOException e){
            e.printStackTrace();
        }

    }

    @FXML
    void toggleDashboard(ActionEvent event) {
        if (isSidebarVisible) {
            mainBox.getChildren().remove(sideMenu);

        } else {
            mainBox.getChildren().add(0, sideMenu);
        }
        isSidebarVisible = !isSidebarVisible;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
//        FXMLLoader loader = new FXMLLoader(getClass().getResource("/main/sensoryexperimentplatform/Test.fxml"));
//        AnchorPane newContent = null;
//        try{
//            newContent = loader.load();
//            TestController view=  loader.getController();
//        }
//        catch (IOException e){
//            e.printStackTrace();
//        }
//        mainContent.getChildren().setAll(newContent);
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/main/sensoryexperimentplatform/DashBoard.fxml"));
        AnchorPane newContent = null;
        try{
            newContent = loader.load();
            AnchorPane.setTopAnchor(newContent, 0.0);
            AnchorPane.setBottomAnchor(newContent, 0.0);
            AnchorPane.setLeftAnchor(newContent, 0.0);
            AnchorPane.setRightAnchor(newContent, 0.0);
            mainContent.getChildren().setAll(newContent);
            DashBoardController view = loader.getController();

        }
        catch (IOException e){
            e.printStackTrace();
        }
        /*mainContent.getChildren().setAll(newContent);*/
    }
    @FXML
    void importExperiment() throws Exception {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(new File(DEFAULT_DIRECTORY));
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("SIPM Files", "*.sipm")); // Accept all file types
        List<File> files = fileChooser.showOpenMultipleDialog(null);

        if (files != null) {
            for(File file : files){
                String filePath = file.getAbsolutePath();
                DataAccess.importExperiment(filePath);
            }
        }
    }

    @FXML
    void exportExperiment(){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(new File(DEFAULT_DIRECTORY));
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("SIPM Files", "*.sipm"));

        File file = fileChooser.showSaveDialog(null);

        if (file != null) {
            saveToFile(file);
        }
    }

    private void saveToFile(File file) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(selectedExp.toString());
            writer.newLine();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}