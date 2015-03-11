package poeCraftingSim.client.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		String p1, p2, p3, s1, s2, s3, implicit;
		implicit = item.getMod("implicit");
		p1 = item.getMod("prefix", 0);
		p2 = item.getMod("prefix", 1);
		p3 = item.getMod("prefix", 2);
		s1 = item.getMod("suffix", 0);
		s2 = item.getMod("suffix", 1);
		s3 = item.getMod("suffix", 2);
		display = new JLabel("<html>Item Type:" + item.getType() + "<br>" 
				+ "Item Base:" + item.getBase() + "<br>"
				+ "Item Rarity:" + item.getRarity() + "<br>"
				+ "Item Level:" + item.getItemLevel() + "<br>"
				+ "Implicit: " + implicit + "<br>"
				+ "Prefixes: " + p1 + p2 + p3 + "<br>" 
				+ "Suffixes: " + s1 + s2 + s3 + "</html>");
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
		
		add(transmutation);
		add(regal);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
