package main.sensoryexperimentplatform.models;

public class Question extends Stage {
    private String question, buttonText, helpText;
    private boolean alert;

    public Question(String title, String content) {
        super(title, content);
    }

    public Question(String question, String buttonText,
                    String helpText, boolean alert) {
        super(question, buttonText);
        this.question = question;
        this.buttonText = buttonText;
        this.helpText = helpText;
        this.alert = alert;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
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

    public boolean isAlert() {
        return alert;
    }

    public void setAlert(boolean alert) {
        this.alert = alert;
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

    public String getType() {
        return "Question";
    }

    @Override
    public String toString() {
        return "questionStage(\"" + question + "\",\"" + buttonText +
                "\",\"" + helpText + "\",\"" + alert + "\")";
    }
}
