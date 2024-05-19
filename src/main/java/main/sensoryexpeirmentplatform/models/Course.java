package main.sensoryexpeirmentplatform.models;

import java.time.Duration;

public class Course extends Stage {
    private String buttonText, helpText;
    private String endStatement;
    private int refillWeight;
    private Duration duration;
    private int quantity;
    public Course(String title, String content,String buttonText, int refillWeight, long duration, int quantity, String helpText,String endStatement){
        super(title, content);
        this.buttonText = buttonText;
        this.refillWeight = refillWeight;
        this.duration = Duration.ofSeconds(duration);
        this.quantity = quantity;
        this.helpText = helpText;
        this.endStatement = endStatement;
    }
    //Default
    public Course(String title, String content){
        super(title, content);
        refillWeight = -1;
        duration = Duration.ofSeconds(5000);
        quantity = 1000; //grams
        helpText = "Please remember while eating:\n" +
                "Do not leave your fork in the bowl at any time: if you want to put your fork down, please use the small plate provided. " +
                "\nPlease also do not lean on the placemat.\n" +
                "Click on Meal Finished ONLY when you are sure you have had enough food.";
        buttonText = "Finished";
        endStatement = "End session";
    }
    public void show(){
        System.out.println("Title: " + title);
        System.out.println("content: " + content);
        System.out.println("buttonText: " + buttonText);
        System.out.println("duration: " + duration.getSeconds() +" seconds");
        System.out.println("Quantity consume: "+ quantity +" grams");
        System.out.println("helpText: " + helpText);
        System.out.println("endStatement: " + endStatement);

    }
    public String getButtonText() {
        return buttonText;
    }

    public void setButtonText(String buttonText) {
        this.buttonText = buttonText;
    }

    public String getHelpText() {
        return helpText;
    }

    public void setHelpText(String helpText) {
        this.helpText = helpText;
    }

    public String getEndStatement() {
        return endStatement;
    }

    public void setEndStatement(String endStatement) {
        this.endStatement = endStatement;
    }

    public int getRefillWeight() {
        return refillWeight;
    }

    public void setRefillWeight(int refillWeight) {
        this.refillWeight = refillWeight;
    }

    public long getDurationInSecond() {
        return duration.toSeconds();
    }

    public void setDuration(long duration) {
        this.duration = Duration.ofSeconds(duration);
    }
    public static void main(String[] args){
        Course course = new Course("Eating stage", "content","next",1000, -1,9000, "help",
                "Please stop eating");
        course.show();
    }
}
