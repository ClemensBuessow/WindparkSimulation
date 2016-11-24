package gui;

import charts.Chart;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.shape.Line;
import javafx.scene.transform.Rotate;
import mapElements.Sun;
import mapElements.Windrad;

public class GUI {

	Pane pane;

	ComboBox<String> windpark;

	ObservableList<String> eintraegeWindpark;

	ObservableList<String> eintraegeWindrichtung;

	Label settings;

	Label windrichtung;

	Label windstaerke;

	Label voegel;

	Label boeen;

	Label brand;

	Label gesamtKW;

	Button start;

	Button stop;

	Button reset;

	Button add;

	Button delete;

	Button x1;

	Button x2;

	Button x4;

	Button chartRenew;

	Line bottomLine;

	Line sideline;

	Line settingLine;

	CheckBox vogelYes;

	CheckBox vogelNo;

	CheckBox brandYes;

	CheckBox brandNo;

	CheckBox boeenYes;

	CheckBox boeenNo;

	ComboBox<String> windRichtung;

	TextField windGrad;

	Box gamefield;

	Scene scene;

	Group root;

	int a;
	
	Double timeData;
	String windstaerkenData;

	public GUI(Scene scene, Pane pane) {

		this.pane = pane;
		root = new Group();
		this.scene = scene;

		eintraegeWindpark = FXCollections.observableArrayList("Windpark Ostsee", "Windpark Nordsee");
		eintraegeWindrichtung = FXCollections.observableArrayList("Nord", "Ost", "Süd", "West");

		settings = new Label("Settings");
		settings.setLayoutX(900);
		settings.setLayoutY(30 - a);

		windpark = new ComboBox<>(eintraegeWindpark);
		windpark.setLayoutX(900);
		windpark.setLayoutY(90 - a);

		windrichtung = new Label("Windrichtung");
		windrichtung.setLayoutX(900);
		windrichtung.setLayoutY(200 - a);

		windstaerke = new Label("Windstaerke");
		windstaerke.setLayoutX(900);
		windstaerke.setLayoutY(300 - a);

		voegel = new Label("Voegel");
		voegel.setLayoutX(900);
		voegel.setLayoutY(540 - a);

		boeen = new Label("Boeen");
		boeen.setLayoutX(900);
		boeen.setLayoutY(600 - a);

		brand = new Label("Brand");
		brand.setLayoutX(900);
		brand.setLayoutY(660 - a);

		gesamtKW = new Label("Gesamt KW");
		gesamtKW.setLayoutX(900);
		gesamtKW.setLayoutY(750 - a);

		start = new Button("Start");
		start.setLayoutX(30);
		start.setLayoutY(700);

		stop = new Button("Stop");
		stop.setLayoutX(80);
		stop.setLayoutY(700);

		reset = new Button("Reset");
		reset.setLayoutX(130);
		reset.setLayoutY(700);

		add = new Button("Add");
		add.setLayoutX(600);
		add.setLayoutY(700);

		delete = new Button("Delete");
		delete.setLayoutX(650);
		delete.setLayoutY(700);

		x1 = new Button("x1");
		x1.setLayoutX(550);
		x1.setLayoutY(100);

		x2 = new Button("x2");
		x2.setLayoutX(600);
		x2.setLayoutY(100);

		x4 = new Button("x4");
		x4.setLayoutX(650);
		x4.setLayoutY(100);

		gamefield = new Box(600, 40, 600);
		gamefield.setMaterial(new PhongMaterial(Color.GREENYELLOW));
		gamefield.getTransforms().add(new Rotate(10, 0, 0, 0, Rotate.X_AXIS));
		gamefield.getTransforms().add(new Rotate(20, 0, 0, 0, Rotate.Y_AXIS));
		gamefield.setLayoutX(400);
		gamefield.setLayoutY(500);

		bottomLine = new Line(0, 650, 850, 650);
		sideline = new Line(850, 0, 850, 1000);
		settingLine = new Line(850, 140, 1500, 140);

		vogelYes = new CheckBox("Yes");
		vogelYes.setLayoutX(900);
		vogelYes.setLayoutY(560 - a);

		vogelNo = new CheckBox("No");
		vogelNo.setLayoutX(970);
		vogelNo.setLayoutY(560 - a);

		brandYes = new CheckBox("Yes");
		brandYes.setLayoutX(900);
		brandYes.setLayoutY(680 - a);

		brandNo = new CheckBox("No");
		brandNo.setLayoutX(970);
		brandNo.setLayoutY(680 - a);

		boeenYes = new CheckBox("Yes");
		boeenYes.setLayoutX(900);
		boeenYes.setLayoutY(620 - a);

		boeenNo = new CheckBox("No");
		boeenNo.setLayoutX(970);
		boeenNo.setLayoutY(620 - a);

		chartRenew = new Button("Renew Charts");
		chartRenew.setLayoutX(720);
		chartRenew.setLayoutY(100);

		windRichtung = new ComboBox<>(eintraegeWindrichtung);
		windRichtung.setLayoutX(900);
		windRichtung.setLayoutY(230);
		windRichtung.setOnAction(e -> {
			switchtingWind();
		});

		windGrad = new TextField("Gradzahl");
		windGrad.setLayoutX(900);
		windGrad.setLayoutY(260);
		windGrad.setEditable(false);

		pane.getChildren().addAll(gamefield, settings, windpark, windrichtung, windstaerke, voegel, boeen, brand,
				gesamtKW, start, stop, reset, add, delete, x1, x2, x4, bottomLine, sideline, settingLine, vogelYes,
				vogelNo, brandYes, brandNo, boeenYes, boeenNo, windRichtung, windGrad, chartRenew);
		scene.setRoot(pane);

		String artLeistung = "Leistung";
		Chart chartLeistung = new Chart(pane, artLeistung);
		chartLeistung.enableEventHandler();
		chartLeistung.setLayout(835, 310);

		chartRenew.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				
//				GuiDataInput guiData = new GuiDataInput();
//				
//				System.out.println(timeData);
//				System.out.println(windstaerkenData);
//				
////				timeData = guiData.getTime();
////				windstaerkenData = guiData.getwindstaerke();
//				chartLeistung.setNewDataEntry(windstaerkenData,timeData);
			}
		});

		String artStaerke = "Staerke";
		Chart chartStaerke = new Chart(pane, artStaerke);
		chartStaerke.enableEventHandler();
		chartStaerke.setLayout(835, 760);
		chartStaerke.setNewDataEntry("1", 15);
		chartStaerke.setNewDataEntry("2", 11);
		chartStaerke.setNewDataEntry("3", 10);
		chartStaerke.setNewDataEntry("4", 5);
		chartStaerke.setNewDataEntry("5", 0);
		chartStaerke.setNewDataEntry("6", 5);
		chartStaerke.setNewDataEntry("7", 5);
		chartStaerke.setNewDataEntry("8", 10);

		Windrad rad = new Windrad(scene, pane);
		rad.setXY(350.0, 350.0);

		Windrad rad2 = new Windrad(scene, pane);
		rad2.setXY(250.0, 300.0);
		

		Windrad rad3 = new Windrad(scene, pane);
		rad3.setXY(600.0, 360.0);

		Windrad rad5 = new Windrad(scene, pane);
		rad5.setXY(200.0, 360.0);

		Windrad rad6 = new Windrad(scene, pane);
		rad6.setXY(500.0, 320.0);

		Sun sun = new Sun(scene, pane);
		sun.startRotation(10000.0);

		start.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				rad.startRotation(1000.0);
			//	rad2.startRotation(1000.0);
				rad3.startRotation(1000.0);
				rad2.gesamtRotate();

				rad5.startRotation(1000.0);
				rad6.startRotation(1000.0);
			}
		});

		stop.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				rad.stopRotation();
				rad2.stopRotation();
				rad3.stopRotation();

				rad5.stopRotation();
				rad6.stopRotation();

			}
		});

		x1.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				rad.startRotation(1000.0);
				rad2.startRotation(1000.0);
				rad3.startRotation(1000.0);

				rad5.startRotation(1000.0);
				rad6.startRotation(1000.0);

			}
		});

		x2.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				rad.startRotation(700.0);
				rad2.startRotation(700.0);
				rad3.startRotation(700.0);

				rad5.startRotation(700.0);
				rad6.startRotation(700.0);

			}
		});

		x4.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				rad.startRotation(500.00);
				rad2.startRotation(500.00);
				rad3.startRotation(500.00);

				rad5.startRotation(500.00);
				rad6.startRotation(500.00);

			}
		});

		vogelYes.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				if (vogelYes.isSelected()) {
					vogelNo.setDisable(true);
				} else {
					vogelNo.setDisable(false);
				}

			}
		});

		vogelNo.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				if (vogelNo.isSelected()) {
					vogelYes.setDisable(true);
				} else {
					vogelYes.setDisable(false);
				}

			}
		});

		boeenYes.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				if (boeenYes.isSelected()) {
					boeenNo.setDisable(true);
				} else {
					boeenNo.setDisable(false);
				}

			}
		});

		boeenNo.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				if (boeenNo.isSelected()) {
					boeenYes.setDisable(true);
				} else {
					boeenYes.setDisable(false);
				}

			}
		});

		brandYes.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				if (brandYes.isSelected()) {
					brandNo.setDisable(true);
				} else {
					brandNo.setDisable(false);
				}

			}
		});

		brandNo.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				if (brandNo.isSelected()) {
					brandYes.setDisable(true);
				} else {
					brandYes.setDisable(false);
				}

			}
		});

	}

	public void switchtingWind() {
		switch (windRichtung.getValue()) {
		case "Nord":
			windGrad.setEditable(true);
			windGrad.clear();
			break;
		case "Ost":
			windGrad.setEditable(true);
			windGrad.clear();
			break;
		case "Süd":
			windGrad.setEditable(true);
			windGrad.clear();
			break;
		case "West":
			windGrad.setEditable(true);
			windGrad.clear();
			break;
		}
	}

}
