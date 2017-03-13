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

public class Birds {

	Scene scene;
	Pane pane;
	Group birds;
	Box wingOne;
	Box wingTwo;
	Box body;
	Box beak;
	Sphere eyeOne;
	Sphere eyeTwo;
	Group root;
	int a = 4;

	public Birds(Scene scene, Pane pane, Group root) {
		this.scene = scene;
		this.pane = pane;
		this.root = root;
		createBirds();
	}
	private void createBirds() {
		
	
		birds = new Group();
		scene = new Scene(birds, 1000, 800);
		pane = new Pane();
		
		
		body = new Box(30/a, 250/a, 20/a);
		body.setMaterial(new PhongMaterial(Color.AQUA));
//		body.getTransforms().add(new Rotate(40, 0, 0, 0, Rotate.X_AXIS));
		body.getTransforms().add(new Rotate(-40, 0, 0, 0, Rotate.Y_AXIS));
		body.getTransforms().add(new Rotate(20, 0, 0, 0, Rotate.Z_AXIS));
		body.getTransforms().add(new Rotate(55));
		body.setTranslateX(200/a);
		body.setTranslateY(230/a);
		
		wingOne = new Box(40/a,150/a,10/a);
		wingOne.setMaterial(new PhongMaterial(Color.RED));
		wingOne.getTransforms().add(new Rotate(100, 0, 0, 0, Rotate.X_AXIS));
		wingOne.getTransforms().add(new Rotate(-20, 0, 0, 0, Rotate.Y_AXIS));
		wingOne.getTransforms().add(new Rotate(20, 0, 0, 0, Rotate.Z_AXIS));
		wingOne.getTransforms().add(new Rotate(125));
		wingOne.setTranslateX(200/a);
		wingOne.setTranslateY(240/a);
		
		wingTwo = new Box(40,150,10);
		wingTwo.setMaterial(new PhongMaterial(Color.RED));
		wingTwo.getTransforms().add(new Rotate(100, 0, 0, 0, Rotate.X_AXIS));
		wingTwo.getTransforms().add(new Rotate(-20, 0, 0, 0, Rotate.Y_AXIS));
		wingTwo.getTransforms().add(new Rotate(20, 0, 0, 0, Rotate.Z_AXIS));
		wingTwo.getTransforms().add(new Rotate(35));
		wingTwo.setTranslateX(200);
		wingTwo.setTranslateY(220);
		
		beak = new Box(10/a,50/a,10/a);
		beak.setMaterial(new PhongMaterial(Color.RED));
		//beak.getTransforms().add(new Rotate(100, 0, 0, 0, Rotate.X_AXIS));
		beak.getTransforms().add(new Rotate(-40, 0, 0, 0, Rotate.Y_AXIS));
		beak.getTransforms().add(new Rotate(20, 0, 0, 0, Rotate.Z_AXIS));
		beak.getTransforms().add(new Rotate(55));
		beak.setTranslateX(300/a);
		beak.setTranslateY(200/a);
		
		
		
		birds.getChildren().addAll(beak,body,wingOne);
		
		root.getChildren().add(birds);
		

	}

	public void setXY(Double x, Double y) {
		birds.setTranslateX(x);
		birds.setTranslateY(y);
	}

	public void movePivot(Node node, double x, double y) {
		// TODO Auto-generated method stub

		
	}

	public void setVisibilityFalse() {
		birds.setVisible(false);

	}

	public void setVisibilityTrue() {
		birds.setVisible(true);

	}

}
