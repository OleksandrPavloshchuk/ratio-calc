package temp.ratio.calc;

import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

public class PolynomUnit {

    private final Map<String, Double> units = new TreeMap<>();

    public PolynomUnit() {

    }

    public PolynomUnit(String letter) {
        this(letter, 1);
    }

    public PolynomUnit(String letter, double order) {
        append(letter, order);
    }

    public PolynomUnit(PolynomUnit src) {
        units.putAll(src.units);
    }

    public Collection<String> getLetters() {
        return units.keySet();
    }

    public Double getOrder(String letter) {
        if (!units.containsKey(letter)) {
            return 0.0;
        }
        return units.get(letter);
    }

    public final PolynomUnit append(String letter, double order) {
        if (null == letter || 0 == order) {
            return this;
        }
        if (!units.containsKey(letter)) {
            units.put(letter, order);
        } else {
            double o = units.get(letter);
            o += order;
            o = Util.adjust(o);
            if (0 == o) {
                units.remove(letter);
            } else {
                units.put(letter, o);
            }
        }
        return this;
    }

    public PolynomUnit merge(PolynomUnit n) {
        final PolynomUnit r = new PolynomUnit();
        n.units.forEach((k, v) -> r.append(k, v));
        this.units.forEach((k, v) -> r.append(k, v));
        return r;
    }

    public boolean isEmpty() {
        return units.isEmpty();
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
        final PolynomUnit other = (PolynomUnit) obj;
        return Objects.equals(units, other.units);
    }

    @Override
    public String toString() {
        return String.valueOf(units);
    }

}
