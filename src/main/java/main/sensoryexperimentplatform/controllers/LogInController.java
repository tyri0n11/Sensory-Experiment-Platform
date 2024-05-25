package main.sensoryexperimentplatform.controllers;

import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import main.sensoryexperimentplatform.ViewModel.Login_VM;
import main.sensoryexperimentplatform.models.UserManager;

import java.net.URL;
import java.util.ResourceBundle;

public class LogInController {


    @FXML
    private Button btn_cancel;

    @FXML
    private Button btn_login;

    @FXML
    private Label lbl_SenseXP;

    @FXML
    private TextField txt_password;
    private Login_VM login_vm;


    public LogInController() {
        UserManager userManager = new UserManager();
        login_vm = new Login_VM(userManager);
        login_vm.setPassword("Thy giang");
    }


    @FXML
    void btn_cancel(ActionEvent event) {

    }

    @FXML
    void btn_login(ActionEvent event) {
        handleLogin();

    }


    @FXML
    void txt_password(ActionEvent event) {



    }

    public void initialize() {
        txt_password.textProperty().bindBidirectional(login_vm.getPasswordProperty());
    }

    private void handleLogin() {
        boolean sucess = login_vm.login();
        if (sucess) {
            System.out.println("Login successful");
        } else {
            System.out.println("Login successful");
        }
    }
}
