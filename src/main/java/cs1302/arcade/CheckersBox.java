package cs1302.arcade;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.geometry.NodeOrientation;

public class CheckersBox extends Pane{

    private double boxSize = 55;

    public CheckersBox(String str){
	if(str.equals("black")){
		//addRed();
	}
	else if(str.equals("white")){
		getChildren().add(new Rectangle(boxSize, boxSize, Color.WHITE));
	}
    }

	
    public void addRed(){
	getChildren().add(new Circle(boxSize/2, Color.RED));
	setNodeOrientation(CENTER);
    }

	
    public void addWhite(){
	getChildren().add(new Circle(boxSize/2, Color.WHITE));
    }

    public void clearPiece(){
	getChildren().clear();	
    }
}
