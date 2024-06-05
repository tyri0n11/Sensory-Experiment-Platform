package main.sensoryexperimentplatform.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class Base implements Initializable {
    private boolean mouseClick;
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
    private Button btn_cross;

    @FXML
    private Button btn_down;

    @FXML
    private Button btn_exportExp;

    @FXML
    private Button btn_menu;

    @FXML
    private Button btn_up;

    @FXML
    private Label lbl_SenseXP;

    @FXML
    private HBox mainBox;

    @FXML
    private AnchorPane mainPain;

    @FXML
    private AnchorPane mainPane;

    @FXML
    private AnchorPane propertiesPane;

    @FXML
    private VBox sideMenu;
    @FXML
    void OpenDashBoard(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/main/sensoryexperimentplatform/DashBoard.fxml"));
        AnchorPane newContent = null;
        try{
            newContent = loader.load();
            DashBoardController view=  loader.getController();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        mainPain.getChildren().setAll(newContent);
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
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/main/sensoryexperimentplatform/Test.fxml"));
        AnchorPane newContent = null;
        try{
            newContent = loader.load();
            TestController view=  loader.getController();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        mainPain.getChildren().setAll(newContent);
    }
}
