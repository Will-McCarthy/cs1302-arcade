package cs1302.arcade;

import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.paint.Color;
import javafx.geometry.Insets;
import javafx.scene.layout.Pane;
/**
* sodokuSquare is kind of all of the backend and board for our sodoku game.
* It makes the board squares and sets them to change when clicked. 
* */
public class SodokuSquare extends GridPane{
    private SodokuSquare[][] board = new SodokuSquare[3][];

    private Text[][] arr = new Text[3][];
/**
* This constructor makes a 3x3 box of text objects. We make 9 of these to make the
* whole board.
* @param mini Mini is the array which this sodokuSquare will represent
* @param sodoku Sodoku is the game that made this object-lets it get numSetting
* @param dontUse param is just here to differentiate this contstructor from the other
* */
    private SodokuSquare(int[][] mini, Sodoku sodoku, int dontUse){
	setStyle("-fx-background-color: black;");
	for(int i = 0; i<3; i++){
		arr[i] = new Text[3];
		for(int j = 0; j<3; j++){
			if(mini[j][i] != 0){
				arr[i][j] = new Text(" " + mini[j][i] + " ");
				arr[i][j].setFill(Color.MAROON);
			}else{
				arr[i][j] = new Text("    ");

				Text temp1 = arr[i][j];
			
				arr[i][j].setOnMouseClicked(event -> {
					temp1.setText(" "+ sodoku.getNumSetting() + " ");
				});
			}

			arr[i][j].setFont(new Font(35));
		
			GridPane temp2 = new GridPane();
			temp2.add(arr[i][j], 0, 0);
			temp2.setStyle("-fx-border-color: black;");
			add(temp2, i, j);
		}//for j
	}//for i
    }//constructor

/** 
* This is the constructor called by the Sodoku class. It makes each of the large blocks
* that each hold 9 numbers. 
*
* @param init init the initial board in an array
* @param sodoku This is the game calling the method
* */
    public SodokuSquare(int[][] init, Sodoku sodoku){
	setStyle("-fx-background-color: white;");
	for(int i = 0; i<3; i++){
		board[i] = new SodokuSquare[3];
		for(int j = 0; j<3; j++){
			board[i][j] = new SodokuSquare(miniArr(init, i, j), sodoku, 7);
			board[i][j].setStyle("-fx-border-color: black;");
			add(board[i][j], i, j);
		}//for j
	}//for i
    }//sodokuSquare
	
/** 
* When sodokuSquare gets the inital board, this method breaks it up into each of
* of the 3x3 blocks.
*
* @param init the whole starting board
* @param y the first coordinate of the set of 9
* @param x the second coordinate of the set of 9
* */
    private int[][] miniArr(int[][] init, int y, int x){

	int[][] mini = new int[3][];
	
	for(int i = 0; i < 3; i++){
		mini[i] = new int[3];	
		for(int j = 0; j < 3; j++){
			mini[i][j] = init[3*x+i][3*y+j];
		}//for j
	}//for x
	return mini;
    }//miniArr 

}//class
