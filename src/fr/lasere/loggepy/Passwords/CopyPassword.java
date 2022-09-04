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
		if (namePasswors == "") {
			return "please put argument";
		}
		namePasswors += "=";
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\Program Files (x86)\\loggepy-edition-java\\password\\passwords"), "UTF-8"));
		//BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("passwords"), "UTF-8"));
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
		lw.WriteLogInfo("the user has a copy of their password");
		return "your password has been copied: " + passwords;
	}
}
