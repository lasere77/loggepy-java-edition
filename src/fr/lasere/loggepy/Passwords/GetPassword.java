package fr.lasere.loggepy.Passwords;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import fr.lasere.loggepy.Encryption.Deciphers;
import fr.lasere.loggepy.Log.LogWriting;

public class GetPassword {
	
	private static LogWriting lw = new LogWriting();
	private Deciphers deciphers = new Deciphers();
	private String FinalPasswordEncrypt = "";
	
	public String GetFullPasswords(int MainPassword) throws IOException {
		lw.WriteLogInfo("the user viewed these passwords");
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\loggepy-edition-java\\password\\passwords"), "UTF-8"));
		String line = br.readLine();
		lw.WriteLogInfo("decryption processing");
		while (line != null) {
			for(int i = 0; i != line.length(); i++) {
				FinalPasswordEncrypt += deciphers.cesar(MainPassword, line.charAt(i));
			}
			FinalPasswordEncrypt += "\n";
			line = br.readLine();
		}
		br.close();
		return FinalPasswordEncrypt;
	}
}