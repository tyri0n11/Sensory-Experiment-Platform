package main.sensoryexperimentplatform.controllers;

import main.sensoryexperimentplatform.viewmodel.choose;

public class Wrapper {
    private String key;
    private choose choose;
    public Wrapper (String key, choose choose){
        this.key = key;
        this.choose = choose;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public choose getChoose() {
        return choose;
    }

    public void setChoose(main.sensoryexperimentplatform.viewmodel.choose choose) {
        this.choose = choose;
    }
}
