package fr.lasere.loggepy.Log;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class LogWriting {
	
	private Path path = Paths.get("src/fr/lasere/loggepy/Log/log");
	private final String INFO = "INFO -> ";
	private final String WARN = "WARN -> ";
	private final String ERROR = "ERROR -> ";
	private final String FATAL = "FATAL -> ";
	
	public void WriteLogInfo(String text) throws IOException  {
		Files.write(path, INFO.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.APPEND);
		text+="\n";
		Files.write(path, text.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.APPEND);
	}
	
	public void WriteLogWarn(String text) throws IOException {
		Files.write(path, WARN.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.APPEND);
		text+="\n";
		Files.write(path, text.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.APPEND);
	}
	
	public void WriteLogError(String text) throws IOException {
		Files.write(path, ERROR.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.APPEND);
		text+="\n";
		Files.write(path, text.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.APPEND);
	}
	
	public void WriteLogFatal(String text) throws IOException {
		Files.write(path, FATAL.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.APPEND);
		text+="\n";
		Files.write(path, text.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.APPEND);
	}
}
