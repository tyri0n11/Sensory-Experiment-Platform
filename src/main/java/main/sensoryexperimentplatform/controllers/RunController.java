package main.sensoryexperimentplatform.controllers;

import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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

import java.io.IOException;

public class RunController {

    @FXML
    private Button btn_Next;

    @FXML
    private Button btn_back;

    @FXML
    private ProgressBar progress_bar;
    @FXML
    private Label labelView;

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

    private void bindViewModel() {
        // Bind ListView items to ViewModel items
        showList.itemsProperty().bind(viewModel.itemsProperty());

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
        System.out.println(showList.getSelectionModel().selectedItemProperty().getValue());;
        displayView(showList.getSelectionModel().getSelectedIndex());
    }

    private void displayView(Object o){
        if(o instanceof Notice){
            labelView.setText(((Notice) o).getContent());
        }
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
        // Implementation to show detail view
        System.out.println("Selected item: " + item);

    }



}
