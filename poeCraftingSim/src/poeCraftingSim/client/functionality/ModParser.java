package poeCraftingSim.client.functionality;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.json.*;

import poeCraftingSim.client.items.Item;

public class ModParser {

	/**
	 * 
	 * @param itemBase
	 * 				type of the item
	 * @param itemLevel
	 *  			max item level of the mod
	 * @param affixType
	 * 				Prefix/Suffix capitalized first letter
	 * @return 
	 * 				name of all valid mods as a string array
	 * @throws FileNotFoundException 
	 */
	public static String[] getValidModNames(String itemBase, int itemLevel, String affixType) throws FileNotFoundException {
		List<String> result = new ArrayList<String>();
		itemBase = itemBase.toLowerCase();
		JSONTokener temp;
		File f = new File("Resources/mods.json");
		temp = new JSONTokener(new FileReader(f));
		JSONObject obj = new JSONObject(temp);
		JSONArray arr = obj.getJSONArray("mods");
		for (int i = 0; i < arr.length(); i++)
		{
			int ilevel = arr.getJSONObject(i).getInt("itemlevel");
			String aType = arr.getJSONObject(i).getString("affix");
			boolean validType;
			switch (itemBase) {
			case "two-handed sword":
			case "two-handed axe":
				if (arr.getJSONObject(i).getString("twohandedswordsandaxes").equals("Yes")) {
					validType = true;
					break;
				}
				else
					validType = false;
				break;
			case "one-handed sword":
			case "one-handed axe":
				if (arr.getJSONObject(i).getString("onehandedswordsandaxes").equals("Yes")) {
					validType = true;
					break;
				}
				else
					validType = false;
				break;
			case"two-handed mace":
				if (arr.getJSONObject(i).getString("twohandedmaces").equals("Yes")) {
					validType = true;
					break;
				}
				else
					validType = false;
				break;
			case"one-handed mace":
				if (arr.getJSONObject(i).getString("onehandedmaces").equals("Yes")) {
					validType = true;
					break;
				}
				else
					validType = false;
				break;
			default:
				if (arr.getJSONObject(i).getString(itemBase).equals("Yes")) {
					validType = true;
					break;
				}
				else
					validType = false;
				break;
			}

			//System.out.println("ilevel: " + ilevel + "itemLevel: " + itemLevel + aType + affixType + validType);
			if (ilevel <= itemLevel && aType.equals(affixType)&& validType) {
				result.add(arr.getJSONObject(i).getString("name"));
			}
		}

		String[] resultAsStringArray = new String[result.size()];
		result.toArray(resultAsStringArray);
		return resultAsStringArray;
	}
	
	/**
	 * Takes an item and affix selection and randomly returns one valid mod based on weights
	 * 
	 * @param i
	 * 			item object
	 * @param affix
	 * 			prefix/suffix
	 * @return
	 * 			one randomly select valid mod
	 * @throws FileNotFoundException
	 */
	public static String getMod(Item i, String affix) throws FileNotFoundException {
		String[] validMods = ModParser.getValidModNames(i.getBase(), i.getItemLevel(), affix);
		//TODO placeholder mod selection
		return validMods[1];
	}
}
