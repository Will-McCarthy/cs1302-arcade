package cs1302.arcade;

import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;

public class CheckersBoard extends GridPane {

    private CheckersBox[][] arr = new CheckersBox[8][];
    public CheckersBoard(){

	for(int i = 0; i<8; i++){
		arr[i] = new CheckersBox[8];
		for(int j=0; j<8; j++){
			if(j%2==i%2){
				arr[i][j] = new CheckersBox("white");
			}
			else{
				arr[i][j] = new CheckersBox("black");				
			}
			
			add(arr[i][j], i, j);
		}//for j

	}//for i
	arr[0][1].addRed();
    }//constructor

    public CheckersBox get(int i, int j){
	return arr[i][j];
    }
}
