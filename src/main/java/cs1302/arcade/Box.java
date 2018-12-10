package cs1302.arcade;

import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
/** 
* Box class is a rectangle of the snake board. It keeps track
* of when it was changed to green so that we know when to change 
* it back to black.
* */
public class Box extends Rectangle{

    private int setTime = 0; 
/** 
* @inheritDoc
* */
    public Box(double i, double j){
	super(i, j);
    }//constructot
/**
* setTail makes this box a part of the snakes tail. It also sets setTime so we know 
* when we need to set it back to black.
* @param time the iteration which this was called.
* */ 
    public void setTail(int time){
	setFill(Color.LIME);
	setTime = time;
    }//setTail
/** 
* Method erases the tail dependent when the tail was made and how long the tail is.
* @param time number of iteration called
* @param tailLength how many iterations block should wait before turning back to black
* */
    public void checkTail(int time, int tailLength){
	if(getFill() == Color.WHITE) {
	    return;
	}
	else if(time-tailLength >= setTime){
		setFill(Color.BLACK);
	
	}//if
    }//checkTail
}//class
	
