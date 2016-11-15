package Main;

import GUI.GUI;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {
Stage primaryStage;
Pane region;
Scene simulation;
Group root;

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		this.primaryStage = primaryStage;
		region = new  Pane();
		root = new Group();
		simulation = new Scene(root,1200,1000);
		primaryStage.setScene(simulation);
		simulation.setRoot(region);
		
		GUI start = new GUI(simulation,region);
		
		primaryStage.show();
		
	}

}
