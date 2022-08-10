package fr.lasere.loggepy.Gui.Controllers;

import java.io.IOException;

import fr.lasere.loggepy.Log.LogWriting;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class Controllers {
	
	private LogWriting lw = new LogWriting();
	
	@FXML
	private Label path;
	
	public void btnGeneratPassword(ActionEvent e) throws IOException {
		path.setText("/Generat Password");
		lw.WriteLogInfo("user was in the section: /Generat Password");
	}
	public void btnGetPassword(ActionEvent e) throws IOException {
		path.setText("/Get Password");
		lw.WriteLogInfo("user was in the section: /Get Password");
	}
	public void btnAddPassword(ActionEvent e) throws IOException {
		path.setText("/Add Password");
		lw.WriteLogInfo("user was in the section: /Add Password");
	}
	public void btnCopy(ActionEvent e) throws IOException {
		path.setText("/Copy");
		lw.WriteLogInfo("user was in the section: /Copy");
	}
	public void btnRepair(ActionEvent e) throws IOException {
		path.setText("/Repair");
		lw.WriteLogInfo("user was in the section: /Repair");
	}
	public void btnHelp(ActionEvent e) throws IOException {
		path.setText("/Help");
		lw.WriteLogInfo("user was in the section: /Help");
	}
	public void btnDelPassword(ActionEvent e) throws IOException {
		path.setText("/Del Password");
		lw.WriteLogInfo("user was in the section: /Del Password");
	}
	public void btnGetUpdate(ActionEvent e) throws IOException {
		path.setText("/Get Update");
		lw.WriteLogInfo("user was in the section: /Get Update");
	}
	public void btnExit(ActionEvent e) {
		((Stage)(((Button)e.getSource()).getScene().getWindow())).close();
		try {
			lw.WriteLogInfo("application and system shutdown");
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

}
