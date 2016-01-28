package gildedrose;

import java.util.ArrayList;
import java.util.List;

public class GildedRose{

	private static List<Item> items = null;

	public static void main(String[] args) {

		System.out.println("OMGHAI!");

		items = new ArrayList<Item>();
		items.add(new Item("+5 Dexterity Vest", 10, 20));
		items.add(new Item("Aged Brie", 2, 0));
		items.add(new Item("Elixir of the Mongoose", 5, 7));
		items.add(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
		items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
		items.add(new Item("Conjured Mana Cake", 3, 6));

		updateQuality();
	}

	public static void updateQuality() {
		
		// Every item gets replaced by a strategy-item
		for (int i = 0; i < items.size(); i++) {
			Item item = items.get(i);
				 item = createUQS(item).updateItem(item);
		}	
	}

	/*
	 * minimal addition to ensure testability
	 */
	public static void setItems(List<Item> items) {
		GildedRose.items = items;
	}

	// factory method
	public static UQS createUQS(Item item){
		
		String name = item.getName();
		
		if(name.equals("Sulfuras, Hand of Ragnaros"))
			return new Sulfuras();
		
		else if(name.equals("Aged Brie"))
			return new AgedBrie();
		
		else if(name.equals("Backstage passes to a TAFKAL80ETC concert"))
			return new BackstagePasses();
		
		else if(name.equals("Conjured Mana Cake"))
			return new ConjuredManaCake();
		
		else
			return new UQS();
	}
}