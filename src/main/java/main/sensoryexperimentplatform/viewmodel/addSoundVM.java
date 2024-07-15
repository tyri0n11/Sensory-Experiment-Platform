package main.sensoryexperimentplatform.viewmodel;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import main.sensoryexperimentplatform.models.Sound;

public class addSoundVM {
    private Sound sound;
    private StringProperty file;
    private StringProperty name;

    public addSoundVM(){
        // Initialize the sound object with default values

        sound.setSoundFilePath(""); // Default file path
        sound.setName(""); // Default name

        // Initialize properties with sound values
        file = new SimpleStringProperty(sound.getSoundFilePath());
        name = new SimpleStringProperty(sound.getName());
        file.addListener((observable, oldValue, newValue) -> {
            setFile(newValue);
        });

        name.addListener((observable, oldValue, newValue) -> {
            setName(newValue);

        });
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

    public void setFile(String newValue) {
        file.set(newValue);
        sound.setSoundFilePath(newValue);
    }

    public void setName(String newValue) {
        name.set(newValue);
        sound.setName(newValue);
    }

    public Sound getSound() {
        return sound;
    }
}
