package main.sensoryexperimentplatform.controllers;

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

import java.io.IOException;

public class TestController {
    @FXML
    private AnchorPane propertiesPane;
    private TestVM testVM;
    private boolean isSidebarVisible = true;
    @FXML
    private TreeView<String> listObject;

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
    TreeItem<String> start;

    public void initialize(){
        testVM = new TestVM();
        HBox.setHgrow(mainPane, Priority.ALWAYS);
        start = new TreeItem<>("Start Experiment");
        listObject.setRoot(start);
        EventHandler<MouseEvent> mouseEventHandler = (MouseEvent event)->{
            try {
                handleMouseClicked(event);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        };
        listObject.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEventHandler);
    }
    @FXML
    void addAudibleInstruction(ActionEvent event) {
        listObject.setMaxHeight(311);
        propertiesPane.setVisible(true);
        start.setExpanded(true);
        start.getChildren().add(new TreeItem<>("[Audio] Default Notice Stage"));
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
        start.setExpanded(true);
        start.getChildren().add(new TreeItem<>("[User Input] Input Stage"));
    }

    @FXML
    void addNoticeStage(ActionEvent event){
        listObject.setMaxHeight(311);
        propertiesPane.setVisible(true);
        start.setExpanded(true);
        start.getChildren().add(new TreeItem<>("[Instruction] Default Notice Stage"));
    }

    @FXML
    void addPeriodicStage(ActionEvent event) {
        listObject.setMaxHeight(311);
        propertiesPane.setVisible(true);

    }

    @FXML
    void addQuestionStage(ActionEvent event) {
        listObject.setMaxHeight(311);
        propertiesPane.setVisible(true);
    }

    @FXML
    void addRatingContainer(ActionEvent event) {
        listObject.setMaxHeight(311);
        propertiesPane.setVisible(true);

    }

    @FXML
    void addTasteTest(ActionEvent event) {
        listObject.setMaxHeight(311);
        propertiesPane.setVisible(true);

    }

    @FXML
    void addTimer(ActionEvent event) {
        listObject.setMaxHeight(311);
        propertiesPane.setVisible(true);
        start.setExpanded(true);
        start.getChildren().add(new TreeItem<>("[Waiting] Please wait"));

    }

    @FXML
    void addVasStage(ActionEvent event) {
        listObject.setMaxHeight(311);
        propertiesPane.setVisible(true);

    }

    @FXML
    void assignSound(ActionEvent event) {
        listObject.setMaxHeight(311);
        propertiesPane.setVisible(true);

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
    private void handleMouseClicked(MouseEvent event) throws IOException {
       Node node = event.getPickResult().getIntersectedNode();
       if (node instanceof Text || (node instanceof TreeCell &&((TreeCell) node).getText() != null)){
           String value = (String)((TreeItem)listObject.getSelectionModel().getSelectedItem()).getValue();
           if (value.equals("[Instruction] Default Notice Stage")){
               FXMLLoader fxmlLoader = new FXMLLoader(SensoryExperimentPlatform.class.getResource("AddNoticeStage.fxml"));
               AnchorPane newContent = fxmlLoader.load();
               propertiesPane.getChildren().setAll(newContent);
               AddNoticeStage controller = fxmlLoader.getController();
           }
           else if (value.equals("[Audio] Default Notice Stage")){
               FXMLLoader fxmlLoader = new FXMLLoader(SensoryExperimentPlatform.class.getResource("InputStage.fxml"));
               AnchorPane newContent = fxmlLoader.load();
               propertiesPane.getChildren().setAll(newContent);
               InputStageController controller = fxmlLoader.getController();
           }
           else if (value.equals("[User Input] Input Stage")){
               FXMLLoader fxmlLoader = new FXMLLoader(SensoryExperimentPlatform.class.getResource("InputStage.fxml"));
               AnchorPane newContent = fxmlLoader.load();
               propertiesPane.getChildren().setAll(newContent);
               InputStageController controller = fxmlLoader.getController();
           }
           else if (value.equals("[Waiting] Please wait")){
               FXMLLoader fxmlLoader = new FXMLLoader(SensoryExperimentPlatform.class.getResource("TimerStage.fxml"));
               AnchorPane newContent = fxmlLoader.load();
               propertiesPane.getChildren().setAll(newContent);
               TimerController controller = fxmlLoader.getController();
           }
       }

    }
}
