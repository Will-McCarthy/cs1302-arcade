package cs1302.arcade;

import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;


public class Board extends GridPane {
    private int rowLength = 30;
    private Box[][] squares = new Box[rowLength][];
    private double squareSize = 14;

    public Board(){	
	
	for(int i=0; i<rowLength; i++){
		squares[i] = new Box[rowLength];
		for(int j=0; j<rowLength; j++){
			squares[i][j] = new Box(squareSize, squareSize);
			add(squares[i][j], i, j);
		}//for j
	}//for i
    }//constructor
	       
    public Box getBox(int i, int j){
	return squares[i][j];
    }//getBox
   
    public int getBoardLength(){
	return rowLength;
    }//getBoardLength

}
