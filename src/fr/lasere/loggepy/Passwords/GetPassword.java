package fr.lasere.loggepy.Passwords;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import fr.lasere.loggepy.Log.LogWriting;

public class GetPassword {
	
	private static LogWriting lw = new LogWriting();
	private String allPasswords = "";
	
	public String GetPasswords() throws IOException {
		lw.WriteLogInfo("the user viewed these passwords");
		
	    File passwordFile = new File("src/fr/lasere/loggepy/Passwords/passwords");
        FileReader readPassword = new FileReader(passwordFile);
        char[] i = new char[3000];
        readPassword.read(i);
        for(char j : i) {
            readPassword.close();
            allPasswords += j;
    	}
		return allPasswords;
	}
}
