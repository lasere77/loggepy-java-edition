package fr.lasere.loggepy.Passwords;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import fr.lasere.loggepy.Encryption.Deciphers;
import fr.lasere.loggepy.Log.LogWriting;

public class DelPassword {
	
	private LogWriting lw = new LogWriting();
	private Deciphers deciphers = new Deciphers();
	private static final Path passwordFile = Paths.get("C:\\loggepy-edition-java\\password\\passwords");	
	
	private String fullPassword;
	private String allPassword = "";
	private int lengthPasswordArray;
	
	public String delPassword(String namePassword, String password, int MainPassword) throws IOException {
		if(namePassword == "" || password == "") {
			return "please put argument";
		}
		String RealPassword = "";
		for(int i = 0; i != password.length(); i++) {
			 RealPassword += deciphers.cesar(MainPassword, password.charAt(i), true);	
		}
		System.out.println("le vrais: " + RealPassword);
		System.out.println("le chiffré: " + password);
		fullPassword = "=" + namePassword + "=" + RealPassword;
		System.out.println("full password: " + fullPassword);
		String result = getDelPassword(fullPassword);
		Files.write(passwordFile, result.getBytes());
		result = namePassword + "=" + password;
		lw.WriteLogInfo("the user has deleted one of its password");
		return "your password has been deleted: " + result;
	}
	
	private String getDelPassword(String fullPassword) throws IOException {
		allPassword = "";
		List<String> passwordArray = Files.readAllLines(passwordFile);
		lengthPasswordArray = passwordArray.size();
		for(int i = 0; i < lengthPasswordArray; i++) {
			System.out.println("la ligne actuelle: " + passwordArray.get(i));
			try {
				if (passwordArray.get(i).equals(fullPassword)) {
					passwordArray.remove(i);
					lengthPasswordArray -= 1;
				}
				if (passwordArray.get(i) != passwordArray.get(0)) {
					allPassword += "\n" + passwordArray.get(i);
				}
			} catch (Exception e) {
				lw.WriteLogWarn("line out of reach...");
				return allPassword;
			}
		}
		return allPassword;
	}
}