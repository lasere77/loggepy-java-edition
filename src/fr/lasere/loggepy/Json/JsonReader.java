package fr.lasere.loggepy.Json;

import java.io.FileNotFoundException;

import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import fr.lasere.loggepy.Log.LogWriting;

public class JsonReader {
	
	private static Locale lang = Locale.getDefault();
	private static LogWriting lw = new LogWriting();
	private static String error = "there was a problem... you can report it here: https://github.com/lasere77/loggepy-java-edition/issues";
	
	@SuppressWarnings("deprecation")
	public static int ReadData(String arg) throws FileNotFoundException {
			JsonParser jsonParser = new JsonParser();
			FileReader reader = new FileReader("src/fr/lasere/loggepy/Json/Data/.json");
			Object object = jsonParser.parse(reader);
			JsonObject data = (JsonObject)object;
			int result = data.get(arg).getAsInt();
			return result;
	}
	
	@SuppressWarnings("deprecation")
	public static String ReadLANG(String arg0, String arg1, String arg2) throws IOException {
		try {
			JsonParser jsonParser = new JsonParser();
			FileReader reader = new FileReader("src/fr/lasere/loggepy/Json/LANG/"+ lang +".json");
			Object object = jsonParser.parse(reader);
			JsonObject lang = (JsonObject)object;
			try {
				if (arg1 != null || arg2 != null) {
					String result = ((JsonObject) ((JsonObject) lang.get(arg0)).get(arg1)).get(arg2).getAsString();
					return result;
				}
				if(arg1 != null || arg2 == null) {
					String result = ((JsonObject) lang.get(arg0)).get(arg1).getAsString();
					return result;
				}
			}catch (Exception e) {
				lw.WriteLogError("what if was not supposed to happen... an argument is missing to be able to access the json data");
			}
			return error;	
		} catch (Exception e) {
			languageNotFound(arg0, arg1, arg2);
		}
		return error;
	}
	
	@SuppressWarnings("deprecation")
	private static String languageNotFound(String arg0, String arg1, String arg2) throws IOException {
		JsonParser jsonParser = new JsonParser();
		FileReader reader = new FileReader("src/fr/lasere/loggepy/Json/LANG/en_US.json");
		Object object = jsonParser.parse(reader);
		JsonObject lang = (JsonObject)object;
		try {
			if (arg1 != null || arg2 != null) {
				String result = ((JsonObject) ((JsonObject) lang.get(arg0)).get(arg1)).get(arg2).getAsString();
				return result;
			}
			if(arg1 != null || arg2 == null) {
				String result = ((JsonObject) lang.get(arg0)).get(arg1).getAsString();
				return result;
			}
		}catch (Exception e) {
			lw.WriteLogError("what if was not supposed to happen... an argument is missing to be able to access the json data" + error);
		}
		return error;
	}
}
