package fr.lasere.loggepy.Passwords;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import fr.lasere.loggepy.Log.LogWriting;

public class CopyPassword {
	
	private static LogWriting lw = new LogWriting();
	private String passwords = "";
	
	public String CopyPasswords(String namePasswors) throws IOException {
		lw.WriteLogInfo("the user has copy one of c is password");
		
		namePasswors += "=";
		
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("src/fr/lasere/loggepy/Passwords/passwords"), "UTF-8"));
		String line = br.readLine();
		while (line != null) {
			if(line.contains(namePasswors)) {
				passwords = line.replace(namePasswors, "");
				StringSelection stringSelection = new StringSelection(passwords);
				Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
				clipboard.setContents(stringSelection, null);
			}
			line = br.readLine();
		}
		br.close();
		return passwords;
	}
}
