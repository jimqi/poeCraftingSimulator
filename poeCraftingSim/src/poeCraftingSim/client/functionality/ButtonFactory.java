package poeCraftingSim.client.functionality;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.swing.JButton;

import poeCraftingSim.client.items.Item;
import poeCraftingSim.client.ui.MainWindow;

public class ButtonFactory {
	
	/**
	 * Creates a button that uses an orb when pressed
	 * 
	 * @param buttonName
	 * 			String: name to be displayed on the created button
	 * @param orbName
	 * 			String: name of the orb class that the button will call use(item) on
	 * @param item
	 * 			Item: single instance of the item and parameter of use(item)
	 * @return
	 */
	public static JButton createButton(String buttonName, String orbName, Item item) {
		    
		JButton button = new JButton(buttonName);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class<?> orbClass = Class.forName("poeCraftingSim.client.orbs." + orbName);
					Class<Item>[] cArg = new Class[1];
					cArg[0] = Item.class;
					Method useMethod = orbClass.getDeclaredMethod("use", cArg);
					useMethod.invoke(null, item);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (NoSuchMethodException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SecurityException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IllegalAccessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IllegalArgumentException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (InvocationTargetException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				MainWindow.updateItemPanel(item);
			}
		});
		return button;
		
	}

}
