package main.sensoryexperimentplatform.controllers;


import main.sensoryexperimentplatform.models.AudibleInstruction;
import main.sensoryexperimentplatform.models.Sound;

public class SoundSingleton {
    private static Sound instance;

    private SoundSingleton() {}

    public static Sound getInstance() {
        if (instance == null) {
            instance = new Sound();
        }
        return instance;
    }
}
