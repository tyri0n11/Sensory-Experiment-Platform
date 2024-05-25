package main.sensoryexperimentplatform.ViewModel;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import main.sensoryexperimentplatform.models.Experiment;
import main.sensoryexperimentplatform.models.Input;

public class inputStage_VM {
    private Experiment experiment;
    private final ListProperty<Object> stages = new SimpleListProperty<>(FXCollections.observableArrayList());
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

    }

    public void addInputStage() {

        String title = this.title.get();
        String content = this.content.get();
        String buttonText = this.buttonText.get();
        boolean alert = this.alert.get();
        Input stage = new Input(title, content, buttonText, alert);
        experiment.addInputStage(title, content, buttonText, alert);
        stages.add(stage);

    }

    public ObservableList<Object> getStages() {
        return stages.get();
    }

    public ListProperty<Object> stagesProperty() {
        return stages;
    }
    public StringProperty titleProperty() {
        return title;
    }

    public StringProperty contentProperty() {
        return content;
    }

    public StringProperty buttonTextProperty() {
        return buttonText;
    }

    public BooleanProperty alertProperty() {
        return alert;
    }

}
