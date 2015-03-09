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
	int sockets;
	int links;
	
	protected Item() {
		sockets = 1;
		links = 1;
		quality = 0;
	}
	
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
	
	public String getBase() {
		return base;
	}
	public String getType() {
		return type;
	}
	
	public String getRarity() {
		return rarity;
	}
	
	public int getItemLevel() {
		return itemLevel;
	}
	
	public void changeRarity(String r) {
		rarity = r;
	}
	
	public boolean isValid(String orbName) {
		switch (orbName) {
			case "TransmutationOrb": if (rarity == "Common") {
				return true;
			}
			case "RegalOrb": if (rarity == "Magic") {
				return true;
			}
			case "ScouringOrb": if (rarity != "Common") {
				return true;
			}
			default:
				return false;
		}
	}

}
