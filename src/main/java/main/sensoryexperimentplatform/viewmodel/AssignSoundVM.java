package main.sensoryexperimentplatform.viewmodel;

import main.sensoryexperimentplatform.controllers.SoundSingleton;
import main.sensoryexperimentplatform.models.AudibleInstruction;
import main.sensoryexperimentplatform.models.Experiment;
import main.sensoryexperimentplatform.models.Sound;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

public class AssignSoundVM {
    private Sound sound;
    private Experiment experiment;



    public AssignSoundVM(Experiment experiment) throws UnsupportedAudioFileException, LineUnavailableException, IOException, URISyntaxException {
        this.sound = SoundSingleton.getInstance();


    }

//    public void addListSoundshow(String name){
//
//       sound.getSoundNameshow().add(name);
//    }
    public void getSoundPath(){
       sound.getSoundFilePath();
    }


    public ArrayList<String> getListNameshow() {
        return sound.getSoundNameshow();
    }

//    public void loadSound(String name, String filePath) {
//       sound.loadSound(name, filePath);
//    }
    public void playSound(String name) {
       sound.playSound(name);
    }
    public void stopSound(String name) {
       sound.stopSound(name);
    }
    public void removeSound(String name) {
       sound.getSoundNameshow().remove(name);
    }

    public ArrayList<String> getSoundFilePaths(){
      return sound.getSoundFilePath();
    }
    public void  addSoundFilePath(String soundPath){
       sound.getSoundFilePath().add(soundPath);
    }
    public Sound getSound(){
        return sound;
    }
}