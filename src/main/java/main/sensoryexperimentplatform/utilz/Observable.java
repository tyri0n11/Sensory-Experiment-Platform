package main.sensoryexperimentplatform.utilz;

import java.util.ArrayList;
import java.util.List;

public class Observable {
    private static List<Observer> observers = new ArrayList<Observer>();

    public static void attach(Observer observer) {
        if (!observers.contains(observer))
            observers.add(observer);
    }

    public static void detach(Observer observer) {
        observers.remove(observer);
    }

    public static void notifyAllObservers(){
        for (Observer observer : observers) {
            observer.update();
        }
    }
}
