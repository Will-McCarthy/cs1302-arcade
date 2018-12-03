package cs1302.arcade;

import javafx.scene.layout.Pane;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
public class Snake extends Pane{
    private Board board = new Board();
    private ArcadeApp app;
    private int x,y;
    private int xFood, yFood;
    private Dir dir;
    private boolean alive;
    public Snake(ArcadeApp app){
	super();
	this.app = app;
	dir = new Dir();
	alive = true;
	getChildren().add(board);
	board.setSquare("green", 15, 15);
	x = 15;
	y = 15;
	makeFood();

	app.getScene().setOnKeyPressed(event -> {
		System.out.println(event);
		if (event.getCode() == KeyCode.LEFT){dir.changeDir(-1,0);}	
		if (event.getCode() == KeyCode.RIGHT){dir.changeDir(1,0);}	
		if (event.getCode() == KeyCode.UP){dir.changeDir(0,-1);}	
		if (event.getCode() == KeyCode.DOWN){dir.changeDir(0,1);}	
	    });
	this.requestFocus();
	while(alive){
	    update();
	    delay();
	    alive = false;

	}//while

	
    }//constructor
    private void update(){
	moveHead(dir.getX(), dir.getY());
	//erase tail
    }//update
    private void delay(){

    }//delay
    
   
    private void moveHead(int i, int j){//need to add kill mechanic for border and itself
	x += i;
	if(x>=30){x=0;}
	if(x<0){x=29;}
	y += j;
	if(y>=30){y=0;}
	if(y<0){y=29;}
	board.setSquare("green", x, y);
	if(x==xFood && y==yFood){ makeFood();}
    }

    private void makeFood(){
	int i = (int)(Math.random()*30);
	int j = (int)(Math.random()*30);
	if(board.getColor(i, j) == Color.GREEN){ makeFood();}//if cant use spot, start over
	board.setSquare("white", i, j);
	xFood = i;
	yFood = j;	
    }//makeFood



    
}//class

