package poeCraftingSim.client.orbs;

import poeCraftingSim.client.enums.OrbTypes;
import poeCraftingSim.client.items.Item;

public class AlterationOrb {
	public static void use(Item i) {
		if (isValid(i)) {
			ScouringOrb.use(i);
			TransmutationOrb.use(i);
		}
		
	}

	private static boolean isValid(Item i) {
		return i.isValid(OrbTypes.ALTERATIONORB.toString());
	}
}
