package poeCraftingSim.client.orbs;

import poeCraftingSim.client.items.Item;

public class TransmutationOrb {

	public void use(Item i) {
		i.changeRarity("magic");
	}


	public boolean isValid(Item i) {
		return i.isValid("TransmutationOrb");
	}

}
