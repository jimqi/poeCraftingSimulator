package poeCraftingSim.client.orbs;

import java.util.Random;

import poeCraftingSim.client.enums.AffixEnum;
import poeCraftingSim.client.enums.OrbTypes;
import poeCraftingSim.client.enums.RarityEnum;
import poeCraftingSim.client.functionality.ModParser;
import poeCraftingSim.client.items.Item;

public class RegalOrb {
	static String whichMod;
	static String mod;

	public static void use(Item i) {
		if (isValid(i)) {
			decideMod();
			//validMods is a list of the name of mods valid for the item type, item level and affix type
			mod = ModParser.getMod(i, whichMod);
			i.setMod(whichMod, mod);
			i.changeRarity(RarityEnum.RARE.toString());
		}
	}
	
	private static void decideMod() {
		Random rand = new Random();
		int temp = rand.nextInt(2);
		if (temp == 0) {
			whichMod = AffixEnum.PREFIX.toString();
		}
		if (temp == 1) {
			whichMod = AffixEnum.SUFFIX.toString();
		}
	}

	private static boolean isValid(Item i) {
		return i.isValid(OrbTypes.REGALORB.toString());
	}
}
