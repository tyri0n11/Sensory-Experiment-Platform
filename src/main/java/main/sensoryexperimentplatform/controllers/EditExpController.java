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
import main.sensoryexperimentplatform.models.Timer;
import main.sensoryexperimentplatform.viewmodel.noticeStage_VM;
import main.sensoryexperimentplatform.models.Experiment;
import main.sensoryexperimentplatform.viewmodel.*;
import main.sensoryexperimentplatform.models.*;


import java.io.IOException;
import java.util.*;

public class EditExpController {
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
    private Map<Integer, Wrapper> displayedItems;
    private int index;
    private boolean mouseClick;
    private Stack<ratingContainer_VM> rating;
    @FXML
    private TreeView<Stages> treeView;


    @FXML
    private Button btn_noticeStage;

    @FXML
    private VBox sideMenu;

    @FXML
    private AnchorPane mainPane;
    private TreeItem<Stages> startStage;
    private AudibleInstruction audibleInstruction;

    @FXML
    private Button btn_cross;

    @FXML
    private Button btn_down;
    @FXML
    private Button btn_up;


    private Stack<AddTasteVM> addTasteVMS;
    private Stack<AddCourseVM> addCourseVMS;
    private AudibleSound_VM selectAudibleSound_vm;
    private Experiment originalExperiment;


    public void initialize() {
        rating = new Stack<>();
        addTasteVMS = new Stack<>();
        addCourseVMS = new Stack<>();

        index = 0;

        //The hashMap to map the object to the tree item
        displayedItems = new LinkedHashMap<>();

        treeView.setRoot(startStage); //set the root of tree, which is the start exp


        initialDisablingButtons();

        treeView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null && newValue != oldValue) {
                // int index = getDisplayedIndex(newValue);
                System.out.println(newValue);
                try {
                    addTasteVMS.clear();
                    addCourseVMS.clear();
                    btn_addFoodAndTaste.setDisable(true);
                    showPropertiesPane(newValue);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });

        //THIS CODE IS TO MAKE THE TREE ITEM WHICH APPEAR DIFFER IN COLORS (ODD VS EVEN)
        treeView.setCellFactory(new Callback<TreeView<Stages>, TreeCell<Stages>>() {

            @Override
            public TreeCell<Stages> call(TreeView<Stages> param) {
                return new TreeCell<Stages>() {
                    @Override
                    protected void updateItem(Stages item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty || item == null) {
                            setText(null);
                            setStyle("");
                        } else {
                            setText(item.toString());
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


    private int getDisplayedIndex(TreeItem<Stages> item) { //GET THE INDEX IN THE DISPLAYED TREE
        if (item.getParent() == null) {
            return 0; // Root item
        }
        return treeView.getSelectionModel().getSelectedIndex();
    }


    private void initialDisablingButtons() {
        btn_assignSound.setDisable(true);
        btn_AddPeriodicStage.setDisable(true);
        btn_addFoodAndTaste.setDisable(true);
    }


    //THREE RIGHT-SIDE BUTTONS
    @FXML
    void delete(ActionEvent event) {
        TreeItem<Stages> selectedItem = treeView.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            TreeItem<Stages> parent = selectedItem.getParent();
            if (parent != null) {
                parent.getChildren().remove(selectedItem);
            } else {
                // If it's a root item, remove it from the TreeView directly
                treeView.getRoot().getChildren().remove(selectedItem);
            }
        }
    }
    @FXML
    void down(ActionEvent event) {
        TreeItem<Stages> selectedItem = treeView.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            TreeItem<Stages> parent = selectedItem.getParent();
            if (parent != null) {
                int currentIndex = parent.getChildren().indexOf(selectedItem);
                System.out.println(currentIndex);
                if (currentIndex < parent.getChildren().size() - 1 && currentIndex >= 0) {
                    TreeItem<Stages> nextItem = parent.getChildren().get(currentIndex + 1);
                    parent.getChildren().set(currentIndex + 1, parent.getChildren().get(currentIndex));
                    parent.getChildren().set(currentIndex, nextItem);

                    Object next = experiment.getStages().get(currentIndex + 1);
                    System.out.println(next);
                    experiment.getStages().set(currentIndex + 1, experiment.getStages().get(currentIndex));
                    experiment.getStages().set(currentIndex, next);
                }
                 treeView.getSelectionModel().select(currentIndex + 1);
            }
        }
    }

    @FXML
    void up(ActionEvent event) {
        TreeItem<Stages> selectedItem = treeView.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            TreeItem<Stages> parent = selectedItem.getParent();
            if (parent != null) {
                int currentIndex = parent.getChildren().indexOf(selectedItem);
                if (currentIndex < parent.getChildren().size() && currentIndex > 0) {
                    TreeItem<Stages> lastItem = parent.getChildren().get(currentIndex - 1);
                    parent.getChildren().set(currentIndex - 1, parent.getChildren().get(currentIndex));
                    parent.getChildren().set(currentIndex, lastItem);
                    Object last = experiment.getStages().get(currentIndex - 1);
                    System.out.println(last);
                    experiment.getStages().set(currentIndex - 1, experiment.getStages().get(currentIndex));
                    experiment.getStages().set(currentIndex, last);
                }
                treeView.getSelectionModel().select(currentIndex);
            }
        }
    }

//


    private void showPropertiesPane(TreeItem<Stages> selectedItem) throws IOException
    {//USED TO LOAD THE PROPERTIES PANE CORRESPONDING TO THE SELECTED ITEM

        Stages stages = selectedItem.getValue();
        if (stages == null) return;

        propertiesPane.getChildren().clear();
        propertiesPane.setVisible(true);
        treeView.setMaxHeight(311);

        stages.loadInterface(propertiesPane, addTasteVMS, addCourseVMS);
        stages.handleMenuButtons(propertiesPane, addTasteVMS, addCourseVMS, btn_AddPeriodicStage, btn_AddCourse, btn_assignSound,
                btn_addFoodAndTaste, btn_addAudibleInstruction
                , btn_addInput, btn_noticeStage,
                btn_addTimer, btn_AddQuestionStage,
                btn_addRatingContainer, btn_addTasteTest, btn_AddConditionalStatement, rating
        );



        selectedItem.setValue(stages);

    }

    private void loadItems() {
        ArrayList<Object> stages = experiment.getStages();

        if (experiment.getStages().isEmpty()) {
            Stages startVM = new StartVM(experiment);
            TreeItem<Stages> startItem = new TreeItem<>(startVM);
            treeView.setRoot(startItem);
         
        } else {
            Start newStart = experiment.getStart();

            StartVM startVM = new StartVM(newStart);
            startStage = new TreeItem<>(startVM);
            treeView.setRoot(startStage);


            for (Object o : stages) {

                if (o instanceof Vas) {
                    vasStage_VM vasStageVm = new vasStage_VM((Vas) o);
                    startStage.getChildren().add(new TreeItem<>(vasStageVm));

                } else if (o instanceof Notice) {

                    noticeStage_VM noticeStage_vm = new noticeStage_VM((Notice) o);
                    startStage.getChildren().add(new TreeItem<>(noticeStage_vm));

                } else if (o instanceof gLMS) {
                    GLMSStage_VM glmsStageVm = new GLMSStage_VM((gLMS) o);
                    startStage.getChildren().add(new TreeItem<>(glmsStageVm));

                } else if (o instanceof RatingContainer) {
                    ratingContainer_VM ratingContainerVm = new ratingContainer_VM((RatingContainer) o);
                    TreeItem<Stages> itemRating = new TreeItem<>(ratingContainerVm);
                    startStage.getChildren().add(itemRating);

                    for (Object subO : ((RatingContainer) o).container) {
                        if (subO instanceof Vas) {
                            vasStage_VM vasStageVm = new vasStage_VM((Vas) subO);
                            itemRating.getChildren().add(new TreeItem<>(vasStageVm));

                        } else if (subO instanceof gLMS) {
                            GLMSStage_VM glmsStageVm = new GLMSStage_VM((gLMS) subO);
                            itemRating.getChildren().add(new TreeItem<>(glmsStageVm));
                        }
                    }
                } else if (o instanceof Input) {
                    InputStage_VM inputStage_vm = new InputStage_VM(experiment,(Input) o);
                    startStage.getChildren().add(new TreeItem<>(inputStage_vm));
                } else if (o instanceof TasteTest) {
                    AddTasteVM inputStage_vm = new AddTasteVM((TasteTest) o);
                    startStage.getChildren().add(new TreeItem<>(inputStage_vm));
                } else if (o instanceof Course) {

                    AddCourseVM addCourseVM = new AddCourseVM((Course) o);
                    startStage.getChildren().add(new TreeItem<>(addCourseVM));
                } else if (o instanceof AudibleInstruction) {
//                         selectAudibleSound_vm= new SelectAud((Timer) o);
//                        startStage.getChildren().add(new TreeItem<>(selectAudibleSound_vm));

                } else if (o instanceof Timer) {
                    timerStage_VM timerStageVm = new timerStage_VM((Timer) o);
                    startStage.getChildren().add(new TreeItem<>(timerStageVm));
                }


//            } else if (o instanceof AudibleInstruction) {
//                String key = "[" + o.getClass().getSimpleName() + "] " + ((AudibleInstruction) o).getTitle();
//                start.getChildren().add(new TreeItem<>(key));
//                selectAudibleSound_vm= new timerStage_VM((Timer) o);
//                Wrapper wrapper = new Wrapper(key, addCourseVM);
//                displayedItems.put(index, wrapper);
//                index++;
//            }
//                else if (o instanceof Periodic){
//                    String key = "[" + o.getClass().getSimpleName() + "] " + ((Periodic) o).getTitle();
//                    start.getChildren().add(new TreeItem<>(key));
//
//                    // Wrapper wrapper = new Wrapper(key, addCourseVM);
//                    //displayedItems.put(index, wrapper);
//                    index++;
//                }
//                else if (o instanceof Periodic){
//                    String key = "[" + o.getClass().getSimpleName() + "] " + ((Periodic) o).getTitle();
//                    start.getChildren().add(new TreeItem<>(key));
//
//                    // Wrapper wrapper = new Wrapper(key, addCourseVM);
//                    //displayedItems.put(index, wrapper);
//                    index++;
//                }

        }
            }
        startStage.setExpanded(true);
            }



//                else if (o instanceof conditionalStatement) {
//                    String key = "If" +  ((conditionalStatement) o).getVariable1Choice();
//                    startStage.getChildren().add( new TreeItem<>(key));
//                    conditionalStatementVM ConditionalStatementVM = new conditionalStatementVM((conditionalStatement) o);
//                    Wrapper wrapper = new Wrapper(key, ConditionalStatementVM);
//                    displayedItems.put(index, wrapper);
//                    index++;
//                }
//            }
//            treeView.setMaxHeight(311);
//            propertiesPane.setVisible(true);
//            startStage.setExpanded(true);
            //}

//
//    @FXML
//    void addAudibleInstruction(ActionEvent event) throws UnsupportedAudioFileException, LineUnavailableException, IOException, URISyntaxException {
////        treeView.setMaxHeight(311);
////        propertiesPane.setVisible(true);
////        startStage.setExpanded(true);
////        AudibleSound_VM audibleSound_vm = new AudibleSound_VM(experiment);
////        selectAudibleSound_vm = audibleSound_vm;
////        String key = "[Audio] " +audibleSound_vm.getAudibleInstruction().getTitle();
////        Wrapper wrapper = new Wrapper(key,audibleSound_vm);
////        displayedItems.put(index, wrapper);
////        index++;
////        //experiment.showStages();
////
////        // Add to Randomnies if selected item matches ifConditional
////        if (ifConditional != null && treeView.getSelectionModel().getSelectedItem() == ifConditional) {
////            ifConditional.getChildren().add(new TreeItem<>(key));
////            ifConditional.setExpanded(true);
////        }
////        // Add to Randomnies if selected item matches elseConditional
////        else if (elseConditional != null && treeView.getSelectionModel().getSelectedItem() == elseConditional) {
////            elseConditional.getChildren().add(new TreeItem<>(key));
////            elseConditional.setExpanded(true);
////        }
////        // Add to start if no conditions match
////        else {
////            startStage.getChildren().add(new TreeItem<>(key));
////        }
//    }
////
////
//    @FXML
//    void addConditionalStatement(ActionEvent event) {
//
////        treeView.setMaxHeight(311);
////        propertiesPane.setVisible(true);
////        startStage.setExpanded(true);
////        conditionalStatementVM ConditionalStatementVM = new conditionalStatementVM(experiment);
////        String key = ConditionalStatementVM.getTitle() ;
////        Wrapper wrapper = new Wrapper(key, ConditionalStatementVM);
////        displayedItems.put(index, wrapper);
////        index++;
////        ifConditional = new TreeItem<>(key);
////        elseConditional = new TreeItem<>("Else");
////        startStage.getChildren().add(ifConditional);
////        startStage.getChildren().add(elseConditional);
////
//       }
////
//   @FXML
//    void addCourse(ActionEvent event) {
////        treeView.setMaxHeight(311);
////        propertiesPane.setVisible(true);
////        startStage.setExpanded(true);
////
////        AddCourseVM addCourseVM = new AddCourseVM(experiment);
////        Course course = addCourseVM.getCourse();
////        String key = course.getTitle();
////
////        Wrapper wrapper = new Wrapper(key, addCourseVM);
////        displayedItems.put(index, wrapper);
////        index++;
////
////
////        if (ifConditional != null && treeView.getSelectionModel().getSelectedItem() == ifConditional) {
////            ifConditional.getChildren().add(new TreeItem<>(key));
////            ifConditional.setExpanded(true);
////        }
////        // Add to Randomnies if selected item matches elseConditional
////        else if (elseConditional != null && treeView.getSelectionModel().getSelectedItem() == elseConditional) {
////            elseConditional.getChildren().add(new TreeItem<>(key));
////            elseConditional.setExpanded(true);
////        }
////        // Add to start if no conditions match
////        else {
////            startStage.getChildren().add(new TreeItem<>(key));
////        }
////
//     }
////
//    @FXML
//    void addFoodAndTaste(ActionEvent event) throws IOException {
////        FXMLLoader fxmlLoader = new FXMLLoader(SensoryExperimentPlatform.class.getResource("FoodAndTaste.fxml"));
////        Parent root = fxmlLoader.load();
////        Stage stage = new Stage();
////        stage.setTitle("Add Food and Taste");
////        TasteTest taste = addTasteVMS.get(0).getTastetest();
////        FoodAndTasteController controller = fxmlLoader.getController();
////        FoodTasteVM foodTasteVM = new FoodTasteVM(taste);
////        controller.setViewModel(foodTasteVM);
////        Scene scene = new Scene(root);
////        stage.setScene(scene);
////
////        stage.show();
//    }
////
//    @FXML
//    void addGLMSStage(ActionEvent event) {
////        treeView.setMaxHeight(311);
////        propertiesPane.setVisible(true);
////        startStage.setExpanded(true);
////        glmsStage_VM glmsStage_VM;
////        if (!rating.isEmpty()){
////            glmsStage_VM = new glmsStage_VM(rating.get(0));
////            System.out.println("con");
////        }
////        else {
////            glmsStage_VM = new glmsStage_VM(experiment);
////            System.out.println("ex");
////        }
////
////        String key = "[GLMS]" + glmsStage_VM.getGLMS().getTitle();
////        Wrapper wrapper = new Wrapper(key, glmsStage_VM);
////        displayedItems.put(index, wrapper);
////        index++;
////
////
////        // Add to Randomnies if selected item matches ifConditional
////        if (ifConditional != null && treeView.getSelectionModel().getSelectedItem() == ifConditional) {
////            ifConditional.getChildren().add(new TreeItem<>(key));
////            ifConditional.setExpanded(true);
////        }
////        // Add to Randomnies if selected item matches elseConditional
////        else if (elseConditional != null && treeView.getSelectionModel().getSelectedItem() == elseConditional) {
////            elseConditional.getChildren().add(new TreeItem<>(key));
////            elseConditional.setExpanded(true);
////        }
////        else if (Randomnies != null && treeView.getSelectionModel().getSelectedItem() == Randomnies){
////            Randomnies.getChildren().add(new TreeItem<>(key));
////            Randomnies.setExpanded(true);}
////        // Add to start if no conditions match
////        else {
////            startStage.getChildren().add(new TreeItem<>(key));
////        }
////        treeView.setMaxHeight(311);
////        propertiesPane.setVisible(true);
////        startStage.setExpanded(true);
////
////
////
//    }
////
//    @FXML
//    void addInput(ActionEvent event) {
////        treeView.setMaxHeight(311);
////        propertiesPane.setVisible(true);
////        startStage.setExpanded(true);
////        inputStage_VM inputStage_vm = new inputStage_VM(experiment);
////        Input inputStage = inputStage_vm.getInput();
////        String key = "[User Input] " +  inputStage.getTitle();
////        Wrapper wrapper = new Wrapper(key, inputStage_vm);
////        displayedItems.put(index, wrapper);
////        index++;
////
////        if (ifConditional != null && treeView.getSelectionModel().getSelectedItem() == ifConditional) {
////            ifConditional.getChildren().add(new TreeItem<>(key) );
////            ifConditional.setExpanded(true);
////        }
////        // Add to Randomnies if selected item matches elseConditional
////        else if (elseConditional != null && treeView.getSelectionModel().getSelectedItem() == elseConditional) {
////            elseConditional.getChildren().add(new TreeItem<>(key) );
////            elseConditional.setExpanded(true);
////        }
////        // Add to start if no conditions match
////        else {
////            startStage.getChildren().add(new TreeItem<>(key));
////        }
////
////
////
//    }
////
//    @FXML
//    void addNoticeStage(ActionEvent event){
////        treeView.setMaxHeight(311);
////        propertiesPane.setVisible(true);
////        startStage.setExpanded(true);
////        noticeStage_VM noticeStage_vm = new noticeStage_VM(experiment);
////        String key = "[Instruction] " + noticeStage_vm.getNotice().getTitle();
////        System.out.println(index);
////        Wrapper wrapper = new Wrapper(key, noticeStage_vm);
////        displayedItems.put(index, wrapper);
////        index++;
////        //experiment.showStages();
////        if (ifConditional != null && treeView.getSelectionModel().getSelectedItem() == ifConditional) {
////            ifConditional.getChildren().add(new TreeItem<>(key));
////            ifConditional.setExpanded(true);
////        }
////        // Add to Randomnies if selected item matches elseConditional
////        else if (elseConditional != null && treeView.getSelectionModel().getSelectedItem() == elseConditional) {
////            elseConditional.getChildren().add(new TreeItem<>(key));
////            elseConditional.setExpanded(true);
////        }
////        // Add to start if no conditions match
////        else {
////            startStage.getChildren().add(new TreeItem<>(key));
////        }
////
////
//    }
////
//    @FXML
//    void addPeriodicStage(ActionEvent event) {
////        treeView.setMaxHeight(311);
////        propertiesPane.setVisible(true);
////        startStage.setExpanded(true);
////        Course course = addCourseVMS.get(0).getCourse();
////        TreeItem<String> selectedItem = treeView.getSelectionModel().getSelectedItem();
////        //PeriodicVM periodicVM = new PeriodicVM();
////        PeriodicVM periodicVM = new PeriodicVM(course);
////        String key = periodicVM.getTitle();
////        Wrapper wrapper = new Wrapper(key, periodicVM);
////        displayedItems.put(index, wrapper);
////        index++;
////        TreeItem<String> periodicStage = new TreeItem<>(key);
////        selectedItem.getChildren().add(periodicStage);
////
////            // Optionally expand the course item to show the newly added child
////        selectedItem.setExpanded(true);
//      }
////
//    @FXML
//    void addQuestionStage(ActionEvent event) {
////        treeView.setMaxHeight(311);
////        propertiesPane.setVisible(true);
////        startStage.setExpanded(true);
////        questionStage_VM questionStage_vm = new questionStage_VM(experiment);
////        Question question = questionStage_vm.getQuestionStage();
////        String key = "[Question] " + question.getQuestion();
////        Wrapper wrapper = new Wrapper(key, questionStage_vm);
////        displayedItems.put(index, wrapper);
////        index++;
////        TreeItem<String> QuestionStage = new TreeItem<>(key);
////        if (ifConditional != null && treeView.getSelectionModel().getSelectedItem() == ifConditional) {
////            ifConditional.getChildren().add(QuestionStage);
////            ifConditional.setExpanded(true);
////        }
////        // Add to Randomnies if selected item matches elseConditional
////        else if (elseConditional != null && treeView.getSelectionModel().getSelectedItem() == elseConditional) {
////            elseConditional.getChildren().add(QuestionStage);
////            elseConditional.setExpanded(true);
////        }
////        // Add to start if no conditions match
////        else {
////            startStage.getChildren().add(QuestionStage);
////        }
//   }
////
//    @FXML
//    void addRatingContainer(ActionEvent event) throws IOException {
////        treeView.setMaxHeight(311);
////        propertiesPane.setVisible(true);
////        startStage.setExpanded(true);
////        ratingContainer_VM ratingContainer_vm = new ratingContainer_VM(experiment);
////        RatingContainer ratingContainer = ratingContainer_vm.getRatingContainer();
////        String key = "Ratings container";
////        Wrapper wrapper = new Wrapper(key,ratingContainer_vm);
////        displayedItems.put(index, wrapper);
////        index++;
////        Randomnies = new TreeItem<>(key);
////
////        if (ifConditional != null && treeView.getSelectionModel().getSelectedItem() == ifConditional) {
////            ifConditional.getChildren().add( Randomnies);
////            ifConditional.setExpanded(true);
////        }
////        // Add to Randomnies if selected item matches elseConditional
////        else if (elseConditional != null && treeView.getSelectionModel().getSelectedItem() == elseConditional) {
////            elseConditional.getChildren().add( Randomnies);
////            elseConditional.setExpanded(true);
////        }
////        // Add to start if no conditions match
////        else {
////            startStage.getChildren().add( Randomnies);
////        }
////
//  }
////
//    @FXML
//    void addTasteTest(ActionEvent event) {
////        treeView.setMaxHeight(311);
////        propertiesPane.setVisible(true);
////        startStage.setExpanded(true);
////        AddTasteVM addTasteVM = new AddTasteVM(experiment);
////        TasteTest tasteTest = addTasteVM.getTastetest();
////        String key = "[Taste Test]";
////        Wrapper wrapper = new Wrapper(key, addTasteVM);
////        displayedItems.put(index, wrapper);
////        index++;
////        if (ifConditional != null && treeView.getSelectionModel().getSelectedItem() == ifConditional) {
////            ifConditional.getChildren().add(new TreeItem<>(key));
////            ifConditional.setExpanded(true);
////        }
////        // Add to Randomnies if selected item matches elseConditional
////        else if (elseConditional != null && treeView.getSelectionModel().getSelectedItem() == elseConditional) {
////            elseConditional.getChildren().add(new TreeItem<>(key));
////            elseConditional.setExpanded(true);
////        }
////        // Add to start if no conditions match
////        else {
////            startStage.getChildren().add(new TreeItem<>(key));
////        }
//    }
////
//   @FXML
//   void addTimer(ActionEvent event) {
////        treeView.setMaxHeight(311);
////        propertiesPane.setVisible(true);
////        startStage.setExpanded(true);
////        timerStage_VM timerStageVm = new timerStage_VM(experiment);
////        String key = "[Waiting] " + timerStageVm.getTimer().getInstruction();
////        Wrapper wrapper = new Wrapper(key, timerStageVm);
////        displayedItems.put(index, wrapper);
////        index++;
////        // experiment.showStages();
////        if (ifConditional != null && treeView.getSelectionModel().getSelectedItem() == ifConditional) {
////            ifConditional.getChildren().add(new TreeItem<>(key));
////            ifConditional.setExpanded(true);
////        }
////        // Add to Randomnies if selected item matches elseConditional
////        else if (elseConditional != null && treeView.getSelectionModel().getSelectedItem() == elseConditional) {
////            elseConditional.getChildren().add(new TreeItem<>(key));
////            elseConditional.setExpanded(true);
////        }
////        // Add to start if no conditions match
////        else {
////            startStage.getChildren().add(new TreeItem<>(key));
////        }
////
//   }
////
////    @FXML
//   void addVasStage(ActionEvent event) {
////        treeView.setMaxHeight(311);
////        propertiesPane.setVisible(true);
////        startStage.setExpanded(true);
////        vasStage_VM vasStageVm ;
////        if (!rating.isEmpty()){
////            vasStageVm =  new vasStage_VM(rating.get(0));
////        }
////        else {
////            vasStageVm = new vasStage_VM(experiment);
////        }
////        String key = "[VAS] " + vasStageVm.getVas().getTitle();
////        Wrapper wrapper = new Wrapper(key, vasStageVm);
////        displayedItems.put(index, wrapper);
////        index++;
////        //  experiment.showStages();
////
////        // Add to Randomnies if selected item matches ifConditional
////        if (ifConditional != null && treeView.getSelectionModel().getSelectedItem() == ifConditional) {
////            ifConditional.getChildren().add(new TreeItem<>(key));
////            ifConditional.setExpanded(true);
////        }
////        // Add to Randomnies if selected item matches elseConditional
////        else if (elseConditional != null && treeView.getSelectionModel().getSelectedItem() == elseConditional) {
////            elseConditional.getChildren().add(new TreeItem<>(key));
////            elseConditional.setExpanded(true);
////        }
////        else if (Randomnies != null && treeView.getSelectionModel().getSelectedItem() == Randomnies){
////            Randomnies.getChildren().add(new TreeItem<>(key));
////            Randomnies.setExpanded(true);
////
////        }
////        // Add to start if no conditions match
////        else {
////            startStage.getChildren().add(new TreeItem<>(key));
////        }
////
////    }
//        }
//
//
//    @FXML
//    void assignSound(ActionEvent event) throws IOException, UnsupportedAudioFileException, LineUnavailableException, URISyntaxException {
//        treeView.setMaxHeight(311);
//        Sound sound = SoundSingleton.getInstance();
//        FXMLLoader fxmlLoader = new FXMLLoader(SensoryExperimentPlatform.class.getResource("AssignSound.fxml"));
//        Parent root = fxmlLoader.load();
//        Stage stage = new Stage();
//        AssignSoundController controller = fxmlLoader.getController();
//        AssignSoundVM viewModel = new AssignSoundVM();
//
//        controller.setViewModel(viewModel,selectAudibleSound_vm);
//        stage.setTitle("Add Sound");
//
//        Scene scene = new Scene(root);
//        stage.setScene(scene);
//        stage.show();
//
//    }

    public void setExperiment(Experiment c) throws IOException {
        this.experiment = c;
        this.originalExperiment = experiment;
        loadItems();
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
    void cancel(ActionEvent event) {

    }




    @FXML
    void saveAs(ActionEvent event) {

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

    @FXML
    void saveAs() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(SensoryExperimentPlatform.class.getResource("NewExperiment.fxml"));
        Parent root = fxmlLoader.load();

        Stage stage = new Stage();

        Scene scene = new Scene(root);
        stage.setScene(scene);

        stage.show();

    }

}