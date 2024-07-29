package main.sensoryexperimentplatform.viewmodel;

import main.sensoryexperimentplatform.controllers.AudibleInstructionSingleton;
import main.sensoryexperimentplatform.models.AudibleInstruction;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class assignSoundVM {
    private AudibleInstruction audibleInstruction;
//    private ArrayList<String> listNameshow;
//    private ArrayList<String> listSoundName;
//    private ArrayList<String>listSoundFilePaths;

    public assignSoundVM(AudibleInstruction audibleInstruction){
        this.audibleInstruction = AudibleInstructionSingleton.getInstance();
//        listNameshow = audibleInstruction.getSoundNameshow();
//        listSoundName= audibleInstruction.getSoundNameList();
//        listSoundFilePaths = audibleInstruction.getSoundFilePath();

    }

    public void addListSoundshow(String name){
//        listNameshow.add(name);
        audibleInstruction.getSoundNameshow().add(name);
    }
    public void addListSoundName(String name){
//        listSoundName.add(name);
        audibleInstruction.getSoundNameList().add(name);
    }


    public ArrayList<String> getListNameshow() {
        return audibleInstruction.getSoundNameshow();
    }


    public Map<String, String> getSoundMap() {
        return audibleInstruction.getSoundMap();
    }

    public void addSound(String name, String filePath) {
        audibleInstruction.addSound(name, filePath);
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