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
import javafx.scene.text.Text;
import main.sensoryexperimentplatform.SensoryExperimentPlatform;
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
    private AnchorPane mainPane;
    @FXML
    private AnchorPane propertiesPane;

    @FXML
    private ListView<String> showList;

    private editEx_VM viewModel;

    public DemoController() throws IOException {
        viewModel = new editEx_VM();
    }
    private void showDetailView(String item)  {
        Object selectedObject = viewModel.getObjectByKey(item);
        if (selectedObject != null) {
            try {
                if (selectedObject instanceof Notice){
                    System.out.println(((Notice) selectedObject).title);
                    FXMLLoader loader = new FXMLLoader(Main.class.getResource("/main/sensoryexperimentplatform/AddNoticeStage.fxml"));
                    AnchorPane newContent = loader.load();
                    propertiesPane.getChildren().setAll(newContent);


                    NoticeStageController controller = loader.getController();
                    noticeStage_VM vm = new noticeStage_VM((Notice) selectedObject);
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


//        Experiment experiment = DataAccess.getExperimentIndividually();
//        if (experiment != null) {
//            ArrayList<Object> stages = experiment.getStages();
//            ArrayList<String> str = new ArrayList<>();
//            for (Object o : stages) {
//                if (o instanceof Stage) {
//                    str.add("[" + o.getClass().getSimpleName() + "] " + ((Stage) o).getTitle());
//                }
//                //handleView(o.getClass().getSimpleName());
//            }
//            for (int i = 0; i < 5; i++) {
//                rcr.getChildren().add(new TreeItem<>(str.get(random.nextInt(str.size()))));
//            }
//        }
        listObject.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                showDetailView(newValue.getValue());
            }
        });
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
