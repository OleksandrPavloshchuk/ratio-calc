package temp.ratio.calc;

import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

public class Polynom {

    private final Map<PolynomUnit, Double> units = new TreeMap<>();

    public Collection<PolynomUnit> getUnits() {
        return units.keySet();
    }

    public Double getValue(PolynomUnit n) {
        if (!units.containsKey(n)) {
            return 0.0;
        }
        return units.get(n);
    }

    public Polynom add(PolynomUnit n, double value) {
        if (0 != value) {
            if (!units.containsKey(n)) {
                units.put(n, value);
            } else {
                double v = units.get(n);
                v += value;
                v = Util.adjust(v);
                if (0 == v) {
                    units.remove(n);
                } else {
                    units.put(n, v);
                }
            }
        }
        return this;
    }

    public Polynom mul(PolynomUnit n, Double value) {
        final Polynom r = new Polynom();
        if (0 == value) {
            units.clear();
            return r;
        }
        units.forEach((k, v) -> {
            final PolynomUnit newKey = k.merge(n);
            r.units.put(newKey, Util.adjust(value * v));
        });
        return r;
    }

    public static Polynom add(Polynom p1, Polynom p2) {
        final Polynom r = new Polynom();
        p1.units.forEach((k, v) -> r.add(k, v));
        p2.units.forEach((k, v) -> r.add(k, v));
        return r;
    }

    public void add(Polynom p) {
        p.units.forEach((k, v) -> add(k, v));
    }

    public static Polynom mul(Polynom p1, Polynom p2) {
        final Polynom r = new Polynom();
        p1.units.forEach((n, v) -> r.add(p2.mul(n, v)));
        return r;
    }

    @Override
    public int hashCode() {
        return Objects.hash(units);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Polynom other = (Polynom) obj;
        return Objects.equals(units, other.units);
    }

    @Override
    public String toString() {
        return String.valueOf(units);
    }

}
