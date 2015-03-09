package poeCraftingSim.client.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import poeCraftingSim.client.items.Item;
import poeCraftingSim.client.orbs.*;

public class ControlToolbar extends JToolBar {
	private JButton testButton, testItemButton, testScourButton;
	
	public ControlToolbar() {
		
		// Prevent user from relocating the toolbar
		setFloatable(false);
		
		Item testItem = MainWindow.getItem();
		
		testButton = new JButton("testRegal");
		testButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				RegalOrb.use(testItem);
				MainWindow.updateItemPanel(testItem);
			}
		});
		
		testItemButton = new JButton("testTransmute");
		testItemButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				TransmutationOrb.use(testItem);
				MainWindow.updateItemPanel(testItem);
				System.out.println(testItem.getRarity());
			}
		});
		
		testScourButton = new JButton("testScouring");
		testScourButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ScouringOrb.use(testItem);
				MainWindow.updateItemPanel(testItem);
				System.out.println(testItem.getRarity());
			}
		});
		
		this.add(testButton);
		this.add(testItemButton);
		this.add(testScourButton);
		
	}

}
