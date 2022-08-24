package fr.lasere.loggepy.Passwords;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import fr.lasere.loggepy.Log.LogWriting;

public class AddPassword {
	
	private LogWriting lw = new LogWriting();
	private final Path passwordFile = Paths.get("src/fr/lasere/loggepy/Passwords/passwords");	
	
	public String AddPasswords(String namePassword, String password) throws IOException {
		lw.WriteLogInfo("your password has just been added");
		String fullPassword = namePassword + "=" + password + "\n";
		Files.write(passwordFile, fullPassword.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.APPEND);
		lw.WriteLogInfo("the password has been saved");
		return fullPassword;
	}
}
