package ThemePark.Attractions;

import ThemePark.Interfaces.ITicketed;
import ThemePark.Visitors.Visitor;

public class Dodgems extends Attraction implements ITicketed {

    @Override
    public double defaultPrice() {
        return 4.50;
    }

    @Override
    public double priceFor(Visitor visitor) {
        boolean shouldBeHalfPrice = (visitor.getAge() <= 12);
        return defaultPrice() * (shouldBeHalfPrice ? 1 : 0.5);
    }

    public Dodgems(String name, int funRating) {
        super(name, funRating);
    }
}