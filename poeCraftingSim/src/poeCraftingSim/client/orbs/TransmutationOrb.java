package poeCraftingSim.client.orbs;

import poeCraftingSim.client.items.Item;

public class TransmutationOrb implements NormalOrb {

	public static void use(Item i) {
		if (isValid(i) == true) {
			i.changeRarity("Magic");
		}
	}

	public static boolean isValid(Item i) {
		return i.isValid(TransmutationOrb.class.getSimpleName());
	}

}
