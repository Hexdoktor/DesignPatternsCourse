import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Gui extends Application {

    private Controller controller;

    private ColorBox colorBox1;
    private ColorBox colorBox2;
    private ColorBox colorBox3;

    private CheckBox checkBox;

    private ListView<IMemento> historyList;

    @Override
    public void start(Stage stage) {

        controller = new Controller(this);

        Insets insets =
                new Insets(10, 10, 10, 10);

        colorBox1 = new ColorBox(1, controller);
        colorBox2 = new ColorBox(2, controller);
        colorBox3 = new ColorBox(3, controller);

        checkBox = new CheckBox("Click Me!");
        checkBox.setPadding(insets);

        HBox hBox =
                new HBox(
                        colorBox1.getRectangle(),
                        colorBox2.getRectangle(),
                        colorBox3.getRectangle()
                );

        hBox.setSpacing(10);

        HBox.setMargin(
                colorBox1.getRectangle(),
                insets
        );

        HBox.setMargin(
                colorBox2.getRectangle(),
                insets
        );

        HBox.setMargin(
                colorBox3.getRectangle(),
                insets
        );

        Label label =
                new Label(
                        "Ctrl+Z = Undo | Ctrl+Y = Redo"
                );

        label.setPadding(insets);

        VBox vBox =
                new VBox(
                        hBox,
                        checkBox,
                        label
                );

        checkBox.setOnAction(event -> {

            controller.setIsSelected(
                    checkBox.isSelected()
            );
        });

        Scene scene =
                new Scene(vBox);

        scene.setOnKeyPressed(event -> {

            if (event.isControlDown()
                    && event.getCode()
                    == KeyCode.Z) {

                controller.undo();
            }

            if (event.isControlDown()
                    && event.getCode()
                    == KeyCode.Y) {

                controller.redo();
            }
        });

        stage.setTitle(
                "Memento Pattern Example"
        );

        stage.setScene(scene);
        stage.show();

        createHistoryWindow();
    }

    private void createHistoryWindow() {

        historyList = new ListView<>();

        historyList.setOnMouseClicked(event -> {

            IMemento selected =
                    historyList
                            .getSelectionModel()
                            .getSelectedItem();

            if (selected != null) {
                controller.restoreState(
                        selected
                );
            }
        });

        VBox root =
                new VBox(historyList);

        Scene scene =
                new Scene(
                        root,
                        500,
                        300
                );

        Stage historyStage =
                new Stage();

        historyStage.setTitle(
                "History"
        );

        historyStage.setScene(scene);

        historyStage.show();
    }

    public void refreshHistoryWindow() {

        if (historyList != null) {

            historyList.setItems(
                    controller.getHistory()
            );
        }
    }

    public void updateGui() {

        colorBox1.setColor(
                controller.getOption(1)
        );

        colorBox2.setColor(
                controller.getOption(2)
        );

        colorBox3.setColor(
                controller.getOption(3)
        );

        checkBox.setSelected(
                controller.getIsSelected()
        );
    }
}