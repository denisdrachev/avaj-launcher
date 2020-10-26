package avaj.weather;

import avaj.Flyable;

import java.util.ArrayList;
import java.util.List;

import static avaj.Printer.writeToFile;

public abstract class Tower {

    private List<Flyable> observers = new ArrayList<>();
    private List<Flyable> removed = new ArrayList<>();

    public void register(Flyable flyable) {
        observers.add(flyable);
    }

    public void unregister(Flyable flyable) {
        writeToFile(flyable + " landing.");
        removed.add(flyable);
    }

    protected void conditionsChanged() {
        for (Flyable elem : observers)
            elem.updateConditions();
        clearObservers();
    }

    public List<Flyable> getObservers() {
        return observers;
    }

    private void clearObservers() {
        for (Flyable flyable : removed)
            observers.remove(flyable);
        removed.clear();
    }
}
