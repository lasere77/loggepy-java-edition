package fr.lasere.loggepy.Passwords;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

import fr.lasere.loggepy.Log.LogWriting;

public class DelPassword {
	
	private LogWriting lw = new LogWriting();
	private static final Path passwordFile = Paths.get("C:\\Program Files (x86)\\loggepy-edition-java\\password\\passwords");	
	
	private String fullPassword;
	private String allPassword = "";
	
	public String delPassword(String namePassword, String password) throws IOException {
		if(namePassword == "" || password == "") {
			return "please put argument";
		}
		fullPassword = namePassword + "=" + password;
		Files.write(passwordFile, getDelPassword(fullPassword).getBytes(), StandardOpenOption.CREATE, StandardOpenOption.WRITE);
		lw.WriteLogInfo("the user has deleted one of its password");
		return "your password has been deleted: " + fullPassword;
	}
	
	private String getDelPassword(String fullPassword) throws IOException {
		List<String> passwordArray = Files.readAllLines(passwordFile);
		for(int i = 0; i != passwordArray.size(); i++) {
			if (passwordArray.get(i).equals(fullPassword)) {
				passwordArray.remove(i);
			}
			if (passwordArray.get(i) != passwordArray.get(0)) {
				allPassword += "\n" + passwordArray.get(i);
			}
		}
		return allPassword;
	}
}
