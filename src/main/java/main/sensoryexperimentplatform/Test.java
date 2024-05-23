package main.sensoryexperimentplatform;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Test extends Application {
    private boolean isSidebarVisible = true;

    @Override
    public void start(Stage primaryStage) {
        // Create the main layout
        BorderPane borderPane = new BorderPane();

        // Create the sidebar
        VBox sidebar = new VBox();
        sidebar.setStyle("-fx-background-color: #2E2E2E; -fx-padding: 10px;");
        Button menuItem1 = new Button("Menu Item 1");
        Button menuItem2 = new Button("Menu Item 2");
        sidebar.getChildren().addAll(menuItem1, menuItem2);

        // Create the main content area
        VBox mainContent = new VBox();
        mainContent.setStyle("-fx-background-color: #FFFFFF; -fx-padding: 10px;");

        // Add buttons to the main content
        Button dashboardButton = new Button("Toggle Sidebar");
        Button anotherButton = new Button("Another Button");
        Button contentButton1 = new Button("Content Button 1");
        Button contentButton2 = new Button("Content Button 2");

        // Create a top row for main content with buttons
        HBox topRow = new HBox(10, dashboardButton, anotherButton);
        topRow.setAlignment(Pos.CENTER_LEFT);

        // Add all components to main content
        mainContent.getChildren().addAll(topRow, contentButton1, contentButton2);
        VBox.setVgrow(contentButton1, Priority.ALWAYS);
        VBox.setVgrow(contentButton2, Priority.ALWAYS);

        // Create a StackPane to manage the sidebar and main content
        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(sidebar, mainContent);
        StackPane.setAlignment(sidebar, Pos.CENTER_LEFT);
        StackPane.setAlignment(mainContent, Pos.CENTER);
        StackPane.setMargin(mainContent, new javafx.geometry.Insets(0, 0, 0, 200)); // Adjust margin for sidebar width

        // Handle sidebar visibility
        dashboardButton.setOnAction(event -> {
            if (isSidebarVisible) {
                stackPane.getChildren().remove(sidebar);
            } else {
                stackPane.getChildren().add(sidebar);
            }
            isSidebarVisible = !isSidebarVisible;
        });

        // Add the stackPane to the center of the BorderPane
        borderPane.setCenter(stackPane);

        // Create and set the scene
        Scene scene = new Scene(borderPane, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Responsive JavaFX Dashboard");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
