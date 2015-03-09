package poeCraftingSim.client.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

import poeCraftingSim.client.items.Item;

public class ItemCraftingPanel extends JPanel implements ActionListener {
	
	Item item;
	
	private JPanel itemDisplay;
	
	public ItemCraftingPanel() {
		item = MainWindow.getItem();
		String test = item.getRarity();
		JLabel testLabel = new JLabel(test);
		
		add(testLabel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
