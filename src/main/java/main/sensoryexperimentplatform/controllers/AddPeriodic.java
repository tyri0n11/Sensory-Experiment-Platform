package main.sensoryexperimentplatform.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import main.sensoryexperimentplatform.viewmodel.PeriodicVM;

public class AddPeriodic {
    private PeriodicVM model;
    @FXML
    private TextField amoutEveryAfter;

    @FXML
    private ComboBox<String> daiLuongAmount;

    @FXML
    private ComboBox<String> daiLuongEveryAfter;

    @FXML
    private ComboBox<String> everyFor;

    @FXML
    private TextField forAmount;

    @FXML
    private Label forLabel;

    public void setViewModel(PeriodicVM periodicVM) {
        this.model=periodicVM;
    }
}
