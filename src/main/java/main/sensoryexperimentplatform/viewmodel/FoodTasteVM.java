package main.sensoryexperimentplatform.viewmodel;

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

    public ArrayList<String> getListGLMSShow() {
        return listGLMSShow;
    }
    public ArrayList<String> getListVasShow() {
        return listVasShow;
    }

    public ArrayList<String> getListVas() {
        return listVas;
    }

    public ArrayList<String> getListGLMS() {
        return listGLMS;
    }

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
        tasteTest.getFoodsShow().add(food);
    }
    public void addVasShow(String food){
        tasteTest.getVasListShow().add(food);}
    public void addGLMSShow (String food){
        tasteTest.getGlmsListShow().add(food);}

    public ArrayList<String> getListFoods() {
        return listFoods;
    }

    public void addListFoods(String food) {
        tasteTest.getFoods().add(food);
    }
    public void addVas(String food){
        listVas.add(food);
    }
    public void addGLMS(String food){
        listGLMS.add(food);
    }

}
