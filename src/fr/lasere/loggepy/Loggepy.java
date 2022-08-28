package fr.lasere.loggepy;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import fr.lasere.loggepy.Log.LogWriting;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;


public class Loggepy extends Application {	
	
	private static LogWriting lw = new LogWriting();
	private static File folderPassword = new File("C:\\Program Files (x86)\\loggepy-edition-java\\password\\backup");
	private static File folderlog = new File("C:\\Program Files (x86)\\loggepy-edition-java\\log");
	public static final Path passwordsFile = Paths.get("C:\\Program Files (x86)\\loggepy-edition-java\\password\\passwords");
	public static final Path backupPasswordsFile = Paths.get("C:\\Program Files (x86)\\loggepy-edition-java\\password\\backup\\backupPassword");
	
	
	public static void main(String[] args) throws IOException {	
		lw.WriteLogInfo("the launch of the application");
		if(!folderPassword.exists()) {
			folderPassword.mkdirs();
		}
		if(!folderlog.exists()) {
			folderlog.mkdirs();
		}
		launch(args);
	}

	@Override 
	public void start(Stage stage) throws IOException {
		new FXMLLoader();
		Parent gui = FXMLLoader.load(getClass().getResource("Gui/Controllers/Fxml/MainScene.fxml"));
		Scene scene = new Scene(gui);
		
		stage.setTitle("loggepy");
		Image icon = new Image("/assets/img/Logo/index.jpg");
		stage.getIcons().add(icon);
		stage.setResizable(false);
		
		stage.setScene(scene);
		stage.show();
	}	
}
