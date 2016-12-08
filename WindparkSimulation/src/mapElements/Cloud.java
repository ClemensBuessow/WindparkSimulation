package mapElements;

import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Sphere;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Cloud extends BasicElement {
	Sphere cloudElementOne;
	Sphere cloudElementTwo;
	Sphere cloudElementThree;
	Sphere cloudElementFour;
	Sphere cloudElementFive;
	Sphere cloudElementSix;
	Sphere cloudElementSeven;
	TranslateTransition cloudTT;

	Double a = 3.0;
	Pane pane;
	Scene scene;
	Group cloud;
	Stage primaryStage;

	public Cloud(Scene scene, Pane pane) {
		this.scene = scene;
		this.pane = pane;
		cloud = new Group();

		addAllClouds();
		pane.getChildren().add(cloud);
	}

	public void setXY(Double x, Double y) {
		cloud.setTranslateX(x);
		cloud.setTranslateY(y);

	}

	public void movePivot(Node node, double x, double y) {
		node.getTransforms().add(new Translate(-x, -y));
		node.setTranslateX(x);
		node.setTranslateY(y);

	}

	public void translateToWindDirection(Double xValue, Double yValue, Double zValue, double duration) {
		cloudTT = new TranslateTransition(Duration.seconds(duration), cloud);
		cloudTT.setByX(xValue);
		cloudTT.setByY(yValue);
		cloudTT.setByZ(zValue);
		cloudTT.setCycleCount(Timeline.INDEFINITE);
		cloudTT.playFromStart();

		cloudTT.setOnFinished(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				cloudTT.play();

			}
		});
	}

	public void stopTT() {
		cloudTT.stop();
	}

	private void addAllClouds() {
		cloudElementOne = new Sphere(30 / a);
		cloudElementOne.setLayoutX(220 / a);
		cloudElementOne.setLayoutY(105 / a);
		cloudElementOne.getTransforms().add(new Rotate(20, 0, 0, 0, Rotate.X_AXIS));
		cloudElementOne.getTransforms().add(new Rotate(20, 0, 0, 0, Rotate.Y_AXIS));

		cloudElementTwo = new Sphere(30 / a);
		cloudElementTwo.setLayoutX(260 / a);
		cloudElementTwo.setLayoutY(105 / a);
		cloudElementTwo.getTransforms().add(new Rotate(20, 0, 0, 0, Rotate.X_AXIS));
		cloudElementTwo.getTransforms().add(new Rotate(20, 0, 0, 0, Rotate.Y_AXIS));

		cloudElementThree = new Sphere(30 / a);
		cloudElementThree.setLayoutX(300 / a);
		cloudElementThree.setLayoutY(105 / a);
		cloudElementThree.getTransforms().add(new Rotate(20, 0, 0, 0, Rotate.X_AXIS));
		cloudElementThree.getTransforms().add(new Rotate(20, 0, 0, 0, Rotate.Y_AXIS));

		cloudElementFour = new Sphere(30 / a);
		cloudElementFour.setLayoutX(340 / a);
		cloudElementFour.setLayoutY(105 / a);
		cloudElementFour.getTransforms().add(new Rotate(20, 0, 0, 0, Rotate.X_AXIS));
		cloudElementFour.getTransforms().add(new Rotate(20, 0, 0, 0, Rotate.Y_AXIS));

		cloudElementFive = new Sphere(30 / a);
		cloudElementFive.setLayoutX(240 / a);
		cloudElementFive.setLayoutY(120 / a);
		cloudElementFive.getTransforms().add(new Rotate(20, 0, 0, 0, Rotate.X_AXIS));
		cloudElementFive.getTransforms().add(new Rotate(20, 0, 0, 0, Rotate.Y_AXIS));

		cloudElementSix = new Sphere(30 / a);
		cloudElementSix.setLayoutX(280 / a);
		cloudElementSix.setLayoutY(120 / a);
		cloudElementSix.getTransforms().add(new Rotate(20, 0, 0, 0, Rotate.X_AXIS));
		cloudElementSix.getTransforms().add(new Rotate(20, 0, 0, 0, Rotate.Y_AXIS));

		cloudElementSeven = new Sphere(30 / a);
		cloudElementSeven.setLayoutX(320 / a);
		cloudElementSeven.setLayoutY(120 / a);
		cloudElementSeven.getTransforms().add(new Rotate(20, 0, 0, 0, Rotate.X_AXIS));
		cloudElementSeven.getTransforms().add(new Rotate(20, 0, 0, 0, Rotate.Y_AXIS));

		cloud.getChildren().addAll(cloudElementOne, cloudElementTwo, cloudElementThree, cloudElementFour,
				cloudElementFive, cloudElementSix, cloudElementSeven);
	}

}
