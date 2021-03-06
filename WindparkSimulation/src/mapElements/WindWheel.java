package mapElements;

import handler.WindradClickHandler;
import javafx.animation.Animation;
import javafx.animation.RotateTransition;
import javafx.scene.DepthTest;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.shape.Cylinder;
import javafx.scene.shape.Sphere;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;
import javafx.util.Duration;

public class WindWheel extends BasicElement {

	private Box wingOne;
	private Box wingTwo;
	private Box wingThree;
	private Cylinder shaft;
	private Sphere rotorNabe;
	private Box generator;
	Pane pane;
	Scene scene;
	private int a = 4;
	Group windrad;
	Group head;
	Group fullhead;
	Group nabe;
	private Group root;

	RotateTransition rotateHead;

	public WindWheel(Scene scene, Pane pane, Group root) {

		this.scene = scene;
		this.pane = pane;
		this.root = root;

		head = new Group();
		windrad = new Group();
		fullhead = new Group();
		nabe = new Group();

		generateWindWheel();

	}

	public void moveHeadPivot(double x, double y) {
		fullhead.getTransforms().add(new Translate(-x, -y));
		fullhead.setLayoutX(x);
		fullhead.setLayoutY(y);
	}

	public void movePivot(Node node, double x, double y) {
		node.getTransforms().add(new Translate(-x, -y));
		node.setTranslateX(x);
		node.setTranslateY(y);

	}

	public void setXY(Double x, Double y) {
		windrad.setLayoutX(x);
		windrad.setLayoutY(y);
	}

	public void setVisibilityFalse() {
		windrad.setVisible(false);

	}

	public void setVisibilityTrue() {
		windrad.setVisible(true);

	}

	public void startRotation(Double duration) {

		rotateHead = new RotateTransition(Duration.seconds(duration), nabe);
		rotateHead.setToAngle(600000);
		rotateHead.setCycleCount(Animation.INDEFINITE);
		rotateHead.play();

	}

	public void stopRotation() {
		rotateHead.stop();

	}

	public void rotateToWindDirection(double angle, double duration) {

		RotateTransition rt = new RotateTransition(Duration.seconds(duration), fullhead);
		rt.setToAngle(angle);
		rt.setAxis(Rotate.Y_AXIS);
		rt.setCycleCount(1);
		rt.play();

	}

	public void generateWindWheel() {
		wingOne = new Box(30 / a, 250 / a, 7 / a);
		wingOne.setMaterial(new PhongMaterial(Color.ALICEBLUE));
		wingOne.getTransforms().add(new Rotate(20, 0, 0, 0, Rotate.Y_AXIS));
		wingOne.getTransforms().add(new Rotate(20, 0, 0, 0, Rotate.Z_AXIS));
		wingOne.getTransforms().add(new Rotate(131));
		wingOne.setTranslateX(290 / a);
		wingOne.setTranslateY(230 / a);
		wingOne.setTranslateZ(-50 / a);

		wingTwo = new Box(30 / a, 250 / a, 7 / a);
		wingTwo.setMaterial(new PhongMaterial(Color.ALICEBLUE));
		wingTwo.getTransforms().add(new Rotate(20, 0, 0, 0, Rotate.Y_AXIS));
		wingTwo.getTransforms().add(new Rotate(20, 0, 0, 0, Rotate.Z_AXIS));
		wingTwo.getTransforms().add(new Rotate(196));
		wingTwo.setTranslateX(310 / a);
		wingTwo.setTranslateY(-30 / a);
		wingTwo.setTranslateZ(-50 / a);

		wingThree = new Box(30 / a, 250 / a, 7 / a);
		wingThree.setMaterial(new PhongMaterial(Color.ALICEBLUE));
		wingThree.getTransforms().add(new Rotate(20, 0, 0, 0, Rotate.Y_AXIS));
		wingThree.getTransforms().add(new Rotate(20, 0, 0, 0, Rotate.Z_AXIS));
		wingThree.getTransforms().add(new Rotate(63));
		wingThree.setTranslateX(77 / a);
		wingThree.setTranslateY(110 / a);
		wingThree.setTranslateZ(20 / a);

		rotorNabe = new Sphere(30 / a);
		rotorNabe.setTranslateX(220 / a);
		rotorNabe.setTranslateY(95 / a);
		rotorNabe.setTranslateZ(-5);
		rotorNabe.getTransforms().add(new Rotate(20, 0, 0, 0, Rotate.X_AXIS));
		rotorNabe.getTransforms().add(new Rotate(20, 0, 0, 0, Rotate.Y_AXIS));

		generator = new Box(60 / a, 60 / a, 60 / a);
		generator.setMaterial(new PhongMaterial(Color.ALICEBLUE));
		generator.getTransforms().add(new Rotate(20, 0, 0, 0, Rotate.Y_AXIS));
		generator.setTranslateX(235 / a);
		generator.setTranslateY(95 / a);
		generator.setTranslateZ(10 / a);

		shaft = new Cylinder(20 / a, 400 / a);
		shaft.setMaterial(new PhongMaterial(Color.ALICEBLUE));
		shaft.getTransforms().add(new Rotate(20, 0, 0, 0, Rotate.Y_AXIS));
		shaft.setTranslateX(235 / a);
		shaft.setTranslateY(310 / a);

		movePivot(nabe, generator.getTranslateX(), generator.getTranslateY());
		movePivot(fullhead, 55.0 / a, 0.0);

		nabe.getChildren().addAll(head, rotorNabe);
		head.getChildren().addAll(wingOne, wingTwo, wingThree);

		fullhead.getChildren().addAll(nabe, generator);
		windrad.setDepthTest(DepthTest.ENABLE);
		windrad.getChildren().addAll(shaft, fullhead);
		windrad.addEventHandler(MouseEvent.MOUSE_CLICKED, new WindradClickHandler());
		root.getChildren().add(windrad);

	}

	public void changeColorToRed() {
		wingThree.setMaterial(new PhongMaterial(Color.RED));
		wingOne.setMaterial(new PhongMaterial(Color.RED));
		wingTwo.setMaterial(new PhongMaterial(Color.RED));
		shaft.setMaterial(new PhongMaterial(Color.RED));
		rotorNabe.setMaterial(new PhongMaterial(Color.RED));
		generator.setMaterial(new PhongMaterial(Color.RED));
	}
}
