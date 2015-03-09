package poeCraftingSim.client.items;

public class Item {
	private static volatile Item instance = null;
	
	//Item Properties
	String name;
	int itemLevel;
	String type;
	String base;
	int quality;
	String rarity;
	
	protected Item() {}
	
	public static Item getInstance() {
		if(instance == null) {
			instance = new Item();
		}
		return instance;
	}
	//set methods
	public void setName(String n) {
		name = n;
	}
	
	public void setItemLevel(int i) {
		itemLevel = i;
	}
	
	public void setType(String t) {
		type = t;
	}
	
	public void setBase(String b) {
		base = b;
	}
	
	public void setQuality(int i) {
		quality = i;
	}
	public void setRarity(String r) {
		rarity = r;
	}
	
	//get methods
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
