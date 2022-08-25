package fr.lasere.loggepy.Passwords;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

import fr.lasere.loggepy.Loggepy;

public class DelPassword {
	
	/* 
	 * very important error: when a password is deleted new passwords will no longer be visible from loggepy.
	 * but there are beautiful and well written in the file.
	 * I noticed that a LOT of space is made after the passwords I think they are generated because of the del password function and I think they are responsible for the problem...
	 */
	
	private String fullPassword;
	private String allPassword;
	private String oldPassword;
	
	public String getDelPassword(String namePassword, String password) throws IOException {
		fullPassword = namePassword + "=" + password;
		Files.write(Loggepy.passwordsFile, delPassword(fullPassword).getBytes(), StandardOpenOption.CREATE, StandardOpenOption.WRITE);
		return fullPassword;
	}
	
	private String delPassword(String fullPassword) throws IOException {
		oldPassword = new GetPassword().GetPasswords();
		allPassword = oldPassword.replaceAll(fullPassword, "f");
		return "test";
	}
}
