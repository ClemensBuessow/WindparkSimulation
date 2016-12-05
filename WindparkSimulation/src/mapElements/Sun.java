package mapElements;

import javafx.animation.Animation;
import javafx.animation.RotateTransition;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Sphere;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

public class Sun extends BasicElement{
	
	Sphere sun;
	Pane pane;
	Scene scene;
	RotateTransition sunRotate;
	
	public Sun(Scene scene,Pane pane){
		this.pane = pane;
		this.scene = scene;
		
		sun = new Sphere(30 );
		sun.setMaterial(new PhongMaterial(Color.YELLOW));
		sun.getTransforms().add(new Rotate(20, 0, 0, 0, Rotate.X_AXIS));
		sun.getTransforms().add(new Rotate(20, 0, 0, 0, Rotate.Y_AXIS));
		
		pane.getChildren().add(sun);
	}
	
	public void startRotation(Double duration) {
        sunRotate = new RotateTransition(Duration.seconds(duration), sun);
        sunRotate.setToAngle(500000);
        sunRotate.setCycleCount(Animation.INDEFINITE);
        sunRotate.play();
    }

	public void setXY(Double x, Double y) {
		sun.setLayoutX(x);
		sun.setLayoutY(y);
	}

	@Override
	public void stopRotation() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void movePivot(Node node, double x, double y) {
		// TODO Auto-generated method stub
		
	}
}
