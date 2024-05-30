package main.sensoryexperimentplatform.models;

import java.util.ArrayList;
import java.util.Arrays;

public class TasteTest{
    private final String question;
    private final String consumptionInstruction;
    private final String endInStruction;
    private final ArrayList<String> foods;
    private final ArrayList<Object> list;
    private final Notice initialNotice;
    private int timeWait;
    boolean randomizeFood, randomizeRatingVas, randomizeRatingGLMS;
    private final ArrayList<String> vasList;
    private final ArrayList<String> glmsList;
    private final Vas sampleVas;
    private final gLMS sampleGLMS;
    public Vas returnsampleVas(){
        return sampleVas;
    }
    public gLMS getSampleGLMS(){
        return sampleGLMS;
    }

    public boolean isRandomizeFood() {
        return randomizeFood;
    }

    public boolean isRandomizeRatingVas() {
        return randomizeRatingVas;
    }

    public boolean isRandomizeRatingGLMS() {
        return randomizeRatingGLMS;
    }

    public void setRandomizeRatingGLMS(boolean randomizeRatingGLMS) {
        this.randomizeRatingGLMS = randomizeRatingGLMS;
    }

    public void setRandomizeRatingVas(boolean randomizeRatingVas) {
        this.randomizeRatingVas = randomizeRatingVas;
    }

    public void setRandomizeFood(boolean randomizeFood) {
        this.randomizeFood = randomizeFood;
    }

    public TasteTest(String noticeStageContent, String consumptionInstruction, String question,
                     String lowAnchorText, String highAnchorText, int lowAnchorValue,
                     int highAnchorValue, String buttonText,
                     boolean isSwap, String helpText, String endInstruction,
                     int timeWait, boolean randomizeFood, boolean randomizeRatingVas, boolean randomizeRatingGLMS){

        this.initialNotice = new Notice("Taste Test",noticeStageContent, buttonText, "", false);
        initialNotice.setContent(noticeStageContent);
        this.sampleVas = new Vas(question, lowAnchorText, highAnchorText, lowAnchorValue, highAnchorValue,
                "Next", "",helpText,isSwap,false);
        this.sampleGLMS = new gLMS(question,"Next","","",false);
        this.question = question;
        this.consumptionInstruction = consumptionInstruction;
        this.endInStruction = endInstruction;
        this.timeWait = timeWait;
        this.randomizeFood =  randomizeFood;
        this.randomizeRatingVas = randomizeRatingVas;
        this.randomizeRatingGLMS = randomizeRatingGLMS;
        foods = new ArrayList<>();
        list = new ArrayList<>();
        vasList = new ArrayList<>();
        glmsList = new ArrayList<>();
        list.add(initialNotice);

    }
    public void selectVas(String[] selectedVas){
        vasList.addAll(Arrays.asList(selectedVas));
    }
    public void selectgLMS(String[] selectedGLMS){
        glmsList.addAll(Arrays.asList(selectedGLMS));
    }

    public void addFood(String[] foods){
        this.foods.addAll(Arrays.asList(foods));
    }

    public int getTimeWait() {
        return timeWait;
    }
    public void setTime(int time){
        this.timeWait = time;
    }
    public void generator(){
        for(String foodName : foods){
            String convertedConsumption = consumptionInstruction.replace("<food>","%s");
            String consumption = String.format(convertedConsumption, foodName);

            Notice notice1 = new Notice("Taste Test",consumption, initialNotice.getButtonText(), "",false);
            notice1.setContent(consumption);
            list.add(notice1);

            Food currentFood = new Food(foodName,randomizeRatingVas,randomizeRatingGLMS,timeWait);
            for(String taste : vasList){
                Vas temp = getVas(foodName, taste);
                currentFood.addVasRating(temp);
            }
            for(String taste : glmsList){
                gLMS temp = getGLMS(foodName,taste);
                currentFood.addGlmsRating(temp);
                }

            list.add(currentFood);
            Notice notice2 = new Notice("Rinsing", endInStruction, initialNotice.getButtonText(), "", false);
            list.add(notice2);

            }
        }
    private gLMS getGLMS(String foodName, String taste){
        String convertedQuestion = question.replace("<taste>","%s").replace("<food>","%s");
        convertedQuestion = String.format(convertedQuestion, taste, foodName);

        return new gLMS(convertedQuestion, sampleGLMS.getButtonText(), sampleGLMS.getContent(),
                sampleGLMS.getHelpText(), sampleGLMS.getAlert());
    }
    private Vas getVas(String foodName, String taste) {
        String convertedQuestion = question.replace("<taste>","%s").replace("<food>","%s");
        convertedQuestion = String.format(convertedQuestion, taste, foodName);

        String convertedLowAnchor = sampleVas.getLowAnchorText().replace("<taste>","%s");
        convertedLowAnchor = String.format(convertedLowAnchor, taste);

        String convertedHighAnchor = sampleVas.getHighAnchorText().replace("<taste>","%s");
        convertedHighAnchor = String.format(convertedHighAnchor, taste);

        return new Vas(convertedQuestion, convertedLowAnchor,convertedHighAnchor,
                sampleVas.getLowAnchorValue(), sampleVas.getHighAnchorValue(), sampleVas.getButtonText(),
                sampleVas.getContent(),sampleVas.getHelpText(), sampleVas.getIsSwap(), sampleVas.getAlert());
    }
    public String getType(){
        return "Taste Test";
    }

    public String toString(){
            StringBuilder stringBuilder = new StringBuilder();
            for(Object o : list){
                stringBuilder.append(o.toString()).append("\n");
            }return stringBuilder.toString();
        }
    public static void main(String[] args){
        Experiment experiment = new Experiment();
        experiment.addTasteTest("For the taste test, samples of simple solutions are presented for you to evaluate. Note you will complete one set of ratings, have a short (2 minute) pause and then complete a second set of ratings.____" +
                        "When prompted by the computer please take the relevant sample.You will be asked to place all of the solution in your mouth, swirl it around while counting to 10 and then expectorate (spit) into the black cup we provide." +
                        " A reminder to rinse your mouth with the water provided (maximum 1-2 sips) and then to expectorate (spit) it into the black cup, will follow the ratings of each sample.",
                "Please empty <food> in your mouth, swirl it around while counting to 10, and then expectorate it into the black cup.",
                "How <taste> is <food>?",
                "Not at all <taste>", "Extremely <taste>",
                0,100,"Continue" , false, "",
                "Please rinse your mouth with the water provided and then expectorate it into the black cup.", 0,
                false,true,true);
        TasteTest tasteTest = (TasteTest) experiment.stages.getFirst();
        String[] foods = {"apple", "banana"};
        String[] vass = {"bit", "pleasant", "tough", "insane"};
        String[] glmss ={"spicy", "flavour", "salty", "creamy"};
        tasteTest.selectVas(vass);
        tasteTest.addFood(foods);
        tasteTest.selectgLMS(glmss);
        tasteTest.generator();
        System.out.println(experiment.stages.toString());
    }
}
