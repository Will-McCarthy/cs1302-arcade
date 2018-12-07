package cs1302.arcade;

import javafx.scene.layout.Pane;

public class Checkers extends Pane{

	public Checkers(ArcadeApp app){
		getChildren().add(new CheckersBoard());
	}

}//class
