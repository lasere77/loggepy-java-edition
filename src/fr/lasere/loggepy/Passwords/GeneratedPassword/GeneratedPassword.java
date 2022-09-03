package fr.lasere.loggepy.Passwords.GeneratedPassword;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Random;

import fr.lasere.loggepy.Backup.Repair;
import fr.lasere.loggepy.GetError.SameName;
import fr.lasere.loggepy.Log.LogWriting;

public class GeneratedPassword {
	
	private LogWriting lw = new LogWriting();
	private Repair repair = new Repair();
	private SameName sameName = new SameName();
	private Random random = new Random();
	
	private final Path passwordFile = Paths.get("C:\\Program Files (x86)\\loggepy-edition-java\\password\\passwords");	
	
	private String password;
	private String fragmentePassword = "";
	
	public String GeneratedPasswords(String namePassword) throws IOException {
		if(namePassword == "") {
			return "please put argument";
		}else if (namePassword.contains("=")) {
			return "please do not put the sign '='";
		}else if (sameName.hasSameName(namePassword)) {
			return "you already have a password with the same name...";
		}
		String result = namePassword + "=" + setPassword();
		String fullPassword = "\n" + namePassword + "=" + setPassword();
		Files.write(passwordFile, fullPassword.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.APPEND);
		lw.WriteLogInfo("the password has been saved");
		repair.setBackup();
		return "your password has been saved: " + result;
	}
	
	private String setPassword() throws IOException {
		fragmentePassword = "";
		for(int i = 0; i <= 26; i++) {
			int rand = random.nextInt(3 + 1);
			if (rand == 0) {
				fragmentePassword += PasswordArguments.uppercase[random.nextInt(PasswordArguments.uppercase.length)];
			}else if (rand == 1) {
				fragmentePassword += PasswordArguments.lowercase[random.nextInt(PasswordArguments.lowercase.length)];
			}else if (rand == 2) {
				fragmentePassword += PasswordArguments.nb[random.nextInt(PasswordArguments.nb.length)];
			}else {
				fragmentePassword += PasswordArguments.specialCharacter[random.nextInt(PasswordArguments.specialCharacter.length)];
			}
		}
		password = fragmentePassword;
		lw.WriteLogInfo("the password has just been created");
		return password;
	}
}
 