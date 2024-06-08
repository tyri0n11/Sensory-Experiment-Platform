package main.sensoryexperimentplatform.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;
import javafx.util.Callback;
import main.sensoryexperimentplatform.SensoryExperimentPlatform;
import main.sensoryexperimentplatform.ViewModel.FoodTasteVM;
import main.sensoryexperimentplatform.models.TasteTest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FoodAndTasteController {
    @FXML
    private Label SoundSelectTionLabel;

    @FXML
    private Button btn_play;

    @FXML
    private Button btn_refresh;

    @FXML
    private Button btn_remove;

    @FXML
    private Button btn_stop;

    @FXML
    private ListView<String> foodView;
    private FoodTasteVM viewModel;
    private ObservableList<String> foods;
    static class XCell extends ListCell<String> {
        HBox hbox = new HBox();
        Label label = new Label("(empty)");
        Pane pane = new Pane();
        CheckBox button = new CheckBox();
        String lastItem;

        public XCell() {
            super();
            hbox.getChildren().addAll(label, pane, button);
            HBox.setHgrow(pane, Priority.ALWAYS);
            button.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    System.out.println(lastItem + " : " + event);
                }
            });
        }

        @Override
        protected void updateItem(String item, boolean empty) {
            super.updateItem(item, empty);
            setText(null);  // No text in label of super class
            if (empty) {
                lastItem = null;
                setGraphic(null);
            } else {
                lastItem = item;
                label.setText(item!=null ? item : "<null>");
                setGraphic(hbox);
            }
        }
    }

    private void loadItems(){
        foods.clear();
        foods.addAll(viewModel.getListFoodsShow());
        foodView.getItems().addAll(foods);
        foodView.setCellFactory(new Callback<ListView<String>, ListCell<String>>() {
            @Override
            public ListCell<String> call(ListView<String> param) {
                return new XCell();
            }
        });

    }

    public void setViewModel(FoodTasteVM viewModel) {
        foods = FXCollections.observableArrayList();
        this.viewModel = viewModel;
        loadItems();
    }

    @FXML
    void Add(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(SensoryExperimentPlatform.class.getResource("AddFood.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("Add Food");
        addFoodController controller = fxmlLoader.getController();
        controller.setViewModel(viewModel);
        Scene scene = new Scene(root);
        stage.setScene(scene);

        stage.show();

    }

    @FXML
    void Close(ActionEvent event) {

    }

    @FXML
    void SelectAll(ActionEvent event) {

    }

    @FXML
    void SelectNone(ActionEvent event) {

    }


}
