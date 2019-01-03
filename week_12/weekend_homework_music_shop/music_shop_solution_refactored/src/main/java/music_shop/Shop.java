package music_shop;


import behaviours.ISell;

import java.util.ArrayList;

public class Shop {
    private String name;
    private ArrayList<ISell> stock;
    private int cash;

    public Shop(String name, int cash) {
        this.name = name;
        this.cash = cash;
        this.stock = new ArrayList<ISell>();
    }

    public String getName() {
        return this.name;
    }

    public int getCash() {
        return cash;
    }

    public int stockCount() {
        return this.stock.size();
    }

    public void addToStock(ISell item) {
        this.stock.add(item);
    }

    public void removeFromStock(ISell item) {
        this.stock.remove(item);
    }
}
