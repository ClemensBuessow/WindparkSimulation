package mapElements;
import handler.WindradClickHandler;
import javafx.animation.Animation;
import javafx.animation.ParallelTransition;
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

	Box wingOne;
	Box wingTwo;
	Box wingThree;
	Cylinder shaft;
	Sphere rotorNabe;
	Box generator;
	Pane pane;
	Scene scene;
	int a = 4;
	Group windrad;
	Group head;
	Group fullhead;
	
	 RotateTransition rotateHead;

	public WindWheel(Scene scene, Pane pane) {

		this.scene = scene;
		this.pane = pane;

		head = new Group();
		windrad = new Group();
		fullhead = new Group();
		
		wingOne = new Box(30 / a, 250 / a, 7 / a);
		wingOne.setMaterial(new PhongMaterial(Color.ALICEBLUE));
//		wingOne.getTransforms().add(new Rotate(20, 0, 0, 0, Rotate.X_AXIS));
		wingOne.getTransforms().add(new Rotate(20, 0, 0, 0, Rotate.Y_AXIS));
		wingOne.getTransforms().add(new Rotate(20, 0, 0, 0, Rotate.Z_AXIS));
//		fluegel1.getTransforms().add(new Translate(0, 0, -10));
		wingOne.getTransforms().add(new Rotate(131));
		wingOne.setTranslateX(290 / a);
		wingOne.setTranslateY(230 / a);
		wingOne.setTranslateZ(-50/ a);
		
		

		wingTwo = new Box(30 / a, 250 / a, 7 / a);
		wingTwo.setMaterial(new PhongMaterial(Color.ALICEBLUE));
//		wingTwo.getTransforms().add(new Rotate(20, 0, 0, 0, Rotate.X_AXIS));
		wingTwo.getTransforms().add(new Rotate(20, 0, 0, 0, Rotate.Y_AXIS));
		wingTwo.getTransforms().add(new Rotate(20, 0, 0, 0, Rotate.Z_AXIS));
		wingTwo.getTransforms().add(new Rotate(196));
		wingTwo.setTranslateX(310 / a);
		wingTwo.setTranslateY(-30 / a);
		wingTwo.setTranslateZ(-50/a);

		wingThree = new Box(30 / a, 250 / a, 7 / a);
		wingThree.setMaterial(new PhongMaterial(Color.ALICEBLUE));
//		wingThree.getTransforms().add(new Rotate(20, 0, 0, 0, Rotate.X_AXIS));
		wingThree.getTransforms().add(new Rotate(20, 0, 0, 0, Rotate.Y_AXIS));
		wingThree.getTransforms().add(new Rotate(20, 0, 0, 0, Rotate.Z_AXIS));
		wingThree.getTransforms().add(new Rotate(63));
		wingThree.setTranslateX(77 / a);
		wingThree.setTranslateY(110 / a);
		wingThree.setTranslateZ(20/a);

		rotorNabe = new Sphere(30 / a);
		rotorNabe.setLayoutX(220 / a);
		rotorNabe.setLayoutY(95 / a);
		rotorNabe.setTranslateZ(-5);
		rotorNabe.getTransforms().add(new Rotate(20, 0, 0, 0, Rotate.X_AXIS));
		rotorNabe.getTransforms().add(new Rotate(20, 0, 0, 0, Rotate.Y_AXIS));
		

		generator = new Box(60 / a, 60 / a, 60 / a);
		generator.setMaterial(new PhongMaterial(Color.ALICEBLUE));
//		generator.getTransforms().add(new Rotate(20, 0, 0, 0, Rotate.X_AXIS));
		generator.getTransforms().add(new Rotate(20, 0, 0, 0, Rotate.Y_AXIS));
		generator.setLayoutX(235 / a);
		generator.setLayoutY(95 / a);
		generator.setTranslateZ(10/a);
		

		shaft = new Cylinder(20 / a, 400 / a);
		shaft.setMaterial(new PhongMaterial(Color.ALICEBLUE));
//		shaft.getTransforms().add(new Rotate(20, 0, 0, 0, Rotate.X_AXIS));
		shaft.getTransforms().add(new Rotate(20, 0, 0, 0, Rotate.Y_AXIS));
		shaft.setLayoutX(235 / a);
		shaft.setLayoutY(310 / a);

		movePivot(head, 50 / a, -14 / a);
		movePivot(fullhead, 55/a, 0);

		movePivot(windrad, -10, 0);
		head.getChildren().addAll(wingOne, wingTwo, wingThree);
		
		fullhead.getChildren().addAll(head,generator,rotorNabe);
		windrad.setDepthTest(DepthTest.ENABLE);
		windrad.getChildren().addAll(shaft, fullhead);
		windrad.addEventHandler(MouseEvent.MOUSE_CLICKED, new WindradClickHandler());
		
	
		pane.getChildren().add(windrad);

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
	
	public void setVisibilityFalse(){
		windrad.setVisible(false);
		
	}
	
	public void setVisibilityTrue(){
		windrad.setVisible(true);
		
	}
	
	public void startRotation(Double duration) {
        rotateHead = new RotateTransition(Duration.seconds(duration), head);
        rotateHead.setToAngle(500000);
        rotateHead.setCycleCount(Animation.INDEFINITE);
        rotateHead.play();
        
      
    }
	
	public void stopRotation() {
		rotateHead.stop(); 
		
	}
	public void gesamtRotate(){
		  RotateTransition rt = new RotateTransition(Duration.seconds(5),fullhead);
			rt.setToAngle(360);
			rt.setAxis(Rotate.Y_AXIS);
			rt.setCycleCount(Animation.INDEFINITE);
			rt.play();
	}

}

