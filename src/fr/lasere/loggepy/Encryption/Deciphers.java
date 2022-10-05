package fr.lasere.loggepy.Encryption;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import fr.lasere.loggepy.Log.LogWriting;

public class Deciphers {
	
	private static LogWriting lw = new LogWriting();
	
	private boolean isEncrypt = true;
	private Map<Integer, String> RealPasswordName = new HashMap<Integer, String>();
	private Map<Integer, String> EncryptPassword = new HashMap<Integer, String>();
	
	public char cesar(int nb, char input) {
		char output = ')';
		while (nb >= 26) {
			nb -= 25;
		}
		if ((input == '$' || input == '=') && isEncrypt) {
			isEncrypt = false;
		}else if ((input == '$' || input == '=') && !isEncrypt) {
			isEncrypt = true;
		}
		System.out.println(isEncrypt);
		if (isEncrypt) {
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
		}else {
			output = input;
		}
		return output;
	}
		
	public Map<Integer, String> getRealPasswordName(Boolean withBeacons) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\loggepy-edition-java\\password\\passwords"), "UTF-8"));
		String line = br.readLine();
		for(int i = 0; line != null; i++) {
			if (!line.equals("")) {
			    Pattern p = Pattern.compile("=(.+?)=", Pattern.DOTALL);
			    Matcher m = p.matcher(line);
			    m.find();
			    if (withBeacons) {
				    RealPasswordName.put(i, "=" + m.group(1) + "=");
				}else {
					RealPasswordName.put(i, m.group(1));
				}
			} 
			line = br.readLine();
		}
		br.close();
		return RealPasswordName;
	}
	
	public String getRealPassword() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\loggepy-edition-java\\password\\passwords"), "UTF-8"));
		String line = br.readLine();
		String fullPassword = "";
		Map<Integer, String> namePassword = getRealPasswordName(true);
		for(int i = 0; line != null; i++) {
			try {
				if (!line.equals("")) {
					line = line.replaceAll(namePassword.get(i), "");
					fullPassword += line +  "\n";
				}
			} catch (Exception e) {
				lw.WriteLogWarn("line out of reach...");
			}
			line = br.readLine();	
		}
		br.close();
		return fullPassword;
	}
	
	public Map<Integer, String> getEncryptPassword(int MainPassword) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\loggepy-edition-java\\password\\passwords"), "UTF-8"));
		String line = br.readLine();
		String fullPassword = "";
		for(int i = 0; line != null; i++) {
			try {
				if (!line.equals("")) {
					for(int k = 0; k != line.length(); k++) {
						fullPassword += cesar(MainPassword, line.charAt(k));
					}
					fullPassword += "\n";
					EncryptPassword.put(i, fullPassword);
					fullPassword = "";
				}
			} catch (Exception e) {
				lw.WriteLogWarn("line out of reach...");
			}
			line = br.readLine();	
		}
		br.close();
		return EncryptPassword;
	}
}