package main.sensoryexperimentplatform.controllers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import main.sensoryexperimentplatform.SensoryExperimentPlatform;

import main.sensoryexperimentplatform.ViewModel.*;
import main.sensoryexperimentplatform.models.*;
import main.sensoryexperimentplatform.models.Timer;


import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TestController implements MouseListener{
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
    private TreeItem<String> ifConditional;
    private TreeItem<String> elseConditional;
    private Map<Integer, Wrapper> displayedItems ;
    private int index;

    private TestVM testVM;
    private boolean mouseClick;
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
        TreeItem<String> selectedItem = listObject.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            TreeItem<String> parent = selectedItem.getParent();
            if (parent != null) {
                int currentIndex = parent.getChildren().indexOf(selectedItem);
                if (currentIndex < parent.getChildren().size() - 1) {
                    TreeItem<String> nextItem = parent.getChildren().get(currentIndex + 1);
                    // Select the next sibling item
                    listObject.getSelectionModel().select(nextItem);
                }
            }
        }

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
        index =0;
        displayedItems = new HashMap<>();
        testVM = new TestVM();
        HBox.setHgrow(mainPane, Priority.ALWAYS);
        start = new TreeItem<>("Start Experiment");
        listObject.setRoot(start);
        btn_assignSound.setDisable(true);
        btn_AddPeriodicStage.setDisable(true);
        btn_addFoodAndTaste.setDisable(true);
        listObject.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                int index = getIndex(newValue);
                System.out.println(index);
                try {
                    showDetailView(index);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

    private int getIndex(TreeItem<String> item) {
        if (item.getParent() == null) {
            return 0; // Root item
        }
        return item.getParent().getChildren().indexOf(item);
    }

    private void showDetailView(int index) throws IOException {
        choose o = displayedItems.get(index).getChoose();
        o.modify(propertiesPane);
        o.modifyWithButton(propertiesPane,btn_AddPeriodicStage, btn_AddCourse, btn_assignSound,
                btn_addFoodAndTaste, btn_addAudibleInstruction
                , btn_addInput, btn_noticeStage,
                btn_addTimer, btn_AddQuestionStage,
                btn_addRatingContainer, btn_addTasteTest, btn_AddConditionalStatement);
               //  experiment.showStages();


//        else if (o instanceof Timer) {
//               FXMLLoader fxmlLoader = new FXMLLoader(SensoryExperimentPlatform.class.getResource("TimerStage.fxml"));
//               AnchorPane newContent = fxmlLoader.load();
//               propertiesPane.getChildren().setAll(newContent);
//               Timer timer = new Timer("13031321", null, false);
//               TimerController controller = fxmlLoader.getController();
//               timerStage_VM view = new timerStage_VM(timer);
//               controller.setViewModel (view);
//     /

    }

    private void mouseClicked(javafx.scene.input.MouseEvent mouseEvent) {
    }

    @FXML
    void addAudibleInstruction(ActionEvent event) {
        listObject.setMaxHeight(311);
        propertiesPane.setVisible(true);
        start.setExpanded(true);
        audibleSound_VM audibleSound_vm = new audibleSound_VM();
        String key = "[Audio]" + audibleSound_vm.getAudibleInstruction().getTitle();
        btn_assignSound.setDisable(false);
        Wrapper wrapper = new Wrapper(key, audibleSound_vm);
        displayedItems.put(index, wrapper);
        index++;
        //experiment.showStages();

        // Add to Randomnies if selected item matches ifConditional
        if (ifConditional != null && listObject.getSelectionModel().getSelectedItem() == ifConditional) {
            ifConditional.getChildren().add(new TreeItem<>(key));
            ifConditional.setExpanded(true);
        }
        // Add to Randomnies if selected item matches elseConditional
        else if (elseConditional != null && listObject.getSelectionModel().getSelectedItem() == elseConditional) {
            elseConditional.getChildren().add(new TreeItem<>(key));
            elseConditional.setExpanded(true);
        }
        // Add to start if no conditions match
        else {
            start.getChildren().add(new TreeItem<>(key));
        }
    }


    @FXML
    void addConditionalStatement(ActionEvent event) {
        listObject.setMaxHeight(311);
        propertiesPane.setVisible(true);
        start.setExpanded(true);
        ifConditional = new TreeItem<>("If Something less than something else then");
        elseConditional = new TreeItem<>("Else");
        start.getChildren().add( ifConditional);
        start.getChildren().add(elseConditional);
    }

    @FXML
    void addCourse(ActionEvent event) {
        listObject.setMaxHeight(311);
        propertiesPane.setVisible(true);
        start.setExpanded(true);

        AddCourseVM addCourseVM = new AddCourseVM(experiment);
        String key = "Start Eating stage";
        Wrapper wrapper = new Wrapper(key, addCourseVM);
        displayedItems.put(index, wrapper);
        index++;


        if (ifConditional != null && listObject.getSelectionModel().getSelectedItem() == ifConditional) {
            ifConditional.getChildren().add(new TreeItem<>(key));
            ifConditional.setExpanded(true);
        }
        // Add to Randomnies if selected item matches elseConditional
        else if (elseConditional != null && listObject.getSelectionModel().getSelectedItem() == elseConditional) {
            elseConditional.getChildren().add(new TreeItem<>(key));
            elseConditional.setExpanded(true);
        }
        // Add to start if no conditions match
        else {
            start.getChildren().add(new TreeItem<>(key));
        }

    }

    @FXML
    void addFoodAndTaste(ActionEvent event) throws IOException {
        listObject.setMaxHeight(311);
        propertiesPane.setVisible(true);
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

        glmsStage_VM glmsStage_VM = new glmsStage_VM(experiment);
        String key = "[GLMS]" + glmsStage_VM.getGLMS().getTitle();
        Wrapper wrapper = new Wrapper(key, glmsStage_VM);
        displayedItems.put(index, wrapper);
        index++;


        // Add to Randomnies if selected item matches ifConditional
        if (ifConditional != null && listObject.getSelectionModel().getSelectedItem() == ifConditional) {
            ifConditional.getChildren().add(new TreeItem<>(key));
            ifConditional.setExpanded(true);
        }
        // Add to Randomnies if selected item matches elseConditional
        else if (elseConditional != null && listObject.getSelectionModel().getSelectedItem() == elseConditional) {
            elseConditional.getChildren().add(new TreeItem<>(key));
            elseConditional.setExpanded(true);
        }
        // Add to start if no conditions match
        else {
            start.getChildren().add(new TreeItem<>(key));
        }
        listObject.setMaxHeight(311);
        propertiesPane.setVisible(true);
        start.setExpanded(true);





    }

    @FXML
    void addInput(ActionEvent event) {
        listObject.setMaxHeight(311);
        propertiesPane.setVisible(true);
        start.setExpanded(true);
        inputStage_VM inputStage_vm = new inputStage_VM();
        Input inputStage = inputStage_vm.getInput();
        String key = "[User Input]" +  inputStage.getTitle();
        Wrapper wrapper = new Wrapper(key, inputStage_vm);
        displayedItems.put(index, wrapper);
        index++;

        if (ifConditional != null && listObject.getSelectionModel().getSelectedItem() == ifConditional) {
            ifConditional.getChildren().add(new TreeItem<>(key) );
            ifConditional.setExpanded(true);
        }
        // Add to Randomnies if selected item matches elseConditional
        else if (elseConditional != null && listObject.getSelectionModel().getSelectedItem() == elseConditional) {
            elseConditional.getChildren().add(new TreeItem<>(key) );
            elseConditional.setExpanded(true);
        }
        // Add to start if no conditions match
        else {
            start.getChildren().add(new TreeItem<>(key));
        }



    }

    @FXML
    void addNoticeStage(ActionEvent event){
        listObject.setMaxHeight(311);
        propertiesPane.setVisible(true);
        start.setExpanded(true);
        noticeStage_VM noticeStage_vm = new noticeStage_VM(experiment);
        String key = "[Instruction]" + noticeStage_vm.getNotice().getTitle();
        System.out.println(index);
        Wrapper wrapper = new Wrapper(key, noticeStage_vm);
        displayedItems.put(index, wrapper);
        index++;
        //experiment.showStages();
        if (ifConditional != null && listObject.getSelectionModel().getSelectedItem() == ifConditional) {
            ifConditional.getChildren().add(new TreeItem<>(key));
            ifConditional.setExpanded(true);
        }
        // Add to Randomnies if selected item matches elseConditional
        else if (elseConditional != null && listObject.getSelectionModel().getSelectedItem() == elseConditional) {
            elseConditional.getChildren().add(new TreeItem<>(key));
            elseConditional.setExpanded(true);
        }
        // Add to start if no conditions match
        else {
            start.getChildren().add(new TreeItem<>(key));
        }


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
        questionStage_VM questionStage_vm = new questionStage_VM();
        Question question = questionStage_vm.getQuestionStage();
        String key = "[Question]" + question.getQuestion();
        Wrapper wrapper = new Wrapper(key, questionStage_vm);
        displayedItems.put(index, wrapper);
        index++;
        TreeItem<String> QuestionStage = new TreeItem<>(key);
        if (ifConditional != null && listObject.getSelectionModel().getSelectedItem() == ifConditional) {
            ifConditional.getChildren().add(QuestionStage);
            ifConditional.setExpanded(true);
        }
        // Add to Randomnies if selected item matches elseConditional
        else if (elseConditional != null && listObject.getSelectionModel().getSelectedItem() == elseConditional) {
            elseConditional.getChildren().add(QuestionStage);
            elseConditional.setExpanded(true);
        }
        // Add to start if no conditions match
        else {
            start.getChildren().add(QuestionStage);
        }
    }

    @FXML
    void addRatingContainer(ActionEvent event) {
        listObject.setMaxHeight(311);
        propertiesPane.setVisible(true);
        start.setExpanded(true);
        ratingContainer_VM ratingContainer_vm = new ratingContainer_VM();
        RatingContainer ratingContainer = ratingContainer_vm.getRatingContainer();
        String key = "Ratings container";
        Wrapper wrapper = new Wrapper(key,ratingContainer_vm);
        displayedItems.put(index, wrapper);
        index++;
        Randomnies = new TreeItem<>(key);


        if (ifConditional != null && listObject.getSelectionModel().getSelectedItem() == ifConditional) {
            ifConditional.getChildren().add( Randomnies);
            ifConditional.setExpanded(true);
        }
        // Add to Randomnies if selected item matches elseConditional
        else if (elseConditional != null && listObject.getSelectionModel().getSelectedItem() == elseConditional) {
            elseConditional.getChildren().add( Randomnies);
            elseConditional.setExpanded(true);
        }
        // Add to start if no conditions match
        else {
            start.getChildren().add( Randomnies);
        }


    }

    @FXML
    void addTasteTest(ActionEvent event) {
        listObject.setMaxHeight(311);
        propertiesPane.setVisible(true);
        start.setExpanded(true);
        btn_addFoodAndTaste.setDisable(false);
        TreeItem<String> tasteTest = new TreeItem<>("Taste test");
        if (ifConditional != null && listObject.getSelectionModel().getSelectedItem() == ifConditional) {
            ifConditional.getChildren().add(tasteTest);
            ifConditional.setExpanded(true);
        }
        // Add to Randomnies if selected item matches elseConditional
        else if (elseConditional != null && listObject.getSelectionModel().getSelectedItem() == elseConditional) {
            elseConditional.getChildren().add(tasteTest);
            elseConditional.setExpanded(true);
        }
        // Add to start if no conditions match
        else {
            start.getChildren().add(tasteTest);
        }
    }

    @FXML
    void addTimer(ActionEvent event) {
        listObject.setMaxHeight(311);
        propertiesPane.setVisible(true);
        start.setExpanded(true);
        timerStage_VM timerStageVm = new timerStage_VM(experiment);
        String key = "[Waiting]" + timerStageVm.getTimer().getTitle();
        Wrapper wrapper = new Wrapper(key, timerStageVm);
        displayedItems.put(index, wrapper);
        index++;
       // experiment.showStages();
        if (ifConditional != null && listObject.getSelectionModel().getSelectedItem() == ifConditional) {
            ifConditional.getChildren().add(new TreeItem<>(key));
            ifConditional.setExpanded(true);
        }
        // Add to Randomnies if selected item matches elseConditional
        else if (elseConditional != null && listObject.getSelectionModel().getSelectedItem() == elseConditional) {
            elseConditional.getChildren().add(new TreeItem<>(key));
            elseConditional.setExpanded(true);
        }
        // Add to start if no conditions match
        else {
            start.getChildren().add(new TreeItem<>(key));
        }

    }

    @FXML
    void addVasStage(ActionEvent event) {
        listObject.setMaxHeight(311);
        propertiesPane.setVisible(true);
        start.setExpanded(true);
        vasStage_VM vasStage_VM = new vasStage_VM(experiment);
        String key = "[Vas]" + vasStage_VM.getVas().getTitle();
        index++;
        Wrapper wrapper = new Wrapper(key, vasStage_VM);
        displayedItems.put(index, wrapper);
      //  experiment.showStages();



        // Add to Randomnies if selected item matches ifConditional
        if (ifConditional != null && listObject.getSelectionModel().getSelectedItem() == ifConditional) {
            ifConditional.getChildren().add(new TreeItem<>(key));
            ifConditional.setExpanded(true);
        }
        // Add to Randomnies if selected item matches elseConditional
        else if (elseConditional != null && listObject.getSelectionModel().getSelectedItem() == elseConditional) {
            elseConditional.getChildren().add(new TreeItem<>(key));
            elseConditional.setExpanded(true);
        }
        // Add to start if no conditions match
        else {
            start.getChildren().add(new TreeItem<>(key));
        }

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


    @Override
    public void mouseClicked(MouseEvent e) {
        mouseClick = true;
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }


    public void setExperiment(Experiment c) {
        this.experiment = c;
    }
}