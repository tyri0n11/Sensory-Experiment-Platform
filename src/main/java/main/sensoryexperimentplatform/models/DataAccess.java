package main.sensoryexperimentplatform.models;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataAccess {
    private static final String saveFilePath = "Data/Saving";
    private static final String loadFilePath = "src/main/java/main/sensoryexperimentplatform/models/Data/SIBG_Screener_2019_20";
    public DataAccess(){

    }
    public static void saveData(ArrayList<Experiment> experiments) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(saveFilePath, false));
        for(Experiment e : experiments){
            writer.write(e.toString());
            writer.newLine();
        }
        writer.close();
    }

    public static Experiment getExperimentIndividually() throws IOException {
        Experiment currentExperiment = new Experiment("null","null","null","null","null");

        try (BufferedReader reader = new BufferedReader(new FileReader(loadFilePath))) {
            String line;
            RatingContainer rc = null;
            boolean isContainer = false;

            while ((line = reader.readLine()) != null) {
                if (line.startsWith("ExperimentName:")) {
                    currentExperiment.setExperimentName(line.split(": ")[1].trim());

                } else if (line.startsWith("ExperimenterName:")) {
                    currentExperiment.setCreatorName(line.split(": ")[1].trim());

                } else if (line.startsWith("Version:")) {
                    currentExperiment.version = line.split(": ")[1].trim();

                } else if (line.startsWith("startExperiment:")) {
                    Pattern patternExperiment = Pattern.compile("startExperiment\\(\"(.*?)\",\"(.*?)\",\"(.*?)\"\\)");
                    Matcher matcher = patternExperiment.matcher(line);

                    if (matcher.find()) {
                        currentExperiment.setDescription(matcher.group(1));
                        currentExperiment.setNote(matcher.group(3));
                    }
                } else if (line.startsWith("noticeStage")) {
                    Pattern noticePattern = Pattern.compile("noticeStage\\(\"([^\"]*?)\",\"([^\"]*?)\",\"([^\"]*?)\",\"([^\"]*?)\",\"([^\"]*?)\"\\)");
                    Matcher matcher = noticePattern.matcher(line);

                    if (matcher.find()) {
                        currentExperiment.addNoticeStage(matcher.group(1),
                                matcher.group(2),
                                matcher.group(3),
                                matcher.group(4),
                                Boolean.parseBoolean(matcher.group(5))
                        );
                    }
                } else if (line.startsWith("inputStage")) {
                    Pattern inputPattern = Pattern.compile("inputStage\\(\"(.*?)\",\"(.*?)\",\"(.*?)\",\"(.*?)\"\\)");
                    Matcher matcher = inputPattern.matcher(line);

                    if (matcher.find()) {
                        currentExperiment.addInputStage(matcher.group(1), matcher.group(2), matcher.group(3), Boolean.parseBoolean(matcher.group(4)));
                    }
                } else if (line.startsWith("wait")) {
                    Pattern timerPattern = Pattern.compile("wait\\(\"(.*?)\",\"(.*?)\",\"(.*?)\"\\)");
                    Matcher matcher = timerPattern.matcher(line);

                    if (matcher.find()) {
                        currentExperiment.addTimerStage(matcher.group(1),
                                matcher.group(2),
                                Boolean.parseBoolean(matcher.group(3))
                        );
                    }
                } else if (line.startsWith("vasStage")) {
                    Pattern vasPattern = Pattern.compile("vasStage\\(\"(.*?)\",\"(.*?)\",\"(.*?)\",\"(.*?)\",\"(.*?)\",\"(.*?)\",\"(.*?)\",\"(.*?)\",\"(.*?)\",\"(.*?)\"\\)");
                    Matcher matcher = vasPattern.matcher(line);

                    if (matcher.find()) {
                        if (isContainer && rc != null) {
                            rc.addVasStageContainer(matcher.group(1),
                                    matcher.group(2),
                                    matcher.group(3),
                                    Integer.parseInt(matcher.group(4)),
                                    Integer.parseInt(matcher.group(5)),
                                    matcher.group(6),
                                    matcher.group(7),
                                    matcher.group(8),
                                    Boolean.parseBoolean(matcher.group(9)),
                                    Boolean.parseBoolean(matcher.group(10))
                            );
                        } else {
                            currentExperiment.addVasStage(matcher.group(1),
                                    matcher.group(2),
                                    matcher.group(3),
                                    Integer.parseInt(matcher.group(4)),
                                    Integer.parseInt(matcher.group(5)),
                                    matcher.group(6),
                                    matcher.group(7),
                                    matcher.group(8),
                                    Boolean.parseBoolean(matcher.group(9)),
                                    Boolean.parseBoolean(matcher.group(10))
                            );
                        }
                    }
                } else if (line.startsWith("glmsStage")) {
                    Pattern glmsPattern = Pattern.compile("glmsStage\\(\"(.*?)\",\"(.*?)\",\"(.*?)\",\"(.*?)\",\"(.*?)\"\\)");
                    Matcher matcher = glmsPattern.matcher(line);

                    if (matcher.find()) {
                        if (isContainer && rc != null) {
                            rc.addGlmsStageContainer(matcher.group(1),
                                    matcher.group(2),
                                    matcher.group(3),
                                    matcher.group(4),
                                    Boolean.parseBoolean(matcher.group(5))
                            );
                        } else {
                            currentExperiment.addGlmsStage(matcher.group(1),
                                    matcher.group(2),
                                    matcher.group(3),
                                    matcher.group(4),
                                    Boolean.parseBoolean(matcher.group(5))
                            );
                        }
                    }
                } else if (line.startsWith("questionStage")) {
                    Pattern questionPattern = Pattern.compile("questionStage\\(\"(.*?)\",\"(.*?)\",\"(.*?)\",\"(.*?)\"\\)");
                    Matcher matcher = questionPattern.matcher(line);

                    if (matcher.find()) {
                        currentExperiment.addQuestionStage(matcher.group(1),
                                matcher.group(2),
                                matcher.group(3),
                                Boolean.parseBoolean(matcher.group(4))
                        );
                    }
                } else if (line.startsWith("ratingsContainer")) {
                    Pattern ratingsContainerPattern = Pattern.compile("ratingsContainer\\(\"(.*?)\",\"(.*?)\"\\)");
                    Matcher matcher = ratingsContainerPattern.matcher(line);

                    isContainer = true;
                    if (matcher.find()) {
                        currentExperiment.addRatingContainerStage(Boolean.parseBoolean(matcher.group(1)),
                                Integer.parseInt(matcher.group(2))
                        );
                        rc = (RatingContainer) currentExperiment.getStages().getLast();
                    }
                } else if (line.startsWith("endRatingsContainer")) {
                    rc = null;
                    isContainer = false;
                } else if (line.startsWith("endExperiment()")) {
                    return currentExperiment;
                }
            }
        }
        return currentExperiment;
    }

    public static ArrayList<Experiment> importExperiment() throws Exception{
        ArrayList<Experiment> experiments = new ArrayList<>();
        Experiment currentExperiment = null;
        RatingContainer rc = null;
        boolean isContainer = false;
        String line;
        //notice, input, timer, vas, glms, question, rating container, course

        try(BufferedReader reader = new BufferedReader(new FileReader(loadFilePath))){
            while ((line = reader.readLine()) != null ){
                if(line.startsWith("ExperimentName")){
                    currentExperiment = new Experiment(null,null,null,null,null);
                    currentExperiment.setExperimentName(line.split(": ")[1].trim());

                }
                else if (line.startsWith("ExperimenterName") && currentExperiment != null){
                    currentExperiment.setCreatorName(line.split(": ")[1].trim());

                }
                else if (line.startsWith("startExperiment")){
                    Pattern patternExperiment = Pattern.compile("startExperiment\\(\"(.*?)\",\"(.*?)\",\"(.*?)\"\\)");
                    Matcher matcher = patternExperiment.matcher(line);
                    if(matcher.find()){
                        currentExperiment.setDescription(matcher.group(1));
                        currentExperiment.setNote(matcher.group(3));

                    }

                }else if (line.startsWith("noticeStage")){
                    Pattern noticePattern = Pattern.compile("noticeStage\\(\"(.*?)\",\"(.*?)\",\"(.*?)\",\"(.*?)\",\"(.*?)\"\\)");
                    Matcher matcher = noticePattern.matcher(line);

                    if(matcher.find() ){
                        currentExperiment.addNoticeStage(matcher.group(1),matcher.group(2), matcher.group(3),
                                matcher.group(4), Boolean.parseBoolean(matcher.group(5)));

                    }

                }else if (line.startsWith("inputStage")){
                    Pattern inputPattern = Pattern.compile("inputStage(\"(.*?)\",\"(.*?)\",\"(.*?)\",\"(.*?)\")");
                    Matcher matcher = inputPattern.matcher(line);

                    if (matcher.find()){
                        currentExperiment.addInputStage(matcher.group(1), matcher.group(2), matcher.group(3),
                                Boolean.parseBoolean(matcher.group(4)));
                    }

                }else if (line.startsWith("wait")){
                    Pattern timerPattern = Pattern.compile("wait\\(\"(.*?)\",\"(.*?)\",\"(.*?)\"\\)");
                    Matcher matcher = timerPattern.matcher(line);

                    if (matcher.find()){
                        currentExperiment.addTimerStage(matcher.group(1), matcher.group(2), Boolean.parseBoolean(matcher.group(3)));
                    }

                }else if (line.startsWith("vasStage")){
                    Pattern vasPattern = Pattern.compile("vasStage\\(\"(.*?)\",\"(.*?)\",\"(.*?)\",\"(.*?)\",\"(.*?)\",\"(.*?)\",\"(.*?)\",\"(.*?)\",\"(.*?)\",\"(.*?)\"\\)");
                    Matcher matcher = vasPattern.matcher(line);

                    if (matcher.find()){
                        if(isContainer && rc != null){
                            rc.addVasStageContainer(matcher.group(1), matcher.group(2), matcher.group(3),
                                    Integer.parseInt(matcher.group(4)), Integer.parseInt(matcher.group(5)),
                                    matcher.group(6),matcher.group(7), matcher.group(8),
                                    Boolean.parseBoolean(matcher.group(9)),Boolean.parseBoolean(matcher.group(10)));
                        }else {
                            currentExperiment.addVasStage(matcher.group(1), matcher.group(2), matcher.group(3),
                                    Integer.parseInt(matcher.group(4)), Integer.parseInt(matcher.group(5)),
                                    matcher.group(6),matcher.group(7), matcher.group(8),
                                    Boolean.parseBoolean(matcher.group(9)),Boolean.parseBoolean(matcher.group(10)));

                        }
                    }

                }else if (line.startsWith("glmsStage")){
                    Pattern glmsPattern = Pattern.compile("glmsStage\\(\"(.*?)\",\"(.*?)\",\"(.*?)\",\"(.*?)\",\"(.*?)\"\\)");
                    Matcher matcher = glmsPattern.matcher(line);

                    if (matcher.find()){
                        if(isContainer && rc != null){
                            rc.addGlmsStageContainer(matcher.group(1), matcher.group(2), matcher.group(3),
                                    matcher.group(4), Boolean.parseBoolean(matcher.group(5)));
                        }else{
                            currentExperiment.addGlmsStage(matcher.group(1), matcher.group(2), matcher.group(3),
                                    matcher.group(4), Boolean.parseBoolean(matcher.group(5)));
                        }

                    }

                }else if (line.startsWith("questionStage")){
                    Pattern questionPattern = Pattern.compile("questionStage\\(\"(.*?)\",\"(.*?)\",\"(.*?)\",\"(.*?)\"\\)");
                    Matcher matcher = questionPattern.matcher(line);

                    if (matcher.find()){
                        currentExperiment.addQuestionStage(matcher.group(1), matcher.group(2), matcher.group(3),
                                Boolean.parseBoolean(matcher.group(4)));

                    }

                }else if (line.startsWith("ratingsContainer")){
                    Pattern ratingsContainerPattern = Pattern.compile("ratingsContainer\\(\"(.*?)\",\"(.*?)\"\\)");
                    Matcher matcher = ratingsContainerPattern.matcher(line);

                    isContainer = true;

                    if(matcher.find()){
                        currentExperiment.addRatingContainerStage(Boolean.parseBoolean(matcher.group(1)), Integer.parseInt(matcher.group(2)));
                        rc = (RatingContainer) currentExperiment.getStages().getLast();
                    }

                }else if(line.startsWith("endRatingsContainer")){
                    rc = null;
                    isContainer = false;

                }else if(line.startsWith("endExperiment()")){
                    /*current_user.addExperiment(currentExperiment);*/
                    currentExperiment = null;

                }
            }
            return experiments;
        }
    }

    /*public static ArrayList<Experiment> loadExperiments() throws Exception {
        ArrayList<Experiment> experiments = new ArrayList<>();
        Experiment currentExperiment = null;
        try (BufferedReader reader = new BufferedReader(new FileReader(loadFilePath))) {
            String line;
            String currentExperimentName = null;

            while ((line = reader.readLine()) != null) {
                if (line.startsWith("ExperimentName")) {
                    currentExperimentName = line.split(": ")[1].trim(); // Extract and store ExperimentName
                }
                else if (line.startsWith("ExperimenterName") && currentExperimentName != null) {
                    String experimenterName = line.split(": ")[1].trim(); // Extract ExperimenterName
                    String[] txtExperiment = {experimenterName, currentExperimentName};

                    currentExperiment = new Experiment(txtExperiment[0], txtExperiment[1], null, null);
                    experiments.add(currentExperiment);

                }else if (line.startsWith("noticeStage")) {
                    Pattern pattern = Pattern.compile("noticeStage\\(\"(.*?)\",\"(.*?)\"\\)");
                    Matcher matcher = pattern.matcher(line);

                    if(matcher.find()){
                        currentExperiment.addNotice(matcher.group(1), matcher.group(2));
                    }
                }
                else if (line.startsWith("glmsStage")) {
                    Pattern pattern = Pattern.compile("glmsStage\\(\"(.*?)\",\"(.*?)\"\\)");
                    Matcher matcher = pattern.matcher(line);

                    if(matcher.find()){
                        currentExperiment.addgLMS(matcher.group(1), matcher.group(2));
                    }
                }
                else if (line.startsWith("vasStage")) {
                    Pattern pattern = Pattern.compile("vasStage\\(\"(.*?)\",\"(.*?)\"\\)");
                    Matcher matcher = pattern.matcher(line);

                    if(matcher.find()){
                        currentExperiment.addVas(matcher.group(1), matcher.group(2));
                    }
                }
                else if (line.startsWith("inputStage")) {
                    Pattern pattern = Pattern.compile("inputStage\\(\"(.*?)\",\"(.*?)\"\\)");
                    Matcher matcher = pattern.matcher(line);

                    if(matcher.find()){
                        currentExperiment.addInput(matcher.group(1), matcher.group(2));
                    }
                }
                *//*else if (line.startsWith("Models.Timer")) {
                    Pattern pattern = Pattern.compile("timerStage\\(\"(.*?)\\)");
                    Matcher matcher = pattern.matcher(line);

                    if(matcher.find()){
                        Duration elapsedTime = Duration.parse(matcher.group(1));
                        currentExperiment.loadElapsedTime(elapsedTime);
                    }

                }*//*
                else if (line.startsWith("questionStage")) {
                    Pattern pattern = Pattern.compile("inputStage\\(\"(.*?)\",\"(.*?)\"\\)");
                    Matcher matcher = pattern.matcher(line);

                    if(matcher.find()){
                        currentExperiment.addQues(matcher.group(1), matcher.group(2));
                    }
                }
            }
            return experiments;
        }
    }*/
    public static void createExcelFile(String volunteer) throws FileNotFoundException {

        FileOutputStream fos = new FileOutputStream(volunteer + ".csv", true);
        PrintWriter pw = new PrintWriter(fos);
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("E-MMM d-yyyy");
        String strDate = format.format(date);
        String strTime = "100";
        String strSubject = "SenseXP";
        String strResponse = Integer.toString(111);
        String strCorrect = Integer.toString(222);
        String strLatency = Integer.toString(333);
        pw.println("date, time, subject, response, correct, latency");
        pw.println(strDate + "," + strTime + "," + strSubject + "," + strResponse
                    + "," + strCorrect + "," + strLatency);
        pw.close();

        System.out.println("new file is created!!");
    }

}


