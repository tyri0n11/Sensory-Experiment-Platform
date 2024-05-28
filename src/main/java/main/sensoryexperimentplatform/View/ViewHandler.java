package main.sensoryexperimentplatform.View;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import main.sensoryexperimentplatform.controllers.GeneralController;
import main.sensoryexperimentplatform.controllers.addFoodController2;
import main.sensoryexperimentplatform.controllers.assignSoundController;
import main.sensoryexperimentplatform.controllers.addTasteController2;

import java.io.IOException;

public class ViewHandler {
    private Stage mainStage;
    private ViewFactory vmf;


    public ViewHandler(ViewFactory vmf){
        mainStage = new Stage();
        this.vmf = vmf;
    }


    public void openGLMS(){
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("AssignSound.fxml"));
        try{
            Parent root = (Parent) loader.load();
            assignSoundController assignSound =  loader.getController();
            assignSound.init(vmf.addSound(), this);
            Scene general = new Scene(root);
            mainStage.setScene(general);
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

}
