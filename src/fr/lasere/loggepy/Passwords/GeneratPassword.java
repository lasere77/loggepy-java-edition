package fr.lasere.loggepy.Passwords;

public class GeneratPassword {
	
	@SuppressWarnings("unused")
	private String[] uppercase = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
	@SuppressWarnings("unused")
	private String[] lowercase = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
	@SuppressWarnings("unused")
	private String[] nb = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
	@SuppressWarnings("unused")
	private String[] specialCharacter = {"\"" + "@" + "<" + "/" + "*" + ">" + "~" + "!" + "?" + "{" + "}"};
	private String password;
	
	public String  GeneratPasswords(String namePassword) {
		System.out.println(namePassword);
		return password;
	}
	
}
