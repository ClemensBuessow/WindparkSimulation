package main;

import gui.GUI;
import javafx.application.Application;
import javafx.application.ConditionalFeature;
import javafx.application.Platform;

import javafx.scene.DepthTest;
import javafx.scene.Group;

import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

import javafx.stage.Stage;

public class Main extends Application {
	Stage primaryStage;
	Pane region;
	Scene simulation;
	Group root;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		this.primaryStage = primaryStage;
		region = new Pane();
		root = new Group();
		
		root.setDepthTest(DepthTest.ENABLE);
		System.out.println("root z-buffer" + root.getDepthTest());
		System.out.println("3D Support?" + Platform.isSupported(ConditionalFeature.SCENE3D));
		PerspectiveCamera p = new PerspectiveCamera();
		p.setFarClip(1000);
		
		simulation = new Scene(root, 1200, 1000,true);
		
//		PerspectiveCamera pe = new PerspectiveCamera();
//		pe.setRotationAxis(Rotate.Y_AXIS);
//		simulation.setCamera(pe);
		
		
		primaryStage.setScene(simulation);
		simulation.setRoot(region);

		new GUI(simulation, region);
		
		primaryStage.show();

	}

}
