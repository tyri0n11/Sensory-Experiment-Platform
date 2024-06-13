package main.sensoryexperimentplatform.viewmodel;

import java.text.SimpleDateFormat;
import java.util.Date;

import javafx.beans.property.*;
import main.sensoryexperimentplatform.models.Vas;

public class RunVas_VM {
    private Vas vas;
    private IntegerProperty sliderValue;
    private final StringProperty questionText;
    private StringProperty lowAnchorText, button, conducted, help;
    private StringProperty highAnchorText;


    public RunVas_VM(Vas vas) {
        this.vas = vas;
        sliderValue = new SimpleIntegerProperty(vas.getResult()); // Khởi tạo giá trị của sliderValue từ kết quả hiện tại
        button = new SimpleStringProperty(vas.getButtonText());
        questionText = new SimpleStringProperty(vas.getTitle());
        lowAnchorText = new SimpleStringProperty(vas.getLowAnchorText());
        highAnchorText = new SimpleStringProperty(vas.getHighAnchorText());
        conducted = new SimpleStringProperty(vas.getConducted());
        help = new SimpleStringProperty(vas.getHelpText());

        sliderValue.addListener((observable, oldValue, newValue) -> {
            setResult(newValue.intValue());
            System.out.println("Vas recording: "+ newValue);
            conducted.set(getCurrentFormattedTime());
            setDate();
        });
    }

    public String getCurrentFormattedTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss.SSS");
        Date now = new Date();
        return sdf.format(now);
    }

    public void setDate(){
        vas.setConducted(getCurrentFormattedTime());
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
    public StringProperty helpTextProperty() {
        return help;
    }

    public StringProperty conductedTextProperty() {
        return conducted;
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