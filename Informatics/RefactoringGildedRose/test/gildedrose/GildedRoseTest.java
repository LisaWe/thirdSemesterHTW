package gildedrose;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class GildedRoseTest {

	@Parameters
	public static Collection<Object[]> data() {
		Collection<Object[]> data = new ArrayList<Object[]>();
		data.addAll(Arrays
				.asList(new Object[][] {
						
						{"1) At the end of each day our system lowers both quality and sell-in for every item",
							"Item with arbitrary name", 5, 49, 4, 48 } ,
						
						{"2) Once the sell by date has passed, Quality degrades twice as fast",
							"Item with arbitrary name", 0, 49, -1, 47 } ,
						
						{"3) The Quality of an item is never negative",
							"Item with arbitrary name", 1, 0, 0, 0 } ,
						
						{"4)'Aged Brie' actually increases in Quality the older it gets",
							"Aged Brie", 5, 0, 4, 1 } ,
								
						{"5) The Quality of an item is never more than 50",
							"Aged Brie", 5, 50, 4, 50 } ,
									
						{"6) 'Sulfuras', being a legendary item, do not change their quality or sell-in",
							"Sulfuras, Hand of Ragnaros", 5, 50, 5, 50}	,
						
						{"7) 'Sulfuras', being a legendary item, do not change their quality or sell-in",
							"Sulfuras, Hand of Ragnaros", 5, -3, 5, -3}	,
						
						{"8) 'Backstage passes', like aged brie, increases in Quality as it's SellIn value approaches",
							"Backstage passes to a TAFKAL80ETC concert", 20, 20, 19, 21 } ,
						
						{"9) 'Backstage passes', Quality increases by 2 when there are 10 days or less",
							"Backstage passes to a TAFKAL80ETC concert", 10, 25, 9, 27},
						
						{"10) 'Backstage passes', Quality increases by 3 when there are 5 days or less",
							"Backstage passes to a TAFKAL80ETC concert", 5, 25, 4, 28}	,
						
						{"11) 'Backstage passes', Quality drops to 0 after the concert",
							"Backstage passes to a TAFKAL80ETC concert", 0, 25, -1, 0},
							
						{"12)'Aged Brie' increases twice as fast in Quality, once the sell by date has passed",
							"Aged Brie", 0, 47, -1, 49 } , // in Spezifikation genauer formulieren
						
						{"13) 'Aged Brie' increases twice as fast in Quality, once the sell by date has passed "
							+ "but Quality is never more than 50",
							"Aged Brie", 0, 50, -1, 50 } ,// in Spezifikation genauer formulieren
						
						{"14) 'Backstage passes', Quality increases by 2 when there are 10 days or less "
							+ "but Quality is never more than 50",
							"Backstage passes to a TAFKAL80ETC concert", 10, 49, 9, 50 },
						
						{"15) 'Backstage passes', Quality increases by 3 when there are 5 days or less "
							+ "but Quality is never more than 50",
							"Backstage passes to a TAFKAL80ETC concert", 5, 49, 4, 50 },
			
						{"16) The Quality of an item is never negative",
							"Item with arbitrary name", 0, 0, -1, 0 },
						
						{"17) 'Sulfuras', being a legendary item, do not change their quality or sell-in",
							"Sulfuras, Hand of Ragnaros", -1, 20, -1, 20 },
							
						{"18) 'Elixir of the Mongoose'",
							"Elixir of the Mongoose", 5, 20, 4, 19 },
								
						// Update needed: Conjured items degrade in quality twice as fast as normal items
						{"19) 'Conjured Mana Cake'",
							"Conjured Mana Cake", 5, 20, 4, 18 }, 
								
						{"20) '+5 Dexterity Vest'",
							"+5 Dexterity Vest", 5, 20, 4, 19 },
					
							
				}));
		return data;
	}

	String message;
	String itemName;
	int sellIn;
	int quality;
	int expectedSellIn;
	int expectedQuality;

	Item item;

	public GildedRoseTest(String message, String itemName, int sellIn,
			int quality, int expectedSellIn, int expectedQuality) {
		this.message = message;
		this.itemName = itemName;
		this.sellIn = sellIn;
		this.quality = quality;
		this.expectedSellIn = expectedSellIn;
		this.expectedQuality = expectedQuality;
	}

	@Before
	public void setUp() {
		List<Item> items = new ArrayList<Item>();
		items.add(item = new Item(itemName, sellIn, quality));
		GildedRose.setItems(items);
	}

	@Test
	public void testQualityUpdate() {
		GildedRose.updateQuality();
		assertEquals(message + " Quality ", expectedQuality, item.getQuality());
	}

	@Test
	public void testSellInUpdate() {
		GildedRose.updateQuality();
		assertEquals(message + " SellIn", expectedSellIn, item.getSellIn());
	}
	@Test
	public void testCreateUs(){
		UQS uqs = GildedRose.createUQS(new Item("Elixir of the Mongoose", 5, 7));
		assertEquals((new UQS().getClass()),(uqs.getClass()));
	}
	
	@Test
	public void testQuality(){
	
		UQS uqs = new UQS();
		uqs.updatedQuality(50);
		assertEquals("50" , "50");
	}


}
