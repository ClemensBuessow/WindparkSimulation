package GUI;

import Charts.Chart;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class GuiDataInput {

    Scene scene;

    Group root;

    Pane pane;

    Stage stage = new Stage();

    ComboBox<String> vorherigeSchema;

    ObservableList<String> eintraege;

    Label settings;

    public void GuiDatenEingebens(String art) {
        System.out.println("eine Gui zum Daten Eingeben");

        pane = new Pane();
        root = new Group();
        scene = new Scene(root, 800, 500);

        eintraege = FXCollections.observableArrayList("eins", "zwei");

        vorherigeSchema = new ComboBox<>(eintraege);
        vorherigeSchema.setLayoutX(10.0);
        vorherigeSchema.setLayoutY(30.0);

        settings = new Label("Settings");
        settings.setLayoutX(10.0);
        settings.setLayoutY(10.0);

        Chart chart = new Chart(pane, art);
        chart.setLayout(100.0, 100.0);

        pane.getChildren().addAll(vorherigeSchema, settings);

        scene.setRoot(pane);

        stage.setTitle("Daten eingeben");
        stage.setScene(scene);
        stage.show();

    }
}
