package main.sensoryexperimentplatform.controllers;



public class NotiAddSound {
    private AssignSoundController AssignSoundController;
    public NotiAddSound(AssignSoundController AssignSoundController){
        this.AssignSoundController = AssignSoundController;
    }
    public void notifyObject(){
        AssignSoundController.loadSoundRadioButtons();
    }
}
