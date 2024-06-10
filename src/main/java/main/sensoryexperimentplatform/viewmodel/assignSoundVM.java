package main.sensoryexperimentplatform.viewmodel;

import main.sensoryexperimentplatform.models.AudibleInstruction;

import java.util.ArrayList;
import java.util.List;

public class assignSoundVM {
    private AudibleInstruction audibleInstruction;
    private ArrayList<String> listNameshow;
    private ArrayList<String> listSoundName;
    private List<String>soundPath;

    public assignSoundVM(AudibleInstruction audibleInstruction){
        this.audibleInstruction = audibleInstruction;
        listNameshow = audibleInstruction.getSoundNameshow();
        listSoundName= audibleInstruction.getSoundNameList();
        soundPath = audibleInstruction.getSoundFilePaths();
    }


    public List<String>getSoundPath(){
        return soundPath;
    }

    public void addsoundPath(String Soundpath){
        soundPath.add(Soundpath);
    }
    public void addListSoundshow(String name){
        listNameshow.add(name);
        audibleInstruction.getSoundNameshow().add(name);

    }
    public void addListSoundName(String name){
        listSoundName.add(name);
        audibleInstruction.getSoundNameList();
    }

    public ArrayList<String> getListNameshow() {
        return listNameshow;
    }

    public ArrayList<String> getListSoundName() {
        return listSoundName;
    }
}