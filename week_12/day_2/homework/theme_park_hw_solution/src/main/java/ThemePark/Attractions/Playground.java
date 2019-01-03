package ThemePark.Attractions;

import ThemePark.Interfaces.ISecurity;
import ThemePark.Visitors.Visitor;

public class Playground extends Attraction implements ISecurity {

    public Boolean isAllowedTo(Visitor visitor){
        Boolean isYoungEnough = visitor.getAge() <= 15;
        return isYoungEnough;
    }

    public Playground(String name, int funRating) {
        super(name, funRating);
    }
}
