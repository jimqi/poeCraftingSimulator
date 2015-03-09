package poeCraftingSim.client.orbs;

import poeCraftingSim.client.items.Item;

public class RegalOrb implements NormalOrb {

	public static void use(Item i) {
		if (isValid(i)) {
			i.changeRarity("Rare");
		}
	}

	public static boolean isValid(Item i) {
		return i.isValid(RegalOrb.class.getSimpleName());
	}
}
