package fr.lasere.loggepy.Passwords;

import java.io.IOException;
import java.util.Map;

import fr.lasere.loggepy.Encryption.Deciphers;
import fr.lasere.loggepy.Log.LogWriting;

public class GetPassword {
	
	private static LogWriting lw = new LogWriting();
	private Deciphers deciphers = new Deciphers();
	private String FinalPasswordEncrypt = "";
	
	public String GetFullPasswords(int MainPassword) throws IOException {
		lw.WriteLogInfo("the user viewed these passwords");
		Map<Integer, String> EncryptPassword = deciphers.getEncryptPassword(MainPassword);
		lw.WriteLogInfo("decryption processing");
		for(int i = 0; i != EncryptPassword.size() + 1; i++) {
			if (EncryptPassword.get(i) != null) {
				FinalPasswordEncrypt += EncryptPassword.get(i).replaceFirst("=", "").replaceAll("\n=", "\n");	
			}
		}
		return FinalPasswordEncrypt;
	}
}