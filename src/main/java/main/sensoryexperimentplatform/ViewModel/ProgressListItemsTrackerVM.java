package main.sensoryexperimentplatform.ViewModel;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class ProgressListItemsTrackerVM extends RunExperiment_VM {
    private IntegerProperty currentItemIndex;

    public ProgressListItemsTrackerVM() {
        currentItemIndex = new SimpleIntegerProperty(-1);
    }

    public IntegerProperty currentItemIndexProperty() {
        return currentItemIndex;
    }

    public int getCurrentItemIndex() {
        return currentItemIndex.get();
    }

    public void setCurrentItemIndex(int index) {
        currentItemIndex.set(index);
    }

    public int getTotalItems() {
        return totalItem;
    }
}