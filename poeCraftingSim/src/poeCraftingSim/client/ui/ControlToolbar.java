package poeCraftingSim.client.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import poeCraftingSim.client.items.Item;

public class ControlToolbar extends JToolBar {
	
	private MainWindow main;
	private JButton testButton;
	
	public ControlToolbar(MainWindow mainWindow) {
		
		this.main = mainWindow;
		
		// Prevent user from relocating the toolbar
		setFloatable(false);
		
		testButton = new JButton("test");
		testButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Item testItem = new Item("test");
				main.updateItemPanel(testItem);
			}
		});
		
		this.add(testButton);
		
	}

}
