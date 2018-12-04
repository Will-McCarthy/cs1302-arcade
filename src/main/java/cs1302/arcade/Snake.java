package cs1302.arcade;

import javafx.scene.layout.Pane;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.animation.Timeline;
import javafx.animation.KeyFrame;
import javafx.event.ActionEvent;
import javafx.util.Duration;
import java.lang.Exception;

public class Snake extends Pane{
    private Board board = new Board();
    private ArcadeApp app;
    private int x,y;
    private int xFood, yFood;
    private Dir dir;
    private Timeline timeline;
    private KeyFrame keyframe;
    private int time;
    private int tailLength = -1;
    private int boardLength;
    
    public Snake(ArcadeApp app){
	super();
	time = 0;
	this.app = app;
	dir = new Dir();
	getChildren().add(board);
	board.getBox(15, 15).setFill(Color.LIME);
	x = 15;
	y = 15;
	boardLength = board.getBoardLength();
	makeFood();
	app.getScene().setOnKeyPressed(event -> {	
		if (event.getCode() == KeyCode.LEFT){dir.changeDir(-1,0);}	
		if (event.getCode() == KeyCode.RIGHT){dir.changeDir(1,0);}	
		if (event.getCode() == KeyCode.UP){dir.changeDir(0,-1);}	
		if (event.getCode() == KeyCode.DOWN){dir.changeDir(0,1);}	
	    });
	this.requestFocus();

	keyframe = new KeyFrame(Duration.seconds(0.3), event -> update());

	timeline = new Timeline();
	timeline.setCycleCount(Timeline.INDEFINITE);
	timeline.getKeyFrames().add(keyframe);
	timeline.play();
	
    }//constructor

    private void update(){
	for(int i=0; i<boardLength; i++){
		for(int j=0; j<boardLength; j++){
			board.getBox(i, j).checkTail(time, tailLength);
		}//for
	}//for i
	time++;
	moveHead(dir.getX(), dir.getY());
    }//update
   
    private void moveHead(int i, int j){
	x += i;
	y += j;

	try{
	    if(board.getBox(x,y).getFill() == Color.LIME){
	    	timeline.stop();
		app.setPane(new Menu("Your score was " + tailLength, app));
	    }
	    board.getBox(x, y).setTail(time);
	    if(x==xFood && y==yFood){ makeFood();}
	}catch(Exception e){
	    timeline.stop();
	    app.setPane(new Menu("Your score was " + tailLength, app));
	}//
	
    }

    private void makeFood(){
	int i = (int)(Math.random()*boardLength);
	int j = (int)(Math.random()*boardLength);	
	if(board.getBox(i,j).getFill() == Color.GREEN){ makeFood();}//if cant use spot, start over
	board.getBox(i, j).setFill(Color.WHITE);
	xFood = i;
	yFood = j;
	tailLength++;
    }//makeFood



    
}//class

