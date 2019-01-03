package ThemePark.Stalls;

import ThemePark.Interfaces.ISecurity;
import ThemePark.Visitors.Visitor;

public class TobaccoStall extends Stall implements ISecurity {

    public Boolean isAllowedTo(Visitor visitor){
        Boolean isOldEnough = visitor.getAge() >= 18;
        return isOldEnough;
    }

    @Override
    public double defaultPrice() {
        return 6.20;
    }

    @Override
    public double priceFor(Visitor visitor) {
        return defaultPrice();
    }

    public TobaccoStall(String name, String ownerName, int partingSpot, int funRating)   {
        super(name, ownerName, partingSpot, funRating);
    }
}
