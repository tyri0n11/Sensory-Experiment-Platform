package main.sensoryexperimentplatform.controllers;


import main.sensoryexperimentplatform.models.AudibleInstruction;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.net.URISyntaxException;

public class AudibleInstructionSingleton {
    private static AudibleInstruction instance;

    private AudibleInstructionSingleton() {}

    public static AudibleInstruction getInstance() {
        if (instance == null) {
            instance = new AudibleInstruction("Default Notice stage", "Default content", "Continue", null);
        }
        return instance;
    }
}
