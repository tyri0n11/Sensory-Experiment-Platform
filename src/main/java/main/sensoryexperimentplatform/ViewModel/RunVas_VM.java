package main.sensoryexperimentplatform.ViewModel;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;
import main.sensoryexperimentplatform.models.Vas;

public class RunVas_VM {
    private Vas vas;
    private StringProperty result;
    private DoubleProperty sliderValue;
    private final StringProperty questionText;
    private StringProperty lowAnchorText, button;
    private StringProperty highAnchorText;

    public RunVas_VM(Vas vas) {
        this.vas = vas;
        result = new SimpleStringProperty(String.format("%.1f", vas.getResult()));
        sliderValue = new SimpleDoubleProperty(vas.getResult()); // Khởi tạo giá trị của sliderValue từ kết quả hiện tại
        button = new SimpleStringProperty(vas.getButtonText());
        questionText = new SimpleStringProperty(vas.getTitle());
        lowAnchorText = new SimpleStringProperty(vas.getLowAnchorText());
        highAnchorText = new SimpleStringProperty(vas.getHighAnchorText());

        sliderValue.addListener((observable, oldValue, newValue) -> {
            setResult(newValue.doubleValue());
            result.set(String.format("%.1f", newValue.doubleValue()));
        });
    }

    public StringProperty resultTextProperty() {
        return result;
    }

    public void setResult(double result) {
        vas.setResult(result);
    }
    public DoubleProperty sliderValueProperty() {
        return sliderValue;
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

    public StringProperty buttonProperty() {
        return button;
    }

    public double getResult() {
        return vas.getResult();
    }
}