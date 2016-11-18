package GUI;

import Charts.Chart;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Data;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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

	TextField time;

	TextField windstaerke;

	Button add;

	String windstaerkedata;

	double timedata;

	XYChart.Series<String, Number> series2;

	public void GuiDatenEingebens(XYChart.Series<String, Number> series, String art) {
		System.out.println("eine Gui zum Daten Eingeben");

		pane = new Pane();
		root = new Group();
		scene = new Scene(root, 800, 500);

		settings = new Label("Settings");
		settings.setLayoutX(10.0);
		settings.setLayoutY(10.0);

		time = new TextField();
		time.setPromptText("Set Time");
		time.setLayoutX(30);
		time.setLayoutY(300);

		windstaerke = new TextField();
		windstaerke.setPromptText("Set Windstaerke");
		windstaerke.setLayoutX(190);
		windstaerke.setLayoutY(300);

		add = new Button("Add to Series");
		add.setLayoutX(350);
		add.setLayoutY(300);

		add.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
			
				timedata = Double.parseDouble(time.getText());
				windstaerkedata = windstaerke.getText();
				series.getData().add(new Data<String, Number>(windstaerkedata, timedata));
				time.clear();
				windstaerke.clear();

				

			}
		});
		
		Chart chart = new Chart(pane, art);
		chart.setNewSeries(series);
		chart.setLayout(10, 50);

		pane.getChildren().addAll(settings, time, windstaerke, add);

		scene.setRoot(pane);

		stage.setTitle("Daten eingeben");
		stage.setScene(scene);
		stage.show();

	}

//	public void setSeries() {
//		Chart chart = new Chart(pane, art);
//		series2 = chart.getSeries();
//	}
	//
	// public double getTime(){
	// System.out.println(timedata + "von Guidata");
	// return timedata;
	// }
	//
	// public String getwindstaerke(){
	// System.out.println(windstaerkedata + "von GuiData");
	// return windstaerkedata;
	// }
}
