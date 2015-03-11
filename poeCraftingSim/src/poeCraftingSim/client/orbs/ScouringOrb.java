package poeCraftingSim.client.orbs;

import poeCraftingSim.client.items.Item;

public class ScouringOrb implements NormalOrb {
	public static void use(Item i) {
		if (isValid(i)) {
			i.resetAffix();
			i.changeRarity("Common");
		}
	}

	public static boolean isValid(Item i) {
		return i.isValid(ScouringOrb.class.getSimpleName());
	}

}
