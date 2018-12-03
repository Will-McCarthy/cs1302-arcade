package cs1302.arcade;

import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;


public class Board extends GridPane {
    private int rowLength = 30;
    private Rectangle[][] squares = new Rectangle[rowLength][];
    private double squareSize = 14;
    private String black = "-fx-background-color: black;";
    private String green ="-fx-background-color: green;";
    private String white ="-fx-background-color: white;";

    public Board(){	
	setVgap(1);
	setHgap(1);
	for(int i=0; i<rowLength; i++){
		squares[i] = new Rectangle[rowLength];
		for(int j=0; j<rowLength; j++){
			squares[i][j] = new Rectangle(squareSize, squareSize);
			squares[i][j].setFill(Color.BLACK);
			add(squares[i][j], i, j);
		}//for j
	}//for i

    }//constructor
    public void setSquare(String color,int i, int j){
	if(color.equals("black")){
	    squares[i][j].setFill(Color.BLACK);
	}
	else if(color.equals("green")){
	    squares[i][j].setFill(Color.LIME);
	}
	else if(color.equals("white")){
	    squares[i][j].setFill(Color.WHITE);
	}
	else{
	    System.out.println("color not spelled right " + color);
	}
	
	
    }

    public Paint getColor(int i, int j){
	return squares[i][j].getFill();
    }//getFill

			       


}
