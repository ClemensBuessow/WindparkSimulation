package mapElements;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
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
	Rectangle wingOne;
	Rectangle wingTwo;
	Rectangle wingThree;
	Rectangle shaft;
	Circle rotorNabe;
	Rectangle generator;
	Slider slider1;
	Label power;

	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		this.primaryStage = primaryStage;
		pane = new Pane();
		root = new Group();
		scene = new Scene(root,1000,700);
		
		
		leftLine = new Line(250, 0, 250, 700);
		rightLine = new  Line(750, 0, 750, 700);
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
		
		shaft = new Rectangle(30,300);
		shaft.setLayoutX(480);
		shaft.setLayoutY(280);
		shaft.setFill(Color.ALICEBLUE);
		
		slider1 = new Slider();
		slider1.setLayoutX(50.0);
		slider1.setLayoutY(100);
		
		power = new Label("Leistung");
		
		
		
		root.getChildren().addAll(leftLine,rightLine, bottomLine,wingOne,wingTwo,wingThree, shaft,slider1);
		
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}

}
