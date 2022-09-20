package fr.lasere.loggepy.Passwords;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import fr.lasere.loggepy.Log.LogWriting;

public class GetPassword {
	
	private static LogWriting lw = new LogWriting();
	private String allPasswords = "";
	private char charPasswordEncrypt = ')';
	
	public String GetPasswords(int MainPassword) throws IOException {
		lw.WriteLogInfo("the user viewed these passwords");

		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\loggepy-edition-java\\password\\passwords"), "UTF-8"));
		String line = br.readLine();
		while (line != null) {
			allPasswords += line + "\n";
			for(int i = 0; i != line.length(); i++) {
				charPasswordEncrypt = line.charAt(i);
				//avec ce char le soumettre au décalacge du mot de passe
				//ensuite l'ajouté a un String qui cerra les String final pour le mot de passe chiffré
				//charPasswordEncrypt.add(MainPassword);
			}
			line = br.readLine();
		}
		br.close();
		System.out.println(MainPassword);
		return allPasswords;
	}
}
