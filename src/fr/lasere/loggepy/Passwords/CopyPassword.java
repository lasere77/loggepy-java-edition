package fr.lasere.loggepy.Passwords;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.IOException;
import java.util.Map;

import fr.lasere.loggepy.Encryption.Deciphers;
import fr.lasere.loggepy.Log.LogWriting;

public class CopyPassword {
	
	private static LogWriting lw = new LogWriting();
	private Deciphers deciphers = new Deciphers();
	
	public String CopyPasswords(String namePassword, int MainPassword) throws IOException {
		String passwords = "";
		if (namePassword == "") {
			return "please put argument";
		}
		namePassword = "=" + namePassword + "=";
		
		
		Map<Integer, String> EncryptPassword = deciphers.getEncryptPassword(MainPassword);
		for(int i = 0; i != EncryptPassword.size() + 1; i++) {
			System.out.println(EncryptPassword.get(i));
			if (EncryptPassword.get(i) != null && EncryptPassword.get(i).contains(namePassword)) {
				passwords = EncryptPassword.get(i).replace(namePassword, "");
				StringSelection stringSelection = new StringSelection(passwords);
				Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
				clipboard.setContents(stringSelection, null);
			}
		}
		if (passwords == "") {
			return "sorry but this password is not negist...";
		}
		lw.WriteLogInfo("the user has a copy of their password");
		return "your password has been copied: " + passwords;
	}
}
