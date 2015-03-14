package poeCraftingSim.client.functionality;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import poeCraftingSim.client.items.Item;

public class ModWeights {
	/**
	 * returns a int array of the same length of 
	 * @param m
	 * 			list of valid mod names for item i
	 * @param i
	 * 			item being crafted
	 * @param affix
	 * 			affix type of the mods
	 * @return
	 */
	public static int[] getModWeights(String[] m, Item i, String affix) {
		List<Integer> weights = new ArrayList<Integer>();
		JSONObject tempResult;
		File f = new File("Resources/modsWeights.json");
		try {
			JSONTokener temp = new JSONTokener(new FileReader(f));
			JSONObject obj = new JSONObject(temp);
			JSONObject arr = obj.getJSONObject(affix);
			switch (i.getBase().substring(0, 3).toLowerCase()) {
			case "two":
				tempResult = arr.getJSONObject("2hswords");
				break;
			case "one":
				tempResult = arr.getJSONObject("1hswords");
				break;
			default:
				tempResult = arr.getJSONObject(i.getBase().toLowerCase() + "s");
				break;
			}
			for (int l = 0; l < m.length; l++) {
				try {
				weights.add(tempResult.getJSONObject(m[l]).getInt("weight"));
				}catch (JSONException e) {
					//if the affix can't be found it has weight 0 and will never be rolled
					weights.add(0);
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("modsWeight.json loading failed: " + e);
			e.printStackTrace();
		} 
		int[] result = convertIntegers(weights);
		return result;
		
	}
	
	//http://stackoverflow.com/questions/718554/how-to-convert-an-arraylist-containing-integers-to-primitive-int-array
	public static int[] convertIntegers(List<Integer> integers)
	{
	    int[] ret = new int[integers.size()];
	    Iterator<Integer> iterator = integers.iterator();
	    for (int i = 0; i < ret.length; i++)
	    {
	        ret[i] = iterator.next().intValue();
	    }
	    return ret;
	}
}
