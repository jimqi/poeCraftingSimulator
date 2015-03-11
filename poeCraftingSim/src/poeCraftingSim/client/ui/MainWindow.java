package poeCraftingSim.client.ui;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import poeCraftingSim.client.functionality.ModParser;
import poeCraftingSim.client.items.Item;

public class MainWindow extends JFrame {
	private static final long serialVersionUID = 2419089325406471624L;
	static Container cb;
	private static Item item;

	private ItemCreationPanel creationPanel;
	private static ItemCraftingPanel craftingPanel;

	private static ControlToolbar toolbar;	

	private MainWindow() {

		JFrame frame = new JFrame("POE Crafting Simulator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		cb = frame.getContentPane();

		cb.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

		creationPanel = new ItemCreationPanel();
		JButton createItem = new JButton("Create");
		createItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO
				//Create Item

				if (creationPanel.getType() != "select type" && creationPanel.getBase() != "select base" && creationPanel.getRarity() != "select rarity" && creationPanel.getItemLevel() != -1) {
					item = Item.getInstance();
					item.setType(creationPanel.getType());
					item.setBase(creationPanel.getBase());
					item.setRarity(creationPanel.getRarity());
					item.setItemLevel(creationPanel.getItemLevel());
					item.setMod("Implicit", "test");

					craftingPanel = new ItemCraftingPanel();
					creationPanel.setVisible(false);;
					createItem.setVisible(false);
					//toolbar = new ControlToolbar();
					//cb.add(toolbar);
					cb.add(craftingPanel);
				}
				else
					System.out.println("missing fields");
			}          
		});
		Dimension buttonSize = new Dimension(50, 50);
		createItem.setPreferredSize(buttonSize);
		cb.add(creationPanel);
		cb.add(createItem);

		frame.setSize(400, 300);
		frame.setVisible(true);

	}

	public void setItem(Item i) {
		item = i;
	}

	public static Item getItem() {
		return item;
	}

	public static void updateItemPanel(Item i) {
		cb.removeAll();
		cb.revalidate();
		cb.repaint();
		//toolbar = new ControlToolbar();
		//cb.add(toolbar);
		craftingPanel = new ItemCraftingPanel();
		cb.add(craftingPanel);
	}

	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable	() {
			public void run() {
				new MainWindow();
			}
		});
	}

}
