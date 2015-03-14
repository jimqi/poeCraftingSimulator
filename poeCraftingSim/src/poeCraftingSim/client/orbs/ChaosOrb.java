package poeCraftingSim.client.orbs;

import poeCraftingSim.client.enums.OrbTypes;
import poeCraftingSim.client.items.Item;

public class ChaosOrb implements NormalOrb {
	public static void use(Item i) {
		if (isValid(i)) {
			ScouringOrb.use(i);
			AlchemyOrb.use(i);
		}
	}

	public static boolean isValid(Item i) {
		return i.isValid(OrbTypes.CHAOSORB.toString());
	}
}