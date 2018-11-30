package cs1302.arcade;

import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.Group;

public class Menu extends VBox{

    private Button game1, game2;
    private ArcadeApp app;

    public Menu(ArcadeApp app){
	super();
	this.app = app;
	game1 = new Button("Checkers");
	game1.setPrefHeight(app.getScene().getHeight()/2);
	game1.setPrefWidth(app.getScene().getWidth());
	game1.setOnAction(event -> app.setPane(new Checkers()));
	
	game2 = new Button("Snake");
	game2.setPrefHeight(app.getScene().getHeight()/2);
	game2.setPrefWidth(app.getScene().getWidth());
	game2.setOnAction(event -> app.setPane(new Snake()));//or whatever game we choose

	getChildren().addAll(game1, game2);
    }



    
}//scene
