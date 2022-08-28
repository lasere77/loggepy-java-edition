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

import net.lingala.zip4j.ZipFile;
import net.lingala.zip4j.exception.ZipException;

public class Update {
	
	@SuppressWarnings("unused")
	private String userName = System.getProperty("user.home");
	private final int MAJOR = 3;
	private final int MINOR = 10;
	private final int PATCH = 3;
	private int getMajor;
	private int getMinor;
	private int getPatch;
	private final String URL = "https://github.com/lasere77/loggepy-java-edition/releases";
	//private final String URL = "https://github.com/lasere77/loggepy/releases";
	
	private ArrayList<String> allVersion = new ArrayList<String>();
	private ArrayList<String> allPatchNote = new ArrayList<String>();
	
	public void Updates() throws IOException {
		getUpdate();
	}
	
	
	private Boolean getUpdate() throws IOException{
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
			if(getMajor > MAJOR || getMinor < MINOR || getPatch < PATCH){
				addResource();
			}
		return false;
	}
	
	@SuppressWarnings("resource")
	private void addResource() throws IOException {
		//resource download
		URL FileZipUrl = new URL("https://github.com/lasere77/loggepy/releases/download/+allVersion.get(0)+/loggepy-edition-java-update.+allVersion.get(0)+.zip");
        ReadableByteChannel readableByteChannel = Channels.newChannel(FileZipUrl.openStream());
        try (FileOutputStream fos = new FileOutputStream("C:\\Windows\\Temp\\loggepy.3.10.3.zip")) {
            fos.getChannel().transferFrom(readableByteChannel, 0, Long.MAX_VALUE);
        }
		
        //unzipping the zip file
	    try {
	         new ZipFile("C:\\Windows\\Temp\\loggepy.3.10.3.zip").extractAll("C:\\Users\\laser\\Desktop\\att");
	    } catch (ZipException e) {
	        e.printStackTrace();
	    }
	    setupResource();
	}
	
	private void setupResource() {
		
	}
}