package project.translation;

import java.util.HashMap;
import java.util.Iterator;
import project.utilities.FileManager;

public class Translator
{
	public HashMap<String, String> vocabulary;

    public Translator(String language)
    {
    	FileManager fileManager = new FileManager("/translation/" + language + ".csv");

    	vocabulary = new HashMap<String, String>();

    	HashMap<Integer, String> map = fileManager.getMap();
		Iterator<Integer> keySetIterator = map.keySet().iterator();
		while (keySetIterator.hasNext()) {
			Integer key = keySetIterator.next();
			String[] parse = map.get(key).split(";");

			vocabulary.put(parse[0], parse[1]);
		}
    }

    public String __(String key)
    {
    	return vocabulary.get(key);
    }
}
