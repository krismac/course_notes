package ThemePark.Attractions;

import ThemePark.Interfaces.ITicketed;
import ThemePark.Interfaces.ISecurity;
import ThemePark.Visitors.Visitor;

public class Rollercoaster extends Attraction implements ISecurity, ITicketed {
    @Override
    public Boolean isAllowedTo(Visitor visitor) {
        boolean isTallEnough = visitor.getHeightInCm() >= 145;
        boolean isOldEnough = visitor.getAge() >= 12;
        return isTallEnough && isOldEnough;
    }

    @Override
    public double defaultPrice() {
        return 8.40;
    }

    @Override
    public double priceFor(Visitor visitor) {
        boolean shouldBeDoublePrice = (visitor.getHeightInCm() > 200);
        return defaultPrice() * (shouldBeDoublePrice ? 2 : 1);
    }
    public Rollercoaster(String name, int funRating) {
        super(name, funRating);
    }
}
