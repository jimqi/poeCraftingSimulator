package poeCraftingSim.client.orbs;

import poeCraftingSim.client.enums.AffixEnum;
import poeCraftingSim.client.enums.OrbTypes;
import poeCraftingSim.client.functionality.ModParser;
import poeCraftingSim.client.items.Item;

public class AugmentationOrb {
	static String whichMod, mod;
	
	public static void use(Item i) {
		if (isValid(i)) {
			decideMod(i);
			mod = ModParser.getMod(i, whichMod);
			i.setMod(whichMod, mod);
		}
		
	}
	
	private static void decideMod(Item i) {
		// case 1: 1 prefix 0 suffix
		if (i.getMod(AffixEnum.PREFIX.toString())[0] == null ) {
			whichMod = AffixEnum.PREFIX.toString();
		}
		else if (i.getMod(AffixEnum.SUFFIX.toString())[0] == null ) {
			whichMod = AffixEnum.SUFFIX.toString();
		}
		// case 2: 0 prefix 1 suffix
	}
	
	private static boolean isValid(Item i) {
		return i.isValid(OrbTypes.AUGMENTATIONORB.toString());
		
	}
}
