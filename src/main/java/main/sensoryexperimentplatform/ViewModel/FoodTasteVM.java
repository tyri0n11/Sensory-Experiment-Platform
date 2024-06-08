package main.sensoryexperimentplatform.ViewModel;

import main.sensoryexperimentplatform.models.TasteTest;

import java.util.ArrayList;

public class FoodTasteVM {
    private TasteTest tasteTest;
    private ArrayList<String> listFoods;
    private ArrayList<String> listFoodsShow;

    public FoodTasteVM(TasteTest tasteTest){
        this.tasteTest = tasteTest;
        listFoods = tasteTest.getFoods();
        listFoodsShow = tasteTest.getFoodsShow();
    }

    public ArrayList<String> getListFoodsShow() {
        return listFoodsShow;
    }

    public void addListFoodsShow(String food) {
        listFoodsShow.add(food);
    }

    public ArrayList<String> getListFoods() {
        return listFoods;
    }

    public void addListFoods(String food) {
        listFoods.add(food);
    }

}
