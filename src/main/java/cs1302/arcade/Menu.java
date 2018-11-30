package cs1302.arcade;

import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.Group;

public class Menu extends VBox{

    private Button game1, game2;
    private ArcadeApp app;
    private Checkers checkers;
    private Snake snake;

    public Menu(ArcadeApp app){
	super();
	this.app = app;
	checkers = new Checkers();
	snake = new Snake();

	game1 = new Button("Checkers");
	game1.setPrefHeight(app.getScene().getHeight()/2);
	game1.setPrefWidth(app.getScene().getWidth());
	game1.setOnAction(event -> app.setPane(checkers));
	
	game2 = new Button("Snake");
	game2.setPrefHeight(app.getScene().getHeight()/2);
	game2.setPrefWidth(app.getScene().getWidth());
	game2.setOnAction(event -> app.setPane(snake));

	getChildren().addAll(game1, game2);
    }



    
}//scene
