package main.sensoryexperimentplatform.ViewModel;

import main.sensoryexperimentplatform.models.TasteTest;

import java.util.ArrayList;

public class FoodTasteVM {
    private TasteTest tasteTest;
    private ArrayList<String> listFoods;
    private ArrayList<String> listFoodsShow;
    private ArrayList<String> listGLMSShow;
    private ArrayList <String> listVasShow;
    private ArrayList <String> listVas;
    private ArrayList<String> listGLMS;


    public FoodTasteVM(TasteTest tasteTest){
        this.tasteTest = tasteTest;
        listFoods = tasteTest.getFoods();
        listFoodsShow = tasteTest.getFoodsShow();
        listVas = tasteTest.getVasList();
        listGLMSShow = tasteTest.getGlmsListShow();
        listVasShow = tasteTest.getVasListShow();
        listGLMS = tasteTest.getGlmsList();
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
