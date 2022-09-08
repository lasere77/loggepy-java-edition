package fr.lasere.loggepy.Encryption;

import java.io.IOException;

import fr.lasere.loggepy.Log.LogWriting;
import javafx.scene.control.Label;

public class Deciphers {
	
	private LogWriting lw = new LogWriting();
	@SuppressWarnings("unused")
	private int MainPassword;
	
	public boolean decipher(String iDEntryMainPassword, Label IDLabelErrorMainPassword) throws IOException {
		System.out.println(iDEntryMainPassword);
		lw.WriteLogInfo("master password processing...");
		try {
			@SuppressWarnings("unused")
			int MainPassword = Integer.parseInt(iDEntryMainPassword);
		} catch (Exception e) {
			lw.WriteLogError("the user did not enter something correct...");
			IDLabelErrorMainPassword.setText("please put only numbers");
			return false;
		}
		return true;
	}
	
}
