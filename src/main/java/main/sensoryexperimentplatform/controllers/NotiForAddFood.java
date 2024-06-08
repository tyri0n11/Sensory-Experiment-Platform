package main.sensoryexperimentplatform.controllers;

import main.sensoryexperimentplatform.ViewModel.FoodTasteVM;

public class NotiForAddFood {
    private FoodAndTasteController foodAndTasteController;
    public NotiForAddFood(FoodAndTasteController foodAndTasteController){
        this.foodAndTasteController = foodAndTasteController;
    }
    public void notifyObject(){
        foodAndTasteController.loadItems();
    }
}
