package main.sensoryexperimentplatform.View;

import main.sensoryexperimentplatform.ViewModel.*;

public class ViewFactory {
    private addFood2VM addfood2;
    private addFoodVM addfood;
    private addSoundVM addsound;
    private general_VM general;
    private AddTasteVM addTasteVM;
    private glmsStage_VM glmsStageVm;
    public AddTasteVM getAddTasteVM(){
        if (addTasteVM == null){
            addTasteVM = new AddTasteVM();
        }
        return addTasteVM;
    }

    public addFoodVM getAddfood() {
        if (addfood == null){
            addfood= new addFoodVM();
        }
        return addfood;
    }
    public addSoundVM addSound(){
        if (addsound == null){
            addsound= new addSoundVM();
        }
        return addsound;
    }
    public addFood2VM getAddfood2() {
        if (addfood2 == null){
            addfood2= new addFood2VM();
        }
        return addfood2;
    }

    public general_VM getGeneralVM() {
        if (general == null){
            general= new general_VM();
        }
        return general;
    }
}
