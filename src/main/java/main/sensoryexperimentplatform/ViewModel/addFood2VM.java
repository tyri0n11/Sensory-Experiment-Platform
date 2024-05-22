package main.sensoryexperimentplatform.ViewModel;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import main.sensoryexperimentplatform.View.ViewHandler;

public class addFood2VM {
    private StringProperty name;
    private ViewHandler viewHandler;
    public addFood2VM(){
        name = new SimpleStringProperty();
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }
}
