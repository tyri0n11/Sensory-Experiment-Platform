package main.sensoryexpeirmentplatform.models;

public class Food {
    private final String name;
    private final int time;
    private RatingContainer vasContainer, glmsContainer;
    public Food (String name,boolean isRandomizeVas, boolean isRandomizeGlms, int time){
        this.name = name;
        this.time = time;
        vasContainer = new RatingContainer(isRandomizeVas,time);
        glmsContainer = new RatingContainer(isRandomizeGlms, time);
    }
    public void addVasRating(Stage stage){
        vasContainer.addStage(stage);
    }
    public void addGlmsRating(Stage stage){
        glmsContainer.addStage(stage);
    }
    public String toString(){
        return vasContainer.toString() +"\n"+
                glmsContainer.toString();
    }
}
