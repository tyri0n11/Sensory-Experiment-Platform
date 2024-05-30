package main.sensoryexperimentplatform.ViewModel;

import javafx.beans.property.*;
import javafx.beans.value.ObservableValue;
import main.sensoryexperimentplatform.models.Vas;

public class RunVas_VM {
    private Vas vas;
    private IntegerProperty sliderValue;
    private final StringProperty questionText;
    private StringProperty lowAnchorText, button;
    private StringProperty highAnchorText;
    private IntegerProperty lowAnchorValue, highAnchorValue;

    public RunVas_VM(Vas vas) {
        this.vas = vas;
        sliderValue = new SimpleIntegerProperty(vas.getResult()); // Khởi tạo giá trị của sliderValue từ kết quả hiện tại
        button = new SimpleStringProperty(vas.getButtonText());
        questionText = new SimpleStringProperty(vas.getTitle());
        lowAnchorText = new SimpleStringProperty(vas.getLowAnchorText());
        highAnchorText = new SimpleStringProperty(vas.getHighAnchorText());

        sliderValue.addListener((observable, oldValue, newValue) -> {
            setResult(newValue.intValue());
            System.out.println(vas.getResult());
        });
    }

    public int getHighAnchorValue() {
        return vas.getHighAnchorValue();
    }
    public int getLowAnchorValue() {
        return vas.getLowAnchorValue();
    }

    public void setResult(int result) {
        vas.setResult(result);
    }
    public IntegerProperty sliderValueProperty() {
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