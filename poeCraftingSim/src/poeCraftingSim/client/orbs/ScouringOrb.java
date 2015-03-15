package poeCraftingSim.client.orbs;

import poeCraftingSim.client.enums.OrbTypes;
import poeCraftingSim.client.enums.RarityEnum;
import poeCraftingSim.client.items.Item;

public class ScouringOrb {
	public static void use(Item i) {
		if (isValid(i)) {
			i.resetAffix();
			i.changeRarity(RarityEnum.COMMON.toString());
		}
	}

	public static boolean isValid(Item i) {
		return i.isValid(OrbTypes.SCOURINGORB.toString());
	}

}
