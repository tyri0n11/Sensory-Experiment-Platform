package main.sensoryexperimentplatform.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import main.sensoryexperimentplatform.ViewModel.RunExperiment_VM;
import main.sensoryexperimentplatform.models.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class DemoController {
    private boolean isSidebarVisible = true;
    @FXML
    private TreeView<String> listObject;

    @FXML
    private HBox mainBox;

    @FXML
    private AnchorPane contentPane;

    @FXML
    private VBox sideMenu;

    @FXML
    private AnchorPane mainPane;
    @FXML
    private AnchorPane propertiesPane;

    @FXML
    private ListView<String> showList;

    private RunExperiment_VM viewModel;



    public void initialize() throws IOException {

        viewModel = new RunExperiment_VM();

        TreeItem<String> root = new TreeItem<>("TASTE TEST");
        TreeItem<String> rcr = new TreeItem<>("Rating container - Randomised");

        listObject.setRoot(root);
        root.getChildren().add(rcr);

        Experiment experiment = DataAccess.getExperimentIndividually();
        if (experiment != null) {
            ArrayList<Object> stages = experiment.getStages();
            ArrayList<String> str = new ArrayList<>();
            for (Object o : stages) {
                if (o instanceof Stage) {
                    str.add("[" + o.getClass().getSimpleName() + "] " + ((Stage) o).getTitle());
                }
                //handleView(o.getClass().getSimpleName());
            }
            for (String s : str) {
                rcr.getChildren().add(new TreeItem<>(s));
            }
        }



//        // Bind the TreeView to the ListProperty
//        ListProperty<String> listProperty = viewModel.itemsProperty();
//        listProperty.addListener((ListChangeListener<String>) change -> {
//            root.getChildren().clear();
//            for (String item : listProperty) {
//                root.getChildren().add(new TreeItem<>(item));
//            }
//        });
//
//         Initial population of TreeView
//        for (String item : listProperty) {
//            System.out.println(item);
//            root.getChildren().add(new TreeItem<>(item));
//        }
//
//        listObject.setRoot(root);

    }
    private void handleView(String s){
        if (s.equals("Timer")){
            String filePath = "/main/sensoryexperimentplatform/propertyVas.fxml";
            try {
                AnchorPane view = FXMLLoader.load((Objects.requireNonNull(Main.class.getResource(filePath))));
                listObject.setPrefHeight(listObject.getPrefHeight() - 200);
                propertiesPane.getChildren().add(view);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

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
}
