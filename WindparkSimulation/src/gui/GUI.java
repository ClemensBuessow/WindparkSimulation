package gui;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import charts.Chart;
import charts.addDataCharts;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Data;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.shape.Line;
import javafx.scene.transform.Rotate;
import mapElements.Birds;
import mapElements.Cloud;
import mapElements.Sun;
import mapElements.WindWheel;

public class GUI {

	Pane pane;
	Scene scene;
	Group root;

	ComboBox<String> windpark;
	ComboBox<String> windDirectionCombo;

	ObservableList<String> recordsWindpark;
	ObservableList<String> recrodsWindDirection;

	Label settings;
	Label windDirection;
	Label windStrength;
	Label birds;
	Label bos;

	Label totalKW;
	Button start;
	Button x1;
	Button x2;
	Button x4;

	Line bottomLine;
	Line sideline;
	Line settingLine;

	CheckBox birdsYes;
	CheckBox birdsNo;
	CheckBox bosYes;
	CheckBox bosNo;

	Box gamefield;

	int scalingForGUI = 100;
	int scalingForGUITwo = 50;
	int scalingForGUIThree = 200;
	String timeData;
	Double windStrenghtData;

	WindWheel windWheelOne;
	WindWheel windWheelTwo;
	WindWheel windWheelThree;
	WindWheel windWheelFour;
	WindWheel windWheelFive;
	WindWheel windWheelSix;

	Cloud cloud;
	Cloud cloudTwo;
	Cloud cloudThree;

	Tooltip tooltip;

	Button addSeries;

	TextField time;

	TextField windStrenghtText;

	XYChart.Series<String, Number> series;
	XYChart.Series<String, Number> series2;

	Birds birdOne;
	Birds birdTwo;

	boolean windradChrash = false;

	boolean outOfIndex = true;
	boolean boeen = false;
	int counter = 0;
	Tooltip tooltipSetTime;

	int speedForThread = 10000;
	boolean birdsStart = false;
	long delayForTimer = 500;
	Timer timer;

	public GUI(Scene scene, Pane region) {

		this.pane = region;
		root = new Group();
		this.scene = scene;

		generateCharts();
		creatingGUI();
		accessEventHandler();
		generateMapElements();
		createDataEntrys();
		resetTransition();
		addToolTipTime();

		// addTimer();

	}

	private void addToolTipTime() {
		tooltipSetTime = new Tooltip(
				"Bitte die Uhrzeiten von 0-24 Uhr stündlich eingeben! Windstärke in m/s eingeben!");
		Tooltip.install(time, tooltipSetTime);

		Tooltip direction = new Tooltip("Bitte die Windrichtung immer mit der Zeit und Särke deklarieren!");
		Tooltip.install(windDirectionCombo, direction);

	}

	private void generateCharts() {

		time = new TextField();
		time.setPromptText("Set Time");
		time.setLayoutX(880);
		time.setLayoutY(290 - scalingForGUI);
		time.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				if (!newValue.matches("\\d*")) {
					time.setText(newValue.replaceAll("[^\\d]", ""));
				}
			}
		});
		windStrenghtText = new TextField();
		windStrenghtText.setPromptText("Set Windstaerke");
		windStrenghtText.setLayoutX(1030 + 20);
		windStrenghtText.setLayoutY(290 - scalingForGUI);
		windStrenghtText.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				if (!newValue.matches("\\d*")) {
					windStrenghtText.setText(newValue.replaceAll("[^\\d]", ""));
				}
			}
		});

		addSeries = new Button("Add");
		addSeries.setLayoutX(1220);
		addSeries.setLayoutY(290 - scalingForGUI);

		series = new Series<String, Number>();
		series2 = new Series<String, Number>();
		addSeries.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {

				timeData = time.getText();
				windStrenghtData = Double.parseDouble(windStrenghtText.getText());
				String wind = windDirectionCombo.getSelectionModel().getSelectedItem().toString();
				series.getData().add(new Data<String, Number>(timeData, windStrenghtData, wind));
				time.clear();
				windStrenghtText.clear();
			}

		});
	}

	private void switchingPark() {
		switch (windpark.getValue()) {
		case "Windpark Ostsee":

			generateBalticSea();
			break;

		case "Windpark Nordsee":
			break;

		case "Delete":
			break;

		}

	}

	private void resetTransition() {
		cloud.translateToWindDirection(0.000, 0.0000, 0.0, 1.0);
		cloudTwo.translateToWindDirection(0.0000, 0.00000, 0.0, 1.0);
		cloudThree.translateToWindDirection(0.0000, 0.00000, 0.0, 1.0);
	}

	private void generateMapElements() {
		cloud = new Cloud(scene, pane, root);
		cloud.setXY(200.0, 160.0);
		cloudTwo = new Cloud(scene, pane, root);
		cloudTwo.setXY(400.0, 160.0);
		cloudThree = new Cloud(scene, pane, root);
		cloudThree.setXY(600.0, 160.0);

		windWheelTwo = new WindWheel(scene, pane, root);
		windWheelTwo.setVisibilityFalse();

		windWheelFour = new WindWheel(scene, pane, root);
		windWheelFour.setVisibilityFalse();

		windWheelOne = new WindWheel(scene, pane, root);
		windWheelOne.setVisibilityFalse();

		windWheelSix = new WindWheel(scene, pane, root);
		windWheelSix.setVisibilityFalse();

		windWheelThree = new WindWheel(scene, pane, root);
		windWheelThree.setVisibilityFalse();

		windWheelFive = new WindWheel(scene, pane, root);
		windWheelFive.setVisibilityFalse();

	}

	/**
	 * creating a Chart and Data entrys
	 */
	private void createDataEntrys() {

		String artLeistung = "Leistung";
		Chart chartLeistung = new Chart(pane, artLeistung, root);
		chartLeistung.setNewSeries(series);
		// chartLeistung.enableEventHandler();
		chartLeistung.setLayout(835, 310 - scalingForGUI);

		String artStaerke = "Staerke";
		Chart chartStaerke = new Chart(pane, artStaerke, root);
		chartStaerke.setNewSeries(series2);
		// chartStaerke.enableEventHandler();
		chartStaerke.setLayout(835, 760 - scalingForGUIThree);

	}

	private void creatingGUI() {
		recordsWindpark = FXCollections.observableArrayList("Windpark Ostsee");
		recrodsWindDirection = FXCollections.observableArrayList("Nord - Nord/Ost", "Ost - Süd/Ost", "Süd - Süd/West",
				"West - Nord/West");

		root = new Group();

		birdOne = new Birds(scene, pane, root);
		birdOne.setXY(300.0, 210.0);
		birdOne.setVisibilityFalse();
		birdTwo = new Birds(scene, pane, root);
		birdTwo.setXY(550.0, 200.0);
		birdTwo.setVisibilityFalse();

		settings = new Label("Windpark Auswahl");
		settings.setLayoutX(900);
		settings.setLayoutY(30 - 20);

		windpark = new ComboBox<>(recordsWindpark);
		windpark.setLayoutX(900);
		windpark.setLayoutY(90 - scalingForGUITwo);

		windDirection = new Label("Windrichtung");
		windDirection.setLayoutX(900);
		windDirection.setLayoutY(200 - scalingForGUI);

		windStrength = new Label("Windstaerke");
		windStrength.setLayoutX(900);
		windStrength.setLayoutY(300 - scalingForGUI);

		birds = new Label("Voegel");
		birds.setLayoutX(900);
		birds.setLayoutY(520 - scalingForGUI);

		bos = new Label("Boeen");
		bos.setLayoutX(900);
		bos.setLayoutY(560 - scalingForGUI);

		totalKW = new Label("Gesamt KW");
		totalKW.setLayoutX(900);
		totalKW.setLayoutY(750 - scalingForGUIThree);

		start = new Button("Start");
		start.setLayoutX(30);
		start.setLayoutY(700);

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
		sideline = new Line(850, 0, 850, 2000);
		settingLine = new Line(850, 140 - scalingForGUITwo, 3000, 140 - scalingForGUITwo);

		birdsYes = new CheckBox("Ja");
		birdsYes.setLayoutX(900);
		birdsYes.setLayoutY(540 - scalingForGUI);

		birdsNo = new CheckBox("Nein");
		birdsNo.setLayoutX(970);
		birdsNo.setLayoutY(540 - scalingForGUI);

		bosYes = new CheckBox("Ja");
		bosYes.setLayoutX(900);
		bosYes.setLayoutY(580 - scalingForGUI);

		bosNo = new CheckBox("Nein");
		bosNo.setLayoutX(970);
		bosNo.setLayoutY(580 - scalingForGUI);

		windDirectionCombo = new ComboBox<>(recrodsWindDirection);
		windDirectionCombo.setLayoutX(900);
		windDirectionCombo.setLayoutY(230 - scalingForGUI);

		root.getChildren().addAll(gamefield, settings, windpark, windDirection, windStrength, birds, bos, totalKW,
				start, x1, x2, x4, bottomLine, sideline, settingLine, birdsYes, birdsNo, bosYes, bosNo,
				windDirectionCombo, addSeries, windStrenghtText, time);

		Sun sun = new Sun(scene, pane, root);
		sun.startRotation(10000.0);
		scene.setRoot(root);

	}

	private void accessEventHandler() {
		start.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				addDataCharts thread = new addDataCharts(speedForThread, series, series2, counter, boeen, windWheelOne,
						windWheelTwo, windWheelThree, windWheelFour, windWheelFive, windWheelSix, windDirectionCombo,
						cloud, cloudTwo, cloudThree, windradChrash);
				if (counter <= series.getData().size()) {
					thread.start();
				}
				addTimer();
			}
		});

		x1.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				speedForThread = 15000;
				delayForTimer = 500;

			}
		});

		x2.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				speedForThread = 10000;
				delayForTimer = 300;

			}
		});

		x4.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				speedForThread = 7000;
				delayForTimer = 150;

			}
		});

		birdsYes.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				if (birdsYes.isSelected()) {
					birdsNo.setDisable(true);
					birdsStart = true;
					birdOne.setVisibilityTrue();
					// addTimer();

					birdTwo.setVisibilityTrue();
				} else {
					birdsStart = false;
					birdsNo.setDisable(false);
					birdOne.setVisibilityFalse();
					birdTwo.setVisibilityFalse();
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
					boeen = true;
				} else {
					bosNo.setDisable(false);
					boeen = false;
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

		windpark.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				switchingPark();

			}
		});

	}

	private void generateBalticSea() {
		windWheelTwo.setXY(250.0, 320.0);
		windWheelTwo.setVisibilityTrue();
		windWheelFour.setXY(400.0, 330.0);
		windWheelFour.setVisibilityTrue();
		windWheelOne.setXY(320.0, 370.0);
		windWheelOne.setVisibilityTrue();
		windWheelSix.setXY(570.0, 340.0);
		windWheelSix.setVisibilityTrue();
		windWheelThree.setXY(500.0, 360.0);
		windWheelThree.setVisibilityTrue();
		windWheelFive.setXY(150.0, 360.0);
		windWheelFive.setVisibilityTrue();

		gamefield.setMaterial(new PhongMaterial(Color.DEEPSKYBLUE));
	}

	private void addTimer() {
		if (birdsStart = true) {
			TimerTask task = new TimerTask() {
				public void run() {
					Random rand = new Random();
					int zufallszahl = rand.nextInt(1000);
					if (zufallszahl > 950 && windradChrash == false) {
						windWheelOne.changeColorToRed();
						windradChrash = true;
					}
					if (windradChrash == true && zufallszahl > 970) {
						windWheelFour.changeColorToRed();
						timer.cancel();
					}
				}
			};

			timer = new Timer();

			long delay = delayForTimer;
			long period = 10000L;
			timer.scheduleAtFixedRate(task, delay, period);

		}
	}
}
