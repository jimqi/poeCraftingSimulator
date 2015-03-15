package poeCraftingSim.client.items;

import java.util.ArrayList;
import java.util.List;

import poeCraftingSim.client.enums.AffixEnum;
import poeCraftingSim.client.enums.RarityEnum;

public class Item {
	private static volatile Item instance = null;

	//Item Properties
	private String name;
	// Weapon, Armor or Jewelery
	private String type;
	private String base;
	private String specificItem;
	private String rarity;
	private List<String> implicit;
	private int sockets;
	private int links;
	private int quality;
	private int itemLevel;
	//aligned arrays value of prefix[x] = pValues[x]
	private String[] prefix;
	private String[] pValues;
	private String[] suffix;
	private String[] sValues;
	
	private Requirments req;

	protected Item() {
		sockets = 1;
		links = 1;
		quality = 0;
		implicit = new ArrayList<String>();
		prefix = new String[3];
		pValues = new String[] {"0", "0", "0"};
		suffix = new String[3];
		sValues = new String[] {"0", "0", "0"};
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

	public void setSockets(int s) {
		if (s <= 6 && s > 0)
			this.sockets = s;
		else
			System.err.println("Error invalid number of Sockets");
	}
	public void setLinks(int l) {
		this.links = l;
	}

	public void setSpecificItem(String specificItem) {
		this.specificItem = specificItem;
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
		if (s == AffixEnum.PREFIX.toString()) {
			while (i < prefix.length) {
				if (prefix[i] == null){
					prefix[i] = m;
					return;
				}
				i++;
			}	
		}
		else if (s == AffixEnum.SUFFIX.toString()) {
			while (i < suffix.length) {
				if (suffix[i] == null){
					suffix[i] = m;
					return;
				}
				i++;
			}
		}
		else if (s == AffixEnum.IMPLICIT.toString()) {
			implicit.add(m);
			return;
		}
		System.out.println("invalid set mod field" + s + m);
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
	
	public String getSpecificItem() {
		return specificItem;
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
		if (s == AffixEnum.PREFIX.toString()) {
			if (i < prefix.length)
				return prefix[i];
			else
				return "empty prefix";
		}
		else if (s == AffixEnum.SUFFIX.toString()) {
			if (i < suffix.length)
				return suffix[i];
			else
				return "empty suffix";
		}
		else if (s == AffixEnum.IMPLICIT.toString())
			if (implicit.get(i) != null)
				return implicit.get(i);
			else
				return null;
		else
			return "invalid";
	}

	/**
	 * Returns the affix string array
	 * 
	 * @param s
	 * 			implicit/prefix/suffix
	 * @return
	 * 			returns all of the specified affix
	 */
	public String[] getMod(String s) {
		String[] result = null;
		int modNumber;
		switch (s) {
		case "IMPLICIT":
			modNumber = implicit.size();
			result = new String[modNumber];
			for (int i = 0; i < modNumber; i++) {
				result[i] = getMod(s, 0);
			}
			break;
		case "PREFIX":
			modNumber = prefix.length;
			result = new String[modNumber];
			for (int i = 0; i < modNumber; i++) {
				result[i] = getMod(s, i);
			}
			break;
		case "SUFFIX":
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
	
	/**
	 *  checks if a orb can be used on the item
	 * @param orbName
	 * 			name of the orb being used
	 * @return
	 * 			boolean 
	 */

	public boolean isValid(String orbName) {
		switch (orbName) {
		case "TRANSMUTATIONORB" : if (rarity.equals(RarityEnum.COMMON.toString())) {
			return true;
		}
		return false;
		case "REGALORB": if (rarity.equals(RarityEnum.MAGIC.toString())) {
			return true;
		}
		return false;
		case "SCOURINGORB": if (!rarity.equals(RarityEnum.COMMON.toString())) {
			return true;
		}
		return false;
		case "ALCHEMYORB": if (rarity.equals(RarityEnum.COMMON.toString())) {
			return true;
		}
		return false;
		case "CHAOSORB": if (rarity.equals(RarityEnum.RARE.toString())) {
			return true;
		}
		return false;
		case "EXALTEDORB": if (rarity.equals(RarityEnum.RARE.toString())) {
			//I already initilized the array to length 3 so I can't check if .length < 3 so I check to see if the 
			//last affix position to be filled in empty or not
			if (prefix[2] == null || suffix[2] == null)
				return true;
		}
		return false;
		default:
			return false;
		}
	}

}
