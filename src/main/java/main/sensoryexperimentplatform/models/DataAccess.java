package main.sensoryexperimentplatform.models;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataAccess {
    private static final String saveFilePath = "src/main/java/main/sensoryexperimentplatform/models/Data/Test";
    private static final String loadFilePath = "src/main/java/main/sensoryexperimentplatform/models/Data/Test";
    public static String getCurrentFormattedTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss.SSS");
        Date now = new Date();
        return sdf.format(now);
    }
    public static void saveData(ArrayList<Experiment> experiments) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(saveFilePath, false));
        for(Experiment e : experiments){
            writer.write(e.toString());
            writer.newLine();
        }
        writer.close();
    }

    public static void exportExperiments(String file_path, ArrayList<Experiment> experiments) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(file_path,true));
        for (Experiment e : experiments){
            writer.write(e.toString());
            writer.newLine();
        }
        System.out.println(STR."Saved in \{file_path}");
    }



    public static Experiment getImportedExperiment(String file_path) throws IOException {
        Experiment currentExperiment = new Experiment("default","default","default","default",0,0,"default");

        try (BufferedReader reader = new BufferedReader(new FileReader(file_path))) {
            String line;
            RatingContainer rc = null;
            boolean isContainer = false;

            while ((line = reader.readLine()) != null) {
                if (line.startsWith("ExperimentName")) {
                    currentExperiment.setExperimentName(line.split(": ")[1].trim());

                } else if (line.startsWith("ExperimenterName")) {
                    currentExperiment.setCreatorName(line.split(": ")[1].trim());

                } else if (line.startsWith("ExperimentID:")) {
                    currentExperiment.setId(Integer.parseInt(line.split(": ")[1].trim()));

                } else if (line.startsWith("Created on")) {
                    currentExperiment.setCreated_date(line.split(": ")[1].trim());

                } else if (line.startsWith("Version")) {
                    int version = Integer.parseInt(line.split(": ")[1].trim());
                    currentExperiment.version = version;

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
                    initializeCaches(currentExperiment.getExperimentName(),currentExperiment.getVersion());
                    currentExperiment.setNumber_of_results(DataAccess.countingResults(currentExperiment));
                    return currentExperiment;
                }
            }
        }
        return currentExperiment;
    }
    public static Experiment getExperimentIndividually() throws IOException {
        Experiment currentExperiment = new Experiment("null","null","null","null",1,000,null);

        try (BufferedReader reader = new BufferedReader(new FileReader(loadFilePath))) {
            String line;
            RatingContainer rc = null;
            boolean isContainer = false;

            while ((line = reader.readLine()) != null) {
                if (line.startsWith("ExperimentName")) {
                    currentExperiment.setExperimentName(line.split(": ")[1].trim());

                } else if (line.startsWith("ExperimenterName")) {
                    currentExperiment.setCreatorName(line.split(": ")[1].trim());

                } else if (line.startsWith("ExperimentID:")) {
                    currentExperiment.setId(Integer.parseInt(line.split(": ")[1].trim()));

                } else if (line.startsWith("Created on")) {
                    currentExperiment.setCreated_date(line.split(": ")[1].trim());

                } else if (line.startsWith("Version")) {
                    int version = Integer.parseInt(line.split(": ")[1].trim());
                    currentExperiment.version = version;

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
                    initializeCaches(currentExperiment.getExperimentName(),currentExperiment.getVersion());
                    currentExperiment.setNumber_of_results(DataAccess.countingResults(currentExperiment));
                    return currentExperiment;
                }
            }
        }
        return currentExperiment;
    }
    private static void initializeCaches(String experimentName, int version){
        File resultsDirectory = new File("results");
        if (!resultsDirectory.exists()) {
            resultsDirectory.mkdirs(); // Automatically creates the directory and any necessary parent directories
        }
        // Create directory for the experiment if it doesn't exist
        File experimentDirectory = new File("results/" + experimentName+"_"+version);
        if (!experimentDirectory.exists()) {
            experimentDirectory.mkdirs(); // Automatically creates the directory and any necessary parent directories
        }
    }
    //Save results of conducted experiment
    public static void quickSave(Experiment experiment, String FILE_NAME) throws IOException {

        String experimentName = experiment.getExperimentName();
        int version = experiment.getVersion();
        initializeCaches(experimentName,version);
        // Create file for saving results
        FileWriter writer = new FileWriter("results/" + experimentName+"_"+version + "/" + FILE_NAME + ".csv", false);

        writer.write("Heading,Time,Vas/GLMS Result,Question,Low Anchor, High Anchor, Low Value, High Value\n");

        for (Object o : experiment.getStages()) {
            if(o instanceof RatingContainer){
                for(Object subO : ((RatingContainer) o).getContainer()){
                    saveResult(writer,subO);
                }
            }
            saveResult(writer,o);
        }

        writer.flush();
        writer.close();
    }
    // quickSave func use this
    private static void saveResult(Writer writer, Object subO) throws IOException {
        if( subO instanceof Vas){
            writer.append("Vas,")
                    .append(((Vas) subO).getConducted())
                    .append(",")
                    .append(String.valueOf(((Vas) subO).getResult()).trim())
                    .append(",")
                    .append(((Vas) subO).getTitle())
                    .append(",")
                    .append(((Vas) subO).getLowAnchorText())
                    .append(",")
                    .append(((Vas) subO).getHighAnchorText())
                    .append(",")
                    .append(String.valueOf(((Vas) subO).getLowAnchorValue()))
                    .append(",")
                    .append(String.valueOf(((Vas) subO).getHighAnchorValue()));
            writer.append("\n");
        }
        if( subO instanceof gLMS){
            writer.append("GLMS ,")
                    .append(((gLMS) subO).getConducted())
                    .append(",")
                    .append(String.format("%.4f",((gLMS) subO).getResult()))
                    .append(",")
                    .append(((gLMS) subO).getTitle());
            writer.append("\n");
        }
    }
    public static int countingResults(Experiment experiment){

        String directory = experiment.getExperimentName() + "_" + experiment.getVersion();
        System.out.println(directory);
        initializeCaches(experiment.getExperimentName(),experiment.getVersion());
        int numOfResults = Objects.requireNonNull(new File("results/" + directory).list()).length;

        return numOfResults;
    }

    public static ArrayList<Experiment> importExperiment() throws Exception{
        ArrayList<Experiment> experiments = new ArrayList<>();
        Experiment currentExperiment = new Experiment(null,null,null,null,1,000,null);
        RatingContainer rc = null;
        boolean isContainer = false;
        String line;
        //notice, input, timer, vas, glms, question, rating container, course

        try(BufferedReader reader = new BufferedReader(new FileReader(loadFilePath))){
            while ((line = reader.readLine()) != null ){
                if (line.startsWith("ExperimentName")) {
                    currentExperiment.setExperimentName(line.split(": ")[1].trim());

                } else if (line.startsWith("ExperimenterName")) {
                    currentExperiment.setCreatorName(line.split(": ")[1].trim());

                } else if (line.startsWith("ExperimentID:")) {
                    currentExperiment.setId(Integer.parseInt(line.split(": ")[1].trim()));

                } else if (line.startsWith("Created on")) {
                    currentExperiment.setCreated_date(line.split(": ")[1].trim());

                } else if (line.startsWith("Version")) {
                    int version = Integer.parseInt(line.split(": ")[1].trim());
                    currentExperiment.version = version;

                } else if (line.startsWith("startExperiment")) {
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
                } else if (line.startsWith("endExperiment()")){
                    currentExperiment.setNumber_of_results(DataAccess.countingResults(currentExperiment));
                    experiments.add(currentExperiment);
                    currentExperiment = new Experiment(null,null,null,null,1,000,null);
                }
            }
            return experiments;
        }

    }
    public static void main(String[] args) {
        try {
            // Assuming the importExperiment() method is in a class called ExperimentImporter
            ArrayList<Experiment> experiments = DataAccess.importExperiment();

            // Print the imported experiments
            for (Experiment experiment : experiments) {

                System.out.println("Experiment Name: " + experiment.getExperimentName());
                System.out.println("Creator Name: " + experiment.getCreatorName());
                System.out.println("Version: " + experiment.getVersion());
                System.out.println("Created date: " + experiment.getCreated_date());
                System.out.println("Id: "+ experiment.getId());
                System.out.println("Number of results = " + experiments.getFirst().getNumber_of_results());

                System.out.println();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}


