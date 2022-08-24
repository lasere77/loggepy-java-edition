package fr.lasere.loggepy.Passwords;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.stream.Collectors;

import fr.lasere.loggepy.Loggepy;
import fr.lasere.loggepy.Log.LogWriting;

public class GetPassword {
	
	private static LogWriting lw = new LogWriting();
	
	public String GetPasswords() throws IOException {
		lw.WriteLogInfo("the user viewed these passwords");
		return Files.newBufferedReader(Loggepy.passwordsFile, StandardCharsets.UTF_8).lines().collect(Collectors.joining());
	}
}
