package main.sensoryexperimentplatform.controllers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import main.sensoryexperimentplatform.SensoryExperimentPlatform;

import java.io.IOException;

public class TestController {
    @FXML
    private AnchorPane propertiesPane;
    private TreeItem<String> courseItem;
    private TestVM testVM;
    private boolean isSidebarVisible = true;
    @FXML
    private TreeView<String> listObject;

    @FXML
    private HBox mainBox;

    @FXML
    private Button btn_AddPeriodicStage;

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

    @FXML
    private Button btn_assignSound;
    private AnchorPane rootPane;
    @FXML
    private Button btn_AddCourse;

    public void initialize(){
        testVM = new TestVM();
        HBox.setHgrow(mainPane, Priority.ALWAYS);
        start = new TreeItem<>("Start Experiment");
        listObject.setRoot(start);
        btn_assignSound.setDisable(true);
        btn_AddPeriodicStage.setDisable(true);

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
        listObject.setMaxHeight(311);
        propertiesPane.setVisible(true);
        start.setExpanded(true);
        start.getChildren().add(new TreeItem<>("If Something less than something else then"));
        start.getChildren().add(new TreeItem<>("Else"));
    }

    @FXML
    void addCourse(ActionEvent event) {
        listObject.setMaxHeight(311);
        propertiesPane.setVisible(true);
        start.setExpanded(true);
        courseItem = new TreeItem<>("Start Eating stage");
        start.getChildren().add(courseItem);

        start.setExpanded(true);




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
        start.setExpanded(true);
        start.getChildren().add(new TreeItem<>("[GLMS] Question?"));
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
        start.setExpanded(true);

        if (courseItem != null) {

            TreeItem<String> periodicStage = new TreeItem<>("Every -1 grams");
            courseItem.getChildren().add(periodicStage);

            // Optionally expand the course item to show the newly added child
            courseItem.setExpanded(true);
        } else {

        }


    }

    @FXML
    void addQuestionStage(ActionEvent event) {
        listObject.setMaxHeight(311);
        propertiesPane.setVisible(true);
        start.setExpanded(true);
        start.getChildren().add(new TreeItem<>("[Question] Question"));
    }

    @FXML
    void addRatingContainer(ActionEvent event) {
        listObject.setMaxHeight(311);
        propertiesPane.setVisible(true);
        start.setExpanded(true);
        start.getChildren().add(new TreeItem<>("Ratings container"));

    }

    @FXML
    void addTasteTest(ActionEvent event) {
        listObject.setMaxHeight(311);
        propertiesPane.setVisible(true);
        start.setExpanded(true);
        start.getChildren().add(new TreeItem<>("Taste test"));
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
        start.setExpanded(true);
        start.getChildren().add(new TreeItem<>("[Vas] Question?"));
    }

    @FXML
    void assignSound(ActionEvent event) throws IOException {
        listObject.setMaxHeight(311);
        FXMLLoader fxmlLoader = new FXMLLoader(SensoryExperimentPlatform.class.getResource("AssignSound.fxml"));
        Parent root = fxmlLoader.load();

        Stage stage = new Stage();
        stage.setTitle("Add Sound");

        Scene scene = new Scene(root);
        stage.setScene(scene);

        stage.show();


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
           else if (value.equals("[Audio] Default Notice Stage")) {
               FXMLLoader fxmlLoader = new FXMLLoader(SensoryExperimentPlatform.class.getResource("AddAudibleSound.fxml"));
               AnchorPane newContent = fxmlLoader.load();
               propertiesPane.getChildren().setAll(newContent);
//               AddNoticeStage controller = fxmlLoader.getController();
               btn_assignSound.setDisable(false);

           }
           else if (value.equals("[User Input] Input Stage")){
               FXMLLoader fxmlLoader = new FXMLLoader(SensoryExperimentPlatform.class.getResource("InputStage.fxml"));
               AnchorPane newContent = fxmlLoader.load();
               propertiesPane.getChildren().setAll(newContent);
               InputStageController controller = fxmlLoader.getController();
           }
           else if (value.equals("[Waiting] Please wait")) {
               FXMLLoader fxmlLoader = new FXMLLoader(SensoryExperimentPlatform.class.getResource("TimerStage.fxml"));
               AnchorPane newContent = fxmlLoader.load();
               propertiesPane.getChildren().setAll(newContent);
               TimerController controller = fxmlLoader.getController();
               controller.init();
           }
           else if (value.equals("Taste test")){
               FXMLLoader fxmlLoader = new FXMLLoader(SensoryExperimentPlatform.class.getResource("AddTasteTest.fxml"));
               AnchorPane newContent = fxmlLoader.load();
               propertiesPane.getChildren().setAll(newContent);
               addTasteController controller = fxmlLoader.getController();
               controller.init();

           }
           else if (value.equals("Ratings container")){
               FXMLLoader fxmlLoader = new FXMLLoader(SensoryExperimentPlatform.class.getResource("AddRatingsContainer.fxml"));
               AnchorPane newContent = fxmlLoader.load();
               propertiesPane.getChildren().setAll(newContent);
//               AddNoticeStage controller = fxmlLoader.getController();
           }
           else if (value.equals("Start Eating stage")){
               FXMLLoader fxmlLoader = new FXMLLoader(SensoryExperimentPlatform.class.getResource("AddCourse.fxml"));
               AnchorPane newContent = fxmlLoader.load();
               propertiesPane.getChildren().setAll(newContent);
//               AddNoticeStage controller = fxmlLoader.getController();
               btn_AddPeriodicStage.setDisable(false);
               btn_AddCourse.setDisable(true);

           }
           else if (value.equals("Every -1 grams")){
               FXMLLoader fxmlLoader = new FXMLLoader(SensoryExperimentPlatform.class.getResource("AddPeriodicStage.fxml"));
               AnchorPane newContent = fxmlLoader.load();
               propertiesPane.getChildren().setAll(newContent);
//               AddNoticeStage controller = fxmlLoader.getController();
               btn_AddPeriodicStage.setDisable(false);
               btn_AddCourse.setDisable(true);

           }
           else if (value.equals("[Question] Question")){
               FXMLLoader fxmlLoader = new FXMLLoader(SensoryExperimentPlatform.class.getResource("QuestionStage.fxml"));
               AnchorPane newContent = fxmlLoader.load();
               propertiesPane.getChildren().setAll(newContent);
//               AddNoticeStage controller = fxmlLoader.getController();
           }
           else if (value.equals("If Something less than something else then")){
               FXMLLoader fxmlLoader = new FXMLLoader(SensoryExperimentPlatform.class.getResource("AddConditionalStatement.fxml"));
               AnchorPane newContent = fxmlLoader.load();
               propertiesPane.getChildren().setAll(newContent);
//               AddNoticeStage controller = fxmlLoader.getController();
           }
           else if (value.equals("Else")){
               FXMLLoader fxmlLoader = new FXMLLoader(SensoryExperimentPlatform.class.getResource("AddConditionalStatement.fxml"));
               AnchorPane newContent = fxmlLoader.load();
               propertiesPane.getChildren().setAll(newContent);
//               AddNoticeStage controller = fxmlLoader.getController();
           }
           else if (value.equals("[Vas] Question?")) {
               FXMLLoader fxmlLoader = new FXMLLoader(SensoryExperimentPlatform.class.getResource("VasStage.fxml"));
               AnchorPane newContent = fxmlLoader.load();
               propertiesPane.getChildren().setAll(newContent);
               VasController controller = fxmlLoader.getController();
               controller.initialize ();
           }
           else if (value.equals("[GLMS] Question?")) {
               FXMLLoader fxmlLoader = new FXMLLoader(SensoryExperimentPlatform.class.getResource("GLMS.fxml"));
               AnchorPane newContent = fxmlLoader.load();
               propertiesPane.getChildren().setAll(newContent);
               GLMSController controller = fxmlLoader.getController();
               controller.init ();
           }





       }

    }
}
