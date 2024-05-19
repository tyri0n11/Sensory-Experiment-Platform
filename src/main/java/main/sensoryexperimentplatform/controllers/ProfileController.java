package main.sensoryexperimentplatform.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class ProfileController implements Initializable {
    @FXML
    private Circle circle;
    @Override
    public void initialize(URL url, ResourceBundle rb){
        Image img = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/css/images/Thay_Thanh.png")));
        circle.setFill(new ImagePattern(img));
    }
}
