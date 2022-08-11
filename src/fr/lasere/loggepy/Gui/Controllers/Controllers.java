package fr.lasere.loggepy.Gui.Controllers;

import java.io.IOException;

import fr.lasere.loggepy.Log.LogWriting;
import fr.lasere.loggepy.Passwords.GeneratPassword;
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
	
	//generate password
	@FXML
	private TextField IDEntryGeneratPassword;
	@FXML 
	private Label IDLabelConfirme;
	private String namePassword;
	
	public void btnHome(ActionEvent e) throws IOException {
		lw.WriteLogInfo("user was in the section: /Home");
		setScene(e, "Main.fxml");
	}
	public void btnGeneratPassword(ActionEvent e) throws IOException {
		lw.WriteLogInfo("user was in the section: /Generat Password");
		setScene(e, "sceneGeneratPassword.fxml");
	}
	public void btnGetPassword(ActionEvent e) throws IOException {
		lw.WriteLogInfo("user was in the section: /Get Password");
	}
	public void btnAddPassword(ActionEvent e) throws IOException {
		lw.WriteLogInfo("user was in the section: /Add Password");
	}
	public void btnCopy(ActionEvent e) throws IOException {
		lw.WriteLogInfo("user was in the section: /Copy");
	}
	public void btnRepair(ActionEvent e) throws IOException {
		lw.WriteLogInfo("user was in the section: /Repair");
	}
	public void btnHelp(ActionEvent e) throws IOException {
		lw.WriteLogInfo("user was in the section: /Help");
	}
	public void btnDelPassword(ActionEvent e) throws IOException {
		lw.WriteLogInfo("user was in the section: /Del Password");
	}
	public void btnGetUpdate(ActionEvent e) throws IOException {
		lw.WriteLogInfo("user was in the section: /Get Update");
	}
	public void btnExit(ActionEvent e) throws IOException {
		((Stage)(((Button)e.getSource()).getScene().getWindow())).close();
		lw.WriteLogInfo("application and system shutdown");
	}
	
	public void btnConfirmeGeneratPassword(ActionEvent e) throws IOException {
		namePassword = IDEntryGeneratPassword.getText();
		new GeneratPassword().GeneratPasswords(namePassword);
		IDLabelConfirme.setText("your password has been saved (this information is fake)");
	}
	
	
	
	private void setScene(ActionEvent e, String file) throws IOException {
		Parent gui = FXMLLoader.load(getClass().getResource("../Fxml/" + file));
		stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(gui);
		stage.setScene(scene);
		stage.show();
	}
	
	//gets
	public String getNamePassword() {
		return namePassword;
	}
}
