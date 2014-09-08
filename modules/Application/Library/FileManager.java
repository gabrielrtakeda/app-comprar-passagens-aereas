package project.modules.Application.Library;

import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

public class FileManager
{
	private HashMap<Integer, String> map;
	private BufferedReader reader = null;
	private File file;

	public FileManager(String filePath)
	{
		map = new HashMap<Integer, String>();
		file = new File(filePath);

		try {
			reader = new BufferedReader(new FileReader(file));
			String content = null;

			int i = 0;
			while((content = reader.readLine()) != null) {
				map.put(i, content);
				i++;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (reader != null) {
					reader.close();
				}
			} catch (IOException e) {
				System.out.println("Erro FileManager::reader.close()");
			}
		}
	}

	public HashMap<Integer, String> getMap()
	{
		return map;
	}
}
