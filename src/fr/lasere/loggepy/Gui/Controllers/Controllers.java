package fr.lasere.loggepy.Gui.Controllers;

import java.io.IOException;

import fr.lasere.loggepy.Backup.Repair;
import fr.lasere.loggepy.Log.LogWriting;
import fr.lasere.loggepy.Passwords.AddPassword;
import fr.lasere.loggepy.Passwords.CopyPassword;
import fr.lasere.loggepy.Passwords.DelPassword;
import fr.lasere.loggepy.Passwords.GeneratPassword;
import fr.lasere.loggepy.Passwords.GetPassword;
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
	
	private Stage stage;
	private Scene scene;
	
	private String namePassword;
	private String password;
	
	//generated password
	@FXML
	private TextField IDEntryGeneratPassword;
	@FXML 
	private Label IDLabelConfirme;
	//get password
	@FXML
	private TextField IDEntryGetPassword;
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
	private TextField IDEntryDelPassword;
	@FXML
	private Label IDLabelConfirmeDelPassword;
	//Update
	@FXML
	private Label IDpatchNote, IDLabelConfirmeUpdate;
	
	
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
	
	public void btnLaunch(ActionEvent e) throws IOException {
		setScene(e, "sceneHome.fxml");
	}
	public void btnExit(ActionEvent e) throws IOException {
		((Stage)(((Button)e.getSource()).getScene().getWindow())).close();
		lw.WriteLogInfo("application and system shutdown");
	}
	public void btnHome(ActionEvent e) throws IOException {
		lw.WriteLogInfo("user was in the section: /Home");
		setScene(e, "sceneHome.fxml");
	}
	
	
	
	
	public void btnConfirmeGeneratPassword(ActionEvent e) {
		namePassword = IDEntryGeneratPassword.getText();
		new GeneratPassword().GeneratPasswords(namePassword);
		IDLabelConfirme.setText("your password has been saved (this information is fake)");
	}
	
	public void  btnConfirmeGetPassword(ActionEvent e) {
		namePassword = IDEntryGetPassword.getText();
		new GetPassword().GetPasswords(namePassword);
		IDLabelConfirmeGetPassword.setText("your password is: (this information is fake)");
	}
	public void btnConfirmeAddPassword(ActionEvent e) {
		namePassword = IDEntryAddPasswordNamePassword.getText();
		password = IDEntryAddPasswordPassword.getText();
		new AddPassword().AddPasswords(namePassword, password);
		IDLabelConfirmeAddPassword.setText("your password is: (this information is fake)");
	}
	public void btnConfirmeCopy(ActionEvent e) {
		namePassword = IDEntryCopy.getText();
		new CopyPassword().CopyPasswords(namePassword);
		IDLabelConfirmeCopy.setText("your password is: (this information is fake)");
	}
	public void btnConfirmeRepair(ActionEvent e) {
		new Repair().Repaired();
		IDLabelConfirmeRepair.setText("we have tried to restore the password (this information is fake)");
	}
	public void btnConfirmeDelPassword(ActionEvent e) {
		namePassword = IDEntryDelPassword.getText();
		new DelPassword().DelPassword(namePassword);
		IDLabelConfirmeDelPassword.setText("your password has been deleted (this information is fake)");
	}
	public void btnConfirmeUpdate(ActionEvent e) {
		new Update().Updates();
		IDLabelConfirmeUpdate.setText("the update was done successfully (this information is fake)");
	}
	
	
	private void setScene(ActionEvent e, String file) throws IOException {
		Parent gui = FXMLLoader.load(getClass().getResource("../Fxml/" + file));
		stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(gui);
		stage.setScene(scene);
		stage.show();
	}
}
