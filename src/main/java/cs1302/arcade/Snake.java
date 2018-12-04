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

    private int boardLength = 30;
    private Board board = new Board(boardLength);
    private ArcadeApp app;
    private int x = boardLength/2;
    private int y = boardLength/2;
    private int xFood, yFood;
    private Dir dir = new Dir();
    private Timeline timeline = new Timeline();;
    private KeyFrame keyframe;
    private int time=0;
    private int tailLength = -1;
    
    public Snake(ArcadeApp app){
	super();
	this.app = app;
	getChildren().add(board);
	board.getBox(x, y).setFill(Color.LIME);

	app.getScene().setOnKeyPressed(event -> {	
		if (event.getCode() == KeyCode.LEFT){dir.changeDir(-1,0);}	
		if (event.getCode() == KeyCode.RIGHT){dir.changeDir(1,0);}	
		if (event.getCode() == KeyCode.UP){dir.changeDir(0,-1);}	
		if (event.getCode() == KeyCode.DOWN){dir.changeDir(0,1);}	
	    });
	this.requestFocus();

	makeFood();
	keyframe = new KeyFrame(Duration.seconds(0.3), event -> update());

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

