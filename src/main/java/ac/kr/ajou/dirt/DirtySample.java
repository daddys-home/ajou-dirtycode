package ac.kr.ajou.dirt;

class DirtySample {
    private Item[] items;

    public DirtySample(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            if (!isName(items[i], "Sulfuras, Hand of Ragnaros")) {
                if (isAgedBrieOrBackstagePasses(items[i])) {
                    isItemQualityLessThan50(i);
                } else if (items[i].quality > 0) addIntegerToQuality(i, -1);

                items[i].sellIn--;
                isItemSellInNegative(i);
            }
        }
    }

    private void isItemQualityLessThan50(int index) {
        if (items[index].quality < 50) {
            addIntegerToQuality(index,1);
            if (isName(items[index], "Backstage passes to a TAFKAL80ETC concert")
                    && items[index].sellIn < 11 && items[index].quality < 50) {
                addIntegerToQuality(index, 1);
                if (items[index].sellIn < 6 && items[index].quality < 50)
                    addIntegerToQuality(index, 1);
            }
        }
    }


    public void isItemSellInNegative(int index) {
        if (items[index].sellIn < 0) {
            if (isName(items[index], "Aged Brie") && items[index].quality < 50) {
                addIntegerToQuality(index,1);
            } else if (isName(items[index], "Backstage passes to a TAFKAL80ETC concert"))
                items[index].quality = 0;
            else if (!isAgedBrieOrBackstagePasses(items[index]) && items[index].quality > 0)
                addIntegerToQuality(index, -1);
        }
    }

    public void addIntegerToQuality(int index, int integerToAdd) {
        items[index].quality += integerToAdd;
    }

    public boolean isName(Item item, String s) {
        return item.name.equals(s);
    }

    public boolean isAgedBrieOrBackstagePasses(Item item) {
        return isName(item, "Aged Brie")
                || isName(item, "Backstage passes to a TAFKAL80ETC concert");
    }


}