package poeCraftingSim.client.items;

public class Requirments {
	private int strength;
	private int dexterity;
	private int intelligence;
	private int level;
	private String itemStatType;

	private enum statTypes {
		STR, DEX, INT, STRDEX, STRINT, DEXINT
	}

	/**
	 * Constructor
	 * 
	 * @param s: strength requirement
	 * @param d: dexterity requirement
	 * @param i: intelligence requirement
	 * @param t: type of item
	 * 			0 = str only
	 * 			1 = dex only
	 * 			2 = int only
	 * 			3 = str dex
	 * 			4 = str int
	 * 			5 = dex int
	 */
	public Requirments(int s, int d, int i, int t) {
		setStrength(s);
		setDexterity(d);
		setIntelligence(i);
		switch (t) {
		case 0:
			setItemStatType(statTypes.STR.toString());
			break;
		case 1:
			setItemStatType(statTypes.DEX.toString());
			break;
		case 2:
			setItemStatType(statTypes.INT.toString());
			break;
		case 3:
			setItemStatType(statTypes.STRDEX.toString());
			break;
		case 4:
			setItemStatType(statTypes.STRINT.toString());
			break;
		case 5:	
			setItemStatType(statTypes.DEXINT.toString());
			break;
		}

	}
	public String getItemStatType() {
		return itemStatType;
	}

	private void setItemStatType(String itemStatType) {
		this.itemStatType = itemStatType;
	}

	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		if (strength >= 0)
			this.strength = strength;
		else
			System.err.println("Invalid strength requirement");
	}

	public int getDexterity() {
		return dexterity;
	}

	public void setDexterity(int dexterity) {
		if (dexterity >= 0)
			this.dexterity = dexterity;
		else
			System.err.println("Invalid dexterity requirement");
	}

	public int getIntelligence() {
		return intelligence;
	}

	public void setIntelligence(int intelligence) {
		if (intelligence >= 0)
			this.intelligence = intelligence;
		else
			System.err.println("Invalid intelligence requirement");
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		if (level >= 0)
			this.level = level;
		else
			System.err.println("Invalid level requirement");
	}
}
