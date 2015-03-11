package poeCraftingSim.client.orbs;

import poeCraftingSim.client.items.Item;

public interface NormalOrb {
	
	public static void use(Item i) {}
	
	public static boolean isValid(Item i) {
		return false;}
}