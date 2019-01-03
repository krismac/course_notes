package music_shop;

public class MusicStand extends StockItem {

    private String colour;

    public MusicStand(String colour, int buyPrice, int sellPrice) {
        super(buyPrice, sellPrice);
        this.colour = colour;
    }

    public String getColour() {
        return this.colour;
    }

    public int calculateMarkup() {
        return this.sellPrice - this.buyPrice;
    }
}
