package fr.lasere.loggepy.Passwords;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import fr.lasere.loggepy.Backup.Repair;
import fr.lasere.loggepy.GetError.SameName;
import fr.lasere.loggepy.Log.LogWriting;

public class AddPassword {
	
	private LogWriting lw = new LogWriting();
	private Repair repair = new Repair();
	private SameName sameName = new SameName();
	private final Path passwordFile = Paths.get("C:\\loggepy-edition-java\\password\\passwords");	
	
	public String AddPasswords(String namePassword, String password, int MainPassword) throws IOException {
		if(namePassword == "" || password == "") {
			return "please put argument";
		}else if (namePassword.contains("=") || password.contains("=")) {
			return "please do not put the sign '='";
		}else if (sameName.hasSameName(namePassword)) {
			return "you already have a password with the same name...";
		}
		lw.WriteLogInfo("your password has just been added");
		String result = namePassword + "=" + password;
		String fullPassword =  "\n" + "$$" + "=" + namePassword + "=" + "$" + password + "$";
		Files.write(passwordFile, fullPassword.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.APPEND);
		lw.WriteLogInfo("the password has been saved");
		repair.setBackup();
		return "your password has been saved: " + result;
	}
}
