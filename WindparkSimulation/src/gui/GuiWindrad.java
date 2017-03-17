package gui;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import mapElements.SingleWindWheel;

public class GuiWindrad {
	Pane pane;
	Scene scene;
	Group root;

	public void GuiWindradShow() {

		pane = new Pane();
		root = new Group();
		scene = new Scene(root, 1000, 700);

		new SingleWindWheel();

	}

}
