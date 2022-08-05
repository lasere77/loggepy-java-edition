package fr.lasere.loggepy;

import java.io.File;
import java.io.IOException;

import com.google.gson.Gson;

import fr.lasere.loggepy.Init.Init;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class Loggepy extends Application {
	
	Gson gson = new Gson();
	Init init = new Init();
	
	private int heigth = 600; // hauteru = y
	private int width = 400; // largeur = x
	
	public static void main(String[] args) {
		
		File file = new File("src/fr/lasere/loggepy/Passwords/passwords");
		if(!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		launch(args);
	}

	@Override
	public void start(Stage stage) {
		Group gui = new Group();
		Scene scene = new Scene(gui, width, heigth, Color.DARKGRAY);
		
		stage.setTitle("loggepy");
		Image icon = new Image("/assets/img/Logo/index.jpg");
		stage.getIcons().add(icon);
		stage.setResizable(false);
		
		
		Text title = new Text();
		title.setText("loggepy");
		title.setX(width / 2 - 50);
		title.setY(heigth / 2);
		title.setFont(Font.font("verdana", 30));
		title.setFill(Color.BLUE);
		
		
		
		Rectangle topBare = generateRectangle(0, 0, 50, width, Color.BLUE);
		Rectangle bottomBare = generateRectangle(heigth - 50, 0, width, heigth, Color.BLUE);
		Rectangle[] allRectangle = {topBare, bottomBare};
		init.initRectangle(gui, allRectangle);
	
		
		Image imgMenu = new Image(getClass().getResourceAsStream("/assets/img/Window/menu.png"));
		ImageView iImageMenu = new ImageView(imgMenu);
		Image imgClose = new Image(getClass().getResourceAsStream("/assets/img/Window/close.png"));
		ImageView iImgClose = new ImageView(imgClose);
		
		Rectangle rectangleSwitche = generateRectangle(0, 0, heigth, 120, Color.BLUE);
		Rectangle borderRectangleSwitche = generateRectangle(0, 120, heigth, 3, Color.AQUA);
		
		Button btnSwitche = new Button();
		Button btnOfSwitche = new Button();

		//config btnOfSwitche
		btnOfSwitche.setGraphic(iImgClose);
		btnOfSwitche.setLayoutY(0);
		btnOfSwitche.setLayoutX(72);
		btnOfSwitche.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				gui.getChildren().removeAll(rectangleSwitche, borderRectangleSwitche, btnOfSwitche, btnOfSwitche);
				gui.getChildren().add(btnSwitche);
			}
		});
		
		//config btnSwitche
		btnSwitche.setGraphic(iImageMenu);
		btnSwitche.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				gui.getChildren().removeAll(btnSwitche);
				gui.getChildren().addAll(rectangleSwitche, borderRectangleSwitche, btnOfSwitche);
				
			}
		});
		
		gui.getChildren().addAll(title, btnSwitche);
		stage.setScene(scene);
		stage.show();
	}
	
	
	private Rectangle generateRectangle(int y, int x, int heigth, int width, Color fill) {
		Rectangle rectangle = new Rectangle();
		rectangle.setY(y);
		rectangle.setX(x);
		
		rectangle.setWidth(width);
		rectangle.setHeight(heigth);

		
		if(fill == null) {
			return rectangle;
		}else {
			rectangle.setFill(fill);
		}
		return rectangle;
	}	
}
