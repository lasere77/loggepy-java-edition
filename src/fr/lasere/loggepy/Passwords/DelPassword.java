package fr.lasere.loggepy.Passwords;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import fr.lasere.loggepy.Log.LogWriting;

public class DelPassword {
	
	private LogWriting lw = new LogWriting();
	private File passwordFile = new File("C:\\Program Files (x86)\\loggepy-edition-java\\password\\passwords");
	
	private String fullPassword;
	private String allPassword;
	private String result;
	
	public String getDelPassword(String namePassword, String password, String oldPassword) throws IOException {
		if(namePassword == "" || password == "") {
			return "please put argument";
		}
		result = namePassword + "=" + password;
		if(!passwordFile.exists()) {
			try {
				passwordFile.createNewFile();
			} catch (Exception e) {
				lw.WriteLogFatal("the password file did not succeed in this creation please report the bug thank you for your understanding");
				return "you don't have a password...";
			}
		}
		//String str1 = new Boolean(lastLine(namePassword, password)).toString();
		//lw.WriteLogInfo(str1);
		if(lastLine(namePassword, password)) {
			fullPassword = "\n" + namePassword + "=" + password + "\n";
		}else {
			fullPassword = "\n" + namePassword + "=" + password;
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
	
	@SuppressWarnings("resource")
	private boolean lastLine(String namePassword, String password) throws IOException {
		String path = "C:\\Program Files (x86)\\loggepy-edition-java\\password\\passwords";
		File file = new File(path);
		Scanner sc = new Scanner(file);
		String line = "";
		while(sc.hasNextLine()) {
			line = sc.nextLine();
		}
		lw.WriteLogInfo(line);
		String temp = namePassword + "=" + password;
		//Why does this condition not work?
		if(line == temp || line == "\n" + temp || line == temp + "\n") {
			return true;
		}
		return false;
	}
}
