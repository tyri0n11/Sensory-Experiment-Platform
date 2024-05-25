package main.sensoryexperimentplatform.models;

public class Vas extends Stage {
    private String lowAnchorText, highAnchorText, helpText, buttonText ;
    private double lowAnchorValue, highAnchorValue;
    private double result;
    private boolean alert, isSwap;

    public Vas(String title, String lowAnchorText, String highAnchorText,
               double lowAnchorValue, double highAnchorValue, String buttonText,
               String content, String helpText, boolean isSwap, boolean alert) {

        super(title,content);
        this.lowAnchorValue = lowAnchorValue;
        this.highAnchorValue = highAnchorValue;
        this.lowAnchorText = lowAnchorText;
        this.highAnchorText = highAnchorText;
        this.buttonText = buttonText;
        this.helpText = helpText;
        this.isSwap = isSwap;
        this.alert = alert;
        initialize();
    }

    public Vas(String title, String content){
        super(title, content);
        this.lowAnchorValue = 0;
        this.highAnchorValue = 100;
        this.lowAnchorText = "Not at all";
        this.highAnchorText = "Extremely";
        this.buttonText = "Continue";
        this.isSwap = false;
        this.helpText = "help text";
        this.alert = false;
        initialize();
    }
    private void initialize(){
        this.result = 0;
    }
    public void swapPolarities(){
        //swap values
        while(isSwap){
            double temp = getLowAnchorValue();
            setLowAnchorValue(getHighAnchorValue());
            setHighAnchorValue(temp);
            //swap text
            String tempStr = lowAnchorText;
            setLowAnchorText(getHighAnchorText());
            setHighAnchorText(tempStr);
        }
    }

    public boolean getAlert() {
        return alert;
    }

    public void setAlert(boolean alert) {
        this.alert = alert;
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

    public boolean getIsSwap() {
        return isSwap;
    }

    public void setSwap(boolean swap) {
        isSwap = swap;
    }

    public void setLowAnchorValue(double lowAnchorValue) {
        this.lowAnchorValue = lowAnchorValue;
    }

    public void setHighAnchorValue(double highAnchorValue) {
        this.highAnchorValue = highAnchorValue;
    }

    public double getLowAnchorValue() {
        return lowAnchorValue;
    }

    public double getHighAnchorValue() {
        return highAnchorValue;
    }

    public String getLowAnchorText(){
        return lowAnchorText;
    }

    public String getHighAnchorText(){
        return  highAnchorText;
    }

    public void setLowAnchorText(String string) {
        this.lowAnchorText = string;
    }

    public void setHighAnchorText(String string) {
        this.highAnchorText = string;
    }
    public void setResult(double result){this.result = result;}
    public double getResult(){return result;}

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    @Override
    public String toString() {
        return "vasStage(\"" + title + "\",\"" + lowAnchorText + "\",\""+
                highAnchorText + "\",\"" + lowAnchorValue + "\",\"" +
                highAnchorValue + "\",\"" + buttonText + "\",\"" +
                content + "\",\"" + helpText + "\",\"" + isSwap + "\",\"" +
                alert +"\")";
    }

}

