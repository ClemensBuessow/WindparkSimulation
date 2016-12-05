package mapElements;

import javafx.scene.Node;

public abstract class BasicElement {

	/**
	 * starting a rotation with a specific duration
	 * 
	 * @param duration the time that is needed for the full rotation
	 **/
	public  void startRotation(Double duration) {
		
	}
	
	/**
	 * stops he rotation
	 */
	
	public void stopRotation() {
		
	}
	
	/**
	 * needed to set the layout of an object 
	 * 
	 * @param x x for setLayoutX;
	 * @param y y for setLayoutY;
	 */
	
	public abstract void setXY(Double x, Double y);
	
	/**
	 * move the pivot element to another point
	 * 
	 * @param node The node you want to move
	 * @param x The x-coordinate you want to move	
	 * @param y The y-coordinate you want to move
	 */
	
	public abstract void movePivot(Node node, double x, double y);
}
