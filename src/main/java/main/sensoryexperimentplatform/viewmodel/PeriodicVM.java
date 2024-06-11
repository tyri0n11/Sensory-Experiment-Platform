package main.sensoryexperimentplatform.viewmodel;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import main.sensoryexperimentplatform.SensoryExperimentPlatform;
import main.sensoryexperimentplatform.controllers.AddCourseController;
import main.sensoryexperimentplatform.controllers.AddPeriodic;
import main.sensoryexperimentplatform.models.Course;

import java.io.IOException;
import java.util.Stack;

public class PeriodicVM implements choose{
    private Course course;
    public PeriodicVM (Course course){
        this.course = course;
    }

    @Override
    public void modify(AnchorPane anchorPane, Stack<AddTasteVM> stack, Stack<AddCourseVM> addCourseVMS) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(SensoryExperimentPlatform.class.getResource("AddPeriodicStage.fxml"));
        AnchorPane newContent = fxmlLoader.load();
        anchorPane.getChildren().setAll(newContent);
        AddPeriodic controller = fxmlLoader.getController();
        controller.setViewModel(this);
    }

    @Override
    public void modifyWithButton(AnchorPane anchorPane, Stack<AddTasteVM> stack, Stack<AddCourseVM> addCourseVMS, Button button1, Button button2, Button button3, Button button4, Button button5, Button button6, Button button7, Button button8, Button button9, Button button10, Button button11, Button button12) throws IOException {

    }

    @Override
    public String getTitle() {
        return null;
    }
}
