package fr.lasere.loggepy.Gui.Controllers;

import java.io.IOException;

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
	private GetPassword oldPassword = new GetPassword();
	private CopyPassword copyPassword = new CopyPassword();
	
	private Stage stage;
	private Scene scene;
	
	private String namePassword;
	private String password;
	
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
	
	
	public void btnLaunch(ActionEvent e) throws IOException { //this button has as its butte of validated or not the main password (which will be set later) and to change the language of the application 
		setScene(e, "sceneHome.fxml");
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
		checkIfArgAsPut(IDLabelConfirme, "your password has been saved: " , generatedPassword.GeneratedPasswords(namePassword));
	}
	public void btnConfirmeGetPassword(ActionEvent e) throws IOException {
		IDLabelConfirmeGetPassword.setText(new GetPassword().GetPasswords());
	}
	public void btnConfirmeAddPassword(ActionEvent e) throws IOException {
		namePassword = IDEntryAddPasswordNamePassword.getText();
		password = IDEntryAddPasswordPassword.getText();
		checkIfArgAsPut(IDLabelConfirmeAddPassword, "your password has been saved: ", addPassword.AddPasswords(namePassword, password));
	}
	public void btnConfirmeCopy(ActionEvent e) throws IOException {
		namePassword = IDEntryCopy.getText();
		checkIfArgAsPut(IDLabelConfirmeCopy, "your password has been copied: ", copyPassword.CopyPasswords(namePassword));
	}
	public void btnConfirmeRepair(ActionEvent e) throws IOException {
		repair.Repaired();
		IDLabelConfirmeRepair.setText("we have tried to restore the password");
	}
	public void IDBtnConfirmeHelp(ActionEvent e) {
		//IDLabelInfo.setText("generated password: in this scene you will have to put in the first textFied the name of your password (what it is responsible for) \nand you will only have to press the button to validate and generate your password");
	}
	public void btnConfirmeDelPassword(ActionEvent e) throws IOException {
		namePassword = IDEntryDelPasswordNamePassword.getText();
		password = IDEntryDelPassword.getText();
		checkIfArgAsPut(IDLabelConfirmeDelPassword, "your password has been deleted: ", delPassword.getDelPassword(namePassword, password, oldPassword.GetPasswords()));
	}
	//in development
	public void btnConfirmeUpdate(ActionEvent e) throws IOException {
		new Update().Updates();
		IDLabelConfirmeUpdate.setText("the update was done successfully (this information is fake)");
	}
	
	private void checkIfArgAsPut(Label iDLabel, String text, Object action) throws IOException {
		if(namePassword == null || namePassword == "") {
			iDLabel.setText("please put argument");
		}else {
			iDLabel.setText(text + action);
		}
	}
	
	private void setScene(ActionEvent e, String file) throws IOException {
		Parent gui = FXMLLoader.load(getClass().getResource("Fxml/" + file));
		stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(gui);
		stage.setScene(scene);
		stage.show();
		}
}
