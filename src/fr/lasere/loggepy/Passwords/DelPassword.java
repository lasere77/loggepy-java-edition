package fr.lasere.loggepy.Passwords;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import fr.lasere.loggepy.Log.LogWriting;

public class DelPassword {
	
	private LogWriting lw = new LogWriting();
	private File passwordFile = new File("C:\\Program Files (x86)\\loggepy-edition-java\\password\\passwords");
	
	private String fullPassword;
	private String allPassword;
	private String result;
	
	/*
	 * You still need to remove unnecessary line breaks.
	 */
	public String getDelPassword(String namePassword, String password, String oldPassword) throws IOException {
		if(namePassword == "" || password == "") {
			return "please put argument";
		}
		result = namePassword + "=" + password;
		fullPassword = "\n" + namePassword + "=" + password;
		if(!passwordFile.exists()) {
			try {
				passwordFile.createNewFile();
			} catch (Exception e) {
				lw.WriteLogFatal("the password file did not succeed in this creation please report the bug thank you for your understanding");
				return "you don't have a password...";
			}
		}
		FileWriter fw = new FileWriter(passwordFile);
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(delPassword(fullPassword, oldPassword));
		bw.close();
		fw.close();
		return "your password has been deleted: " + result;
	}
	
	private String delPassword(String fullPassword, String oldPassword) throws IOException {
		allPassword = oldPassword.replaceAll(fullPassword, "");
		return allPassword;
	}
}
