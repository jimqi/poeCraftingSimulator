package poeCraftingSim.client.ui;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;;

public class ItemCreationPanel extends JPanel implements ActionListener {


	private final JComboBox<String> typeSelection = new JComboBox<String>( new String[] { "select type", "Armor", "Weapon", "Jewelery" }) { 
	@Override
    public Dimension getMaximumSize() {
        Dimension max = super.getMaximumSize();
        max.height = getPreferredSize().height;
        max.width = getPreferredSize().width;
        return max;};
	};

	
	private final JComboBox<String> baseSelection = new JComboBox<String>() { 
		@Override
	    public Dimension getMaximumSize() {
	        Dimension max = super.getMaximumSize();
	        max.height = getPreferredSize().height;
	        max.width = getPreferredSize().width;
	        return max;};
		};

	private final ComboBoxModel[] models = new ComboBoxModel[4];
	//armor type

	//weapon type

	//jewelery type

	public ItemCreationPanel() {
		models[0] = new DefaultComboBoxModel<String>(
				new String[] { " " });
		models[1] = new DefaultComboBoxModel<String>(
				new String[] { "select armor", "Helm", "Chest", "Gloves", "Boots", "Shield" });
		models[2] = new DefaultComboBoxModel<String>(
				new 	String[] { "select weapons", "Bow", "Claw", "Dagger", "One-Handed Axe", "One-Handed Mace", "One-Handed Sword",
						"Sceptre", "Staff", "Two-Handed Axe", "Two-Handed Mace", "Two-Handed Sword", "Wand" });
		models[3] = new DefaultComboBoxModel<String>(
				new 	String[] { "select jewelery", "Ring", "Belt", "Amulet" });
		baseSelection.setModel(models[0]); 
		//JComboBox typeSelection = new JComboBox(itemType);
		typeSelection.addActionListener(this);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		Dimension comboBoxSize = new Dimension(140,25);
		baseSelection.setPreferredSize(comboBoxSize);
		typeSelection.setPreferredSize(comboBoxSize);
		typeSelection.setAlignmentX(Component.CENTER_ALIGNMENT);

		add(typeSelection);
		add(baseSelection);
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

}
