package poeCraftingSim.client.orbs;

import java.util.Random;

import poeCraftingSim.client.items.Item;

public class RegalOrb implements NormalOrb {
	static String whichMod;
	static String mod;

	public static void use(Item i) {
		if (isValid(i)) {
			decideMod();
			i.setMod(whichMod, mod);
			i.changeRarity("Rare");
		}
	}
	
	public static void decideMod() {
		Random rand = new Random();
		int temp = rand.nextInt(2);
		if (temp == 0) {
			whichMod = "prefix";
		}
		if (temp == 1) {
			whichMod = "suffix";
		}
		mod = "test";
	}

	public static boolean isValid(Item i) {
		return i.isValid(RegalOrb.class.getSimpleName());
	}
}
