package main.sensoryexperimentplatform.controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.StackPane;

import java.io.IOException;
import java.util.Objects;

public class ScenseSwitch {
    public ScenseSwitch(StackPane currentStackPane, String fxml) throws IOException {
        StackPane nextStackPane = FXMLLoader.load(Objects.requireNonNull(Main.class.getResource(fxml)));
        currentStackPane.getChildren().removeAll();
        currentStackPane.getChildren().setAll(nextStackPane);
    }
}
