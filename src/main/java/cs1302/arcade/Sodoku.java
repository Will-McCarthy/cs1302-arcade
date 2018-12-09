package cs1302.arcade;

import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.control.Button;
import javafx.scene.text.Font;

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

    public Sodoku(ArcadeApp app){
	for(int i=0;i<9;i++){
		arr[i] = new int[9];
		for(int j=0; j<9; j++){
			arr[i][j] = 2;
		}
	}//for i 
 
	getChildren().addAll(new SodokuSquare(easy, this), numStrip());

    }//constructor


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
	
    private void setNum(int k){
	numSetting = k;
    }

    public int getNumSetting(){
	return numSetting;
    } 

    

}//sodoku
