package mapElements;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.shape.Sphere;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;

public class Birds extends Application {

	Scene scene;
	Pane pane;
	Group birds;
	Box wingOne;
	Box wingTwo;
	Box body;
	Box beak;
	Sphere eyeOne;
	Sphere eyeTwo;

//	public Birds(Scene scene, Pane pane) {
//		this.scene = scene;
//		this.pane = pane;

//	}
	@Override
	public void start(Stage primaryStage) throws Exception {
		birds = new Group();
		scene = new Scene(birds, 1000, 800);
		pane = new Pane();
		
		
		body = new Box(30, 250, 20);
		body.setMaterial(new PhongMaterial(Color.AQUA));
//		body.getTransforms().add(new Rotate(40, 0, 0, 0, Rotate.X_AXIS));
		body.getTransforms().add(new Rotate(-40, 0, 0, 0, Rotate.Y_AXIS));
		body.getTransforms().add(new Rotate(20, 0, 0, 0, Rotate.Z_AXIS));
		body.getTransforms().add(new Rotate(55));
		body.setTranslateX(200);
		body.setTranslateY(230);
		
		wingOne = new Box(40,150,10);
		wingOne.setMaterial(new PhongMaterial(Color.RED));
		wingOne.getTransforms().add(new Rotate(100, 0, 0, 0, Rotate.X_AXIS));
		wingOne.getTransforms().add(new Rotate(-20, 0, 0, 0, Rotate.Y_AXIS));
		wingOne.getTransforms().add(new Rotate(20, 0, 0, 0, Rotate.Z_AXIS));
		wingOne.getTransforms().add(new Rotate(125));
		wingOne.setTranslateX(200);
		wingOne.setTranslateY(240);
		
		wingTwo = new Box(40,150,10);
		wingTwo.setMaterial(new PhongMaterial(Color.RED));
		wingTwo.getTransforms().add(new Rotate(100, 0, 0, 0, Rotate.X_AXIS));
		wingTwo.getTransforms().add(new Rotate(-20, 0, 0, 0, Rotate.Y_AXIS));
		wingTwo.getTransforms().add(new Rotate(20, 0, 0, 0, Rotate.Z_AXIS));
		wingTwo.getTransforms().add(new Rotate(35));
		wingTwo.setTranslateX(200);
		wingTwo.setTranslateY(220);
		
		beak = new Box(10,50,10);
		beak.setMaterial(new PhongMaterial(Color.RED));
		//beak.getTransforms().add(new Rotate(100, 0, 0, 0, Rotate.X_AXIS));
		beak.getTransforms().add(new Rotate(-40, 0, 0, 0, Rotate.Y_AXIS));
		beak.getTransforms().add(new Rotate(20, 0, 0, 0, Rotate.Z_AXIS));
		beak.getTransforms().add(new Rotate(55));
		beak.setTranslateX(300);
		beak.setTranslateY(200);
		
		
		
		birds.getChildren().addAll(wingTwo,beak,body,wingOne);
		
		pane.getChildren().add(birds);
		
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public void setXY(Double x, Double y) {
		// TODO Auto-generated method stub

	}

	public void movePivot(Node node, double x, double y) {
		// TODO Auto-generated method stub

	}

	private void createBirds() {
		
	}

	
	
	public static void main(String[] args) {
		launch(args);
	}

}
