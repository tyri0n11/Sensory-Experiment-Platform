package main.sensoryexperimentplatform.models;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import main.sensoryexperimentplatform.SensoryExperimentPlatform;

import java.io.IOException;

public class Periodic{
    private long amount;
    private long forAmount;
    private String daiLuong;
    private String time;
    private String forDaiLuong;
    public Periodic( long grams, String daiLuong, String time,long forAmount, String forDaiLuong) {
        this.time = time;
        this.amount = grams;
        this.daiLuong = daiLuong;
        this.forAmount = forAmount;
        this.forDaiLuong = forDaiLuong;
    }


//    public Periodic (long seconds){
//        this.seconds = seconds;
//    }


}
