package fr.lasere.loggepy.Encryption;

public class Deciphers {
	
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
}
