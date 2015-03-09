package poeCraftingSim.client.items;

public class Item {
	//Item Properties
	static String name;
	static String type;
	int quality;
	String rarity;
	
	public Item(String t) {
		name = "test";
		type = t;
		quality = 0;
		rarity = "common";
	}
	
	public String getName() {
		return name;
	}
	
	public String getRarity() {
		return rarity;
	}
	
	public void changeRarity(String r) {
		rarity = r;
	}
	
	public boolean isValid(String orbName) {
		switch (orbName) {
			case "transmuationOrb": if (rarity == "common") {
				return true;
			}
			else
				return false;
			default:
				return false;
		}
	}

}
