package main.sensoryexperimentplatform.ViewModel;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import main.sensoryexperimentplatform.models.Experiment;
import main.sensoryexperimentplatform.models.Input;

public class inputStage_VM {
    private Input input;
    private Experiment experiment;
//    private final ListProperty<Object> stages = new SimpleListProperty<>(FXCollections.observableArrayList());
    private StringProperty title;
    private StringProperty content;
    private StringProperty button;
    private BooleanProperty alert;

    public inputStage_VM(){
        this.input = new Input("User input", "This is question","this is button", false);
        title = new SimpleStringProperty(input.getTitle());
        content = new SimpleStringProperty(input.getContent());
        button = new SimpleStringProperty(input.getButtonText());
        alert = new SimpleBooleanProperty(input.isAlert());

    }



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

    public String getTitle(){
        return title.get();
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
}
