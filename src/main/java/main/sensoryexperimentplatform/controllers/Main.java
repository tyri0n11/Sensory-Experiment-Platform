package main.sensoryexperimentplatform.controllers;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
<<<<<<< HEAD
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("/main/sensoryexperimentplatform/Demo.fxml"));
=======

        FXMLLoader loader = new FXMLLoader(Main.class.getResource("/main/sensoryexperimentplatform/Base.fxml"));
        //FXMLLoader loader = new FXMLLoader(getClass().getResource("/main/sensoryexperimentplatform/LogIn2.fxml"));

//        ProfileController controller = new ProfileController();
//        loader.setController(controller);*/
>>>>>>> 7a2212825dec188091988102bf0da9285f466266
        Parent root = loader.load();
        Scene scene = new Scene(root);
        primaryStage.setTitle("Sense XP");

        primaryStage.setScene(scene);

        primaryStage.sizeToScene();

        primaryStage.show();

    }
}