package poeCraftingSim.client.ui;

import java.awt.BorderLayout;

import javax.swing.*;

import poeCraftingSim.client.items.Item;

public class MainWindow extends JFrame {
	
	private Item item;
	
	private JLabel itemPanel;
	private ControlToolbar controlToolbar;
	
	private MainWindow() {
		
		JFrame frame = new JFrame("POE Crafting Simulator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		controlToolbar = new ControlToolbar(this);
		
		itemPanel = new JLabel();
		itemPanel.setHorizontalAlignment(SwingConstants.CENTER);
		itemPanel.setText("<html>Item Name:" + "<br>" 
							+ "Item Rarity:" + "<br>" + "</html>");
		
		frame.getContentPane().add(itemPanel);
		frame.add(controlToolbar, BorderLayout.PAGE_START);
		
		frame.pack();
		frame.setVisible(true);
	}
	
	public void updateItemPanel(Item i) {
		itemPanel.setText("<html>Item Name:" + i.getName() + "<br>" 
				+ "Item Rarity:" + i.getRarity() + "<br>" + "</html>");
	}
	
	public void setItem(Item i) {
		item = i;
	}
	
	public Item getItem() {
		return item;
	}
	
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable	() {
			public void run() {
				new MainWindow();
			}
		});
	}

}
