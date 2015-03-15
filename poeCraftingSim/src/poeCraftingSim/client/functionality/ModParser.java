package poeCraftingSim.client.functionality;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

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
	 * 				PREFIX/SUFFIX enum
	 * @return 
	 * 				name of all valid mods as a string array
	 * @throws FileNotFoundException 
	 */
	private static String[] getValidModNames(Item i, String affixType) {

		String itemBase = i.getBase(); 
		int itemLevel = i.getItemLevel();
		List<String> result = new ArrayList<String>();
		itemBase = itemBase.toLowerCase();
		JSONTokener temp;
		File f = new File("Resources/mods.json");
		try {
			temp = new JSONTokener(new FileReader(f));
			JSONObject obj = new JSONObject(temp);
			JSONArray arr = obj.getJSONArray("mods");

			// checks each mod json object to see if the mod is valid for the item base and item level
			for (int i1 = 0; i1 < arr.length(); i1++)
			{
				int ilevel = arr.getJSONObject(i1).getInt("itemlevel");
				String aType = arr.getJSONObject(i1).getString("affix");
				boolean validType = false;
				switch (itemBase) {
				case "two-handed sword":
				case "two-handed axe":
					if (arr.getJSONObject(i1).getString("twohandedswordsandaxes").equals("Yes")) {
						validType = true;
						break;
					}
					else
						validType = false;
					break;
				case "one-handed sword":
				case "one-handed axe":
					if (arr.getJSONObject(i1).getString("onehandedswordsandaxes").equals("Yes")) {
						validType = true;
						break;
					}
					else
						validType = false;
					break;
				case"two-handed mace":
					if (arr.getJSONObject(i1).getString("twohandedmaces").equals("Yes")) {
						validType = true;
						break;
					}
					else
						validType = false;
					break;
				case"one-handed mace":
					if (arr.getJSONObject(i1).getString("onehandedmaces").equals("Yes")) {
						validType = true;
						break;
					}
					else
						validType = false;
					break;
				default:
					String valid = arr.getJSONObject(i1).getString(itemBase);
					switch (valid) {
					case "Yes":
						validType = true;
						break;
					case "Yes (str)":
					case "Yes (int)":
					case "Yes (dex)":
					case "Yes (str-only)":
					case "Yes (int-only)":
					case "Yes (dex-only)":
					case "Yes (int-str)":
					case "Yes (dex-str)":
					case "Yes (int-dex)":
					default:
						validType = false;
						break;
					}
				}
				
				// at this point validType has been set (mod is valid or not for the item base) and if the required
				// ilevel is <= itemLevel of teh item add it to the result array containing all valid mods
				if (ilevel <= itemLevel && aType.equals(affixType) && validType) {
					result.add(arr.getJSONObject(i1).getString("name"));
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("Error loading mod list (json): " + e);
		}

		String[] resultAsStringArray = new String[result.size()];
		result.toArray(resultAsStringArray);
		return resultAsStringArray;
	}

	/**
	 * Takes an item and affix selection and randomly returns one valid mod non duplicate mod based on weights
	 * 
	 * @param i
	 * 			item to generate a mod for
	 * @param affix
	 * 			generate prfix or suffix
	 * @return
	 * 			one randomly select valid mod non duplicate mod for the specified affix
	 * @throws FileNotFoundException
	 * 			
	 */
	public static String getMod(Item i, String affix) {
		// validMods is an array of the names of mods valid for item i
		// weights is an array of mod weights aligned with validMods such that the weight of mod validMods[x] = weights[x];
		String[] validMods = ModParser.getValidModNames(i, affix);
		int[] weights = ModWeights.getModWeights(validMods, i, affix);

		// sumWeights is used to calculate the probability of any mod being rolled based on the total mod pool
		// 		by taking modWeight[x]/sumWeights
		int sumWeights = IntStream.of(weights).sum();
		Random rand = new Random();
		int modRoll = rand.nextInt(sumWeights) + 1;

		// find the modRolled by modRoll. Inner if statements prevent duplicate mods
		//		case 1: affix array is empty = no duplicate mods
		//		case 2: affix array is not empty check if validMods[l] already exists in the item
		//					if it does recursively call getMod to generate a new affix
		//					else return validMods[l] because it is not a duplicate
		int acc = 0;
		for (int l = 0; l < validMods.length; l++) {
			acc += weights[l];

			// find the mod 
			if (acc > modRoll) {
				if (i.getMod(affix) == null) {
					return validMods[l];
				}
				else if (Arrays.asList(i.getMod(affix)).contains(validMods[l]) == false) {
					return validMods[l];
				}
				else
					return getMod(i, affix);
			}
		}
		return validMods[1];
	}
}
