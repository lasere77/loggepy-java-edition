package fr.lasere.loggepy.Encryption;

public class EncryptionArguments {
	
	//password aruments
	protected static char[] uppercase = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
	protected static char[] lowercase = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
	protected static char[] nb = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
	//do not put its it's argument "? ² \ { }" in the list
	protected static char[] specialCharacter = {'"', '@', '<', '#', '&', '>', '~', '!', '-', '\'', '_'};
	
	//EncryptionArguments
	protected final static int lengthSpecialCharacter = specialCharacter.length;
	protected final static int lengthUppercase = uppercase.length;
	protected final static int lengthLowercase = lowercase.length;
	protected final static int lengthNb = nb.length;

}
