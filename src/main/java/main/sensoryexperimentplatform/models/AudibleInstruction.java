package main.sensoryexperimentplatform.models;

public class AudibleInstruction extends Stage{
    private String title, content;
    public AudibleInstruction(String title, String content){
        super(title,content);
        this.title = title;
        this.content = content;
    }
}
