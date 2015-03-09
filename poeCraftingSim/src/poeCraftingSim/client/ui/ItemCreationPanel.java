package poeCraftingSim.client.ui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;

public class ItemCreationPanel extends JPanel implements ActionListener {

	protected JFormattedTextField itemLevelSelection;
	private NumberFormat itemLevelFormat;

	private JLabel typeLabel;
	private JLabel baseLabel;
	private JLabel rarityLabel;
	private JLabel itemLevelLabel;

	private static String typeString = "Item Type: ";
	private static String baseString = "Item Base: ";
	private static String rarityString = "Item Rarity: ";
	private static String itemLevelString = "Item Level: ";

	private static final long serialVersionUID = -5067664254897140321L;

	private final JComboBox<String> typeSelection = new JComboBox<String>( new String[] { "select type", "Armor", "Weapon", "Jewelery" }) { 
		private static final long serialVersionUID = -3938673127117291014L;
	};


	private final JComboBox<String> baseSelection = new JComboBox<String>() { 
		private static final long serialVersionUID = 8754447548911695908L;
	};

	private final JComboBox<String> raritySelection = new JComboBox<String>(new String[] { "select rarity", "Common", "Magic", "Rare" }) { 
		private static final long serialVersionUID = 8754447548911695908L;
	};

	private final JButton createItem;

	@SuppressWarnings("rawtypes")
	private final ComboBoxModel[] models = new ComboBoxModel[4];

	@SuppressWarnings("unchecked")
	public ItemCreationPanel() {

		models[0] = new DefaultComboBoxModel<String>(
				new String[] { " " });
		models[1] = new DefaultComboBoxModel<String>(
				new String[] { "select armor", "Helm", "Chest", "Gloves", "Boots", "Shield" });
		models[2] = new DefaultComboBoxModel<String>(
				new 	String[] { "select weapons", "Bow", "Claw", "Dagger", "One-Handed Axe", "One-Handed Mace", "One-Handed Sword",
						"Sceptre", "Staff", "Two-Handed Axe", "Two-Handed Mace", "Two-Handed Sword", "Wand" });
		models[3] = new DefaultComboBoxModel<String>(
				new 	String[] { "select jewelry", "Ring", "Belt", "Amulet" });
		baseSelection.setModel(models[0]); 
		//JComboBox typeSelection = new JComboBox(itemType);
		typeSelection.addActionListener(this);

		//set sizes of dropboxes
		Dimension comboBoxSize = new Dimension(140,25);
		baseSelection.setPreferredSize(comboBoxSize);
		typeSelection.setPreferredSize(comboBoxSize);
		raritySelection.setPreferredSize(comboBoxSize);
		typeSelection.setAlignmentX(Component.CENTER_ALIGNMENT);

		//create itemLevel text field
		Dimension itemLevelSize = new Dimension(70,25);
		itemLevelFormat = NumberFormat.getNumberInstance();
		itemLevelSelection = new JFormattedTextField(itemLevelFormat);
		itemLevelSelection.setPreferredSize(itemLevelSize);

		//create the labels
		typeLabel = new JLabel(typeString);
		baseLabel = new JLabel(baseString);
		rarityLabel = new JLabel(rarityString);
		itemLevelLabel = new JLabel(itemLevelString);

		//alignment
		//TODO work out how this actually works
		JComponent panel = this;
		GroupLayout layout = new GroupLayout(panel);
		panel.setLayout(layout);

		GroupLayout.SequentialGroup hGroup = layout.createSequentialGroup();

		hGroup.addGroup(layout.createParallelGroup().
				addComponent(typeLabel).addComponent(baseLabel).addComponent(rarityLabel).addComponent(itemLevelLabel));
		hGroup.addGroup(layout.createParallelGroup().
				addComponent(typeSelection).addComponent(baseSelection).addComponent(raritySelection).addComponent(itemLevelSelection));
		layout.setHorizontalGroup(hGroup);

		GroupLayout.SequentialGroup vGroup = layout.createSequentialGroup();

		vGroup.addGroup(layout.createParallelGroup(Alignment.BASELINE).
				addComponent(typeLabel).addComponent(typeSelection));
		vGroup.addGroup(layout.createParallelGroup(Alignment.BASELINE).
				addComponent(baseLabel).addComponent(baseSelection));
		vGroup.addGroup(layout.createParallelGroup(Alignment.BASELINE).
				addComponent(rarityLabel).addComponent(raritySelection));
		vGroup.addGroup(layout.createParallelGroup(Alignment.BASELINE).
				addComponent(itemLevelLabel).addComponent(itemLevelSelection));
		layout.setVerticalGroup(vGroup);

		//set up panels
		JPanel labelPane = new JPanel(new GridLayout(0,1));  
		labelPane.add(typeLabel);
		labelPane.add(baseLabel);
		labelPane.add(rarityLabel);
		labelPane.add(itemLevelLabel);

		JPanel fieldPane = new JPanel();
		fieldPane.setLayout(new BoxLayout(fieldPane, BoxLayout.Y_AXIS));
		fieldPane.add(typeSelection);
		fieldPane.add(baseSelection);
		fieldPane.add(raritySelection);
		fieldPane.add(itemLevelSelection);

		//add panels to the ItemCreationPanel
		setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		add(labelPane, BorderLayout.CENTER);
		add(fieldPane, BorderLayout.LINE_END);

		//create item button
		createItem = new JButton("Create");

	}

	@SuppressWarnings("unchecked")
	@Override
	public void actionPerformed(ActionEvent e) {
		JComboBox<String> cb = (JComboBox<String>) e.getSource();
		String result = (String) cb.getSelectedItem();
		switch (result) {
		case "Armor": 
			baseSelection.setSelectedIndex(0);
			baseSelection.setModel(models[1]);
			break;
		case "Weapon": 
			baseSelection.setSelectedIndex(0);
			baseSelection.setModel(models[2]);
			break;
		case "Jewelery": 
			baseSelection.setSelectedIndex(0);
			baseSelection.setModel(models[3]);
			break;
		}

	}

	public String getType() {
		String type = (String) typeSelection.getSelectedItem();
		return type;
	}

	public String getBase() {
		String base = (String) baseSelection.getSelectedItem();
		return base;
	}

	public String getRarity() {
		String rarity = (String) raritySelection.getSelectedItem();
		return rarity;
	}

	public int getItemLevel() {
		if (itemLevelSelection.getText().isEmpty() == false) {
			int itemLevel = Integer.parseInt(itemLevelSelection.getText());
			return itemLevel;
		}
		else
			return -1;
	}
}