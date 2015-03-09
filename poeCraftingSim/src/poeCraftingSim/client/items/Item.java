package poeCraftingSim.client.items;

public class Item {
	private static volatile Item instance = null;
	
	//Item Properties
	String name;
	String type;
	int quality;
	String rarity;
	
	protected Item() {}
	
	public static Item getInstance() {
		if(instance == null) {
			instance = new Item();
		}
		return instance;
	}
	
	public void setName(String n) {
		name = n;
	}
	
	public void setType(String t) {
		type = t;
	}
	
	public void setQuality(int i) {
		quality = i;
	}
	public void setRarity(String r) {
		rarity = r;
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
