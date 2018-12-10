package cs1302.arcade;

import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.control.Button;
import javafx.scene.text.Font;
/**
* This class is the main class for sokodu (intentionally misspeelled). The game is played just like 
* traditionally. To place a block, press the number button you want then the block
* */
public class Sodoku extends VBox{

    private int[][] arr = new int[9][];
    private int numSetting = 1;

    private int[][] easy = new int[][]{
			   { 0, 0, 5,   1, 8, 2,   0, 0, 0},
			   { 0, 0, 0,   3, 7, 9,   1, 6, 0},
			   { 0, 0, 0,   0, 0, 4,   0, 0, 2},
			   
			   { 5, 0, 9,   2, 0, 0,   0, 4, 7},
			   { 0, 6, 1,   0, 0, 5,   3, 0, 0},
			   { 0, 4, 0,   0, 6, 0,   8, 0, 0},
			
			   { 2, 1, 0,   0, 0, 6,   0, 3, 8},
			   { 9, 0, 0,   0, 2, 0,   7, 1, 0},
			   { 8, 5, 0,   7, 3, 0,   0, 9, 4}
			};
/** 
* Constructor for sudoku creates new board and adds buttons to the bottom of the screen
*
* @param app Pass in application so that you can do things like change the window size and  
* */
    public Sodoku(ArcadeApp app){
	getChildren().addAll(new SodokuSquare(easy, this), numStrip());

    }//constructor

/** 
* numStrip creates HBox full of buttons 1 through 9
*@return HBox
* */
    private HBox numStrip(){
	HBox strip = new HBox();
	for(int i = 1; i<10; i++){
		Button temp = new Button(""+i);
		temp.setFont(new Font(23));
		int k = i;
		temp.setOnAction(event -> {
			setNum(k);
		});
		strip.getChildren().add(temp);
	}
	return strip;
    }//numStrip
/** 
* setNum is what each of the buttons call to change the number the player places.
*@param k the number the player places
* */
    private void setNum(int k){
	numSetting = k;
    }
/**
* getNumSetting is what each block in the game calls when clicked. it returns the 
* number the player wants to place
* @return numSetting number to set in block
* */
    public int getNumSetting(){
	return numSetting;
    } 

}//sodoku
