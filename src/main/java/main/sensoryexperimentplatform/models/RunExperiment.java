package main.sensoryexperimentplatform.models;

import java.util.ArrayList;
import java.util.Scanner;

public class RunExperiment {
    public static void main(String[] args) throws Exception {
        Experiment exs = DataAccess.getExperimentIndividually();
        Scanner sc = new Scanner(System.in);
        //run the first experiment

        for(Object o : exs.stages){
            if(o instanceof RatingContainer){
                for(Object subO : ((RatingContainer) o).container){
                    if(subO instanceof Vas){
                        System.out.println(subO);
                        System.out.print("Enter Result of Vas: ");
                        int temp = sc.nextInt();
                        sc.nextLine();
                        ((Vas) subO).setResult(temp);
                        System.out.println(((Vas) subO).getButtonText());
                    }
                    if(subO instanceof gLMS){
                        System.out.println(subO);
                        System.out.print("Enter Result of GLMS: ");
                        String temp = sc.nextLine();
                        ((gLMS) subO).setResult(temp);
                        System.out.println(((gLMS) subO).getButtonText());
                    }
                }
            }
            if(o instanceof Vas){
                System.out.println(o);
                System.out.print("Enter Result of Vas: ");
                int temp = sc.nextInt();
                sc.nextLine();
                ((Vas) o).setResult(temp);
                System.out.println(((Vas) o).getButtonText());
            }if(o instanceof gLMS){
                System.out.println(o);
                System.out.print("Enter Result of GLMS: ");
                String result = sc.nextLine();
                ((gLMS) o).setResult(result);
                System.out.println(((gLMS) o).getButtonText());
            }
        }
        sc.close();
        System.out.println("----------------------Result---------------------");
        for (Object o : exs.stages){
            if(o instanceof RatingContainer){
                for(Object sub : ((RatingContainer) o).getContainer()){
                    if(sub instanceof Vas){
                        System.out.println(sub);
                        System.out.println("Result of Vas: " + ((Vas) sub).getResult());
                    }if(sub instanceof gLMS){
                        System.out.println(sub);
                        System.out.println("Result of GLMS: " + ((gLMS) sub).getResult());
                    }
                }
            }
            if(o instanceof Vas){
                System.out.println(o);
                System.out.println("Result of Vas: " + ((Vas) o).getResult());
            }if(o instanceof gLMS){
                System.out.println(o);
                System.out.println("Result of GLMS: " + ((gLMS) o).getResult());
            }
        }
    }
}
