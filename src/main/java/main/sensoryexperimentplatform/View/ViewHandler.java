package main.sensoryexperimentplatform.View;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import main.sensoryexperimentplatform.controllers.GeneralController;

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
            Scene treatmentLogScnene = new Scene(root);
            mainStage.setScene(treatmentLogScnene);
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

}
