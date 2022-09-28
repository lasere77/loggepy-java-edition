package fr.lasere.loggepy.Encryption;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Deciphers {
	
	private ArrayList<String> RealPasswordName = new ArrayList<String>();
	
	public char cesar(int nb, char input) {
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
		return output;
	}
		
	public ArrayList<String> getRealPasswordName() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\loggepy-edition-java\\password\\passwords"), "UTF-8"));
		String line = br.readLine();
		while (line != null) {
			if (!line.equals("")) {
			    Pattern p = Pattern.compile("=(.+?)=", Pattern.DOTALL);
			    Matcher m = p.matcher(line);
			    m.find();
			    RealPasswordName.add(m.group(1));
			} 
			line = br.readLine();
		}
		br.close();
		for(int i = 0; i != RealPasswordName.size(); i++) {
			System.out.println(RealPasswordName.get(i));
		}
		return RealPasswordName;
	}
}
