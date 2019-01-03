package ThemePark.Interfaces;

import ThemePark.Visitors.Visitor;

public interface ITicketed {
    public double defaultPrice() ;
    public double priceFor(Visitor visitor) ;
}
