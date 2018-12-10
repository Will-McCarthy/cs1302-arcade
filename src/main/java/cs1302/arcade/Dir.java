package cs1302.arcade;

/**
* stores the direction the snake is traveling
* */
public class Dir{

    int x = 0;
    int y = 0;
/**
* changes direction twards i, j
* @param i x direction component
* @param j y direction component
* */
    public void changeDir(int i, int j){
	x = i;
	y = j;
    }//changeDir
/** 
* gets x direction
* @return x component direction in x
* */
    public int getX(){
	return x;
    }//getX
	
/** 
* gets y direction
* @return y component direction in y
* */
    public int getY(){
	return y;
    }//getY
	
}//Dir
