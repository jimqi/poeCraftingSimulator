package poeCraftingSim.client.orbs;

import poeCraftingSim.client.items.Item;

public class RegalOrb  {

	public void use(Item i) {
		if (isValid(i)) {
			i.changeRarity("Rare");
		}
	}

	public boolean isValid(Item i) {
		if (i.getRarity() == "Magic") {
			return true;
		}
		return false;
	}

}
