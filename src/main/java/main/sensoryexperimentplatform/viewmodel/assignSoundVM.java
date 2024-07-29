package main.sensoryexperimentplatform.viewmodel;

import main.sensoryexperimentplatform.controllers.AudibleInstructionSingleton;
import main.sensoryexperimentplatform.models.AudibleInstruction;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class assignSoundVM {
    private AudibleInstruction audibleInstruction;


    public assignSoundVM(AudibleInstruction audibleInstruction){
        this.audibleInstruction = AudibleInstructionSingleton.getInstance();

    }

    public void addListSoundshow(String name){

        audibleInstruction.getSoundNameshow().add(name);
    }
    public void getSoundPath(){
        audibleInstruction.getSoundFilePath();
    }
    public void addListSoundName(String name){
        audibleInstruction.getSoundNameList().add(name);
    }


    public ArrayList<String> getListNameshow() {
        return audibleInstruction.getSoundNameshow();
    }

//    public void loadSound(String name, String filePath) {
//        audibleInstruction.loadSound(name, filePath);
//    }
    public void playSound(String name) {
        audibleInstruction.playSound(name);
    }
    public void stopSound(String name) {
        audibleInstruction.stopSound(name);
    }

    public ArrayList<String> getListSoundName() {
        return audibleInstruction.getSoundNameList();
    }
    public ArrayList<String> getSoundFilePaths(){
      return audibleInstruction.getSoundFilePath();
    }
    public void  addSoundFilePath(String soundPath){
        audibleInstruction.getSoundFilePath().add(soundPath);
    }
}