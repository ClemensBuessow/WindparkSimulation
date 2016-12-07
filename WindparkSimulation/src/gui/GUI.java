package gui;

import charts.Chart;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.shape.Line;
import javafx.scene.transform.Rotate;
import mapElements.Cloud;
import mapElements.Sun;
import mapElements.WindWheel;

public class GUI {

	Pane pane;

	ComboBox<String> windpark;

	ObservableList<String> recordsWindpark;

	ObservableList<String> recrodsWindDirection;

	Label settings;

	Label windDirection;

	Label windStrength;

	Label birds;

	Label bos;

	Label fire;

	Label totalKW;

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

	CheckBox birdsYes;

	CheckBox birdsNo;

	CheckBox fireYes;

	CheckBox fireNo;

	CheckBox bosYes;

	CheckBox bosNo;

	ComboBox<String> windDirectionCombo;

	TextField windDegree;

	Box gamefield;

	Scene scene;

	Group root;

	int scalingForGUI;

	Double timeData;
	String windStrenghtData;

	WindWheel rad;
	WindWheel rad2;
	WindWheel rad3;
	WindWheel rad4;
	WindWheel rad5;
	WindWheel rad6;

	Cloud cloud;
	Cloud cloud2;
	Cloud cloud3;

	public GUI(Scene scene, Pane pane) {

		this.pane = pane;
		root = new Group();
		this.scene = scene;

		recordsWindpark = FXCollections.observableArrayList("Windpark Ostsee", "Windpark Nordsee", "Delete");
		recrodsWindDirection = FXCollections.observableArrayList("Nord - Nord/Ost", "Ost - Süd/Ost", "Süd - Süd/West",
				"West - Nord/West");

		settings = new Label("Settings");
		settings.setLayoutX(900);
		settings.setLayoutY(30 - scalingForGUI);

		windpark = new ComboBox<>(recordsWindpark);
		windpark.setLayoutX(900);
		windpark.setLayoutY(90 - scalingForGUI);

		windDirection = new Label("Windrichtung");
		windDirection.setLayoutX(900);
		windDirection.setLayoutY(200 - scalingForGUI);

		windStrength = new Label("Windstaerke");
		windStrength.setLayoutX(900);
		windStrength.setLayoutY(300 - scalingForGUI);

		birds = new Label("Voegel");
		birds.setLayoutX(900);
		birds.setLayoutY(540 - scalingForGUI);

		bos = new Label("Boeen");
		bos.setLayoutX(900);
		bos.setLayoutY(600 - scalingForGUI);

		fire = new Label("Brand");
		fire.setLayoutX(900);
		fire.setLayoutY(660 - scalingForGUI);

		totalKW = new Label("Gesamt KW");
		totalKW.setLayoutX(900);
		totalKW.setLayoutY(750 - scalingForGUI);

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
		gamefield.setTranslateZ(1);

		bottomLine = new Line(0, 650, 850, 650);
		sideline = new Line(850, 0, 850, 1000);
		settingLine = new Line(850, 140, 1500, 140);

		birdsYes = new CheckBox("Yes");
		birdsYes.setLayoutX(900);
		birdsYes.setLayoutY(560 - scalingForGUI);

		birdsNo = new CheckBox("No");
		birdsNo.setLayoutX(970);
		birdsNo.setLayoutY(560 - scalingForGUI);

		fireYes = new CheckBox("Yes");
		fireYes.setLayoutX(900);
		fireYes.setLayoutY(680 - scalingForGUI);

		fireNo = new CheckBox("No");
		fireNo.setLayoutX(970);
		fireNo.setLayoutY(680 - scalingForGUI);

		bosYes = new CheckBox("Yes");
		bosYes.setLayoutX(900);
		bosYes.setLayoutY(620 - scalingForGUI);

		bosNo = new CheckBox("No");
		bosNo.setLayoutX(970);
		bosNo.setLayoutY(620 - scalingForGUI);

		chartRenew = new Button("Renew Charts");
		chartRenew.setLayoutX(720);
		chartRenew.setLayoutY(100);

		windDirectionCombo = new ComboBox<>(recrodsWindDirection);
		windDirectionCombo.setLayoutX(900);
		windDirectionCombo.setLayoutY(230);
		windDirectionCombo.setOnAction(e -> {
			switchtingWind();
		});

		windDegree = new TextField("Gradzahl");
		windDegree.setLayoutX(900);
		windDegree.setLayoutY(260);
		windDegree.setEditable(false);

		pane.getChildren().addAll(gamefield, settings, windpark, windDirection, windStrength, birds, bos, fire, totalKW,
				start, stop, reset, add, delete, x1, x2, x4, bottomLine, sideline, settingLine, birdsYes, birdsNo,
				fireYes, fireNo, bosYes, bosNo, windDirectionCombo, windDegree, chartRenew);

		cloud = new Cloud(scene, pane);
		cloud2 = new Cloud(scene, pane);
		cloud3 = new Cloud(scene, pane);

		rad = new WindWheel(scene, pane);
		rad.setVisibilityFalse();
		rad2 = new WindWheel(scene, pane);
		rad2.setVisibilityFalse();
		rad3 = new WindWheel(scene, pane);
		rad3.setVisibilityFalse();
		rad4 = new WindWheel(scene, pane);
		rad4.setVisibilityFalse();
		rad5 = new WindWheel(scene, pane);
		rad5.setVisibilityFalse();
		rad6 = new WindWheel(scene, pane);
		rad6.setVisibilityFalse();
		
		scene.setRoot(pane);

		String artLeistung = "Leistung";
		Chart chartLeistung = new Chart(pane, artLeistung);
		chartLeistung.enableEventHandler();
		chartLeistung.setLayout(835, 310);

		chartRenew.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {

				// GuiDataInput guiData = new GuiDataInput();
				//
				// System.out.println(timeData);
				// System.out.println(windstaerkenData);
				//
				//// timeData = guiData.getTime();
				//// windstaerkenData = guiData.getwindstaerke();
				// chartLeistung.setNewDataEntry(windstaerkenData,timeData);
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

		// WindWheel rad = new WindWheel(scene, pane);
		// rad.setXY(350.0, 350.0);
		//
		// WindWheel rad2 = new WindWheel(scene, pane);
		// rad2.setXY(250.0, 300.0);
		//
		// WindWheel rad3 = new WindWheel(scene, pane);
		// rad3.setXY(600.0, 360.0);
		//
		// WindWheel rad5 = new WindWheel(scene, pane);
		// rad5.setXY(200.0, 360.0);
		//
		// WindWheel rad6 = new WindWheel(scene, pane);
		// rad6.setXY(500.0, 320.0);

		Sun sun = new Sun(scene, pane);
		sun.startRotation(10000.0);

		start.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				rad.startRotation(1000.0);
				// rad2.startRotation(1000.0);
				rad3.startRotation(1000.0);
				rad2.gesamtRotate();
				rad4.startRotation(1000.0);
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
				rad4.stopRotation();
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
				rad4.startRotation(1000.0);
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
				rad4.startRotation(700.0);
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
				rad4.startRotation(500.0);
				rad5.startRotation(500.00);
				rad6.startRotation(500.00);

			}
		});

		birdsYes.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				if (birdsYes.isSelected()) {
					birdsNo.setDisable(true);
				} else {
					birdsNo.setDisable(false);
				}

			}
		});

		birdsNo.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				if (birdsNo.isSelected()) {
					birdsYes.setDisable(true);
				} else {
					birdsYes.setDisable(false);
				}

			}
		});

		bosYes.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				if (bosYes.isSelected()) {
					bosNo.setDisable(true);
				} else {
					bosNo.setDisable(false);
				}

			}
		});

		bosNo.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				if (bosNo.isSelected()) {
					bosYes.setDisable(true);
				} else {
					bosYes.setDisable(false);
				}

			}
		});

		fireYes.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				if (fireYes.isSelected()) {
					fireNo.setDisable(true);
				} else {
					fireNo.setDisable(false);
				}

			}
		});

		fireNo.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				if (fireNo.isSelected()) {
					fireYes.setDisable(true);
				} else {
					fireYes.setDisable(false);
				}

			}
		});

		windpark.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				switchingPark();

			}
		});

		windDirectionCombo.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				switchingDirection();

			}
		});

	}

	public void switchtingWind() {
		switch (windDirectionCombo.getValue()) {
		case "Nord":
			windDegree.setEditable(true);
			windDegree.clear();
			break;
		case "Ost":
			windDegree.setEditable(true);
			windDegree.clear();
			break;
		case "SÃ¼d":
			windDegree.setEditable(true);
			windDegree.clear();
			break;
		case "West":
			windDegree.setEditable(true);
			windDegree.clear();
			break;
		}
	}

	public void switchingPark() {
		switch (windpark.getValue()) {
		case "Windpark Ostsee":

			rad2.setXY(250.0, 320.0);
			rad2.setVisibilityTrue();
			rad4.setXY(400.0, 330.0);
			rad4.setVisibilityTrue();
			rad.setXY(320.0, 370.0);
			rad.setVisibilityTrue();
			rad6.setXY(570.0, 340.0);
			rad6.setVisibilityTrue();
			rad3.setXY(480.0, 380.0);
			rad3.setVisibilityTrue();
			rad5.setXY(150.0, 360.0);
			rad5.setVisibilityTrue();

			gamefield.setMaterial(new PhongMaterial(Color.DEEPSKYBLUE));

			break;

		case "Windpark Nordsee":
			break;

		case "Delete":
			break;

		}

	}

	public void switchingDirection() {
		switch (windDirectionCombo.getValue()) {

		case "Nord - Nord/Ost":

			cloud.translateToWindDirection(-80.0, 20.0, 45.0);
			cloud.setXY(200.0, 160.0);

			cloud2.translateToWindDirection(-80.0, 20.0, 45.0);
			cloud2.setXY(400.0, 160.0);

			cloud3.translateToWindDirection(-80.0, 20.0, 45.0);
			cloud3.setXY(600.0, 160.0);
			break;

		case "Ost - Süd/Ost":
			break;
		case "Süd - Süd/West":
			break;
		case "West - Nord/West":
			break;

		}
	}

}
