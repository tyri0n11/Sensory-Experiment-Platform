package main.sensoryexperimentplatform.ViewModel;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;

public class TestVM {
    private BooleanProperty addNoticeStage;
    public TestVM(){
        addNoticeStage = new SimpleBooleanProperty();
    }

}