package main.sensoryexperimentplatform.models;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import main.sensoryexperimentplatform.SensoryExperimentPlatform;

import java.io.IOException;

public class Periodic extends Stage{
    private long weight, seconds;
    public Periodic(String title, String content, long grams, long durations ) {
        super(title, content);
        this.weight = grams;
        this.seconds = durations;
    }

    public long getWeight() {
        return weight;
    }

    public void setWeight(long weight) {
        this.weight = weight;
    }

    public long getSeconds() {
        return seconds;
    }

    public void setSeconds(long seconds) {
        this.seconds = seconds;
    }

}
