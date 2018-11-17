package temp.ratio.calc;

import java.util.Collection;

public interface Polynom {

    Collection<PolynomUnit> getUnits();

    double getValue(PolynomUnit n);

    Polynom add(PolynomUnit n, double value);

    Polynom mul(PolynomUnit n, double value);
    
    Polynom mul(Polynom p);
    
    public Polynom[] getComplementToNegative();

    default Polynom add(Polynom p) {
        p.getUnits().forEach(k -> add(k, p.getValue(k)));
        return this;
    }

}
