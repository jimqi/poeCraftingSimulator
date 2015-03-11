package poeCraftingSim.client.items;

import java.util.ArrayList;
import java.util.List;

public class Item {
	private static volatile Item instance = null;

	//Item Properties
	private String name;
	private String type;
	private String base;
	private String rarity;
	private List<String> implicit;
	private int sockets;
	private int links;
	private int quality;
	private int itemLevel;
	private String[] prefix;
	private String[] suffix;
	private Requirments req;

	protected Item() {
		sockets = 1;
		links = 1;
		quality = 0;
		implicit = new ArrayList<String>();
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
		this.name = n;
	}

	public void setItemLevel(int i) {
		this.itemLevel = i;
	}

	public void setType(String t) {
		this.type = t;
	}

	public void setBase(String b) {
		this.base = b;
	}

	public void setQuality(int i) {
		this.quality = i;
	}
	public void setRarity(String r) {
		this.rarity = r;
	}

	/**
	 * Puts the mod into the first open mod space or does nothing if no open spaces left
	 * 
	 * @param s
	 * 			specifys prefix/suffix
	 * @param m
	 * 			the mod to be added
	 */
	public void setMod(String s, String m) {
		int i = 0;
		if (s == "Prefix") {
			while (i < prefix.length) {
				if (prefix[i] == null){
					prefix[i] = m;
					return;
				}
				i++;
			}	
		}
		else if (s == "Suffix") {
			while (i < suffix.length) {
				if (suffix[i] == null){
					suffix[i] = m;
					return;
				}
				i++;
			}
		}
		else if (s == "Implicit") {
			implicit.add(m);
			return;
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
			if (implicit.get(i) != null)
				return implicit.get(i);
			else
				return null;
		else
			return "invalid";
	}

	public String[] getMod(String s) {
		String[] result = null;
		int modNumber;
		switch (s) {
		case "implicit":
			modNumber = implicit.size();
			result = new String[modNumber];
			for (int i = 0; i < modNumber; i++) {
				result[i] = getMod(s, 0);
			}
			break;
		case "prefix":
			modNumber = prefix.length;
			result = new String[modNumber];
			for (int i = 0; i < modNumber; i++) {
				result[i] = getMod(s, i);
			}
			break;
		case "suffix":
			modNumber = suffix.length;
			result = new String[modNumber];
			for (int i = 0; i < modNumber; i++) {
				result[i] = getMod(s, i);
			}
			break;
		}
		return result;
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
