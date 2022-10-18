package fr.lasere.loggepy.Passwords.GeneratedPassword;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Random;

import fr.lasere.loggepy.Backup.Repair;
import fr.lasere.loggepy.Encryption.Deciphers;
import fr.lasere.loggepy.GetError.SameName;
import fr.lasere.loggepy.Gui.Controllers.Controllers;
import fr.lasere.loggepy.Log.LogWriting;


public class GeneratedPassword {
	
	private LogWriting lw = new LogWriting();
	private Repair repair = new Repair();
	private SameName sameName = new SameName();
	private Deciphers deciphers = new Deciphers();
	private Random random = new Random();
	
	private final Path passwordFile = Paths.get("C:\\loggepy-edition-java\\password\\passwords");	
	private ArrayList<Object> generationArgument = new ArrayList<>();
	
	private String password;
	private String fragmentePassword = "";

	
	public String GeneratedPasswords(String namePassword, int MainPassword) throws IOException {
		if(namePassword == "") {
			return "please put argument";
		}else if (namePassword.contains("=")) {
			return "please do not put the sign '='";
		}else if (sameName.hasSameName(namePassword)) {
			return "you already have a password with the same name...";
		}
		String setPassword = setPassword();
		String EncryptPassword = "";
		for(int i = 0; i != setPassword.length(); i++) {
			EncryptPassword += deciphers.cesar(MainPassword, setPassword.charAt(i), false);
		}
		String result = namePassword + "=" + EncryptPassword;
		String fullPassword = "\n" + "=" + namePassword + "=" + setPassword;
		Files.write(passwordFile, fullPassword.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.APPEND);
		lw.WriteLogInfo("the password has been saved");
		repair.setBackup();
		return "your password has been saved: " + result;
	}
	
	private String setPassword() throws IOException {
		fragmentePassword = "";
		if (Controllers.ContainsCapitalLetters) {
			generationArgument.add(PasswordArguments.uppercase);
		}
		if (Controllers.ContainsLowercaseLetters) {
			generationArgument.add(PasswordArguments.lowercase);
		}
		if (Controllers.ContainsNumbers) {
			generationArgument.add(PasswordArguments.nb);
		}
		if (Controllers.SpecialCharacters) {
			generationArgument.add(PasswordArguments.specialCharacter);
		}
		for(int i = 0; i <= Controllers.nbCharPassword - 1; i++) {
			int rand = random.nextInt(generationArgument.size());
			Object randomGenerationArgument = generationArgument.get(rand);
			if (randomGenerationArgument == PasswordArguments.specialCharacter) {
				fragmentePassword += PasswordArguments.specialCharacter[random.nextInt(PasswordArguments.specialCharacter.length)];
			}else if (randomGenerationArgument == PasswordArguments.nb) {
				fragmentePassword += PasswordArguments.nb[random.nextInt(PasswordArguments.nb.length)];
			}else if (randomGenerationArgument == PasswordArguments.uppercase) {
				fragmentePassword += PasswordArguments.uppercase[random.nextInt(PasswordArguments.uppercase.length)];
			}else if (randomGenerationArgument == PasswordArguments.lowercase) {
				fragmentePassword += PasswordArguments.lowercase[random.nextInt(PasswordArguments.lowercase.length)];
			}
		}
		password = fragmentePassword;
		lw.WriteLogInfo("the password has just been created");
		setDefaultValues();
		return password;
	}
	
	private void setDefaultValues() {
		Controllers.nbCharPassword = 24;
		Controllers.ContainsCapitalLetters = true;
		Controllers.ContainsLowercaseLetters = true;
		Controllers.ContainsNumbers = true;
		Controllers.SpecialCharacters = true;
	}
}