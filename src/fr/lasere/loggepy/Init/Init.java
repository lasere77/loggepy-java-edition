package fr.lasere.loggepy.Init;

import javafx.scene.Group;
import javafx.scene.shape.Rectangle;

public class Init {
	
	public void initRectangle(Group gui, Rectangle[] rectangle) {
		for(int i = 0; i < rectangle.length; i++) {
			gui.getChildren().addAll(rectangle[i]);
		}
	}
	public void initRectangle(Group gui, Rectangle rectangle) {
		gui.getChildren().addAll(rectangle);
	}
	
}
