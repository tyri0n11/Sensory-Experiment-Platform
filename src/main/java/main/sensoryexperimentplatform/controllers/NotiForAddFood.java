package main.sensoryexperimentplatform.controllers;

public class NotiForAddFood {
    private FoodAndTasteController foodAndTasteController;
    public NotiForAddFood(FoodAndTasteController foodAndTasteController){
        this.foodAndTasteController = foodAndTasteController;
    }
    public void notifyObject(){
        foodAndTasteController.loadItems();
    }
}
