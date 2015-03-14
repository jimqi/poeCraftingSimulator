package poeCraftingSim.client.items;

import static org.junit.Assert.*;

import org.junit.Test;

public class ItemTest {

	@Test
	public void test() {
		Item i = Item.getInstance();
		i.changeRarity("Common");
		assertEquals(i.getRarity(), "Common");
	}

}
