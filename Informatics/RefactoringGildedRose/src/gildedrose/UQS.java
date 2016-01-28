package gildedrose;

public class UQS {
	
	public Item updateItem(Item item){
		
		item = updateSellIn(item);
		item = updateQualitiy(item);
		return item;
	}

	public int updatedQuality(int quality) {
		
		return checkQuality(quality);
	}

	public int checkQuality(int quality) {
		
		if (quality > 50) {
			quality = 50;
			
		} else if (quality < 0) {
			quality = 0;
		}
		return quality;
	}
	
	// Quality decreases by 1, if the sell by date has passed, it decreases twice as fast
	public Item updateQualitiy(Item item) {
		
		int quality = item.getQuality();
		
		if( item.getSellIn() < 0){
			item.setQuality(checkQuality(quality - 2));
			return item;
			
		}else{
			item.setQuality(checkQuality(quality - 1));
			return item;
		}
	}

	
	public Item updateSellIn(Item item){
		
		item.setSellIn(item.getSellIn()-1);
		
		return item;
	}
}
