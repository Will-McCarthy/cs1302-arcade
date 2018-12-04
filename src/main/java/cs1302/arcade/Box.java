package cs1302.arcade;

import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;

public class Box extends Rectangle{

    private int setTime = 0; 
    
    public Box(double i, double j){
	super(i, j);
    }//constructot
    
    public void setTail(int time){
	setFill(Color.LIME);
	setTime = time;
    }//setTail

    public void checkTail(int time, int tailLength){
	if(getFill() == Color.WHITE) {
	    return;
	}
	if(time-tailLength >= setTime){
		setFill(Color.BLACK);
	
	}//if
    }//checkTail


}
	
