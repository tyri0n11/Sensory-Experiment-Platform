package main.sensoryexperimentplatform.models;

public abstract class Stage {
//    String Button_Text = "Continue";
//    Boolean balanceRequire = true;
//    String backgroundColour = "blue";
//    String textColour = "black";
//    String Font = "example";
//    int startDelay = 0;
//    int endDelay = 0;
//    String buttonColour = "white";
    public String title, content;
    public Stage(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
