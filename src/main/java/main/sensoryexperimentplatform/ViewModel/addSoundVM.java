package main.sensoryexperimentplatform.ViewModel;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class addSoundVM {
    private StringProperty file;
    private StringProperty name;
    public addSoundVM(){
        file = new SimpleStringProperty();
        name = new SimpleStringProperty();
    }

    public String getFile() {
        return file.get();
    }

    public StringProperty fileProperty() {
        return file;
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }
}
