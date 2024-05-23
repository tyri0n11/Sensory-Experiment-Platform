package main.sensoryexperimentplatform.controllers;

import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;
import main.sensoryexperimentplatform.ViewModel.RunExperiment_VM;
import main.sensoryexperimentplatform.models.Notice;
import org.controlsfx.control.PropertySheet;
import javafx.scene.layout.AnchorPane;
import javafx.util.Callback;
import main.sensoryexperimentplatform.SensoryExperimentPlatform;
import main.sensoryexperimentplatform.ViewModel.RunExperiment_VM;
import main.sensoryexperimentplatform.ViewModel.RunGLMS_VM;
import main.sensoryexperimentplatform.ViewModel.RunNotice_VM;
import main.sensoryexperimentplatform.ViewModel.RunVas_VM;
import main.sensoryexperimentplatform.models.*;

import java.io.IOException;

public class RunController {
    @FXML
    private AnchorPane content;

    @FXML
    private Button btn_Next;

    @FXML
    private Button btn_back;

    @FXML
    private ProgressBar progress_bar;


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

    private void bindViewModel() {
        // Bind ListView items to ViewModel items
        showList.itemsProperty().bind(viewModel.itemsProperty());
/*        showList.setCellFactory(new Callback<ListView<String>, ListCell<String>>() {
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
        });*/

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
        if (selectedIndex >= 0 && selectedIndex < showList.getItems().size() - 1) {
            showList.getSelectionModel().select(selectedIndex + 1);
        }
    }

    private void showDetailView(String item) {



}
        Object selectedObject = viewModel.getObjectByKey(item);
        if (selectedObject != null) {
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
                if (selectedObject instanceof Notice){
                    loader = new FXMLLoader(SensoryExperimentPlatform.class.getResource("RunNotice.fxml"));
                    AnchorPane newContent = loader.load();
                    content.getChildren().setAll(newContent);

                    RunNoticeController controller = loader.getController();
                    RunNotice_VM vm = new RunNotice_VM((Notice) selectedObject);
                    controller.setViewModel(vm);


                }
                // Add more conditions here for other types of objects


            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}

