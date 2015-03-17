package poeCraftingSim.client.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import poeCraftingSim.client.enums.AffixEnum;
import poeCraftingSim.client.functionality.ButtonFactory;
import poeCraftingSim.client.items.Item;
import poeCraftingSim.client.orbs.*;

public class ItemCraftingPanel extends JPanel implements ActionListener {

	private static final long serialVersionUID = 3925873318794410180L;
	
	Item item;
	//panel to display the item
	static JPanel itemPanel;
	static JLabel display;
	final static int maxGap = 20;

	static JButton transmutation, augmentation, alteration, regal, scouring, alchemy, chaos, exalt;
	GridLayout buttonLayout = new GridLayout(4,5);

	public ItemCraftingPanel() {
		//get the item instance
		item = MainWindow.getItem();

		//create the panel to display the item stats
		JPanel itemPanel = new JPanel();
		itemPanel.setPreferredSize(new Dimension(200, 230));
		String[] prefixes, suffixes, implicits;
		implicits = item.getMod(AffixEnum.IMPLICIT.toString());
		prefixes = item.getMod(AffixEnum.PREFIX.toString());
		suffixes = item.getMod(AffixEnum.SUFFIX.toString());
		String itemDisplay = "";
		//build the affix string
		itemDisplay = itemDisplay.concat("Implicits:<br> ");
		for (int i = 0; i < implicits.length; i++) {
			if (implicits[i] != null)
				itemDisplay = itemDisplay.concat(implicits[i] + "<br>");
		}
		itemDisplay = itemDisplay.concat("Prefixes:<br> ");
		for (int i = 0; i < prefixes.length; i++) {
			if (prefixes[i] != null)
				itemDisplay = itemDisplay.concat(prefixes[i] + "<br>");
		}
		itemDisplay = itemDisplay.concat("Suffixes:<br> ");
		for (int i = 0; i < suffixes.length; i++) {
			if (suffixes[i] != null)
				itemDisplay = itemDisplay.concat(suffixes[i] + "<br>");
		}
		display = new JLabel("<html>Item Type:" + item.getType() + "<br>" 
				+ "Item Base:" + item.getBase() + "<br>"
				+ "Item:" + item.getSpecificItem() + "<br>"
				+ "Item Rarity:" + item.getRarity() + "<br>"
				+ "Item Level:" + item.getItemLevel() + "<br>"
				+ itemDisplay + "</html>");
		itemPanel.add(display);

		add(itemPanel);

		//create the buttons to apply orbs	
		transmutation = ButtonFactory.createButton("Transmutation Orb", "TransmutationOrb", item);
		augmentation = ButtonFactory.createButton("Augmentation Orb", "AugmentationOrb", item);
		alteration = ButtonFactory.createButton("Alteration Orb", "AlterationOrb", item);
		regal = ButtonFactory.createButton("Regal Orb", "RegalOrb", item);
		scouring = ButtonFactory.createButton("Scouring Orb", "ScouringOrb", item);
		alchemy = ButtonFactory.createButton("Alchemy Orb", "AlchemyOrb", item);
		chaos = ButtonFactory.createButton("Chaos Orb", "ChaosOrb", item);
		exalt = ButtonFactory.createButton("Exalted Orb", "ExaltedOrb", item);
		
		final JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(buttonLayout);
		
	    //Set up components preferred size
        JButton b = new JButton("Just fake button");
        Dimension buttonSize = b.getPreferredSize();
        buttonPanel.setPreferredSize(new Dimension((int)(buttonSize.getWidth() * 2.5)+maxGap,
                (int)(buttonSize.getHeight() * 3.5)+maxGap * 2));
        
        buttonPanel.add(transmutation);
        buttonPanel.add(augmentation);
        buttonPanel.add(alteration);
        buttonPanel.add(scouring);
        buttonPanel.add(regal);
        buttonPanel.add(alchemy);
        buttonPanel.add(chaos);
        buttonPanel.add(exalt);

        
        add(buttonPanel, BorderLayout.SOUTH);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
