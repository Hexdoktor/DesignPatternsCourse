import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

public class Controller {

    private Model model;
    private Gui gui;

    private List<IMemento> history;
    private List<IMemento> redoHistory;

    public Controller(Gui gui) {

        this.model = new Model();
        this.gui = gui;

        this.history = new ArrayList<>();
        this.redoHistory = new ArrayList<>();
    }

    public void setOption(
            int optionNumber,
            int choice) {

        saveToHistory();
        model.setOption(optionNumber, choice);
    }

    public int getOption(int optionNumber) {
        return model.getOption(optionNumber);
    }

    public void setIsSelected(boolean isSelected) {

        saveToHistory();
        model.setIsSelected(isSelected);
    }

    public boolean getIsSelected() {
        return model.getIsSelected();
    }

    private void saveToHistory() {

        history.add(
                model.createMemento()
        );

        redoHistory.clear();

        gui.refreshHistoryWindow();
    }

    public void undo() {

        if (!history.isEmpty()) {

            redoHistory.add(
                    model.createMemento()
            );

            IMemento previousState =
                    history.remove(history.size() - 1);

            model.restoreState(previousState);

            gui.updateGui();
            gui.refreshHistoryWindow();

            System.out.println("Undo executed");
        }
    }

    public void redo() {

        if (!redoHistory.isEmpty()) {

            history.add(
                    model.createMemento()
            );

            IMemento nextState =
                    redoHistory.remove(
                            redoHistory.size() - 1
                    );

            model.restoreState(nextState);

            gui.updateGui();
            gui.refreshHistoryWindow();

            System.out.println("Redo executed");
        }
    }

    public ObservableList<IMemento> getHistory() {

        return FXCollections.observableArrayList(
                history
        );
    }

    public void restoreState(IMemento memento) {

        history.add(
                model.createMemento()
        );

        model.restoreState(memento);

        gui.updateGui();
        gui.refreshHistoryWindow();
    }
}