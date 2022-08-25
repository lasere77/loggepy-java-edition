package fr.lasere.loggepy.Backup;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import fr.lasere.loggepy.Loggepy;
import fr.lasere.loggepy.Log.LogWriting;

public class Repair {
	
	private LogWriting lw = new LogWriting();
	
	public void Repaired() throws IOException {
		Files.copy(Loggepy.backupPasswordsFile, Loggepy.passwordsFile, StandardCopyOption.REPLACE_EXISTING);
		lw.WriteLogInfo("we have tried to restore the password");
	}
	public void setBackup() throws IOException {
		Files.copy(Loggepy.passwordsFile, Loggepy.backupPasswordsFile, StandardCopyOption.REPLACE_EXISTING);
		lw.WriteLogInfo("a new backup has been made");
	}
}
