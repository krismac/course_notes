package music_shop;

public class MusicBook extends StockItem {
    String title;

    public MusicBook(String title, int buyPrice, int sellPrice) {
        super(buyPrice, sellPrice);
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }
    public int calculateMarkup() {
        return this.sellPrice - this.buyPrice;
    }

}
