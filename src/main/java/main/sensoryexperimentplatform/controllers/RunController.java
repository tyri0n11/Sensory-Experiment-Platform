package main.sensoryexperimentplatform.controllers;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Callback;
import main.sensoryexperimentplatform.SensoryExperimentPlatform;
import main.sensoryexperimentplatform.ViewModel.*;
import main.sensoryexperimentplatform.models.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Random;


public class RunController {
    double pivot = 0.0;
    double processed = 0.0;
    @FXML
    private AnchorPane content;

    @FXML
    private Button btn_Next;

    @FXML
    private Button btn_back;

    @FXML
    private ProgressBar progress_bar;

    @FXML
    private Label runelbl;

    @FXML
    private Label senseXPlbl;

    @FXML
    private ListView<String> showList;

    private RunExperiment_VM viewModel;

    @FXML
    public void initialize() {
        viewModel = new RunExperiment_VM();
        bindViewModel();

        try {
            viewModel.loadItems();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void updateProgress(double processed){
        if(processed > pivot){
            pivot = processed;
            progress_bar.setProgress(pivot/(viewModel.count - 1));
        }
    }

    private void bindViewModel() {
        // Bind ListView items to ViewModel items
        showList.itemsProperty().bind(viewModel.itemsProperty());

        showList.addEventHandler(MouseEvent.MOUSE_PRESSED, event -> {
            event.consume(); // Ngăn sự kiện click lan truyền
        });
        showList.setCellFactory(new Callback<ListView<String>, ListCell<String>>() {
            @Override
            public ListCell<String> call(ListView<String> listView) {
                return new ListCell<>() {
                    @Override
                    protected void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        if (item != null && !empty) {
                            setText(item);
                        } else {
                            setText(null);
                        }
                    }
                };
            }
        });

        // Add selection listener
        showList.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                // Handle item selection (e.g., show detail view)
                showDetailView(newValue);
            }
        });
    }
    @FXML
    void handleBtnBack(MouseEvent event) {
        processed-=2;
        updateProgress(processed);
        int selectedIndex = showList.getSelectionModel().getSelectedIndex();
        if (selectedIndex > 0) {
            showList.getSelectionModel().select(selectedIndex - 1);
        } else {
            showList.getSelectionModel().clearSelection();
        }
    }

    @FXML
    void handleBtnNext(MouseEvent event) {
        int selectedIndex = showList.getSelectionModel().getSelectedIndex();
        if (selectedIndex == -1){
            showList.getSelectionModel().select(0);
        }
        if (selectedIndex >= 0 && selectedIndex < showList.getItems().size() - 1) {
            showList.getSelectionModel().select(selectedIndex + 1);
        }
    }

    private void showDetailView(String item) {
        Object selectedObject = viewModel.getObjectByKey(item);
        if (selectedObject != null) {
            int currentIndex = viewModel.getIndexOfObject(selectedObject);
            if (currentIndex >= 0) {
                if (currentIndex > processed) {
                    processed = currentIndex;
                    updateProgress(currentIndex);
                }
            } else {
                processed++;
                updateProgress(processed);
            }
            content.getChildren().clear();
            try {
                FXMLLoader loader;
                if (selectedObject instanceof Vas) {
                    loader = new FXMLLoader(SensoryExperimentPlatform.class.getResource("RunVas.fxml"));
                    AnchorPane newContent = loader.load();
                    content.getChildren().setAll(newContent);

                    RunVasController controller = loader.getController();
                    RunVas_VM vm = new RunVas_VM((Vas) selectedObject);
                    controller.setViewModel(vm);
                    btn_Next.textProperty().bind(vm.buttonProperty());
                }
                if (selectedObject instanceof gLMS) {
                    loader = new FXMLLoader(SensoryExperimentPlatform.class.getResource("RunGLMS.fxml"));
                    AnchorPane newContent = loader.load();
                    content.getChildren().setAll(newContent);

                    RunGLMSController controller = loader.getController();
                    RunGLMS_VM vm = new RunGLMS_VM((gLMS) selectedObject);
                    controller.setViewModel(vm);
                    btn_Next.textProperty().bind(vm.buttonProperty());

                }
                if (selectedObject instanceof Notice) {
                    loader = new FXMLLoader(SensoryExperimentPlatform.class.getResource("RunNotice.fxml"));
                    AnchorPane newContent = loader.load();
                    content.getChildren().setAll(newContent);

                    RunNoticeController controller = loader.getController();
                    RunNotice_VM vm = new RunNotice_VM((Notice) selectedObject);
                    controller.setViewModel(vm);
                    btn_Next.textProperty().bind(vm.buttonProperty());
                }
                if (selectedObject instanceof Timer) {
                    loader = new FXMLLoader(SensoryExperimentPlatform.class.getResource("RunTimer.fxml"));
                    AnchorPane newContent = loader.load();
                    content.getChildren().setAll(newContent);

                    RunTimerController controller = loader.getController();
                    RunTimer_VM viewModel = new RunTimer_VM((Timer) selectedObject);
                    controller.setViewModel(viewModel);
                }
                if (selectedObject instanceof RatingContainer) {
                    loader = new FXMLLoader(SensoryExperimentPlatform.class.getResource("RunRating.fxml"));
                    AnchorPane newContent = loader.load();
                    content.getChildren().setAll(newContent);
                }
                if (currentIndex == viewModel.count - 1) {
                    btn_Next.setOnAction(event -> handleFinalNext());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void handleFinalNext() {
        try {
            Random random = new Random();
            String save = String.valueOf(random.nextInt(1000));
            FileWriter writer = new FileWriter(save+"_results.csv");
            writer.append("Heading,Vas/GLMS Result,Question,Low Anchor, High Anchor, Low Value, High Value\n");

            for (Object o : viewModel.getStages()) {
                if(o instanceof RatingContainer){
                    for(Object subO : ((RatingContainer) o).getContainer()){
                        saveResult(writer,subO);
                    }
                }
                saveResult(writer,o);
            }

            writer.flush();
            writer.close();

            System.out.println("Result was stored at " + save + "_results.csv");
            Platform.exit();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void saveResult(Writer writer, Object subO) throws IOException {
        if( subO instanceof Vas){
            writer.append("Vas,")
                    .append(String.valueOf(((Vas) subO).getResult()).trim())
                    .append(",")
                    .append(((Vas) subO).getTitle())
                    .append(",")
                    .append(((Vas) subO).getLowAnchorText())
                    .append(",")
                    .append(((Vas) subO).getHighAnchorText())
                    .append(",")
                    .append(String.valueOf(((Vas) subO).getLowAnchorValue()))
                    .append(",")
                    .append(String.valueOf(((Vas) subO).getHighAnchorValue()));
            writer.append("\n");
        }
        if( subO instanceof gLMS){
            writer.append("GLMS ,")
                    .append(String.valueOf(((gLMS) subO).getResult()))
                    .append(",")
                    .append(((gLMS) subO).getTitle());
            writer.append("\n");
        }
    }

}