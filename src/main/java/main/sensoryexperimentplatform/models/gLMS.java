package main.sensoryexperimentplatform.models;

public class gLMS extends Stage implements containerObject{
    private String title;
    private String questionText;
    private String buttonText;
    private boolean response;
    private String helpText, conducted;
    private double result;
    private boolean alert;

    public gLMS(String title, String content){
        super(title,content);
        //default
        this.questionText = title;
        buttonText = "";
        response = false;
        this.helpText = "";
    }
    public gLMS(String title, String buttonText, String content, String helpText, boolean alert){
        super(title,content);
        this.title = title;
        this.questionText = title;
        this.buttonText = buttonText;
        this.helpText = helpText;
        this.alert = alert;
        result=0;
    }
    public void setAlert(boolean s){
        this.alert =s;
    }
    public void setResult(double result){
        this.result = result;
    }

    public double getResult() {
        return result;
    }

    public String getQuestionText() {
        return questionText;
    }
    public boolean getAlert(){
        return alert;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public String getButtonText() {
        return buttonText;
    }

    public void setButtonText(String buttonText) {
        this.buttonText = buttonText;
    }

    public boolean isResponse() {
        return response;
    }

    public void setResponse(boolean response) {
        this.response = response;
    }

    public String getHelpText() {
        return helpText;
    }

    public void setHelpText(String helpText) {
        this.helpText = helpText;
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
    public String getType(){
        return "GLMS";
    }
    @Override
    public String toString() {
        return "glmsStage(\"" + title + "\",\"" + buttonText + "\",\"" +
                content + "\",\""+ helpText + "\",\"" + alert + "\")";
    }

    public void setConducted(String currentFormattedTime) {
        this.conducted = currentFormattedTime;
    }
    public String getConducted(){
        return conducted;
    }


}




