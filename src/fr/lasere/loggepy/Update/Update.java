package fr.lasere.loggepy.Update;

import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Update {
	
	@SuppressWarnings("unused")
	private String userName = System.getProperty("user.home");
	@SuppressWarnings("unused")
	private final byte IMPORTANT = 1;
	@SuppressWarnings("unused")
	private final byte MAJOR = 0;
	@SuppressWarnings("unused")
	private final byte PATCH = 0;
	//private final String URL = "https://github.com/lasere77/loggepy-java-edition/releases";
	private final String URL = "https://github.com/lasere77/loggepy/releases";
	
	//private String FileZipUrl = "https://github.com/lasere77/loggepy/releases/download/{get_important}{point}{get_major}{point}{get_minor}/loggepy.{get_important}{point}{get_major}{point}{get_minor}.zip";
	
	private ArrayList<String> allVersion = new ArrayList<String>();
	private ArrayList<String> allPatchNote = new ArrayList<String>();
	
	public void Updates() {
		if(getUpdate()) {
			
		}
	}
	
	
	private Boolean getUpdate(){
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
			System.out.println(allVersion);
			System.out.println(allPatchNote);
		} catch (Exception e) {
			e.getMessage();
		}
		return false;
	}
}
