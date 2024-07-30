package main.sensoryexperimentplatform.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.util.Callback;
import main.sensoryexperimentplatform.SensoryExperimentPlatform;
import main.sensoryexperimentplatform.viewmodel.noticeStage_VM;
import main.sensoryexperimentplatform.models.Experiment;
import main.sensoryexperimentplatform.viewmodel.*;
import main.sensoryexperimentplatform.models.*;
import main.sensoryexperimentplatform.models.Timer;


import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.*;

public class TestController{
    @FXML
    private Button btn_AddConditionalStatement;
    private Experiment experiment;
    @FXML
    private Button btn_AddCourse;

    @FXML
    private Button btnCancel;

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

    private TreeItem<String> Randomnies;
    private TreeItem<String> ifConditional;
    private TreeItem<String> elseConditional;
    private Map<Integer, Wrapper> displayedItems ;
    private int index;
    private boolean mouseClick;
    private Stack<ratingContainer_VM> rating;
    @FXML
    private TreeView<String> listObject;


    @FXML
    private Button btn_noticeStage;

    @FXML
    private VBox sideMenu;

    @FXML
    private AnchorPane mainPane;
    private TreeItem<String> start;
    private AudibleInstruction audibleInstruction;
    private Stack <AddTasteVM> addTasteVMS;
    private Stack <AddCourseVM> addCourseVMS;
    private Experiment originalExperiment;

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
        rating = new Stack<>();
        addTasteVMS = new Stack<>();
        addCourseVMS = new Stack<>();
        index = 0;
        displayedItems = new HashMap<>();
        listObject.setRoot(start);
        btn_assignSound.setDisable(true);
        btn_AddPeriodicStage.setDisable(true);
        btn_addFoodAndTaste.setDisable(true);
        listObject.setPrefHeight(574);
        listObject.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                int index = getIndex(newValue);
                // System.out.println(index);
                try {
                    addTasteVMS.clear();
                    addCourseVMS.clear();
                    btn_addFoodAndTaste.setDisable(true);
                    newValue.setValue(showDetailView(index));


                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        listObject.setCellFactory(new Callback<TreeView<String>, TreeCell<String>>() {
            @Override
            public TreeCell<String> call(TreeView<String> param) {
                return new TreeCell<>() {
                    @Override
                    protected void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty || item == null) {
                            setText(null);
                            setStyle("");
                        } else {
                            setText(item);
                            // Apply the style conditionally
                            if (getTreeItem().getParent() != null && getTreeItem().getParent().getChildren().indexOf(getTreeItem()) % 2 != 0) {
                                setStyle("-fx-background-color: #F1F6FB; -fx-text-fill: black;");
                            } else {
                                setStyle("");
                            }
                        }
                    }
                };
            }
        });
    }

    private int getIndex(TreeItem<String> item) {
        if (item.getParent() == null) {
            return 0; // Root item
        }
        return listObject.getRow(item);
    }

    private String showDetailView(int index) throws IOException {
        choose o = displayedItems.get(index).getChoose();
        o.modify(propertiesPane, addTasteVMS, addCourseVMS);
        o.modifyWithButton(propertiesPane,addTasteVMS, addCourseVMS,btn_AddPeriodicStage, btn_AddCourse, btn_assignSound,
                btn_addFoodAndTaste, btn_addAudibleInstruction
                , btn_addInput, btn_noticeStage,
                btn_addTimer, btn_AddQuestionStage,
                btn_addRatingContainer, btn_addTasteTest, btn_AddConditionalStatement, rating
        );
        return o.getTitle();

    }
    private void loadItems() {
        Set<String> set = new LinkedHashSet<>();
        ArrayList<Object> stages = experiment.getStages();
        if (experiment.getStages().isEmpty()) {
            StartVM startVM = new StartVM(experiment);
            String key = startVM.getTitle();
            start = new TreeItem<>(key);
            listObject.setRoot(start);
            Wrapper wrapper = new Wrapper(key, startVM);
            displayedItems.put(index, wrapper);
            index++;
        } else {
                    Start startNe = experiment.getStart();
                    String key1 = startNe.getTitle();
                    start = new TreeItem<>(key1);
                    listObject.setRoot(start);
                    StartVM startVM = new StartVM(startNe);
                    Wrapper wrapper1 = new Wrapper(key1, startVM);
                    displayedItems.put(index, wrapper1);
                    index++;
            for (Object o : stages) {

                if (o instanceof Vas) {
                    String key = "[VAS]" + ((Vas) o).getTitle();
                    start.getChildren().add(new TreeItem<>(key));
                    start.getChildren().add(new TreeItem<>(key));
                    vasStage_VM vasStageVm = new vasStage_VM((Vas) o);
                    Wrapper wrapper = new Wrapper(key, vasStageVm);
                    displayedItems.put(index, wrapper);
                    index++;
                    // str.add(key);
                    // items.setAll(str);
                } else if (o instanceof Notice) {
                    String key = "[Instruction] " + ((Notice) o).getTitle();
                    start.getChildren().add(new TreeItem<>(key));
                    noticeStage_VM noticeStage_vm = new noticeStage_VM((Notice) o);
                    Wrapper wrapper = new Wrapper(key, noticeStage_vm);
                    displayedItems.put(index, wrapper);
                    index++;

                } else if (o instanceof gLMS) {
                    String key = "[GLMS] " + ((gLMS) o).getTitle();
                    start.getChildren().add(new TreeItem<>(key));
                    glmsStage_VM glmsStageVm = new glmsStage_VM((gLMS) o);
                    Wrapper wrapper = new Wrapper(key, glmsStageVm);
                    displayedItems.put(index, wrapper);
                    index++;
                } else if (o instanceof Input) {
                    String key = "[User Input] " + ((Input) o).getTitle();
                    start.getChildren().add(new TreeItem<>(key));
                    inputStage_VM inputStage_vm = new inputStage_VM(experiment,(Input) o);
                    Wrapper wrapper = new Wrapper(key, inputStage_vm);
                    displayedItems.put(index, wrapper);
                    index++;
                } else if (o instanceof TasteTest) {
                    String key = "[User Input] " + ((Input) o).getTitle();
                    start.getChildren().add(new TreeItem<>(key));
                    AddTasteVM inputStage_vm = new AddTasteVM((TasteTest) o);
                    Wrapper wrapper = new Wrapper(key, inputStage_vm);
                    displayedItems.put(index, wrapper);
                    index++;
                } else if (o instanceof Course) {
                    String key = "[" + o.getClass().getSimpleName() + "] " + ((Course) o).getTitle();
                    start.getChildren().add(new TreeItem<>(key));
                    AddCourseVM addCourseVM = new AddCourseVM((Course) o);
                    Wrapper wrapper = new Wrapper(key, addCourseVM);
                    displayedItems.put(index, wrapper);
                    index++;
                } else if (o instanceof Timer) {
                    String key = "[" + o.getClass().getSimpleName() + "] " + ((Timer) o).getTitle();
                    start.getChildren().add(new TreeItem<>(key));
                    timerStage_VM addCourseVM = new timerStage_VM((Timer) o);
                    Wrapper wrapper = new Wrapper(key, addCourseVM);
                    displayedItems.put(index, wrapper);
                    index++;
                }
//                else if (o instanceof Periodic){
//                    String key = "[" + o.getClass().getSimpleName() + "] " + ((Periodic) o).getTitle();
//                    start.getChildren().add(new TreeItem<>(key));
//
//                    // Wrapper wrapper = new Wrapper(key, addCourseVM);
//                    //displayedItems.put(index, wrapper);
//                    index++;
//                }
//                else if (o instanceof RatingContainer) {
////                       String key = "[" + o.getClass().getSimpleName() + "] " + ((Stage) o).getTitle();
////                       System.out.println(key);
////                       displayedItems.put(key, o);
////                       str.add(key);
//                    for (Object subO : ((RatingContainer) o).container) {
//                        if (subO instanceof Vas) {
//                            String key = "[VAS]" + ((Vas) subO).getTitle();
//                            System.out.println(key);
//                            //    displayedScales.put(key, o);
//                            set.add(key);
//                        } else if (subO instanceof gLMS) {
//                            String key = "[GLMS]" + ((gLMS) subO).getTitle();
//                            System.out.println(key);
//                            // displayedScales.put(key, o);
//                            set.add(key);
//                        }
//                    }
//
//                    //scales.setAll(set);
//                }
//                else if (o instanceof Periodic){
//                    String key = "[" + o.getClass().getSimpleName() + "] " + ((Periodic) o).getTitle();
//                    start.getChildren().add(new TreeItem<>(key));
//
//                    // Wrapper wrapper = new Wrapper(key, addCourseVM);
//                    //displayedItems.put(index, wrapper);
//                    index++;
//                }
                else if (o instanceof RatingContainer) {
//                       String key = "[" + o.getClass().getSimpleName() + "] " + ((Stage) o).getTitle();
//                       System.out.println(key);
//                       displayedItems.put(key, o);
//                       str.add(key);
                    for (Object subO : ((RatingContainer) o).container) {
                        if (subO instanceof Vas) {
                            String key = "[VAS]" + ((Vas) subO).getTitle();
                            System.out.println(key);
                            //    displayedScales.put(key, o);
                            set.add(key);
                        } else if (subO instanceof gLMS) {
                            String key = "[GLMS]" + ((gLMS) subO).getTitle();
                            System.out.println(key);
                            // displayedScales.put(key, o);
                            set.add(key);
                        }
                    }

                    //scales.setAll(set);
                }
//                else if (o instanceof conditionalStatement) {
//                    String key = "If" +  ((conditionalStatement) o).getVariable1Choice();
//                    start.getChildren().add( new TreeItem<>(key));
//                    conditionalStatementVM ConditionalStatementVM = new conditionalStatementVM((conditionalStatement) o);
//                    Wrapper wrapper = new Wrapper(key, ConditionalStatementVM);
//                    displayedItems.put(index, wrapper);
//                    index++;
//                }
            }
            listObject.setMaxHeight(311);
            propertiesPane.setVisible(true);
            start.setExpanded(true);
        }
    }
    @FXML
    void addAudibleInstruction(ActionEvent event) {
        listObject.setMaxHeight(311);
        propertiesPane.setVisible(true);
        start.setExpanded(true);
        audibleSound_VM audibleSound_vm = new audibleSound_VM(experiment);
        String key = "[Audio] " +audibleSound_vm.getAudibleInstruction().getTitle();

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
        conditionalStatementVM ConditionalStatementVM = new conditionalStatementVM(experiment);
        String key = ConditionalStatementVM.getTitle() ;
        Wrapper wrapper = new Wrapper(key, ConditionalStatementVM);
        displayedItems.put(index, wrapper);
        index++;
        ifConditional = new TreeItem<>(key);
        elseConditional = new TreeItem<>("Else");
        start.getChildren().add(ifConditional);
        start.getChildren().add(elseConditional);

    }

    @FXML
    void addCourse(ActionEvent event) {
        listObject.setMaxHeight(311);
        propertiesPane.setVisible(true);
        start.setExpanded(true);

        AddCourseVM addCourseVM = new AddCourseVM(experiment);
        Course course = addCourseVM.getCourse();
        String key = course.getTitle();

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
        FXMLLoader fxmlLoader = new FXMLLoader(SensoryExperimentPlatform.class.getResource("FoodAndTaste.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("Add Food and Taste");
        TasteTest taste = addTasteVMS.get(0).getTastetest();
        FoodAndTasteController controller = fxmlLoader.getController();
        FoodTasteVM foodTasteVM = new FoodTasteVM(taste);
        controller.setViewModel(foodTasteVM);
        Scene scene = new Scene(root);
        stage.setScene(scene);

        stage.show();
    }

    @FXML
    void addGLMSStage(ActionEvent event) {
        listObject.setMaxHeight(311);
        propertiesPane.setVisible(true);
        start.setExpanded(true);
        glmsStage_VM glmsStage_VM;
        if (!rating.isEmpty()){
            glmsStage_VM = new glmsStage_VM(rating.get(0));
            System.out.println("con");
        }
        else {
            glmsStage_VM = new glmsStage_VM(experiment);
            System.out.println("ex");
        }

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
        else if (Randomnies != null && listObject.getSelectionModel().getSelectedItem() == Randomnies){
            Randomnies.getChildren().add(new TreeItem<>(key));
            Randomnies.setExpanded(true);}
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
        inputStage_VM inputStage_vm = new inputStage_VM(experiment);
        Input inputStage = inputStage_vm.getInput();
        String key = "[User Input] " +  inputStage.getTitle();
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
        String key = "[Instruction] " + noticeStage_vm.getNotice().getTitle();
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
        Course course = addCourseVMS.get(0).getCourse();
        TreeItem<String> selectedItem = listObject.getSelectionModel().getSelectedItem();
        //PeriodicVM periodicVM = new PeriodicVM();
        PeriodicVM periodicVM = new PeriodicVM(course);
        String key = periodicVM.getTitle();
        Wrapper wrapper = new Wrapper(key, periodicVM);
        displayedItems.put(index, wrapper);
        index++;
        TreeItem<String> periodicStage = new TreeItem<>(key);
        selectedItem.getChildren().add(periodicStage);

            // Optionally expand the course item to show the newly added child
        selectedItem.setExpanded(true);
        }

    @FXML
    void addQuestionStage(ActionEvent event) {
        listObject.setMaxHeight(311);
        propertiesPane.setVisible(true);
        start.setExpanded(true);
        questionStage_VM questionStage_vm = new questionStage_VM(experiment);
        Question question = questionStage_vm.getQuestionStage();
        String key = "[Question] " + question.getQuestion();
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
    void addRatingContainer(ActionEvent event) throws IOException {
        listObject.setMaxHeight(311);
        propertiesPane.setVisible(true);
        start.setExpanded(true);
        ratingContainer_VM ratingContainer_vm = new ratingContainer_VM(experiment);
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
        AddTasteVM addTasteVM = new AddTasteVM(experiment);
        TasteTest tasteTest = addTasteVM.getTastetest();
        String key = "[Taste Test]";
        Wrapper wrapper = new Wrapper(key, addTasteVM);
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
    void addTimer(ActionEvent event) {
        listObject.setMaxHeight(311);
        propertiesPane.setVisible(true);
        start.setExpanded(true);
        timerStage_VM timerStageVm = new timerStage_VM(experiment);
        String key = "[Waiting] " + timerStageVm.getTimer().getInstruction();
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
        vasStage_VM vasStageVm ;
        if (!rating.isEmpty()){
            vasStageVm =  new vasStage_VM(rating.get(0));
        }
        else {
            vasStageVm = new vasStage_VM(experiment);
        }
        String key = "[VAS] " + vasStageVm.getVas().getTitle();
        Wrapper wrapper = new Wrapper(key, vasStageVm);
        displayedItems.put(index, wrapper);
        index++;
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
        else if (Randomnies != null && listObject.getSelectionModel().getSelectedItem() == Randomnies){
            Randomnies.getChildren().add(new TreeItem<>(key));
            Randomnies.setExpanded(true);

        }
        // Add to start if no conditions match
        else {
            start.getChildren().add(new TreeItem<>(key));
        }

    }

    @FXML
    void assignSound(ActionEvent event) throws IOException, UnsupportedAudioFileException, LineUnavailableException, URISyntaxException {
        listObject.setMaxHeight(311);
        audibleInstruction = AudibleInstructionSingleton.getInstance();
        FXMLLoader fxmlLoader = new FXMLLoader(SensoryExperimentPlatform.class.getResource("AssignSound.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = new Stage();
        assignSoundController controller = fxmlLoader.getController();
        assignSoundVM viewModel = new assignSoundVM(audibleInstruction);
        controller.setViewModel(viewModel);
        stage.setTitle("Add Sound");

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void setExperiment(Experiment c) throws IOException {
        this.experiment = c;
        this.originalExperiment = experiment;
        loadItems();
    }

    @FXML
    void save(ActionEvent event) throws Exception {
        DataAccess.updateFile();
        this.experiment.version++;
    }

    @FXML
    void cancel(){
        Stage stage = (Stage) btnCancel.getScene().getWindow();
        stage.close();
        this.experiment = originalExperiment;
    }

}