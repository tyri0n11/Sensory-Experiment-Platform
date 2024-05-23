package main.sensoryexperimentplatform.ViewModel;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import main.sensoryexperimentplatform.models.Vas;

public class RunVas_VM {
    private Vas vas;
    private DoubleProperty sliderValue;
    private final StringProperty questionText;
    private StringProperty lowAnchorText;
    private StringProperty highAnchorText;

    public RunVas_VM(Vas vas) {
        this.vas = vas;
        questionText = new SimpleStringProperty(vas.getTitle());
        lowAnchorText = new SimpleStringProperty(vas.getLowAnchorText());
        highAnchorText = new SimpleStringProperty(vas.getHighAnchorText());
    }
    public void setResult(int result){
        vas.setResult(result);
    }
    public StringProperty questionTextProperty() {
        return questionText;
    }

    public StringProperty lowAnchorTextProperty() {
        return lowAnchorText;
    }

    public StringProperty highAnchorTextProperty() {
        return highAnchorText;
    }
}