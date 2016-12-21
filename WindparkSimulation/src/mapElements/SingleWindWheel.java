package mapElements;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;

public class SingleWindWheel extends Application {

	Pane pane;
	Scene scene;
	Group root;
	Stage primaryStage;

	Line leftLine;
	Line rightLine;
	Line bottomLine;

	Rectangle generator;
	Rectangle wingOne;
	Rectangle wingTwo;
	Rectangle wingThree;
	Rectangle shaft;

	Circle rotorNabe;

	Slider sliderWindSpeed;
	Slider sliderDegrees;

	TextField showPower;

	Label power;
	Label providedHouses;
	Label housesOne;
	Label housesTwo;
	Label housesThree;
	Label manuell;
	Label automatik;
	Label windSpeed;
	Label degrees;

	ProgressBar showProvidedHouses;
	ProgressIndicator pi;
	
	CheckBox checkManuell;
	CheckBox checkAutomatik;

	
	ImageView wind;
	ImageView rotationSettings;
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		this.primaryStage = primaryStage;
		pane = new Pane();
		root = new Group();
		scene = new Scene(root, 1000, 700);

		leftLine = new Line(250, 0, 250, 700);
		rightLine = new Line(750, 0, 750, 700);
		bottomLine = new Line(250, 600, 750, 600);

		wingOne = new Rectangle(30, 200);
		wingOne.setLayoutX(490);
		wingOne.setLayoutY(290);
		wingOne.setFill(Color.ALICEBLUE);
		wingOne.getTransforms().add(new Rotate(290));

		wingTwo = new Rectangle(30, 200);
		wingTwo.setLayoutX(490);
		wingTwo.setLayoutY(270);
		wingTwo.setFill(Color.ALICEBLUE);
		wingTwo.getTransforms().add(new Rotate(50));

		wingThree = new Rectangle(30, 200);
		wingThree.setLayoutX(510);
		wingThree.setLayoutY(270);
		wingThree.setFill(Color.ALICEBLUE);
		wingThree.getTransforms().add(new Rotate(160));

		shaft = new Rectangle(30, 300);
		shaft.setLayoutX(480);
		shaft.setLayoutY(280);
		shaft.setFill(Color.ALICEBLUE);

		sliderWindSpeed = new Slider();
		sliderWindSpeed.setPrefSize(180, 30);
		sliderWindSpeed.setLayoutX(40.0);
		sliderWindSpeed.setLayoutY(400);
		sliderWindSpeed.setMin(0);
		sliderWindSpeed.setMax(35);
		sliderWindSpeed.setShowTickLabels(true);
		sliderWindSpeed.setShowTickMarks(true);
		sliderWindSpeed.setMajorTickUnit(17.5);
		sliderWindSpeed.setMinorTickCount(5);
		sliderWindSpeed.setBlockIncrement(5);
		sliderWindSpeed.setDisable(true);
		
		
		sliderDegrees = new Slider();
		sliderDegrees.setPrefSize(180, 30);
		sliderDegrees.setLayoutX(40);
		sliderDegrees.setLayoutY(500);
		sliderDegrees.setMin(0);
		sliderDegrees.setMax(90);
		sliderDegrees.setShowTickMarks(true);
		sliderDegrees.setShowTickLabels(true);
		sliderDegrees.setMajorTickUnit(45);
		sliderDegrees.setMinorTickCount(10);
		sliderDegrees.setBlockIncrement(5);
		
		power = new Label("Leistung");
		power.setLayoutX(850);
		power.setLayoutY(10);

		showPower = new TextField();
		showPower.setLayoutX(800);
		showPower.setLayoutY(40);

		providedHouses = new Label("Versorgte Haushalte");
		providedHouses.setLayoutX(820);
		providedHouses.setLayoutY(110);

		showProvidedHouses = new ProgressBar(0);
		showProvidedHouses.setLayoutX(785);
		showProvidedHouses.setLayoutY(140);
		showProvidedHouses.setPrefSize(180, 30);

		housesOne = new Label("0");
		housesOne.setLayoutX(785);
		housesOne.setLayoutY(180);

		housesTwo = new Label("20000");
		housesTwo.setLayoutX(950);
		housesTwo.setLayoutY(180);

		housesThree = new Label("10000");
		housesThree.setLayoutX(860);
		housesThree.setLayoutY(180);

		manuell = new Label("Manuell");
		manuell.setLayoutX(20);
		manuell.setLayoutY(20);

		automatik = new Label("Automatisch");
		automatik.setLayoutX(20);
		automatik.setLayoutY(50);

		windSpeed = new Label("Windgeschwindigkeit");
		windSpeed.setLayoutX(60);
		windSpeed.setLayoutY(360);

		degrees = new Label("Stellung in Grad");
		degrees.setLayoutX(60);
		degrees.setLayoutY(450);
		
		checkAutomatik = new CheckBox();
		checkAutomatik.setLayoutX(150);
		checkAutomatik.setLayoutY(50);
		
		checkManuell = new CheckBox();
		checkManuell.setLayoutX(150);
		checkManuell.setLayoutY(20);
		
		wind = new ImageView();
		wind.setLayoutX(20);
		wind.setLayoutY(150);
		//wind.setImage();
		
		rotationSettings = new ImageView();
		rotationSettings.setLayoutX(70);
		rotationSettings.setLayoutY(150);
		
		root.getChildren().addAll(rotationSettings, wind,degrees, automatik, providedHouses, power, leftLine, rightLine, bottomLine, wingOne,
				wingTwo, wingThree, shaft, sliderWindSpeed, showPower, showProvidedHouses, housesOne, housesTwo, housesThree,
				manuell, windSpeed,sliderDegrees,checkAutomatik, checkManuell);

		primaryStage.setScene(scene);
		primaryStage.show();

		sliderWindSpeed.valueProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				showProvidedHouses.setProgress(newValue.doubleValue() / 35);

			}
		});
		
		sliderDegrees.valueProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				showProvidedHouses.setProgress(newValue.doubleValue()/90);
				
			}
		});

	}

}
