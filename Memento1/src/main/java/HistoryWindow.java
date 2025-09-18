package main.java;

import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;

public class HistoryWindow {
    private Stage stage;
    private ListView<String> listView;
    private Controller controller;

    public HistoryWindow(Controller controller) {
        this.controller = controller;
        stage = new Stage();
        listView = new ListView<>();
        VBox vBox = new VBox(listView);
        Scene scene = new Scene(vBox, 300, 400);
        stage.setScene(scene);
        stage.setTitle("History");

        listView.setOnMouseClicked(event -> {
            if (event.getClickCount() == 2) {
                int index = listView.getSelectionModel().getSelectedIndex();
                controller.restoreFromHistory(index);
                stage.close();
            }
        });
    }

    public void show() {
        stage.show();
    }

    public void updateHistory(List<String> history) {
        listView.getItems().setAll(history);
    }
}