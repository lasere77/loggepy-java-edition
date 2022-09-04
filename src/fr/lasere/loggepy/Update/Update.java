package fr.lasere.loggepy.Update;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import fr.lasere.loggepy.Log.LogWriting;

public class Update {
	
	private LogWriting lw = new LogWriting();

	private final int MAJOR = 1;
	private final int MINOR = 0;
	private final int PATCH = 0;
	private int getMajor;
	private int getMinor;
	private int getPatch;
	private final String URL = "https://github.com/lasere77/loggepy-java-edition/releases";
	
	private ArrayList<String> allVersion = new ArrayList<String>();
	private ArrayList<String> allPatchNote = new ArrayList<String>();
	
	public void Updates() throws IOException, InterruptedException {
		lw.WriteLogInfo("you are on the version\r\n" + MAJOR + "." + MINOR + "." + PATCH);
		getUpdate(MAJOR, MINOR, PATCH);
	}
	
	
	private void getUpdate(int MAJOR, int MINOR, int PATCH) throws IOException, InterruptedException{
		lw.WriteLogInfo("checking is updated");
		try {
			Document doc = Jsoup.connect(URL).get();
			Elements versionElements = doc.getElementsByTag("h1");
			Elements textElements = doc.getElementsByTag("p");
			for(Element versionElement : versionElements) {
				allVersion.add(versionElement.text());
			}
			for(Element textElement : textElements) {
				allPatchNote.add(textElement.text());
			}
			getMajor = Character.getNumericValue(allVersion.get(0).charAt(0));
			getMinor = Character.getNumericValue(allVersion.get(0).charAt(2));
			getPatch = Character.getNumericValue(allVersion.get(0).charAt(4));
			System.out.println(getMajor + " " + getMinor + " " + getPatch);
			if(getMajor > MAJOR || getMinor > MINOR || getPatch > PATCH){
				lw.WriteLogInfo("update");
				addResource();
			}else if(getMajor == MAJOR || getMinor == MINOR || getPatch == PATCH) {
				lw.WriteLogInfo("you have the latest version of loggepy edition java");
			}else {
				lw.WriteLogInfo("...");
			}
		} catch (Exception e) {
			lw.WriteLogInfo(e.getMessage());
		}
	}
	
	private void addResource() throws IOException, InterruptedException {
		//resource download
		lw.WriteLogInfo("resource download");
		URL FileZipUrl = new URL("https://github.com/lasere77/loggepy/releases/download/" + allVersion.get(0) + "/loggepy-edition-java-update." + allVersion.get(0) + ".zip");
        ReadableByteChannel readableByteChannel = Channels.newChannel(FileZipUrl.openStream());
        try (FileOutputStream fos = new FileOutputStream("C:\\Windows\\Temp\\loggepy.3.10.3.zip")) {
            fos.getChannel().transferFrom(readableByteChannel, 0, Long.MAX_VALUE);
        }
		setupResource();
	}
	
	private void setupResource() throws InterruptedException, IOException {
		lw.WriteLogInfo("resource installation");
		String cmd = "C:\\Program Files (x86)\\loggepy-edition-java\\setupdate.bat";
		Runtime t = Runtime.getRuntime();
		Process y = t.exec(cmd);
		y.waitFor();
	}
}