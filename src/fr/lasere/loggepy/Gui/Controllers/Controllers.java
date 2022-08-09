package fr.lasere.loggepy.Gui.Controllers;

import java.io.IOException;

import fr.lasere.loggepy.Log.LogWriting;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Controllers {
	
	LogWriting lw = new LogWriting();
	
	public void btnGeneratPassword(ActionEvent e) throws IOException {
		System.out.println("btnGeneratPassword");
	}
	public void btnGetPassword(ActionEvent e) {
		System.out.println("btnGetPassword");
	}
	public void btnAddPassword(ActionEvent e) {
		System.out.println("btnAddPassword");
	}
	public void btnCopy(ActionEvent e) {
		System.out.println("btnCopy");
	}
	public void btnRepair(ActionEvent e) {
		System.out.println("btnRepair");
	}
	public void btnHelp(ActionEvent e) {
		System.out.println("btnHelp");
	}
	public void btnDelPassword(ActionEvent e) {
		System.out.println("btnDelPassword");
	}
	public void btnGetUpdate(ActionEvent e) {
		System.out.println("btnGetUpdate");
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
