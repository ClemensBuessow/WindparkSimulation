package gui;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import charts.Chart;
import charts.addDataCharts;
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

		windStrenghtText = new TextField();
		windStrenghtText.setPromptText("Set Windstaerke");
		windStrenghtText.setLayoutX(1030 + 20);
		windStrenghtText.setLayoutY(290 - scalingForGUI);

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

	// private void switchingDirectionClouds() {
	// switch (windDirectionCombo.getValue()) {
	//
	// case "Nord - Nord/Ost":
	//
	// stopTransition();
	// changeDirectionToNorth();
	// break;
	//
	// case "Ost - Süd/Ost":
	//
	// stopTransition();
	// changeDirectionToEast();
	// break;
	//
	// case "Süd - Süd/West":
	//
	// stopTransition();
	// changeDirectionToSouth();
	// break;
	//
	// case "West - Nord/West":
	//
	// stopTransition();
	// changeDirectionToWest();
	// break;
	//
	// }
	// }

	private void stopTransition() {
		cloud.stopTT();
		cloudTwo.stopTT();
		cloudThree.stopTT();
	}

	// private void changeDirectionToNorth() {
	//
	// cloud.setXY(150.0, 160.0);
	// cloud.translateToWindDirection(-80.0, 20.0, 45.0, 4.0);
	//
	// cloudTwo.setXY(350.0, 160.0);
	// cloudTwo.translateToWindDirection(-80.0, 20.0, 45.0, 4.0);
	//
	// cloudThree.setXY(550.0, 160.0);
	// cloudThree.translateToWindDirection(-80.0, 20.0, 45.0, 4.0);
	//
	// // windWheelOne.rotateToWindDirection(180.0, 6);
	//
	// // windWheelTwo.rotateToWindDirection(180.0, 6);
	// // windWheelThree.rotateToWindDirection(180.0, 6);
	// // windWheelFour.rotateToWindDirection(180.0, 6);
	// // windWheelFive.rotateToWindDirection(180.0, 6);
	// // windWheelSix.rotateToWindDirection(180.0, 6);
	//
	// }
	//
	// private void changeDirectionToEast() {
	// cloud.setXY(150.0, 160.0);
	// cloud.translateToWindDirection(80.0, 0.0, 0.0, 4.0);
	//
	// cloudTwo.setXY(350.0, 160.0);
	// cloudTwo.translateToWindDirection(80.0, 0.0, 0.0, 4.0);
	//
	// cloudThree.setXY(550.0, 160.0);
	// cloudThree.translateToWindDirection(80.0, 0.0, 0.0, 4.0);
	// //
	// // windWheelOne.rotateToWindDirection(90.0, 4);
	// // windWheelTwo.rotateToWindDirection(90.0, 4);
	// // windWheelThree.rotateToWindDirection(90.0, 4);
	// // windWheelFour.rotateToWindDirection(90.0, 4);
	// // windWheelFive.rotateToWindDirection(90.0, 4);
	// // windWheelSix.rotateToWindDirection(90.0, 4);
	// }
	//
	// private void changeDirectionToSouth() {
	// cloud.setXY(150.0, 160.0);
	// cloud.translateToWindDirection(80.0, -20.0, 0.0, 4.0);
	//
	// cloudTwo.setXY(350.0, 160.0);
	// cloudTwo.translateToWindDirection(80.0, -20.0, 0.0, 4.0);
	//
	// cloudThree.setXY(550.0, 160.0);
	// cloudThree.translateToWindDirection(80.0, -20.0, 0.0, 4.0);
	//
	// // windWheelOne.rotateToWindDirection(360.0, 4);
	// // windWheelTwo.rotateToWindDirection(360.0, 4);
	// // windWheelThree.rotateToWindDirection(360.0, 4);
	// // windWheelFour.rotateToWindDirection(360.0, 4);
	// // windWheelFive.rotateToWindDirection(360.0, 4);
	// // windWheelSix.rotateToWindDirection(360.0, 4);
	//
	// }
	//
	// private void changeDirectionToWest() {
	// cloud.setXY(150.0, 160.0);
	// cloud.translateToWindDirection(-80.0, 0.0, 0.0, 4.0);
	//
	// cloudTwo.setXY(350.0, 160.0);
	// cloudTwo.translateToWindDirection(-80.0, 0.0, 0.0, 4.0);
	//
	// cloudThree.setXY(550.0, 160.0);
	// cloudThree.translateToWindDirection(-80.0, 0.0, 0.0, 4.0);
	// //
	// // windWheelTwo.rotateToWindDirection(270.0, 7);
	// // windWheelThree.rotateToWindDirection(270.0, 7);
	// // windWheelFour.rotateToWindDirection(270.0, 7);
	// // windWheelFive.rotateToWindDirection(270.0, 7);
	// // windWheelSix.rotateToWindDirection(270.0, 7);
	// }

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
		chartLeistung.enableEventHandler();
		chartLeistung.setLayout(835, 310 - scalingForGUI);

		String artStaerke = "Staerke";
		Chart chartStaerke = new Chart(pane, artStaerke, root);
		chartStaerke.setNewSeries(series2);
		chartStaerke.enableEventHandler();
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

		settings = new Label("Settings");
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

		stop = new Button("Stop");
		stop.setLayoutX(80);
		stop.setLayoutY(700);

		reset = new Button("Reset");
		reset.setLayoutX(130);
		reset.setLayoutY(700);

		add = new Button("Add");
		add.setLayoutX(600);
		add.setLayoutY(700);
		add.setTooltip(tooltipSetTime);

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
		sideline = new Line(850, 0, 850, 2000);
		settingLine = new Line(850, 140 - scalingForGUITwo, 3000, 140 - scalingForGUITwo);

		birdsYes = new CheckBox("Yes");
		birdsYes.setLayoutX(900);
		birdsYes.setLayoutY(540 - scalingForGUI);

		birdsNo = new CheckBox("No");
		birdsNo.setLayoutX(970);
		birdsNo.setLayoutY(540 - scalingForGUI);

		bosYes = new CheckBox("Yes");
		bosYes.setLayoutX(900);
		bosYes.setLayoutY(580 - scalingForGUI);

		bosNo = new CheckBox("No");
		bosNo.setLayoutX(970);
		bosNo.setLayoutY(580 - scalingForGUI);

		chartRenew = new Button("Renew Charts");
		chartRenew.setLayoutX(720);
		chartRenew.setLayoutY(100);

		windDirectionCombo = new ComboBox<>(recrodsWindDirection);
		windDirectionCombo.setLayoutX(900);
		windDirectionCombo.setLayoutY(230 - scalingForGUI);

		chartRenew.setTooltip(tooltip);

		root.getChildren().addAll(gamefield, settings, windpark, windDirection, windStrength, birds, bos, totalKW,
				start, stop, reset, add, delete, x1, x2, x4, bottomLine, sideline, settingLine, birdsYes, birdsNo,
				bosYes, bosNo, windDirectionCombo, chartRenew, addSeries, windStrenghtText, time);

		Sun sun = new Sun(scene, pane, root);
		sun.startRotation(10000.0);
		scene.setRoot(root);

	}

	private void windWheelSpeedOne() {
		windWheelOne.startRotation(1000.0);
		windWheelTwo.startRotation(1000.0);
		windWheelThree.startRotation(1000.0);
		windWheelFour.startRotation(1000.0);
		windWheelFive.startRotation(1000.0);
		windWheelSix.startRotation(1000.0);
	}

	// private void stopHeadRotation() {
	// windWheelOne.stopRotation();
	// windWheelTwo.stopRotation();
	// windWheelThree.stopRotation();
	// windWheelFour.stopRotation();
	// windWheelFive.stopRotation();
	// windWheelSix.stopRotation();
	// }

	private void windWheelSpeedTwo() {
		windWheelOne.startRotation(700.0);
		windWheelTwo.startRotation(700.0);
		windWheelThree.startRotation(700.0);
		windWheelFour.startRotation(700.0);
		windWheelFive.startRotation(700.0);
		windWheelSix.startRotation(700.0);
	}

	private void windWheelSpeedFour() {
		windWheelOne.startRotation(500.00);
		windWheelTwo.startRotation(500.00);
		windWheelThree.startRotation(500.00);
		windWheelFour.startRotation(500.0);
		windWheelFive.startRotation(500.00);
		windWheelSix.startRotation(500.00);
	}

	private void accessEventHandler() {
		start.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				addDataCharts thread = new addDataCharts(100000, series, series2, counter, boeen, windWheelOne,
						windWheelTwo, windWheelThree, windWheelFour, windWheelFive, windWheelSix, windDirectionCombo,
						cloud, cloudTwo, cloudThree);
				if (counter <= series.getData().size()) {
					thread.start();
				}

			}
		});

		stop.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// stopHeadRotation();

			}
		});

		x1.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				addDataCharts thread = new addDataCharts(100000, series, series2, counter, boeen, windWheelOne,
						windWheelTwo, windWheelThree, windWheelFour, windWheelFive, windWheelSix, windDirectionCombo,
						cloud, cloudTwo, cloudThree);
				if (counter <= series.getData().size()) {
					thread.start();
				}
			}
		});

		x2.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				addDataCharts thread = new addDataCharts(10000, series, series2, counter, boeen, windWheelOne,
						windWheelTwo, windWheelThree, windWheelFour, windWheelFive, windWheelSix, windDirectionCombo,
						cloud, cloudTwo, cloudThree);
				if (counter <= series.getData().size()) {
					thread.start();
				}

			}
		});

		reset.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				series.getData().clear();
				series2.getData().clear();

			}
		});

		x4.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {

			}
		});

		birdsYes.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				if (birdsYes.isSelected()) {
					birdsNo.setDisable(true);

					birdOne.setVisibilityTrue();
					// addTimer();

					birdTwo.setVisibilityTrue();
				} else {

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

		// windDirectionCombo.setOnAction(new EventHandler<ActionEvent>() {
		//
		// @Override
		// public void handle(ActionEvent event) {
		//
		// switchingDirectionClouds();
		//
		// }
		// });
		//
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
		windWheelThree.setXY(480.0, 380.0);
		windWheelThree.setVisibilityTrue();
		windWheelFive.setXY(150.0, 360.0);
		windWheelFive.setVisibilityTrue();

		gamefield.setMaterial(new PhongMaterial(Color.DEEPSKYBLUE));
	}

	private void addTimer() {
		TimerTask task = new TimerTask() {
			public void run() {
				Random rand = new Random();
				int n = rand.nextInt(1000);
				System.out.println(Thread.currentThread().getName() + n);
				if (n > 950 && windradChrash == false) {
					windWheelOne.changeColorToRed();
					windradChrash = true;
				}
				if (windradChrash == true && n > 970) {
					windWheelFour.changeColorToRed();

				}
			}
		};

		Timer timer = new Timer("Generate Random Number : ");

		long delay = 500L;
		long period = 10000L;
		timer.scheduleAtFixedRate(task, delay, period);
	}

}
