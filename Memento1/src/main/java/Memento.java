package main.java;

import java.time.LocalTime;

public class Memento implements IMemento {
    private final int[] options;
    private final boolean isSelected;
    private final LocalTime timestamp;

    public Memento(int[] options, boolean isSelected) {
        this.options = options.clone(); // Clone to avoid external modification
        this.isSelected = isSelected;
        this.timestamp = LocalTime.now();
    }

    public int[] getOptions() {
        return options.clone(); // Clone to avoid external modification
    }

    public boolean isSelected() {
        return isSelected;
    }

    @Override
    public String getMetadata() {
        return "Saved at: " + timestamp.toString();
    }
}