package main.sensoryexperimentplatform.ViewModel;

import main.sensoryexperimentplatform.models.TasteTest;

import java.util.ArrayList;

public class FoodTasteVM {
    private ArrayList<String> listFoods;
    public FoodTasteVM(TasteTest tasteTest){
        listFoods = tasteTest.getFoods();
    }

    public ArrayList<String> getListFoods() {
        return listFoods;
    }

    public void setListFoods(ArrayList<String> listFoods) {
        this.listFoods = listFoods;
    }

}
