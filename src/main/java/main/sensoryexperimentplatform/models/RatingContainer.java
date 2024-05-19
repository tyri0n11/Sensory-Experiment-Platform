package main.sensoryexperimentplatform.models;

import java.util.ArrayList;
import java.util.Collections;

public class RatingContainer extends Test{
    private boolean isRandomize;
    private long minTime;
    public ArrayList<Stage> container;
    public RatingContainer(boolean isRandomize,int minTime){
        this.minTime = minTime;
        this.isRandomize = isRandomize;
        container = new ArrayList<>();
    }
    public void randomizeContainer(){
        if(isRandomize){
            Collections.shuffle(container);
        }

    }
    public void addStage(Stage s){
        container.add(s);
    }
    public void addVasStageContainer(String title, String lowAnchorText, String highAnchorText,
                            int lowAnchorValue, int highAnchorValue, String buttonText,
                            String content, String helpText, boolean isSwap, boolean alert){

        Vas stage = new Vas(title, lowAnchorText, highAnchorText,
                lowAnchorValue, highAnchorValue, buttonText, content,
                helpText, isSwap, alert);

        container.add(stage);
    }

    public void addGlmsStageContainer(String question, String buttonText, String content,
                             String helpText, boolean alert){

        gLMS stage = new gLMS(question, buttonText, content, helpText, alert);

        container.add(stage);
    }

    public void countMinTime(){
        Timer timer = new Timer("Minimum Time is",String.valueOf(minTime));
        timer.start();
    }
    public void showContainer(){
        ArrayList<Object> show = new ArrayList<>(container);
        if (isRandomize){
            Collections.shuffle(show);
            StringBuilder sb = new StringBuilder();
            for(Object o : show){
                sb.append(o.toString()).append("\n");
            }
            System.out.println(sb);
        }
    }

    public void setMinTime(int minTime) {
        this.minTime = minTime;
    }

    public boolean isRandomize() {
        return isRandomize;
    }

    public void setRandomize(boolean randomize) {
        isRandomize = randomize;
    }

    public long getMinTime() {
        return minTime;
    }

    public void setContainer(ArrayList<Stage> container) {
        this.container = container;
    }

    public ArrayList<Stage> getContainer() {
        return container;
    }
    public String stageToString(){
        StringBuilder sb = new StringBuilder();
        for(Object s : container){
            sb.append(s.toString()).append("\n");
        }
        return  sb.toString();
    }
    public String toString(){
        return "ratingsContainer(\"" + isRandomize + "\",\"" + minTime +"\")\n" +
                stageToString()+"endRatingsContainer()";

    }


}
