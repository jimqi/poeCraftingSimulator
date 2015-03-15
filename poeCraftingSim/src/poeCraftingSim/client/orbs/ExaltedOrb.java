package poeCraftingSim.client.orbs;

import java.util.Random;

import poeCraftingSim.client.enums.AffixEnum;
import poeCraftingSim.client.enums.OrbTypes;
import poeCraftingSim.client.functionality.ModParser;
import poeCraftingSim.client.items.Item;

public class ExaltedOrb {
	static String whichMod, mod;

	public static void use(Item i) {
		if (isValid(i)) {
			decideMod(i);
			//validMods is a list of the name of mods valid for the item type, item level and affix type
			mod = ModParser.getMod(i, whichMod);
			i.setMod(whichMod, mod);
		}

	}

	private static void decideMod(Item i) {
		Random rand = new Random();
		int temp = rand.nextInt(2);

		//determine if there are affix slots left
		int pNumber = 0;
		String[] pArray =i.getMod(AffixEnum.PREFIX.toString());
		for (int l = 0; l < pArray.length; l++) {
			if (pArray[l] != null)
				pNumber++;
		}

		int sNumber = 0;
		String[] sArray =i.getMod(AffixEnum.SUFFIX.toString());
		for (int l = 0; l < pArray.length; l++) {
			if (sArray[l] != null)
				sNumber++;
		}

		if (temp == 0) {
			if (pNumber < 3) {
				whichMod = AffixEnum.PREFIX.toString();
			}
			else {
				whichMod = AffixEnum.SUFFIX.toString();
			}
		}
		if (temp == 1) {
			if (sNumber < 3) {
				whichMod = AffixEnum.SUFFIX.toString();
			}
			else {
				whichMod = AffixEnum.PREFIX.toString();
			}
		}
	}

	private static boolean isValid(Item i) {
		return i.isValid(OrbTypes.EXALTEDORB.toString());
	}
}
