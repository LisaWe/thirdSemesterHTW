package gildedrose;

public class AgedBrie extends UQS {

	@Override
	public Item updateQualitiy(Item item) {
		
		int quality = checkQuality(item.getQuality());
		
		if( item.getSellIn() < 0){
		item.setQuality(checkQuality(quality + 2));
		return item;
		
		}else{
			item.setQuality(checkQuality(quality + 1));
			return item;
		}
	}
}
