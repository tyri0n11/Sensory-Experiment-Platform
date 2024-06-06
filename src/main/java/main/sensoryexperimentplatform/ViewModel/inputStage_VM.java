package main.sensoryexperimentplatform.ViewModel;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import main.sensoryexperimentplatform.SensoryExperimentPlatform;
import main.sensoryexperimentplatform.controllers.InputStageController;
import main.sensoryexperimentplatform.models.Experiment;
import main.sensoryexperimentplatform.models.Input;

import java.io.IOException;

public class inputStage_VM implements choose{
    private Input input;
    private Experiment experiment;
//    private final ListProperty<Object> stages = new SimpleListProperty<>(FXCollections.observableArrayList());
    private StringProperty title;
    private StringProperty content;
    private StringProperty buttonText;
    private BooleanProperty alert;

    public inputStage_VM(Experiment experiment){
        this.experiment = experiment;

        title = new SimpleStringProperty();
        content = new SimpleStringProperty();
        buttonText = new SimpleStringProperty();
        alert = new SimpleBooleanProperty();
        experiment.addInput(input);

    }

    private StringProperty button;


    public void addInputStage() {

        String title = this.title.get();
        String content = this.content.get();
        String buttonText = this.button.get();
        boolean alert = this.alert.get();
        Input stage = new Input(title, content, buttonText, alert);
        experiment.addInputStage(title, content, buttonText, alert);
//        stages.add(stage);

    }


//    public ObservableList<Object> getStages() {
//        return stages.get();
//    }
//
//    public ListProperty<Object> stagesProperty() {
//        return stages;
//    }
    public StringProperty titleProperty() {
        return title;
    }

    public StringProperty contentProperty() {
        return content;
    }

    public StringProperty buttonTextProperty() {
        return button;
    }

    public BooleanProperty alertProperty() {
        return alert;
    }
    public String getContent(){
        return content.get();
    }
    public String getButton(){
        return button.get();
    }

    public boolean getAlert(){
        return alert.get();
    }

    public void setHelpText(String newValue) {
        input.setContent(newValue);
    }
    public void setQuestion(String newValue) {
        input.setTitle(newValue);
    }
    public void setButtonText(String newValue) {
        input.setButtonText(newValue);
    }
    public void setAlert(Boolean newValue) {
        input.setAlert(newValue);
    }
    public Input getInput(){
        return input;
    }

    @Override
    public void modify(AnchorPane anchorPane) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(SensoryExperimentPlatform.class.getResource("InputStage.fxml"));
        AnchorPane newContent = fxmlLoader.load();
        anchorPane.getChildren().setAll(newContent);

        InputStageController controller =fxmlLoader.getController();
        controller.setViewModel(this);

    }

    @Override
    public void modifyWithButton(AnchorPane anchorPane, Button button1, Button button2, Button button3, Button button4, Button button5, Button button6, Button button7, Button button8, Button button9, Button button10, Button button11, Button button12) throws IOException {

    }
    @Override
    public String getTitle(){
        return "[User Input] "+title.get();
    }
}
