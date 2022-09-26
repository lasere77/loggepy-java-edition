package fr.lasere.loggepy.GetError;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class SameName {
	
	public boolean hasSameName(String namePasswors) throws IOException {
		@SuppressWarnings("resource")
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\loggepy-edition-java\\password\\passwords"), "UTF-8"));
		namePasswors = "=" + namePasswors + "=";
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
