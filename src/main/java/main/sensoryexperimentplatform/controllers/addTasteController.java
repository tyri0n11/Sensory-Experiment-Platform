package main.sensoryexperimentplatform.controllers;

import javafx.event.ActionEvent;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import main.sensoryexperimentplatform.ViewModel.AddTasteVM;

public class addTasteController {
    public TextField txt_inital;
    public CheckBox cbox;
    public TextArea txt_help;
    public TextField txt_endInstruction;
    public TextField txt_timetowait;
    public CheckBox checkbox_randomfood;
    public CheckBox checkbox_randomrate;
    public CheckBox checkbox_playalert;
    public TextField txt_howtaste;
    public TextField txt_consumpins;
    public TextField txt_lowanchortext;
    public TextField txt_highanchortext;
    public TextField txt_lowacnhorvalue;
    public TextField txt_highacnhorvalue;
    public TextField txt_buttontext;
    public CheckBox checkbox_swappole;
    private AddTasteVM addVM;

    public void init() {
        addVM = new AddTasteVM();
        txt_inital.textProperty().bindBidirectional(addVM.txt_initalProperty());
        txt_buttontext.textProperty().bindBidirectional(addVM.txt_buttontextProperty());
        txt_consumpins.textProperty().bindBidirectional(addVM.txt_consumpinsProperty());
        cbox.selectedProperty().bindBidirectional(addVM.cboxProperty());
        txt_help.textProperty().bindBidirectional(addVM.txt_helpProperty());
        txt_endInstruction.textProperty().bindBidirectional(addVM.txt_endInstructionProperty());
        txt_howtaste.textProperty().bindBidirectional(addVM.txt_howtasteProperty());
        txt_timetowait.textProperty().bindBidirectional(addVM.txt_timetowaitProperty());
        checkbox_randomfood.selectedProperty().bindBidirectional(addVM.checkbox_randomfoodProperty());
        checkbox_playalert.selectedProperty().bindBidirectional(addVM.checkbox_playalertProperty());
        checkbox_swappole.selectedProperty().bindBidirectional(addVM.checkbox_swappoleProperty());
        txt_highacnhorvalue.textProperty().bindBidirectional(addVM.txt_highacnhorvalueProperty());
        txt_lowacnhorvalue.textProperty().bindBidirectional(addVM.txt_lowacnhorvalueProperty());
        checkbox_randomrate.selectedProperty().bindBidirectional(addVM.checkbox_randomrateProperty());
        txt_lowanchortext.textProperty().bindBidirectional(addVM.txt_lowanchortextProperty());
        txt_highanchortext.textProperty().bindBidirectional(addVM.txt_highanchortextProperty());
    }
}
