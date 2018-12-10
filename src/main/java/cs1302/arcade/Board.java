package cs1302.arcade;

import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

/**
* board is the board for snake. Its just a bunch of rectangles
* that hold white, green or black.
* */
public class Board extends GridPane {
    
    private Box[][] squares;
    private double squareSize = 14;
/**
* Makes a new board to specified length.
* @param rowLength Number of rows and columns on board
* */
    public Board(int rowLength){	
	squares = new Box[rowLength][];	
	for(int i=0; i<rowLength; i++){
		squares[i] = new Box[rowLength];
		for(int j=0; j<rowLength; j++){
			squares[i][j] = new Box(squareSize, squareSize);
			add(squares[i][j], i, j);
		}//for j
	}//for i
    }//constructor
/** 
* just returns the box specified
* @return Box box specified
* */
    public Box getBox(int i, int j){
	return squares[i][j];
    }//getBox

}//class
