package music_shop;

import behaviours.IPlay;
import behaviours.ISell;

public class Guitar extends Instrument implements IPlay, ISell {
    private String model;
    private int numberOfStrings;
    private int costPrice;
    private int retailPrice;

    public Guitar(String model, String colour, int numberOfStrings, int costPrice, int retailPrice) {
        super(colour, "String");
        this.numberOfStrings = numberOfStrings;
        this.model = model;
        this.costPrice = costPrice;
        this.retailPrice = retailPrice;
    }

    public String getModel() {
        return this.model;
    }

    public int getNumberOfStrings() {
        return this.numberOfStrings;
    }

    public int getCostPrice() {
        return this.costPrice;
    }

    public int getRetailPrice() {
        return this.retailPrice;
    }

    public String play() {
        return "Kerrang!!!";
    }

    public int calculateMarkup() {
        return this.retailPrice - this.costPrice;
    }

}
