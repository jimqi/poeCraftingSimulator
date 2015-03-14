package poeCraftingSim.client.orbs;

import java.io.FileNotFoundException;
import java.util.Random;

import poeCraftingSim.client.enums.AffixEnum;
import poeCraftingSim.client.enums.OrbTypes;
import poeCraftingSim.client.enums.RarityEnum;
import poeCraftingSim.client.functionality.ModParser;
import poeCraftingSim.client.items.Item;

public class AlchemyOrb implements NormalOrb {

	static String whichMod, mod;
	static int howMany, numP, numS, prefixMax = 3, suffixMax = 3;



	public static void use(Item i) {
		if (isValid(i)) {
			Random rand = new Random();
			howMany = rand.nextInt(3) + 4;
			numP = 0;
			numS = 0;
			for (int l = 0; l < howMany; l++) {
				decideMod();
				mod = ModParser.getMod(i, whichMod);
				i.setMod(whichMod, mod);
			};
			i.changeRarity(RarityEnum.RARE.toString());
		}
	}

	private static void decideMod() {
		Random rand = new Random();
		int temp = rand.nextInt(2);
		if (numP < prefixMax && numS < suffixMax) {
			if (temp == 0) {
				whichMod = AffixEnum.PREFIX.toString();
				numP++;
				return;
			}
			if (temp == 1) {
				whichMod = AffixEnum.SUFFIX.toString();
				numS++;
				return;
			}
		}
		else if (numP < prefixMax) {
			whichMod = AffixEnum.PREFIX.toString();
			return;
		}
		else
			whichMod = AffixEnum.SUFFIX.toString();
	}

	public static boolean isValid(Item i) {

		return i.isValid(OrbTypes.ALCHEMYORB.toString());
	}

}
