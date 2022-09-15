package fr.lasere.loggepy.Encryption;

import java.io.IOException;

import fr.lasere.loggepy.Log.LogWriting;

public class Ciphers {
	
	private LogWriting lw = new LogWriting();
	private int MainPassword;
	
	public boolean Cipher(String iDEntryMainPassword) throws IOException {
		System.out.println(iDEntryMainPassword);
		lw.WriteLogInfo("master password processing...");
		try {
			MainPassword = Integer.parseInt(iDEntryMainPassword);
			System.out.println(MainPassword);
		} catch (Exception e) {
			lw.WriteLogError("the user did not enter something correct...");
			return false;
		}
		return true;
	}
}
