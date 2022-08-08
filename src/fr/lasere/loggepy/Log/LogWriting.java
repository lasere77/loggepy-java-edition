package fr.lasere.loggepy.Log;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class LogWriting {
	
	private File log = new File("src/fr/lasere/loggepy/Log/log");
	private String text = "";
	private int nblines = 0;
	private boolean isInit = false; 
	
	private boolean FileExist() throws IOException {
		if(!log.exists()) {
			log.createNewFile();
		}
		return true;
	}
	
	private String ReadLog() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(log), "UTF-8"));
		String line = reader.readLine();
		
		//get row count
		while (line != null) {
			line = reader.readLine();
			nblines++;
		}
		
		//retrieve old logs
		reader = new BufferedReader(new InputStreamReader(new FileInputStream(log), "UTF-8"));
		for(int i = 0; i < nblines; i++) {
			line = reader.readLine();
			text += line + "\n";
		}
		reader.close();
		return text;
	}
	
	private void initLog() throws IOException {
		if(FileExist() && !isInit) {
			text = ReadLog();
			FileWriter writer = new FileWriter(log);
			BufferedWriter bw = new BufferedWriter(writer);
			bw.write(text);
			bw.newLine();
			bw.close();
			writer.close();
			isInit = true;
		}
	}
	
	public void WriteLogInfo(String args) throws IOException {
		if(FileExist() && !isInit) {
			FileWriter writer = new FileWriter(log);
			BufferedWriter bw = new BufferedWriter(writer);
			bw.write("INFO -> " + args);
			bw.newLine();
			bw.close();
			writer.close();
		}else {
			initLog();
		}
	}
}
