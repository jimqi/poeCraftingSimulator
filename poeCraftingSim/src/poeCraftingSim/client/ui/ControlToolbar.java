package poeCraftingSim.client.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import poeCraftingSim.client.items.Item;
import poeCraftingSim.client.orbs.TransmutationOrb;

public class ControlToolbar extends JToolBar {
	
	private MainWindow main;
	private JButton testButton, testItemButton;
	
	public ControlToolbar(MainWindow mainWindow) {
		
		this.main = mainWindow;
		
		// Prevent user from relocating the toolbar
		setFloatable(false);
		
		testButton = new JButton("test");
		testButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Item testItem = Item.getInstance();
				main.setItem(testItem);
				main.updateItemPanel(testItem);
			}
		});
		
		testItemButton = new JButton("testItem");
		testItemButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Item testItem = main.getItem();;
				TransmutationOrb.use(testItem);
				main.updateItemPanel(testItem);
			}
		});
		
		this.add(testButton);
		this.add(testItemButton);
		
	}

}
