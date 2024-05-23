package main.sensoryexperimentplatform.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.*;

import java.io.IOException;

public class DashBoardController {

    private boolean isSidebarVisible = true;

    @FXML
    private BorderPane borderPane;

    @FXML
    private Button btn_Config;

    @FXML
    private Button btn_DashBoard;

    @FXML
    private Button btn_ImportExp;

    @FXML
    private Button btn_ShareExp;

    @FXML
    private Button btn_exportExp;

    @FXML
    private Button btn_menu;

    @FXML
    private AnchorPane contentPane;

    @FXML
    private Label lbl_SenseXP;

    @FXML
    private HBox mainBox;

    @FXML
    private AnchorPane mainPane;

    @FXML
    private VBox sideMenu;
    @FXML
    private HBox senseXPane;

    public void initialize(){
        HBox.setHgrow(mainPane, Priority.ALWAYS);
        HBox.setHgrow(senseXPane, Priority.ALWAYS);

    }

    @FXML
    void btn_Config(ActionEvent event) {

    }

    @FXML
    void btn_DashBoard(ActionEvent event) throws IOException {
        AnchorPane view = FXMLLoader.load(getClass().getResource("/main/sensoryexperimentplatform/ViewAllExperiment.fxml"));
        contentPane.getChildren().setAll(view);

    }

    @FXML
    void btn_ImportExp(ActionEvent event) {

    }

    @FXML
    void btn_ShareExp(ActionEvent event) {

    }

    @FXML
    void btn_exportExp(ActionEvent event) {

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

    }


