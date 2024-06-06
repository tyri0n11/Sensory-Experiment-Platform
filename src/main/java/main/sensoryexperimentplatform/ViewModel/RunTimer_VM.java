package main.sensoryexperimentplatform.ViewModel;

import javafx.beans.property.*;
import main.sensoryexperimentplatform.models.Timer;

public class RunTimer_VM {
    private Timer timer;
    private StringProperty instruction;
    private StringProperty time;
    private DoubleProperty progress;
    private BooleanProperty timerComplete;

    public RunTimer_VM(Timer timer) {
        this.timer = timer;
        instruction = new SimpleStringProperty(timer.getInstruction());
        time = new SimpleStringProperty(timer.getTitle());
        progress = new SimpleDoubleProperty(0);  // Initial progress set to 0
        timerComplete = new SimpleBooleanProperty(false); // Timer starts as incomplete
    }
    public int getDuration(){
        return Integer.parseInt(timer.getTitle());
    }
    public StringProperty getInstruction() {
        return instruction;
    }

    public StringProperty getTime() {
        return time;
    }

    public DoubleProperty getProgress() {
        return progress;
    }

    public void updateProgress(double progressValue) {
        progress.set(progressValue);
    }

}
