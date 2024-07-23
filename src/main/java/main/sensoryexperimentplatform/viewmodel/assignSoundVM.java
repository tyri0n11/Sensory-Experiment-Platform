package main.sensoryexperimentplatform.viewmodel;

import main.sensoryexperimentplatform.models.AudibleInstruction;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class assignSoundVM {
    private AudibleInstruction audibleInstruction;
    private ArrayList<String> listNameshow;
    private ArrayList<String> listSoundName;
    private ArrayList<String>listSoundFilePaths;

    public assignSoundVM(AudibleInstruction audibleInstruction){
        this.audibleInstruction = audibleInstruction;
        listNameshow = audibleInstruction.getSoundNameshow();
        listSoundName= audibleInstruction.getSoundNameList();
        listSoundFilePaths = audibleInstruction.getSoundFilePath();

    }

    public void addListSoundshow(String name){
        listNameshow.add(name);


    }
    public void addListSoundName(String name){
        listSoundName.add(name);
        audibleInstruction.getSoundNameList().add(name);
    }


    public ArrayList<String> getListNameshow() {
        return listNameshow;
    }


    public Map<String, String> getSoundMap() {
        return audibleInstruction.getSoundMap();
    }

    public void addSound(String name, String filePath) {
        audibleInstruction.addSound(name, filePath);
    }

    public ArrayList<String> getListSoundName() {
        return listSoundName;
    }
    public ArrayList<String> getSoundFilePaths(){
      return listSoundFilePaths;
    }
    public void  addSoundFilePath(String soundPath){
        listSoundFilePaths.add( soundPath);
    }
}