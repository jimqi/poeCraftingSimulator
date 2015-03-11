package poeCraftingSim.client.items;

public class Item {
	private static volatile Item instance = null;

	//Item Properties
	String name;
	String type;
	String base;
	String rarity;
	String implicit;
	int sockets;
	int links;
	int quality;
	int itemLevel;
	String[] prefix;
	String[] suffix;

	protected Item() {
		sockets = 1;
		links = 1;
		quality = 0;
		prefix = new String[3];
		suffix = new String[3];
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
	
	public void setMod(String s, String m) {
		int i = 0;
		if (s == "prefix") {
			while (i < prefix.length) {
				if (prefix[i] == null){
					prefix[i] = s;
					return;
				}
				i++;
			}	
		}
		else if (s == "suffix") {
			while (i < suffix.length) {
				if (suffix[i] == null){
					suffix[i] = s;
					return;
				}
				i++;
			}
		}
		else if (s == "implicit") {
			implicit = m;
		}
		System.out.println("invalid set mod field");
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

	/**
	 * gets one item mod
	 * 
	 * @param s
	 *            implicit, prefix or suffix
	 * @param i
	 *            which mod to get if s = 0 || 1
	 * @returns 
	 *  		  the mod as a string
	 */
	public String getMod(String s, int i) {
		if (s == "prefix") {
			if (i < prefix.length)
				return prefix[i];
			else
				return "empty prefix";
		}
		else if (s == "suffix") {
			if (i < suffix.length)
				return suffix[i];
			else
				return "empty suffix";
		}
		else if (s == "implicit")
			return implicit;
		else
			return "invalid";
	}
	
	public String getMod(String s) {
		return getMod(s, 0);
	}

	public void changeRarity(String r) {
		rarity = r;
	}
	
	public void resetAffix() {
		for (int i = 0; i < prefix.length; i++) {
			prefix[i] = null;
		}
		for (int i = 0; i < suffix.length; i++) {
			suffix[i] = null;
		}
	}

	public boolean isValid(String orbName) {
		switch (orbName) {
		case "TransmutationOrb": if (rarity == "Common") {
			return true;
		}
		else
			return false;
		case "RegalOrb": if (rarity == "Magic") {
			return true;
		}
		else
			return false;
		case "ScouringOrb": if (rarity != "Common") {
			return true;
		}
		else
			return false;
		default:
			return false;
		}
	}

	public void createJson() {

	}

}
