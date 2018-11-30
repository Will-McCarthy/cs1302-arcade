package cs1302.arcade;

import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.Group;

public class Menu extends VBox{

    private Button game1 = new Button("game1");
    private Button game2 = new Button("game2");
    private Application app;

    public Menu(Application app){
	super();

	game1 = new Button("game1");
	game1.setOnAction(event -> app.setPane(new Tetris()));//or whatever game we choose

	game2 = new Button("game2");
	game2.setOnAction(event -> app.setPane(new Snake()));//or whatever game we choose

	getChildren().addAll(game1, game2);
	this.app=app;
    }



    
}//scene
