package gildedrose;

public class BackstagePasses extends UQS {
	
	@Override
	public Item updateQualitiy(Item item) {
		
		int quality = item.getQuality();
		
		if (item.getSellIn() <= 10 && item.getSellIn() > 5) {
			item.setQuality(checkQuality(quality + 2));
			return item;
			
		} else if (item.getSellIn() <= 5 && item.getSellIn() >= 0) {
			item.setQuality(checkQuality(quality + 3));
			return item;
			
		} else if (item.getSellIn() < 0) {
			item.setQuality(0);
			return item;
			
		} else {
			item.setQuality(checkQuality(quality + 1));
			return item;
		}
	}
}
