package poeCraftingSim.client.orbs;

import java.io.FileNotFoundException;
import java.util.Random;

import poeCraftingSim.client.functionality.ModParser;
import poeCraftingSim.client.items.Item;

public class RegalOrb implements NormalOrb {
	static String whichMod;
	static String mod;

	public static void use(Item i) {
		if (isValid(i)) {
			decideMod();
			try {
				//validMods is a list of the name of mods valid for the item type, item level and affix type
				mod = ModParser.getMod(i, whichMod);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			i.setMod(whichMod, mod);
			i.changeRarity("Rare");
		}
	}
	
	public static void decideMod() {
		Random rand = new Random();
		int temp = rand.nextInt(2);
		if (temp == 0) {
			whichMod = "Prefix";
		}
		if (temp == 1) {
			whichMod = "Suffix";
		}
	}

	public static boolean isValid(Item i) {
		return i.isValid(RegalOrb.class.getSimpleName());
	}
}
