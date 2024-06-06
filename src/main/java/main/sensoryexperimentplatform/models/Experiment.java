package main.sensoryexperimentplatform.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class Experiment {
    private static Integer num = 0;
    private String id, creatorName, experimentName, description, note;
    public int version;
    private boolean isChanged;
    private ArrayList<Vas> vass;
    private ArrayList<gLMS> glmss;
    private ArrayList<Question> quess;
    private ArrayList<Notice> notices;
    private ArrayList<Input> inputs;
    private ArrayList<Timer> timers;
    ArrayList<Object> stages;
    List<Pair<Stage,Integer>> pairs;
    public Experiment(){
        super();
        this.id = UUID.randomUUID().toString();
//        Scanner sc = new Scanner(System.in);
//        System.out.print("Enter the Creator: ");
//        setCreatorName(sc.nextLine());
//        System.out.print("Enter the Experiment Name: ");
//        setExperimentName(sc.nextLine());
//        System.out.print("Enter the Experiment Description: ");
//        setDescription(sc.nextLine());
//        System.out.print("Enter the Additional Notes: ");
//        setNote(sc.nextLine());
        pairs = new ArrayList<>();
        timers = new ArrayList<>();
        notices = new ArrayList<>();
        inputs=new ArrayList<>();
        vass = new ArrayList<>();
        glmss = new ArrayList<>();
        quess = new ArrayList<>();
        stages = new ArrayList<>();
        version = 1;
        isChanged = false;
    }
    public Experiment(String creatorName, String experimentName, String description, String note, int version) {
        this.creatorName = creatorName;
        this.experimentName = experimentName;
        this.description = description;
        this.note = note;
        this.version = version;
        this.id = UUID.randomUUID().toString();
        pairs = new ArrayList<>();
        timers = new ArrayList<>();
        notices = new ArrayList<>();
        inputs=new ArrayList<>();
        vass = new ArrayList<>();
        glmss = new ArrayList<>();
        quess = new ArrayList<>();
        stages = new ArrayList<>();
        isChanged = false;
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
    public void addAudibleInstruction(String title, String content, String buttonText, String helpText){
        AudibleInstruction temp = new AudibleInstruction(title,content, buttonText,helpText);
        stages.add(temp);
    }

    public void addAnyStage(Object o){
        stages.addLast(o);
    }
    //start eating stage
    public void addCourse(String title, String content, String buttonText,
                          int weight, int quantity,long duration,
                          String helpText, String endState){

        Course stage = new Course(title,content,buttonText,
                weight,duration,quantity,helpText,endState);
    }
    public void addNotice(String title, String content) {
        Notice temp = new Notice(title,content);
        this.notices.add(temp);
        pairs.add(new Pair<>(temp, ++num));
        System.out.println("Add Models.Notice is done");
    }
    public void addInput(String title, String content) {
        Input temp = new Input(title, content);
        this.inputs.add(temp);
        pairs.add(new Pair<>(temp, ++num));
        System.out.println(" Add Models.Input is done");
    }
    public void addTimer(String title, String content) {
        Timer temp = new Timer(title,content);
        this.timers.add(temp);
        pairs.add(new Pair<>(temp, ++num));
        System.out.println(" Add Models.Timer stage is done");
    }
    public void addVas(String title, String content) {
        Vas temp = new Vas(title,content);
        this.vass.add(temp);
        pairs.add(new Pair<>(temp, ++num));
        System.out.println("Add Models.Vas is done");
    }
    public void addgLMS(String title, String content) {
        gLMS temp = new gLMS(title,content);
        this.glmss.add(temp);
        pairs.add(new Pair<>(temp, ++num));
        System.out.println("Add Models.gLMS is done");
    }
    public void addQues(String title, String content) {
        Question temp = new Question(title,content);
        this.quess.add(temp);
        pairs.add(new Pair<>(temp, ++num));
        System.out.println("Add Models.Question is done");
    }

    public void show(){
        System.out.println("\n-----------------------The Experiment-----------------------");
        System.out.println("Creator:" + creatorName + "\n Experiment Name: " + experimentName);
        System.out.println("Description:" + description + "\n Additional Note: " + note);
        for (Pair<Stage, Integer> pair: pairs)
        {
            System.out.print(pair.getValue() + ". ");
            System.out.println(pair.getKey().toString());
        }
        System.out.println("-------------------------------------------------------------------");
    }
    public void showStages(){
        System.out.println("\n-----------------------The Experiment-----------------------");
        System.out.println("Creator:" + creatorName + "\n Experiment Name: " + experimentName);
        System.out.println("Description:" + description + "\n Additional Note: " + note +"\n version: "+ version);
        for (Object o : stages)
        {
            System.out.println(o);
        }
        System.out.println("-------------------------------------------------------------------");
    }

    public ArrayList<Object> getStages() {
        return stages;
    }

    public void setStages(ArrayList<Object> stages) {
        this.stages = stages;
    }

    // integer k can thiet
    public List<Pair<Stage, Integer>> getPairs() {
        return pairs;
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
    public String pairsToString(){
        StringBuilder sb = new StringBuilder();

        for(Object o: pairs){
            sb.append(o.toString()).append("\n");
        }
        return sb.toString();
    }
    public void setId(String id){
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public int getVersion() {
        return version;
    }

    public void updateVersion(){
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
        return "ExperimentID: "+ id +"\nExperimentName: " + experimentName + "\nExperimenterName: " + creatorName + "\nVersion: "+ version +
                "\nstartExperiment(\"" + description + "\",\"" + "\",\"" + note + "\")\n"+
                stagesToString() +"endExperiment()\n";
    }


}