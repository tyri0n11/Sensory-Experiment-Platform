package main.sensoryexperimentplatform.ViewModel;

import main.sensoryexperimentplatform.models.AudibleInstruction;

import java.util.ArrayList;
import java.util.List;

public class assignSoundVM {
    private AudibleInstruction audibleInstruction;
    private List<String> soundName;
    private List<String>soundPath;
    public assignSoundVM(AudibleInstruction audibleInstruction){
        this.audibleInstruction = audibleInstruction;
        soundName = audibleInstruction.getSoundNames();
        soundPath = audibleInstruction.getSoundFilePaths();
    }

    public List<String>getSoundName(){
        return soundName;
    }
    public List<String>getSoundPath(){
        return soundPath;
    }
    public void addSoundName(String Soundname){
        soundName.add(Soundname);
    }
    public void addsoundPath(String Soundpath){
        soundPath.add(Soundpath);
    }
}