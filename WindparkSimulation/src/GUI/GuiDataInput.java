package GUI;

import Charts.Chart;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class GuiDataInput {

    Scene scene;

    Group root;

    Pane pane;

    Stage stage = new Stage();

    ObservableList<String> eintraege;

    Label settings;

    LineChart<String, Number> chart;

    public void GuiDatenEingebens(XYChart.Series<String, Number> series, String art) {
        System.out.println("eine Gui zum Daten Eingeben");

        pane = new Pane();
        root = new Group();
        scene = new Scene(root, 800, 500);

        settings = new Label("Settings");
        settings.setLayoutX(10.0);
        settings.setLayoutY(10.0);

        Chart chart = new Chart(pane, art);
        chart.setNewSeries(series);
        chart.setLayout(10, 50);

        pane.getChildren().addAll(settings);

        scene.setRoot(pane);

        stage.setTitle("Daten eingeben");
        stage.setScene(scene);
        stage.show();

    }
}
