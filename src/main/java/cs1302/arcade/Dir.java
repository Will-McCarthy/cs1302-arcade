package cs1302.arcade;

public class Dir{

    int x = 0;
    int y = 0;
    
    public void changeDir(int i, int j){
	x = i;
	y = j;

    }//changeDir
    public int getX(){
	return x;
    }
    public int getY(){
	return y;
    }

    
}//Dir
