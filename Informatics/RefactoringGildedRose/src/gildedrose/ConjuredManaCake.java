package gildedrose;

public class ConjuredManaCake extends UQS{
	
	@ Override
	public Item updateQualitiy(Item item) {
		
			item.setQuality(checkQuality(item.getQuality() - 2));
			return item;
	}
}
