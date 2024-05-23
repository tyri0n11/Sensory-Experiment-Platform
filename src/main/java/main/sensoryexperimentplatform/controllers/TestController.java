package main.sensoryexperimentplatform.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TreeView;
import javafx.scene.layout.*;

public class TestController {
    @FXML
    private AnchorPane propertiesPane;
    private TestVM testVM;
    private boolean isSidebarVisible = true;
    @FXML
    private TreeView<?> listObject;

    @FXML
    private HBox mainBox;

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
    private Label lbl_SenseXP;

    @FXML
    private Button btn_noticeStage;

    @FXML
    private VBox sideMenu;

    @FXML
    private AnchorPane mainPane;

    public void initialize(){
        testVM = new TestVM();
        HBox.setHgrow(mainPane, Priority.ALWAYS);
    }
    @FXML
    void addAudibleInstruction(ActionEvent event) {

    }

    @FXML
    void addConditionalStatement(ActionEvent event) {

    }

    @FXML
    void addCourse(ActionEvent event) {
        listObject.setMaxHeight(311);
        propertiesPane.setVisible(true);
    }

    @FXML
    void addFoodAndTaste(ActionEvent event) {
        listObject.setMaxHeight(311);
        propertiesPane.setVisible(true);
    }

    @FXML
    void addGLMSStage(ActionEvent event) {
        listObject.setMaxHeight(311);
        propertiesPane.setVisible(true);
    }

    @FXML
    void addInput(ActionEvent event) {
        listObject.setMaxHeight(311);
        propertiesPane.setVisible(true);
    }

    @FXML
    void addNoticeStage(ActionEvent event) {
        listObject.setMaxHeight(311);
        propertiesPane.setVisible(true);
    }

    @FXML
    void addPeriodicStage(ActionEvent event) {

    }

    @FXML
    void addQuestionStage(ActionEvent event) {

    }

    @FXML
    void addRatingContainer(ActionEvent event) {

    }

    @FXML
    void addTasteTest(ActionEvent event) {

    }

    @FXML
    void addTimer(ActionEvent event) {

    }

    @FXML
    void addVasStage(ActionEvent event) {

    }

    @FXML
    void assignSound(ActionEvent event) {

    }

    @FXML
    private void toggleDashboard(){;
        if (isSidebarVisible) {
            mainBox.getChildren().remove(sideMenu);

        } else {
            mainBox.getChildren().add(0, sideMenu);
        }
        isSidebarVisible = !isSidebarVisible;
    }
}
