package poeCraftingSim.client.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import poeCraftingSim.client.enums.AffixEnum;
import poeCraftingSim.client.items.Item;
import poeCraftingSim.client.orbs.*;

public class ItemCraftingPanel extends JPanel implements ActionListener {

	Item item;
	//panel to display the item
	static JPanel itemPanel;
	static JLabel display;
	final static int maxGap = 20;

	static JButton transmutation, augmentation, regal, scouring, alchemy, chaos;
	GridLayout buttonLayout = new GridLayout(4,5);

	private JPanel itemDisplay;

	public ItemCraftingPanel() {
		//get the item instance
		item = MainWindow.getItem();

		//create the panel to display the item stats
		JPanel itemPanel = new JPanel();
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
		transmutation = new JButton("Transmutation Orb");
		transmutation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TransmutationOrb.use(item);
				MainWindow.updateItemPanel(item);
			}
		});

		regal = new JButton("Regal Orb");
		regal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegalOrb.use(item);
				MainWindow.updateItemPanel(item);
			}
		});

		scouring = new JButton("Scouring Orb");
		scouring.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ScouringOrb.use(item);
				MainWindow.updateItemPanel(item);
			}
		});
		
		alchemy = new JButton("Alchemy Orb");
		alchemy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AlchemyOrb.use(item);
				MainWindow.updateItemPanel(item);
			}
		});
		
		chaos = new JButton("Chaos Orb");
		chaos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChaosOrb.use(item);
				MainWindow.updateItemPanel(item);
			}
		});

		
		final JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(buttonLayout);
		
	    //Set up components preferred size
        JButton b = new JButton("Just fake button");
        Dimension buttonSize = b.getPreferredSize();
        buttonPanel.setPreferredSize(new Dimension((int)(buttonSize.getWidth() * 2.5)+maxGap,
                (int)(buttonSize.getHeight() * 3.5)+maxGap * 2));
        
        buttonPanel.add(transmutation);
        buttonPanel.add(scouring);
        buttonPanel.add(regal);
        buttonPanel.add(alchemy);
        buttonPanel.add(chaos);
        buttonPanel.add(new JButton("Button 3"));
        buttonPanel.add(new JButton("Button 4"));
        
        add(buttonPanel, BorderLayout.SOUTH);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
