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
	private static final File folderPassword = new File("C:\\loggepy-edition-java\\password\\backup");
	private static final File folderlog = new File("C:\\loggepy-edition-java\\log");
	private static final File logFile = new File("C:\\loggepy-edition-java\\log\\log");
	private static final File backupPasswordFile = new File("C:\\loggepy-edition-java\\password\\backup\\backupPassword");
	private static final File passwordFile = new File("C:\\loggepy-edition-java\\password\\passwords");
	
	public static final Path passwordsFile = Paths.get("C:\\loggepy-edition-java\\password\\passwords");
	public static final Path backupPasswordsFile = Paths.get("C:\\loggepy-edition-java\\password\\backup\\backupPassword");
	
	public static void main(String[] args) throws IOException {	
		lw.WriteLogInfo("the launch of the application");
		setFile();
		launch(args);
	}

	@Override 
	public void start(Stage stage) throws IOException {
		new FXMLLoader();
		Parent gui = FXMLLoader.load(getClass().getResource("Gui/Controllers/Fxml/MainScene.fxml"));
		Scene scene = new Scene(gui);
		
		stage.setTitle("loggepy-edition-java");
		Image icon = new Image("/assets/img/Logo/index.jpg");
		stage.getIcons().add(icon);
		stage.setResizable(false);
		
		stage.setScene(scene);
		stage.show();
	}
	private static void setFile() throws IOException {
		if(!folderPassword.exists()) {
			folderPassword.mkdirs();
		}
		if(!folderlog.exists()) {
			folderlog.mkdirs();
		}
		if (!logFile.exists()) {
			logFile.createNewFile();
		}
		if (!backupPasswordFile.exists()) {
			backupPasswordFile.createNewFile();
		}
		if (!passwordFile.exists()) {
			passwordFile.createNewFile();
		}
	}
}