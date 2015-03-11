package poeCraftingSim.client.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import poeCraftingSim.client.items.Item;
import poeCraftingSim.client.orbs.*;

public class ItemCraftingPanel extends JPanel implements ActionListener {
	
	Item item;
	//panel to display the item
	static JPanel itemPanel;
	static JLabel display;
	
	static JButton transmutation, augmentation, regal, scouring;
	
	private JPanel itemDisplay;
	
	public ItemCraftingPanel() {
		//get the item instance
		item = MainWindow.getItem();
		
		//create the panel to display the item stats
		JPanel itemPanel = new JPanel();
		String[] prefixes, suffixes, implicits;
		implicits = item.getMod("implicit");
		prefixes = item.getMod("prefix");
		suffixes = item.getMod("suffix");
		String itemDisplay = "";
		//build the affix string
		itemDisplay = itemDisplay.concat("Implicits:<br> ");
		for (int i = 0; i < implicits.length; i++) {
			itemDisplay = itemDisplay.concat(implicits[i] + "<br>");
		}
		itemDisplay = itemDisplay.concat("Prefixes:<br> ");
		for (int i = 0; i < prefixes.length; i++) {
			itemDisplay = itemDisplay.concat(prefixes[i] + "<br>");
		}
		itemDisplay = itemDisplay.concat("Suffixes:<br> ");
		for (int i = 0; i < suffixes.length; i++) {
			itemDisplay = itemDisplay.concat(suffixes[i] + "<br>");
		}
		display = new JLabel("<html>Item Type:" + item.getType() + "<br>" 
				+ "Item Base:" + item.getBase() + "<br>"
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
		
		add(transmutation);
		add(regal);
		add(scouring);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
