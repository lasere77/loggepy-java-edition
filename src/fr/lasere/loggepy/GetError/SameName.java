package fr.lasere.loggepy.GetError;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class SameName {
	
	private final Path passwordFile = Paths.get("C:\\Program Files (x86)\\loggepy-edition-java\\password\\passwords");	
	
	public boolean hasSameName(String namePasswors) throws IOException {
		Files.write(passwordFile, "".getBytes(), StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.APPEND);
		@SuppressWarnings("resource")
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\Program Files (x86)\\loggepy-edition-java\\password\\passwords"), "UTF-8"));
		namePasswors += "=";
		String line = br.readLine();
		while (line != null) {
			if(line.contains(namePasswors)) {
				return true;
			}
			line = br.readLine();
		}
		br.close();
		return false;
	}
}
