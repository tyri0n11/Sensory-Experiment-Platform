package main.sensoryexperimentplatform.viewmodel;

import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import main.sensoryexperimentplatform.models.Experiment;

import java.io.IOException;
import java.util.Stack;

public class StartVM implements choose{
    private Experiment experiment;

    @Override
    public void modify(AnchorPane anchorPane, Stack<AddTasteVM> stack, Stack<AddCourseVM> addCourseVMS) throws IOException {

    }

    @Override
    public void modifyWithButton(AnchorPane anchorPane, Stack<AddTasteVM> stack, Stack<AddCourseVM> addCourseVMS, Button button1, Button button2, Button button3, Button button4, Button button5, Button button6, Button button7, Button button8, Button button9, Button button10, Button button11, Button button12) throws IOException {

    }

    @Override
    public String getTitle() {
        return null;
    }
}
