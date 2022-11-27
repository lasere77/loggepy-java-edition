package fr.lasere.loggepy.Passwords;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import fr.lasere.loggepy.Log.LogWriting;

public class DelPassword {
	
	private LogWriting lw = new LogWriting();
	private static final Path passwordFile = Paths.get("C:\\loggepy-edition-java\\password\\passwords");	
	
	private String fullPassword;
	private String allPassword = "";
	private int lengthPasswordArray;
	
	public String delPassword(String namePassword, int MainPassword) throws IOException {
		if(namePassword == "") {
			return "please put argument";
		}
		fullPassword = "=" + namePassword + "=";
		String result = getDelPassword(fullPassword);
		if(result == "error") {
			return "this password does not ignore...";
		}
		Files.write(passwordFile, result.getBytes());
		result = namePassword;
		lw.WriteLogInfo("the user has deleted one of its password");
		return "your password " + "'" + result + "'" + " has been deleted ";
	}
	
	private String getDelPassword(String fullPassword) throws IOException {
		allPassword = "";
		List<String> passwordArray = Files.readAllLines(passwordFile);
		final int LENGTHPASSWORDARRAY = passwordArray.size();
		lengthPasswordArray = passwordArray.size();
		for(int i = 0; i < lengthPasswordArray; i++) {
			try {
				if (passwordArray.get(i).contains(fullPassword)) {
					passwordArray.remove(i);
					lengthPasswordArray -= 1;
				}
				if (passwordArray.get(i) != passwordArray.get(0)) {
					allPassword += "\n" + passwordArray.get(i);
				}
			} catch (Exception e) {
				lengthPasswordArray = passwordArray.size();
				if(LENGTHPASSWORDARRAY == lengthPasswordArray + 1) {
					lw.WriteLogInfo("this password is not ignored, it could not be deleted");
					return allPassword;
				}
				lw.WriteLogWarn("line out of reach...");
				return "error";
			}
		}
		if(LENGTHPASSWORDARRAY == lengthPasswordArray) {
			lw.WriteLogInfo("this password is not ignored, it could not be deleted");
			return "error";
		}
		return allPassword;
	}
}