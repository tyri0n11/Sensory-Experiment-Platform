package main.sensoryexperimentplatform.controllers;



public class notiAddSound {
    private assignSoundController AssignSoundController;
    public notiAddSound(assignSoundController AssignSoundController){
        this.AssignSoundController = AssignSoundController;
    }
    public void notifyObject(){
        AssignSoundController.loadSoundRadioButtons();
    }
}
