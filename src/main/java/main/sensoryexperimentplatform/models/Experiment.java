package main.sensoryexperimentplatform.models;

import javafx.scene.paint.Color;
import org.controlsfx.control.Rating;

import java.util.*;

public class Experiment {
    private String creatorName, experimentName, description, note, created_date;
    public int version, number_of_results, id, elapsedTime;
    ArrayList<Object> stages;
    List<Pair<Stage,Integer>> pairs;
    public Experiment(){
        super();
        Random random = new Random();
        this.id = random.nextInt(999);
        stages = new ArrayList<>();
        version = 1;
        elapsedTime= 0;
//       // start = new Start("default","default","default",
//                false,null, null,
//                0,100,null);
        this.created_date = DataAccess.getCurrentFormattedDate();
    }

    public Experiment(String creatorName, String experimentName, String description, String note, int version, int id, String created_date) {
        this.creatorName = creatorName;
        this.experimentName = experimentName;
        this.description = description;
        this.note = note;
        this.version = version;
        this.id = id;
        this.created_date = created_date;
        stages = new ArrayList<>();
        elapsedTime = 0;
        //start = new Start("default","default","default",false,null, null,0,100,null);
    }
    public Experiment(Experiment selectedExperiment) {
        this.creatorName = selectedExperiment.getCreatorName();
        this.experimentName = selectedExperiment.getExperimentName();
        this.description = selectedExperiment.getDescription();
        this.note = selectedExperiment.getNote();
        this.version = selectedExperiment.getVersion();
        this.id = selectedExperiment.getId();
        this.created_date = selectedExperiment.getCreated_date();
        elapsedTime= 0;
        stages = new ArrayList<>();
        for (Object o : selectedExperiment.getStages()) {
            if(o instanceof Start){
                Start temp = new Start((Start) o);
                stages.add(temp);
            }
            if (o instanceof Vas) {
                Vas temp = new Vas((Vas) o);
                stages.add(temp);
            }
            if (o instanceof gLMS) {
                gLMS temp = new gLMS((gLMS) o);
                stages.add(temp);
            }
            if (o instanceof RatingContainer) {
                RatingContainer ratingContainer = new RatingContainer((RatingContainer) o);
                stages.add(ratingContainer);
            }
            if (o instanceof AudibleInstruction) {
                AudibleInstruction audibleInstruction = new AudibleInstruction((AudibleInstruction) o);
                stages.add(audibleInstruction);
            }
            if(o instanceof Notice) {
                Notice temp = new Notice((Notice) o);
                stages.add(temp);
            }if(o instanceof Timer) {
                Timer temp = new Timer((Timer) o);
                stages.add(temp);}
        }
    }

    public void addNoticeStage(String title, String content, String buttonText,
                               String helpText, boolean alert){

        Notice stage = new Notice(title,content,buttonText,helpText, alert);

        stages.add(stage);
    }
    public void addInputStage(String title, String content, String buttonText, boolean alert){
        Input stage = new Input(title, content, buttonText, alert);

        stages.add(stage);
    }
    public void addTimerStage(String instruction, String timeWait, boolean alert){
        Timer stage = new Timer(instruction,timeWait, alert);

        stages.add(stage);
    }
    public void addVasStage (Vas vas){
        stages.add(vas);
    }
    public void addGlmsStage(gLMS gLMS){
        stages.add(gLMS);
    }
    public void addNoticeStage(Notice notice){
        stages.add(notice);
    }
    public void addTimerStage (Timer timer){
        stages.add(timer);
    }
    public void addVasStage(String title, String lowAnchorText, String highAnchorText,
                            int lowAnchorValue, int highAnchorValue, String buttonText,
                            String content, String helpText, boolean isSwap, boolean alert){

        Vas stage = new Vas(title, lowAnchorText, highAnchorText,
                lowAnchorValue, highAnchorValue, buttonText, content,
                helpText, isSwap, alert);

        stages.add(stage);
    }

    public void addGlmsStage(String question, String buttonText, String content,
                             String helpText, boolean alert){

        gLMS stage = new gLMS(question, buttonText, content, helpText, alert);

        stages.add(stage);
    }

    public void addQuestionStage(String question, String buttonText,
                                 String helpText, boolean alert){

        Question stage = new Question(question, buttonText, helpText, alert);

        stages.add(stage);
    }
    public void addRatingContainerStage(boolean isRandomize, int time){
        RatingContainer container = new RatingContainer(isRandomize,time);
        stages.add(container);
    }
    public void addRatingContainerStage(RatingContainer ratingContainer){
        stages.add(ratingContainer);
    }
    public void addTasteTest(String noticeStageContent, String consumptionInstruction, String question,
                             String lowAnchorText, String highAnchorText, int lowAnchorValue,
                             int highAnchorValue, String buttonText,
                             boolean isSwap, String helpText, String endInstruction,
                             int timeWait, boolean randomizeFood, boolean randomizeRatingVas, boolean randomizeRatingGLMS){
        TasteTest tasteTest = new TasteTest( noticeStageContent,  consumptionInstruction,  question,
                 lowAnchorText,  highAnchorText,  lowAnchorValue,highAnchorValue,  buttonText, isSwap,  helpText,  endInstruction,
         timeWait,  randomizeFood,  randomizeRatingVas,  randomizeRatingGLMS);
        stages.add(tasteTest);
    }
    // Audible instruction stage

    public void addAudibleInstruction(String title, String content, String buttonText, String helpText,String soundName) {
        AudibleInstruction temp = new AudibleInstruction(title, content, buttonText, helpText,soundName);
        stages.add(temp);
    }

    //start eating stage
    public void addCourse(String title, String content, String buttonText,
                          int weight, int quantity,long duration,
                          String helpText, String endState){

        Course stage = new Course(title,content,buttonText,
                weight,duration,quantity,helpText,endState);
    }
    public void addCourse (Course course){
        stages.add(course);
    }
    public void addQuestion (Question question){
        stages.add(question);
    }
    public void addAudibleInstruction (AudibleInstruction audibleInstruction){
        stages.add(audibleInstruction);
    }
    public void addInput(Input input){
        stages.add(input);
    }
    public void addConditionalStatement(conditionalStatement ConditionalStatement){
        stages.add(ConditionalStatement);
    }


    public ArrayList<Object> getStages() {
        return stages;
    }

    public void setStages(ArrayList<Object> stages) {
        this.stages = stages;
    }


    public String getCreated_date() {
        return created_date;
    }

    public void setCreated_date(String created_date) {
        this.created_date = created_date;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public int getNumber_of_results() {
        return number_of_results;
    }

    public void setNumber_of_results(int number_of_results) {
        this.number_of_results = number_of_results;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public String getExperimentName() {
        return experimentName;
    }


    public String getNote() {
        return note;
    }

    public String getDescription() {
        return description;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    public void setExperimentName(String experimentName) {
        this.experimentName = experimentName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public void setId(int id){
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public int getVersion() {
        return version;
    }

    public void updateVersion(){
        System.out.println("Version updated successfully");
        version+=1;
    }

    public String stagesToString(){
        StringBuilder sb = new StringBuilder();
        for(Object o : stages){
            sb.append(o.toString()).append("\n");
        }
        return sb.toString();
    }
    @Override
    public String toString() {
        return "ExperimentName: " + experimentName + "\nExperimenterName: " + creatorName +
                "\nExperimentID: "+ id + "\nCreated on: "+ created_date +
                "\nVersion: "+ version + "\n"+
                stagesToString() +"endExperiment()\n";
    }

    public void addStartStage(String title, String content, String buttonText, Boolean requireBalance, Color backGroundColor, Color TextColor
            , long StartOfStageDelay, long EndOfStageDelay, Color disableButtonColor){
        Start stage = new Start(title,
                content,
                buttonText,
                requireBalance,
                backGroundColor,
                TextColor,StartOfStageDelay,
                EndOfStageDelay, disableButtonColor);
        stages.add(stage);
    }
    public void addStartStage(String title, String content, String buttonText){
        Start stage = new Start(title, content,  buttonText, false, null, null, 0, 0, null);
        stages.add(stage);
    }

    public Start getStart() {
        if(stages.isEmpty()){
            return null;
        }
        else {
            return (Start)stages.get(0);
        }
    }

    public void addStart(Start start) {
        stages.add(start);
    }
}