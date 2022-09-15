package fr.lasere.loggepy.Encryption;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import fr.lasere.loggepy.Log.LogWriting;
import javafx.scene.control.Label;

public class Deciphers {
	
	private LogWriting lw = new LogWriting();
	private int MainPassword;
	
	public boolean decipher(String iDEntryMainPassword, Label IDLabelErrorMainPassword) throws IOException {
		System.out.println(iDEntryMainPassword);
		lw.WriteLogInfo("master password processing...");
		try {
			MainPassword = Integer.parseInt(iDEntryMainPassword);
			System.out.println(MainPassword);
		} catch (Exception e) {
			lw.WriteLogError("the user did not enter something correct...");
			IDLabelErrorMainPassword.setText("please put only numbers");
			return false;
		}
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\loggepy-edition-java\\password\\passwords"), "UTF-8"));
		String line = br.readLine();
		while (line != null) {
			for(int i = 0; i != line.length(); i++) {
				System.out.println("origine = " + line.charAt(i));
				cesar(MainPassword, line.charAt(i));
			}
			System.out.println(line);
			line = br.readLine();
		}
		br.close();
		return true;
	}
	
	private char cesar(int nb, char input) {
		char output = ')';
		while (nb >= 26) {
			nb -= 25;
		}
		for(int i = 0; i != EncryptionArguments.lengthUppercase; i++) {
			if (input == EncryptionArguments.uppercase[i]) {
				try {
					output = EncryptionArguments.uppercase[i + nb];
				} catch (Exception e) {
					output = EncryptionArguments.uppercase[nb];
				}
			}else if (input == EncryptionArguments.lowercase[i]) {
				try {
					output = EncryptionArguments.lowercase[i + nb];
				} catch (Exception e) {
					output = EncryptionArguments.lowercase[nb];
				}
			}
		}
		while (nb > 10) {
			nb -= 5;
		}
		for(int i = 0; i != 10; i++) {
			if (input == EncryptionArguments.nb[i]) {
				try {
					output = (char) EncryptionArguments.nb[i + nb];
				} catch (Exception e) {
					output = (char) EncryptionArguments.nb[i];
				}
			}
		}
		for(int i = 0; i != EncryptionArguments.lengthSpecialCharacter; i++) {
			if(input == '=') {
				output = '=';
			}else if (input == EncryptionArguments.specialCharacter[i]) {
				try {
					output = EncryptionArguments.specialCharacter[i + nb];
				} catch (Exception e) {
					output = EncryptionArguments.specialCharacter[i];
				}
			}
		}
		//System.out.println(output);
		return output;
	}
}
