package fr.lasere.loggepy.Passwords.GeneratedPassword;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Random;

import fr.lasere.loggepy.Log.LogWriting;

public class GeneratedPassword {
	
	
	private LogWriting lw = new LogWriting();
	private Random random = new Random();
	
	private final Path passwordFile = Paths.get("src/fr/lasere/loggepy/Passwords/passwords");	
	
	private String password;
	private String fragmentePassword = "";
	
	public String GeneratedPasswords(String namePassword) throws IOException {
		String fullPassword = namePassword + "=" + setPassword() + "\n";
		Files.write(passwordFile, fullPassword.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.APPEND);
		lw.WriteLogInfo("the password has been saved");
		return fullPassword;
	}
	
	private String setPassword() throws IOException {
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
 