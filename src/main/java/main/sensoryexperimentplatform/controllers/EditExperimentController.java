package main.sensoryexperimentplatform.controllers;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import main.sensoryexperimentplatform.ViewModel.*;
import main.sensoryexperimentplatform.models.*;
import main.sensoryexperimentplatform.models.Timer;

import java.io.IOException;
import java.util.*;

public class EditExperimentController {
    private boolean isSidebarVisible = true;
    @FXML
    private TreeView<String> listObject;
    private Map<String, Object> objectsMap = new HashMap<>();

    @FXML
    private HBox mainBox;

    @FXML
    private VBox sideMenu;
    @FXML
    private Button btnCancel;
    @FXML
    private AnchorPane propertiesPane;
    @FXML
    private AnchorPane contentPane;
    private editEx_VM viewModel;
    private TreeItem<String> root;
    private String currentVal;
    public EditExperimentController() throws IOException {
        viewModel = new editEx_VM();
    }
    private void showDetailView(String item)  {
        Object selectedObject = viewModel.getObjectByKey(item);
        if (selectedObject != null) {
            listObject.setPrefHeight(listObject.getPrefHeight() - 300);
            try {
                if (selectedObject instanceof Notice){
                    FXMLLoader loader = new FXMLLoader(Main.class.getResource("/main/sensoryexperimentplatform/AddNoticeStage.fxml"));
                    AnchorPane newContent = loader.load();
                    propertiesPane.getChildren().setAll(newContent);
                    NoticeStageController controller = loader.getController();
                    noticeStage_VM vm = new noticeStage_VM((Notice) selectedObject);
                    controller.setNoticeStage_vm(vm);
                }
                else if (selectedObject instanceof Timer){
                    FXMLLoader loader = new FXMLLoader(Main.class.getResource("/main/sensoryexperimentplatform/TimerStage.fxml"));
                    AnchorPane newContent = loader.load();
                    propertiesPane.getChildren().setAll(newContent);
                    TimerController controller = loader.getController();
                    timerStage_VM vm = new timerStage_VM((Timer) selectedObject);
                    controller.setViewModel(vm);
                } else if (selectedObject instanceof Vas) {
                    FXMLLoader loader = new FXMLLoader(Main.class.getResource("/main/sensoryexperimentplatform/VasStage.fxml"));
                    AnchorPane newContent = loader.load();
                    propertiesPane.getChildren().setAll(newContent);
                    VasController controller = loader.getController();
                    vasStage_VM vm = new vasStage_VM((Vas) selectedObject);
                    controller.setViewModel(vm);
                } else if (selectedObject instanceof gLMS) {
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
    private void showScaleByKey(String item) throws IOException {
        Object selectedObject = viewModel.getScaleByKey(item);
        if (selectedObject != null) {
            listObject.setPrefHeight(listObject.getPrefHeight() - 300);
            if (selectedObject instanceof RatingContainer) {
                for (Object subO : ((RatingContainer) selectedObject).container) {
                    if (subO instanceof Vas) {
                        FXMLLoader loader = new FXMLLoader(Main.class.getResource("/main/sensoryexperimentplatform/VasStage.fxml"));
                        AnchorPane newContent = loader.load();
                        propertiesPane.getChildren().setAll(newContent);
                        VasController controller = loader.getController();
                        vasStage_VM vm = new vasStage_VM((Vas) subO);
                        controller.setViewModel(vm);
                    } else if (subO instanceof gLMS) {
                        FXMLLoader loader = new FXMLLoader(Main.class.getResource("/main/sensoryexperimentplatform/GLMS.fxml"));
                        AnchorPane newContent = loader.load();
                        propertiesPane.getChildren().setAll(newContent);
                        GLMSController controller = loader.getController();
                        glmsStage_VM vm = new glmsStage_VM((gLMS) subO);
                        controller.setViewModel(vm);
                    }
                }
            }
        }
    }
    public void initialize() throws IOException {
        root = new TreeItem<>("TASTE TEST");
        listObject.setRoot(root);

        Experiment experiment = DataAccess.getExperimentIndividually();
        if (experiment != null) {
            ArrayList<Object> stages = experiment.getStages();
            for(Object o : stages){
                if(o instanceof Stage){
                    root.getChildren().add(new TreeItem<>("[" + o.getClass().getSimpleName() + "] " + ((Stage) o).getTitle()));
                }
            }
        }
        listObject.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                System.out.println(newValue.getValue());
                currentVal = newValue.getValue();
                showDetailView(newValue.getValue());
            }
        });
        btnCancel.setOnAction((ActionEvent event) -> {
            showDetailView(currentVal);
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
        TreeItem<String> rcr = new TreeItem<>("Rating container - Randomised");
        ObservableList<String> displayedItem = viewModel.getScales();
        root.getChildren().add(rcr);
        for(String item : displayedItem){
            rcr.getChildren().add(new TreeItem<>(item));
        }

        listObject.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                try {
                    showScaleByKey(newValue.getValue());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });


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
//    @FXML
//    void cancel(ActionEvent event) throws IOException {
//        listObject.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
//            if (newValue != null) {
//                System.out.println(newValue.getValue());
//                showDetailView(newValue.getValue());
//            }
//        });
//    }

    @FXML
    void saveAllInfo(ActionEvent event) throws IOException {
        ArrayList<Experiment> arr = new ArrayList<>();
        arr.add(viewModel.getCurrentExperiment());
        DataAccess.saveData(arr);
    }

    @FXML
    void saveInfo(ActionEvent event) throws IOException {
//        ArrayList<Experiment> arr = new ArrayList<>();
//        arr.add(viewModel.getCurrentExperiment());
//        DataAccess.saveData(arr);
    }

}
