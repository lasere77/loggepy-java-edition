package fr.lasere.loggepy;

import java.io.File;
import java.io.IOException;

import fr.lasere.loggepy.Log.LogWriting;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;


public class Loggepy extends Application {

	private static LogWriting lw = new LogWriting();

	
	public static void main(String[] args) throws IOException {
		lw.WriteLogInfo("the launch of the application");
		
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
	public void start(Stage stage) throws IOException {
		new FXMLLoader();
		Parent gui = FXMLLoader.load(getClass().getResource("Gui/Fxml/Main.fxml"));
		Scene scene = new Scene(gui);
		scene.getStylesheets().add(getClass().getResource("Gui/Css/style.css").toExternalForm());
		
		stage.setTitle("loggepy");
		Image icon = new Image("/assets/img/Logo/index.jpg");
		stage.getIcons().add(icon);
		stage.setResizable(false);
		
		stage.setScene(scene);
		stage.show();
	}	
}
