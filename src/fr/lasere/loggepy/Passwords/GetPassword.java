package fr.lasere.loggepy.Passwords;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import fr.lasere.loggepy.Log.LogWriting;

public class GetPassword {
	
	private static LogWriting lw = new LogWriting();
	private String allPasswords = "";
	
	public String GetPasswords() throws IOException {
		lw.WriteLogInfo("the user viewed these passwords");

		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("src/fr/lasere/loggepy/Passwords/passwords"), "UTF-8"));
		String line = br.readLine();
		while (line != null) {
			allPasswords += line + "\n";
			line = br.readLine();
		}
		br.close();
		return allPasswords;
	}
}
