package main.sensoryexperimentplatform.controllers;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import main.sensoryexperimentplatform.ViewModel.*;
import main.sensoryexperimentplatform.models.*;

import java.io.IOException;
import java.util.*;

public class DemoController {
    private boolean isSidebarVisible = true;
    private Random random = new Random();
    @FXML
    private TreeView<String> listObject;
    private Map<String, Object> objectsMap = new HashMap<>();

    @FXML
    private HBox mainBox;

    @FXML
    private AnchorPane contentPane;

    @FXML
    private VBox sideMenu;
    @FXML
    private AnchorPane propertiesPane;

    @FXML
    private Button btnCancel;

    @FXML
    private Button btnSave;

    @FXML
    private Button btnSaveAll;

    private editEx_VM viewModel;

    public DemoController() throws IOException {
        viewModel = new editEx_VM();
    }
    private void showDetailView(String item)  {
        Object selectedObject = viewModel.getObjectByKey(item);
        if (selectedObject != null) {
            listObject.setPrefHeight(listObject.getPrefHeight() - 300);
            try {
                if (selectedObject instanceof Vas){
                    FXMLLoader loader = new FXMLLoader(Main.class.getResource("/main/sensoryexperimentplatform/VasStage.fxml"));
                    AnchorPane newContent = loader.load();
                    propertiesPane.getChildren().setAll(newContent);
                    VasController controller = loader.getController();
                    vasStage_VM vm = new vasStage_VM((Vas) selectedObject);
                    controller.setViewModel(vm);
                }
                else if (selectedObject instanceof gLMS){
                    FXMLLoader loader = new FXMLLoader(Main.class.getResource("/main/sensoryexperimentplatform/GLMS.fxml"));
                    AnchorPane newContent = loader.load();
                    propertiesPane.getChildren().setAll(newContent);
                    GLMSController controller = loader.getController();
                    glmsStage_VM vm = new glmsStage_VM((gLMS) selectedObject);
                    controller.setViewModel(vm);
                }


            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void initialize() throws IOException {

        TreeItem<String> root = new TreeItem<>("TASTE TEST");
        TreeItem<String> rcr = new TreeItem<>("Rating container - Randomised");

        ObservableList<String> displayedItem = viewModel.getItems();
        listObject.setRoot(root);
        root.getChildren().add(rcr);
        for(String item : displayedItem){
            rcr.getChildren().add(new TreeItem<>(item));
        }

        listObject.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                showDetailView(newValue.getValue());
            }
        });
    }


    @FXML
    void addAudibleInstruction(ActionEvent event) {

    }

    @FXML
    void addConditionalStatement(ActionEvent event) {

    }

    @FXML
    void addCourse(ActionEvent event) {

    }

    @FXML
    void addFoodAndTaste(ActionEvent event) {

    }

    @FXML
    void addGLMSStage(ActionEvent event) {

    }

    @FXML
    void addInput(ActionEvent event) {

    }

    @FXML
    void addNoticeStage(ActionEvent event) {

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
            contentPane.setPrefWidth(800);

        } else {
            mainBox.getChildren().add(0, sideMenu);
            contentPane.setPrefWidth(669.6);
        }
        isSidebarVisible = !isSidebarVisible;

    }
    @FXML
    void cancel(ActionEvent event) {
        propertiesPane.lookupAll(".text-field").forEach(node -> {
            if (node instanceof TextField) {
                ((TextField) node).setText(null);
            }
            if (node instanceof TextArea){
                ((TextArea) node).setText(null);
            }
        });
    }

    @FXML
    void saveAllInfo(ActionEvent event) {

    }

    @FXML
    void saveInfo(ActionEvent event) {

    }

}
