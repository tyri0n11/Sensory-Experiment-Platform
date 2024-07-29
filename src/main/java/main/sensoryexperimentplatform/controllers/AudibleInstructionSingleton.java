package main.sensoryexperimentplatform.controllers;


import main.sensoryexperimentplatform.models.AudibleInstruction;

public class AudibleInstructionSingleton {
    private static AudibleInstruction instance;

    private AudibleInstructionSingleton() {}

    public static AudibleInstruction getInstance() {
        if (instance == null) {
            instance = new AudibleInstruction("Default Notice stage", null, null, null);
        }
        return instance;
    }
}
