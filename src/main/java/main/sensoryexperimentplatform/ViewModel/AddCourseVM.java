package main.sensoryexperimentplatform.ViewModel;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import main.sensoryexperimentplatform.models.Periodic;

public class AddCourseVM {
    private Periodic model;
    private StringProperty txt_button;
    private StringProperty txt_content;
    private StringProperty  txt_help;
    private StringProperty txt_quantity;
    private StringProperty  txt_refill;

    private StringProperty txt_title;
    public AddCourseVM( Periodic model){
        this.model = model;
        //txt_button = new SimpleStringProperty(model.)
        txt_content = new SimpleStringProperty(model.getContent());
        //txt_help = new SimpleStringProperty(model.getHelp)

    }
}
