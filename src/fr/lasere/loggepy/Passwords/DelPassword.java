package fr.lasere.loggepy.Passwords;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import fr.lasere.loggepy.Log.LogWriting;

public class DelPassword {
	
	private LogWriting lw = new LogWriting();
	private File passwordFile = new File("src/fr/lasere/loggepy/Passwords/passwords");
	
	private String fullPassword;
	private String allPassword;
	private String oldPassword;
	
	//not functional
	public String getDelPassword(String namePassword, String password) throws IOException {
		fullPassword = namePassword + "=" + password;
		if(!passwordFile.exists()) {
			try {
				passwordFile.createNewFile();
			} catch (Exception e) {
				lw.WriteLogFatal("the password file did not succeed in this creation please report the bug thank you for your understanding");
				e.getMessage();
			}
		}else {
			FileWriter fw = new FileWriter(passwordFile);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(delPassword(fullPassword));
			bw.close();
			fw.close();
		}
		return fullPassword;
	}
	
	private String delPassword(String fullPassword) throws IOException {
		oldPassword = new GetPassword().GetPasswords();
		System.out.println(oldPassword);
		allPassword = oldPassword.replaceAll(fullPassword, "\n");
		System.out.println(allPassword);
		return allPassword;
	}
}
