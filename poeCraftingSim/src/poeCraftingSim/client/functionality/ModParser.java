package poeCraftingSim.client.functionality;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.*;

public class ModParser {

	//"C:/Users/Jim/git/poeCraftingSimulator/poeCraftingSim/data/mods.json"
	public static void test() {
		JSONTokener temp;
		try {
			File f = new File("Resources/mods.json");
			temp = new JSONTokener(new FileReader(f));
			JSONObject obj = new JSONObject(temp);
			JSONArray arr = obj.getJSONArray("mods");
			for (int i = 0; i < arr.length(); i++)
			{
				String test = arr.getJSONObject(i).getString("name");
				System.out.println(test);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
