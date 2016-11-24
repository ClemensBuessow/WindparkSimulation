package mapElements;
import handler.WindradClickHandler;
import javafx.animation.Animation;
import javafx.animation.RotateTransition;
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

public class Windrad extends BasicElement {

	Box fluegel1;
	Box fluegel2;
	Box fluegel3;
	Cylinder schaft;
	Sphere rotorNarbe;
	Box generator;
	Pane pane;
	Scene scene;
	int a = 4;
	Group windrad;
	Group head;
	Group fullhead;
	
	 RotateTransition rotateHead;

	public Windrad(Scene scene, Pane pane) {

		this.scene = scene;
		this.pane = pane;

		head = new Group();
		windrad = new Group();
		fullhead = new Group();
		
		fluegel1 = new Box(30 / a, 250 / a, 7 / a);
		fluegel1.setMaterial(new PhongMaterial(Color.ALICEBLUE));
		fluegel1.getTransforms().add(new Rotate(20, 0, 0, 0, Rotate.X_AXIS));
		fluegel1.getTransforms().add(new Rotate(20, 0, 0, 0, Rotate.Y_AXIS));
		fluegel1.getTransforms().add(new Rotate(20, 0, 0, 0, Rotate.Z_AXIS));
//		fluegel1.getTransforms().add(new Translate(0, 0, -10));
		fluegel1.getTransforms().add(new Rotate(130));
		fluegel1.setLayoutX(280 / a);
		fluegel1.setLayoutY(220 / a);
		

		fluegel2 = new Box(30 / a, 250 / a, 7 / a);
		fluegel2.setMaterial(new PhongMaterial(Color.ALICEBLUE));
		fluegel2.getTransforms().add(new Rotate(20, 0, 0, 0, Rotate.X_AXIS));
		fluegel2.getTransforms().add(new Rotate(20, 0, 0, 0, Rotate.Y_AXIS));
		fluegel2.getTransforms().add(new Rotate(20, 0, 0, 0, Rotate.Z_AXIS));
		fluegel2.getTransforms().add(new Rotate(190));
		fluegel2.setLayoutX(280 / a);
		fluegel2.setLayoutY(10 / a);

		fluegel3 = new Box(30 / a, 250 / a, 7 / a);
		fluegel3.setMaterial(new PhongMaterial(Color.ALICEBLUE));
		fluegel3.getTransforms().add(new Rotate(20, 0, 0, 0, Rotate.X_AXIS));
		fluegel3.getTransforms().add(new Rotate(20, 0, 0, 0, Rotate.Y_AXIS));
		fluegel3.getTransforms().add(new Rotate(20, 0, 0, 0, Rotate.Z_AXIS));
		fluegel3.getTransforms().add(new Rotate(65));
		fluegel3.setLayoutX(100 / a);
		fluegel3.setLayoutY(100 / a);

		rotorNarbe = new Sphere(30 / a);
		rotorNarbe.setLayoutX(220 / a);
		rotorNarbe.setLayoutY(105 / a);
		rotorNarbe.getTransforms().add(new Rotate(20, 0, 0, 0, Rotate.X_AXIS));
		rotorNarbe.getTransforms().add(new Rotate(20, 0, 0, 0, Rotate.Y_AXIS));

		generator = new Box(60 / a, 60 / a, 60 / a);
		generator.setMaterial(new PhongMaterial(Color.ALICEBLUE));
		generator.getTransforms().add(new Rotate(20, 0, 0, 0, Rotate.X_AXIS));
		generator.getTransforms().add(new Rotate(20, 0, 0, 0, Rotate.Y_AXIS));
		generator.setLayoutX(235 / a);
		generator.setLayoutY(95 / a);

		schaft = new Cylinder(20 / a, 400 / a);
		schaft.setMaterial(new PhongMaterial(Color.ALICEBLUE));
		schaft.getTransforms().add(new Rotate(20, 0, 0, 0, Rotate.X_AXIS));
		schaft.getTransforms().add(new Rotate(20, 0, 0, 0, Rotate.Y_AXIS));
		schaft.setLayoutX(235 / a);
		schaft.setLayoutY(310 / a);

		movePivot(head, 53.5 / a, -16 / a);
		movePivot(fullhead, 14, 0);

		head.getChildren().addAll(fluegel1, fluegel2, fluegel3, rotorNarbe);
//		fullhead.getChildren().addAll(fluegel1,fluegel2,fluegel3,rotorNarbe,generator);
		windrad.getChildren().addAll(schaft, generator, head,fullhead);
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
	
	public void setVisibility(){
		windrad.setVisible(false);
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
		RotateTransition rt = new RotateTransition(Duration.seconds(5), head);
		rt.setToAngle(360);
		rt.setAxis(Rotate.Y_AXIS);
		rt.setCycleCount(Animation.INDEFINITE);
		rt.play();
	}

}

