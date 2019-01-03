package ThemePark.Stalls;

import ThemePark.Visitors.Visitor;

public class IceCreamStall extends Stall {
    @Override
    public double defaultPrice() {
        return 4.10;
    }

    @Override
    public double priceFor(Visitor visitor){
        return defaultPrice();
    }

    public IceCreamStall(String name, String ownerName, int partingSpot, int funRating)   {
        super(name, ownerName, partingSpot, funRating);
    }
}
