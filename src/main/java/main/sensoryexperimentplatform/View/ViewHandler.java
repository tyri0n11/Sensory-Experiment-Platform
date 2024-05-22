package main.sensoryexperimentplatform.View;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import main.sensoryexperimentplatform.controllers.GeneralController;
import main.sensoryexperimentplatform.controllers.addFoodController2;

import java.io.IOException;

public class ViewHandler {
    private Stage mainStage;
    private ViewFactory vmf;


    public ViewHandler(ViewFactory vmf){
        mainStage = new Stage();
        this.vmf = vmf;
    }
    public void start(){
        openGeneral();
        mainStage.show();
    }

    private void openGeneral() {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("general.fxml"));
        try{
            Parent root = (Parent) loader.load();
            GeneralController generalController =  loader.getController();
            generalController.init(vmf.getGeneralVM(), this);
            Scene general = new Scene(root);
            mainStage.setScene(general);
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
    public void openAddFood2(){
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("AddFood2.fxml"));
        try{
            Parent root = (Parent) loader.load();
            addFoodController2 addFood =  loader.getController();
            addFood.init(vmf.getAddfood2(), this);
            Scene general = new Scene(root);
            mainStage.setScene(general);
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

}
