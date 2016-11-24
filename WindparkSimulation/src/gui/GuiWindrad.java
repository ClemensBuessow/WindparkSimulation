package gui;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import mapElements.singleWindrad;

/**
 * 
 * 
 * @author Sophie Schumann
 * @since 04.11.2016 16:16:01
 * @version Release 5.2
 */
public class GuiWindrad {
	Pane pane;
	Scene scene;
	Group root;

    public void GuiWindradShow() {
    	
    	pane = new Pane();
		root = new Group();
		scene = new Scene(root,1000,700);
		
       new singleWindrad();
    	
    }

}
