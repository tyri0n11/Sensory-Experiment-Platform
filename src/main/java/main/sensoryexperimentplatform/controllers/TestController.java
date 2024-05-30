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

import main.sensoryexperimentplatform.ViewModel.*;
import main.sensoryexperimentplatform.models.*;


import java.io.IOException;
import java.util.ArrayList;

public class TestController {
    @FXML
    private Button btn_AddConditionalStatement;
    private Experiment experiment;
    @FXML
    private Button btn_AddCourse;

    @FXML
    private Button btn_AddGLMS;

    @FXML
    private Button btn_AddPeriodicStage;

    @FXML
    private Button btn_AddQuestionStage;
    @FXML
    private Button btn_addAudibleInstruction;

    @FXML
    private Button btn_addFoodAndTaste;

    @FXML
    private Button btn_addInput;

    @FXML
    private Button btn_addRatingContainer;

    @FXML
    private Button btn_addTasteTest;

    @FXML
    private Button btn_addTimer;

    @FXML
    private Button btn_addVasStage;

    @FXML
    private Button btn_assignSound;

    @FXML
    private AnchorPane propertiesPane;
    private TreeItem<String> courseItem;
    private TreeItem<String> Randomnies;
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


    private AnchorPane rootPane;
    @FXML
    void delete(ActionEvent event) {
        TreeItem<String> selectedItem = listObject.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            TreeItem<String> parent = selectedItem.getParent();
            if (parent != null) {
                parent.getChildren().remove(selectedItem);
            } else {
                // If it's a root item, remove it from the TreeView directly
                listObject.getRoot().getChildren().remove(selectedItem);
            }
        }
    }
    @FXML
    void down(ActionEvent event) {

    }
    @FXML
    void up(ActionEvent event) {
        TreeItem<String> selectedItem = listObject.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            TreeItem<String> parent = selectedItem.getParent();
            if (parent != null) {
                int currentIndex = parent.getChildren().indexOf(selectedItem);
                if (currentIndex > 0) {
                    TreeItem<String> previousItem = parent.getChildren().get(currentIndex - 1);
                    // Select the previous sibling item
                    listObject.getSelectionModel().select(previousItem);
                }
            }
        }
    }


    public void initialize(){
        this.experiment = new Experiment("Prof Tung`","Toi di test dao","khong co gi ca","ko","1");
        testVM = new TestVM();
        HBox.setHgrow(mainPane, Priority.ALWAYS);
        start = new TreeItem<>("Start Experiment");
        listObject.setRoot(start);
        btn_assignSound.setDisable(true);
        btn_AddPeriodicStage.setDisable(true);
        btn_addFoodAndTaste.setDisable(true);

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
    void addFoodAndTaste(ActionEvent event) throws IOException {
        listObject.setMaxHeight(311);
        propertiesPane.setVisible(true);
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
    void addGLMSStage(ActionEvent event) {
        listObject.setMaxHeight(311);
        propertiesPane.setVisible(true);
        start.setExpanded(true);

        TreeItem<String> glmsQuestionItem = new TreeItem<>("[GLMS] Question?");
        if (Randomnies != null && listObject.getSelectionModel().getSelectedItem() == Randomnies) {
            Randomnies.getChildren().add(glmsQuestionItem);
            Randomnies.setExpanded(true);
        } else {
            start.getChildren().add( glmsQuestionItem);
        }

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
       // start.getChildren().add(new TreeItem<>("[Question] Question"));
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
        Randomnies = new TreeItem<>("Ratings container");
        start.getChildren().add(Randomnies);



    }

    @FXML
    void addTasteTest(ActionEvent event) {
        listObject.setMaxHeight(311);
        propertiesPane.setVisible(true);
        start.setExpanded(true);
        btn_addFoodAndTaste.setDisable(false);
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


        TreeItem<String> vasQuestionItem = new TreeItem<>("[Vas] Question?");

        if (Randomnies != null && listObject.getSelectionModel().getSelectedItem() == Randomnies) {
            Randomnies.getChildren().add(vasQuestionItem);
            Randomnies.setExpanded(true);
        } else {
            start.getChildren().add(vasQuestionItem);
        }

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
       if (node instanceof Text || (node instanceof TreeCell &&((TreeCell) node).getText() != null)) {
           String value = (String) ((TreeItem) listObject.getSelectionModel().getSelectedItem()).getValue();
           if (value.equals("Start Experiment")) {

               btn_AddCourse.setDisable(false);
               btn_addAudibleInstruction.setDisable(false);
               btn_addInput.setDisable(false);
               btn_addRatingContainer.setDisable(false);
               btn_addTasteTest.setDisable(false);
               btn_addTimer.setDisable(false);
               btn_AddQuestionStage.setDisable(false);
               btn_noticeStage.setDisable(false);
               btn_AddConditionalStatement.setDisable(false);

               }
           else if (value.equals("[Instruction] Default Notice Stage")) {
               FXMLLoader fxmlLoader = new FXMLLoader(SensoryExperimentPlatform.class.getResource("AddNoticeStage.fxml"));
               AnchorPane newContent = fxmlLoader.load();
               propertiesPane.getChildren().setAll(newContent);
               NoticeStageController controller = new NoticeStageController();
               noticeStage_VM viewModel = new noticeStage_VM();
               controller.setNoticeStage_vm(viewModel);
           }
           else if (value.equals("[Audio] Default Notice Stage")) {
               FXMLLoader fxmlLoader = new FXMLLoader(SensoryExperimentPlatform.class.getResource("AddAudibleSound.fxml"));
               AnchorPane newContent = fxmlLoader.load();
               propertiesPane.getChildren().setAll(newContent);
                addAudibleSoundController controller = new addAudibleSoundController();
               btn_assignSound.setDisable(false);


           }
             else if (value.equals("[User Input] Input Stage")) {
               FXMLLoader fxmlLoader = new FXMLLoader(SensoryExperimentPlatform.class.getResource("InputStage.fxml"));
               AnchorPane newContent = fxmlLoader.load();
               propertiesPane.getChildren().setAll(newContent);

               InputStageController controller = new InputStageController();
               inputStage_VM viewModel = new inputStage_VM();
               controller.setViewModel(viewModel);



           }   else if (value.equals("[Waiting] Please wait")) {
               FXMLLoader fxmlLoader = new FXMLLoader(SensoryExperimentPlatform.class.getResource("TimerStage.fxml"));
               AnchorPane newContent = fxmlLoader.load();
               propertiesPane.getChildren().setAll(newContent);
               Timer timer = new Timer("13031321", null, false);
               TimerController controller = fxmlLoader.getController();
               timerStage_VM view = new timerStage_VM(timer);
               controller.setViewModel (view);
           }

              else if (value.equals("Taste test")){
                    FXMLLoader fxmlLoader = new FXMLLoader(SensoryExperimentPlatform.class.getResource("AddTasteTest.fxml"));
                    AnchorPane newContent = fxmlLoader.load();
                    propertiesPane.getChildren().setAll(newContent);
                    TasteTest model = new TasteTest("hjd", "df", "kh", "d","da", 0, 100, "as", false,"áds", "ád", 0, false, false, false);
                    addTasteController controller = fxmlLoader.getController();
                    AddTasteVM view = new AddTasteVM(model);
                    controller.setViewModel(view);

       }
           else if (value.equals("Ratings container")){
               FXMLLoader fxmlLoader = new FXMLLoader(SensoryExperimentPlatform.class.getResource("AddRatingsContainer.fxml"));
               AnchorPane newContent = fxmlLoader.load();
               propertiesPane.getChildren().setAll(newContent);
               btn_AddPeriodicStage.setDisable(true);
               btn_AddCourse.setDisable(true);
               btn_assignSound.setDisable(true);
               btn_addFoodAndTaste.setDisable(true);
               btn_addAudibleInstruction.setDisable(true);
                btn_addInput.setDisable(true);
               btn_addInput.setDisable(true);
               btn_noticeStage.setDisable(true);
               btn_addTimer.setDisable(true);
               btn_AddQuestionStage.setDisable(true);
               btn_addRatingContainer.setDisable(true);
               btn_addTasteTest.setDisable(true);
               btn_addFoodAndTaste.setDisable(true);
               btn_AddConditionalStatement.setDisable(true);




//               AddNoticeStage controller = fxmlLoader.getController();
           }
           else if (value.equals("Start Eating stage")){
               FXMLLoader fxmlLoader = new FXMLLoader(SensoryExperimentPlatform.class.getResource("AddCourse.fxml"));
               AnchorPane newContent = fxmlLoader.load();
               propertiesPane.getChildren().setAll(newContent);
               AddCourseController controller = fxmlLoader.getController();
               btn_AddPeriodicStage.setDisable(false);
               btn_AddCourse.setDisable(true);
               btn_noticeStage.setDisable(true);
               btn_addAudibleInstruction.setDisable(true);


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
               questionStageController controller = fxmlLoader.getController();
               questionStage_VM viewModel = new questionStage_VM();
               controller.setQuestionStage_vm(viewModel);
           }
           else if (value.equals("If Something less than something else then")){
               FXMLLoader fxmlLoader = new FXMLLoader(SensoryExperimentPlatform.class.getResource("AddConditionalStatement.fxml"));
               AnchorPane newContent = fxmlLoader.load();
               propertiesPane.getChildren().setAll(newContent);

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
               Vas stage = new Vas(null,null,null,
                       0,100,null,null,
                       null,false,false);
               VasController controller = fxmlLoader.getController();
               vasStage_VM viewModel = new vasStage_VM(stage);
               controller.setViewModel(viewModel);
           }
           else if (value.equals("[GLMS] Question?")) {
               FXMLLoader fxmlLoader = new FXMLLoader(SensoryExperimentPlatform.class.getResource("GLMS.fxml"));
               AnchorPane newContent = fxmlLoader.load();
               propertiesPane.getChildren().setAll(newContent);
               gLMS glms = new gLMS(null,null,null,null, false);
               GLMSController controller = fxmlLoader.getController();
               glmsStage_VM view = new glmsStage_VM(glms);
               controller.setViewModel(view);
           }

       }

    }
}
