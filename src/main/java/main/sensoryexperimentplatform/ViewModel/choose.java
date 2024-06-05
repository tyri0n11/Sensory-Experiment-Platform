package main.sensoryexperimentplatform.ViewModel;

import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public interface choose {
    void modify(AnchorPane anchorPane) throws IOException;
    void modifyWithButton (AnchorPane anchorPane, Button button1, Button button2, Button button3, Button button4, Button button5, Button button6, Button button7, Button button8, Button button9, Button button10, Button button11, Button button12, Button button13) throws IOException;
}
