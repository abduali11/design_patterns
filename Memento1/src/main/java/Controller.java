package main.java;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    private Model model;
    private Gui gui;
    private List<IMemento> history; // Memento history
    private List<IMemento> redoHistory; // Redo history
    private HistoryWindow historyWindow;

    public Controller(Gui gui) {
        this.model = new Model();
        this.gui = gui;
        this.history = new ArrayList<>();
        this.redoHistory = new ArrayList<>();
        this.historyWindow = new HistoryWindow(this);
    }

    public void setOption(int optionNumber, int choice) {
        saveToHistory();
        model.setOption(optionNumber, choice);
        redoHistory.clear(); // Clear redo history on new action
        updateHistoryWindow();
    }

    public int getOption(int optionNumber) {
        return model.getOption(optionNumber);
    }

    public void setIsSelected(boolean isSelected) {
        saveToHistory();
        model.setIsSelected(isSelected);
        redoHistory.clear(); // Clear redo history on new action
        updateHistoryWindow();
    }

    public boolean getIsSelected() {
        return model.getIsSelected();
    }

    public void undo() {
        if (!history.isEmpty()) {
            System.out.println("Undo operation");
            IMemento previousState = history.remove(history.size() - 1);
            redoHistory.add(model.createMemento()); // Save current state to redo history
            model.restoreState(previousState);
            gui.updateGui();
            updateHistoryWindow();
        }
    }

    public void redo() {
        if (!redoHistory.isEmpty()) {
            System.out.println("Redo operation");
            IMemento nextState = redoHistory.remove(redoHistory.size() - 1);
            saveToHistory(); // Save current state to undo history
            model.restoreState(nextState);
            gui.updateGui();
            updateHistoryWindow();
        }
    }

    public void restoreFromHistory(int index) {
        if (index >= 0 && index < history.size()) {
            IMemento selectedState = history.get(index);
            saveToHistory(); // Save current state to undo history
            model.restoreState(selectedState);
            gui.updateGui();
            updateHistoryWindow();
        }
    }

    private void saveToHistory() {
        IMemento currentState = model.createMemento();
        history.add(currentState);
    }

    private void updateHistoryWindow() {
        List<String> historyDescriptions = new ArrayList<>();
        for (IMemento memento : history) {
            historyDescriptions.add(memento.getMetadata());
        }
        historyWindow.updateHistory(historyDescriptions);
    }

    public void showHistoryWindow() {
        historyWindow.show();
    }
}