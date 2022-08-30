package fr.lasere.loggepy.Passwords;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import fr.lasere.loggepy.Backup.Repair;
import fr.lasere.loggepy.Log.LogWriting;

public class AddPassword {
	
	private LogWriting lw = new LogWriting();
	private Repair repair = new Repair();
	private final Path passwordFile = Paths.get("C:\\Program Files (x86)\\loggepy-edition-java\\password\\passwords");	
	
	public String AddPasswords(String namePassword, String password) throws IOException {
		lw.WriteLogInfo("your password has just been added");
		String result = namePassword + "=" + password;
		String fullPassword =  "\n" + namePassword + "=" + password;
		Files.write(passwordFile, fullPassword.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.APPEND);
		lw.WriteLogInfo("the password has been saved");
		repair.setBackup();
		return result;
	}
}
