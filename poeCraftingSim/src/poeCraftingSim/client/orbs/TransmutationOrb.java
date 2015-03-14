package poeCraftingSim.client.orbs;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Random;

import poeCraftingSim.client.enums.AffixEnum;
import poeCraftingSim.client.enums.OrbTypes;
import poeCraftingSim.client.enums.RarityEnum;
import poeCraftingSim.client.functionality.ModParser;
import poeCraftingSim.client.items.Item;

public class TransmutationOrb implements NormalOrb {
	static String whichMod;
	static String mod, modP, modS;
	//2 affix magic item or 1 affix
	static int howMany;

	public static void use(Item i) {
		if (isValid(i)) {
			Random rand = new Random();
			howMany = rand.nextInt(2) + 1;
			if (howMany == 1) {
				decideMod();
				//validMods is a list of the name of mods valid for the item type, item level and affix type
				mod = ModParser.getMod(i, whichMod);
				i.setMod(whichMod, mod);
			}
			else
			{
					modP = ModParser.getMod(i, AffixEnum.PREFIX.toString());
					i.setMod(AffixEnum.PREFIX.toString(), modP);
					modS = ModParser.getMod(i, AffixEnum.SUFFIX.toString());
					i.setMod(AffixEnum.SUFFIX.toString(), modS);
			}
			i.changeRarity(RarityEnum.MAGIC.toString());
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
		return i.isValid(OrbTypes.TRANSMUTATIONORB.toString());
	}

}
