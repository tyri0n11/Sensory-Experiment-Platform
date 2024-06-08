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

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FoodAndTasteController {
    private List <XCell> xcell;
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
    @FXML
    private ListView<String> glmsTable;

    @FXML
    private ListView<String> vasTable;
    private FoodTasteVM viewModel;
    private ObservableList<String> foods;

    static class XCell extends ListCell<String> {

        HBox hbox = new HBox();
        Label label = new Label("(empty)");
        Pane pane = new Pane();
        CheckBox button = new CheckBox();
        String lastItem;
        private String name;
        private Boolean isSelect;

        public String getName() {
            return name;
        }

        public void setSelect(Boolean select) {
            isSelect = select;
        }

        public Boolean getSelect() {
            return isSelect;
        }

        public XCell(boolean boo) {
            super();
            this.isSelect = boo;
            hbox.getChildren().addAll(label, pane, button);
            HBox.setHgrow(pane, Priority.ALWAYS);
            button.setOnAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent event) {
                    isSelect = button.isSelected();
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
                name = item;
                label.setText(item!=null ? item : "<null>");
                setGraphic(hbox);
            }
        }
    }

    public void loadItems(){
        foods.clear();
        foodView.getItems().clear();
        foods.addAll(viewModel.getListFoodsShow());
        foodView.getItems().addAll(foods);
        foodView.setCellFactory(new Callback<ListView<String>, ListCell<String>>() {
            @Override
            public ListCell<String> call(ListView<String> param) {
                XCell xCell = new XCell(false);
                xcell.add(xCell);
                System.out.println(xCell.getName());
                return xCell;
            }
        });

    }

    public void setViewModel(FoodTasteVM viewModel) {
        xcell = new ArrayList<>();
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
        controller.setViewModel(viewModel, this);
        Scene scene = new Scene(root);
        stage.setScene(scene);

        stage.show();

    }

    @FXML
    void Close(ActionEvent event) {
        for (XCell a:xcell){
            if (a.getSelect()){
                viewModel.addListFoods(a.getName());
            }
        }
        Stage currentStage = (Stage) btn_play.getScene().getWindow();
        currentStage.close();
    }

    @FXML
    void SelectAll(ActionEvent event) {
        for (XCell cell : xcell) {
            cell.button.setSelected(true);
            cell.setSelect(true);
        }
    }

    @FXML
    void SelectNone(ActionEvent event) {
        for (XCell cell : xcell) {
            cell.button.setSelected(false);
            cell.setSelect(false);
        }
    }


}
