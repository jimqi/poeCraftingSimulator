package poeCraftingSim.client.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

import poeCraftingSim.client.items.Item;

public class ItemCraftingPanel extends JPanel implements ActionListener {
	
	Item item;
	static JPanel itemPanel;
	static JLabel test;
	
	private JPanel itemDisplay;
	
	public ItemCraftingPanel() {
		item = MainWindow.getItem();
		JPanel itemPanel = new JPanel();
		test = new JLabel("<html>Item Type:" + item.getType() + "<br>" 
				+ "Item Base:" + item.getBase() + "<br>"
				+ "Item Rarity:" + item.getRarity() + "<br>"
				+ "Item Level:" + item.getItemLevel() + "<br>" + "</html>");
		itemPanel.add(test);
		
		add(itemPanel);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
