package main.sensoryexperimentplatform.View;

import main.sensoryexperimentplatform.ViewModel.addFood2VM;
import main.sensoryexperimentplatform.ViewModel.addFoodVM;
import main.sensoryexperimentplatform.ViewModel.addSoundVM;
import main.sensoryexperimentplatform.ViewModel.general_VM;

public class ViewFactory {
    private addFood2VM addfood2;
    private addFoodVM addfood;
    private addSoundVM addsound;
    private general_VM general;

    public addFoodVM getAddfood() {
        if (addfood == null){
            addfood= new addFoodVM();
        }
        return addfood;
    }
    public addFood2VM getAddfood2() {
        if (addfood2 == null){
            addfood2= new addFood2VM();
        }
        return addfood2;
    }

    public Object getGeneralVM() {
        if (general == null){
            general= new general_VM();
        }
        return general;
    }
}
