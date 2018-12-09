package cs1302.arcade;

import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.paint.Color;
import javafx.geometry.Insets;
import javafx.scene.layout.Pane;

public class SodokuSquare extends GridPane{
    private SodokuSquare[][] board = new SodokuSquare[3][];

    private Text[][] arr = new Text[3][];

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
	//setHgap(15);
	//setVgap(5);
    }//constructor


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
	//setHgap(20);
	//setVgap(10);
    }
    
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
