package main.sensoryexperimentplatform.models;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;

public class User{
    private String[] permission;
    private ArrayList<Experiment> experiments;
    private final String username;
    protected String hashedPassword;
    private String hashPassword(String password){
        try{
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
            StringBuilder hexString = new StringBuilder();
            for(byte b: hash){
                String hex = Integer.toHexString(0xff & b);
                if(hex.length() == 1){
                    hexString.append('0');
                }
                hexString.append(hex);
            }return hexString.toString();
        }catch (NoSuchAlgorithmException e){
            e.printStackTrace();
            return null;
        }
    }
    public User(String username, String password){
        this.username = username;
        this.permission = null;
        this.hashedPassword = hashPassword(password);
        experiments = new ArrayList<>();
    }
    public void setPermission(String[] list){
        this.permission = list;
    }
    public String[] getPermission(){
        return permission;
    }
    public void addPermission(String id){
        String[] newPermission = new String[permission.length+1];
        System.arraycopy(permission, 0, newPermission, 0, permission.length);
        newPermission[newPermission.length-1] = id;
        permission = newPermission;

    }
    //for password changing feature
    public void setHashedPassword(String newPassword){
        this.hashedPassword = hashPassword(newPassword);
    }

    public ArrayList<Experiment> getExperiments() {
        return experiments;
    }

    public void setExperiments(ArrayList<Experiment> experiments) {
        this.experiments = experiments;
    }

    public void addExperiment(Experiment experiment){
        experiments.add(experiment);
    }
    private String experimentString(){
        if (experiments.get(0) == null){
            return "No experiments";
        }else{
            StringBuilder sb = new StringBuilder();
            for(Experiment e : experiments){
                sb.append(e.toString()).append("\n");
            }return sb.toString();
        }
    }
    public String toString(){
        return username+":"+hashedPassword+":"+ Arrays.toString(permission) +"\n" +experimentString();
    }
}
