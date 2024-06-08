package main.sensoryexperimentplatform.viewmodel;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class addFoodVM {
    private StringProperty name;
    public addFoodVM(){
        name = new SimpleStringProperty();
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }
}
