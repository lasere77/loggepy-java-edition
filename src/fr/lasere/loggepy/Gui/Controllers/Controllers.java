package fr.lasere.loggepy.Gui.Controllers;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import fr.lasere.loggepy.Backup.Repair;
import fr.lasere.loggepy.Log.LogWriting;
import fr.lasere.loggepy.Passwords.AddPassword;
import fr.lasere.loggepy.Passwords.CopyPassword;
import fr.lasere.loggepy.Passwords.DelPassword;
import fr.lasere.loggepy.Passwords.GetPassword;
import fr.lasere.loggepy.Passwords.GeneratedPassword.GeneratedPassword;
import fr.lasere.loggepy.Update.Update;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Controllers {

	private LogWriting lw = new LogWriting();
	private GeneratedPassword generatedPassword = new GeneratedPassword();
	private AddPassword addPassword = new AddPassword();
	private DelPassword delPassword = new DelPassword();
	private Repair repair = new Repair();
	private CopyPassword copyPassword = new CopyPassword();
	private final int MainPasswordError = 159753456;
	private static int realMainPassword = 000000000;
	
	private Stage stage;
	private Scene scene;
	
	private String namePassword;
	private String password;
	
	//main
	@FXML
	private Label IDLabelErrorMainPassword;
	@FXML
	private TextField IDEntryMainPassword;
	//home
	@FXML
	private Label version;
	//generated password
	@FXML
	private TextField IDEntryGeneratedPassword;
	@FXML 
	private Label IDLabelConfirme;
	//get password
	@FXML 
	private Label IDLabelConfirmeGetPassword;
	//add password
	@FXML
	private TextField IDEntryAddPasswordNamePassword, IDEntryAddPasswordPassword;
	@FXML
	private Label IDLabelConfirmeAddPassword;
	//copy
	@FXML
	private TextField IDEntryCopy;
	@FXML 
	private Label IDLabelConfirmeCopy;
	//Repair
	@FXML 
	private Label IDLabelConfirmeRepair;
	//del passwod
	@FXML
	private TextField IDEntryDelPassword, IDEntryDelPasswordNamePassword;
	@FXML
	private Label IDLabelConfirmeDelPassword;
	//Update
	@FXML
	private Label IDpatchNote, IDLabelConfirmeUpdate;
	//help
	@FXML
	private Label IDLabelInfo;
	
	
	public void btnLaunch(ActionEvent e) throws IOException { //this button has as its butte of validated or not the main password (which will be set later)
		if (getTrueMainPassword() != MainPasswordError) {
			setScene(e, "sceneHome.fxml");
		}
	}
	
	
	public void btnGeneratedPassword(ActionEvent e) throws IOException {
		lw.WriteLogInfo("user was in the section: /Generated Password");
		setScene(e, "sceneGeneratedPassword.fxml");
	}
	public void btnGetPassword(ActionEvent e) throws IOException {
		lw.WriteLogInfo("user was in the section: /Get Password");
		setScene(e, "sceneGetPassword.fxml");
	}
	public void btnAddPassword(ActionEvent e) throws IOException {
		lw.WriteLogInfo("user was in the section: /Add Password");
		setScene(e, "sceneAddPassword.fxml");
	}
	public void btnCopy(ActionEvent e) throws IOException {
		lw.WriteLogInfo("user was in the section: /Copy");
		setScene(e, "sceneCopy.fxml");
	}
	public void btnRepair(ActionEvent e) throws IOException {
		lw.WriteLogInfo("user was in the section: /Repair");
		setScene(e, "sceneRepair.fxml");
	}
	public void btnHelp(ActionEvent e) throws IOException {
		lw.WriteLogInfo("user was in the section: /Help");
		setScene(e, "sceneHelp.fxml");
	}
	public void btnDelPassword(ActionEvent e) throws IOException {
		lw.WriteLogInfo("user was in the section: /Del Password");
		setScene(e, "sceneDelPassword.fxml");
	}
	public void btnGetUpdate(ActionEvent e) throws IOException {
		lw.WriteLogInfo("user was in the section: /Get Update");
		setScene(e, "sceneUpdate.fxml");
	}
	
	public void btnExit(ActionEvent e) throws IOException {
		((Stage)(((Button)e.getSource()).getScene().getWindow())).close();
		lw.WriteLogInfo("application and system shutdown");
	}
	public void btnHome(ActionEvent e) throws IOException {
		lw.WriteLogInfo("user was in the section: /Home");
		setScene(e, "sceneHome.fxml");
	}
	
	
	
	public void btnConfirmeGeneratPassword(ActionEvent e) throws IOException {
		namePassword = IDEntryGeneratedPassword.getText();
		IDLabelConfirme.setText(generatedPassword.GeneratedPasswords(namePassword));
	}
	public void btnConfirmeGetPassword(ActionEvent e) throws IOException {
		System.out.println(realMainPassword);
		IDLabelConfirmeGetPassword.setText(new GetPassword().GetFullPasswords(getTrueMainPassword()));
	}
	public void btnConfirmeAddPassword(ActionEvent e) throws IOException {
		namePassword = IDEntryAddPasswordNamePassword.getText();
		password = IDEntryAddPasswordPassword.getText();
		IDLabelConfirmeAddPassword.setText(addPassword.AddPasswords(namePassword, password));
	}
	public void btnConfirmeCopy(ActionEvent e) throws IOException {
		namePassword = IDEntryCopy.getText();
		IDLabelConfirmeCopy.setText(copyPassword.CopyPasswords(namePassword));
	}
	public void btnConfirmeRepair(ActionEvent e) throws IOException {
		repair.Repaired();
		IDLabelConfirmeRepair.setText("we have tried to restore the password");
	}
	public void IDBtnConfirmeHelp(ActionEvent e) throws IOException, URISyntaxException {
		Desktop desktop = Desktop.getDesktop();
		desktop.browse(new URI("https://lasere77.github.io/loggepy-web/loggepy-edition-java/help.html"));
		IDLabelInfo.setText("please check your internet connection if the page does not want to launch.");
	}
	public void btnConfirmeDelPassword(ActionEvent e) throws IOException {
		namePassword = IDEntryDelPasswordNamePassword.getText();
		password = IDEntryDelPassword.getText();
		IDLabelConfirmeDelPassword.setText(delPassword.delPassword(namePassword, password));
	}
	public void btnConfirmeUpdate(ActionEvent e) throws IOException, InterruptedException {
		IDLabelConfirmeUpdate.setText("please wait...");
		new Update().Updates();
		IDLabelConfirmeUpdate.setText("Thanks for waiting");
	}
	
	private void setScene(ActionEvent e, String file) throws IOException {
		Parent gui = FXMLLoader.load(getClass().getResource("Fxml/" + file));
		stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(gui);
		stage.setScene(scene);
		stage.show();		
	}
	
	private int getTrueMainPassword() throws IOException {
		lw.WriteLogInfo("master password processing...");
		if (realMainPassword != 000000000) {
			return realMainPassword;
		}
		String MainPassword = IDEntryMainPassword.getText();
		MainPassword = MainPassword.replaceAll("[^\\d]", " "); 
		MainPassword = MainPassword.replace(" ", "");
		try {
			realMainPassword = Integer.parseInt(MainPassword);
			if (realMainPassword == 000000000) {
				lw.WriteLogError("the user was not granted permission to use this password because it is already in use by the system");
				return MainPasswordError;
			}
	        return realMainPassword; 
		} catch (Exception e) {
			lw.WriteLogWarn("the user did not enter a complete password...");
			return MainPasswordError;
		}
	}
}
