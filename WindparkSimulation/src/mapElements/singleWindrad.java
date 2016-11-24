package mapElements;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;

public class singleWindrad extends Application {

	Pane pane;
	Scene scene;
	Group root;
	Stage primaryStage;
	Line leftLine;
	Line rightLine;
	Line bottomLine;
	Rectangle fluegel1;
	Rectangle fluegel2;
	Rectangle fluegel3;
	Rectangle schaft;
	Circle rotorNarbe;
	Rectangle generator;
	Slider slider1;

	
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		this.primaryStage = primaryStage;
		pane = new Pane();
		root = new Group();
		scene = new Scene(root,1000,700);
		
		
		leftLine = new Line(250, 0, 250, 700);
		rightLine = new  Line(750, 0, 750, 700);
		bottomLine = new Line(250, 600, 750, 600);
		
		
		fluegel1 = new Rectangle(30, 200);
		fluegel1.setLayoutX(490);
		fluegel1.setLayoutY(290);
		fluegel1.setFill(Color.ALICEBLUE);
		fluegel1.getTransforms().add(new Rotate(290));
		
		
		fluegel2 = new Rectangle(30, 200);
		fluegel2.setLayoutX(490);
		fluegel2.setLayoutY(270);
		fluegel2.setFill(Color.ALICEBLUE);
		fluegel2.getTransforms().add(new Rotate(50));
		
		fluegel3 = new Rectangle(30, 200);
		fluegel3.setLayoutX(510);
		fluegel3.setLayoutY(270);
		fluegel3.setFill(Color.ALICEBLUE);
		fluegel3.getTransforms().add(new Rotate(160));
		
		schaft = new Rectangle(30,300);
		schaft.setLayoutX(480);
		schaft.setLayoutY(280);
		schaft.setFill(Color.ALICEBLUE);
		
		slider1 = new Slider();
		slider1.setLayoutX(50.0);
		slider1.setLayoutY(100);
		
		
		root.getChildren().addAll(leftLine,rightLine, bottomLine,fluegel1,fluegel2,fluegel3, schaft,slider1);
		
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}

}
