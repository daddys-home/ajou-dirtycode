package ac.kr.ajou.dirt;

class DirtySample {
    Item[] items;

    public DirtySample(Item[] items) {
        this.items = items;
    }


    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            if (isLowQualiyItem(items[i])) {
                if (items[i].quality > 0){
                    if(!isName(items[i],"Sulfuras, Hand of Ragnaros")) {
                        addQualityNumber(i,-1);
                    }
                }
            }
            else if(items[i].quality < 50){
                updateQualityIsLessThan50(i);
            }
            if (!isName(items[i],"Sulfuras, Hand of Ragnaros")) {
                addSelllnNumber(i, -1);
            }
            if (items[i].sellIn < 0) {
                updateSelllnIsLessThan_0(i);
            }
        }
    }

    private void addSelllnNumber(int i, int num) {
        items[i].sellIn = items[i].sellIn + num;
    }

    private void updateSelllnIsLessThan_0(int num) {
        if (!isName(items[num],"Aged Brie")){
             if(!isName(items[num],"Backstage passes to a TAFKAL80ETC concert")){
                 if (items[num].quality > 0) {
                     if (!items[num].name.equals("Sulfuras, Hand of Ragnaros")) {
                         addQualityNumber(num, -1);
                     }
                 }
            }
             else {
                 items[num].quality = 0;
             }
        }
        else{
                if (items[num].quality < 50) {
                    addQualityNumber(num, 1);
                }
        }
    }

    private void addQualityNumber(int i, int num) {
        items[i].quality = items[i].quality + num;
    }

    public boolean isLowQualiyItem(Item item)
    {
        return !isName(item,"Aged Brie")
                 && !isName(item,"Backstage passes to a TAFKAL80ETC concert");

    }

    private void updateQualityIsLessThan50(int num) {
        addQualityNumber(num,1);

        if (isName(items[num],"Backstage passes to a TAFKAL80ETC concert")) {
            if (items[num].sellIn < 11 && items[num].quality < 50) {
                addQualityNumber(num,1);
            }

            if (items[num].sellIn < 6 && items[num].quality < 50) {
                addQualityNumber(num, 1);
            }
        }
    }

    private boolean isName(Item item, String name) {
        return item.name.equals(name);
    }
}