package temp.ratio.calc;

import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

public class PolynomUnit implements Comparable<PolynomUnit> {

    private final Map<String, Frac> units = new TreeMap<>();

    public PolynomUnit() {
    }

    public PolynomUnit(String letter) {
        this(letter, 1);
    }

    public PolynomUnit(String letter, int n) {
        this(letter, n, 1);
    }

    public PolynomUnit(String letter, int n, int d) {
        this(letter, new Frac(n, d));
    }

    public PolynomUnit(String letter, Frac order) {
        append(letter, order);
    }

    public PolynomUnit(PolynomUnit src) {
        units.putAll(src.units);
    }

    public Collection<String> getLetters() {
        return units.keySet();
    }

    public Frac getOrder(String letter) {
        if (!units.containsKey(letter)) {
            return Frac.ZERO;
        }
        return units.get(letter);
    }

    public final PolynomUnit append(String letter) {
        return append(letter, 1);
    }

    public final PolynomUnit append(String letter, int n) {
        return append(letter, n, 1);
    }

    public final PolynomUnit append(String letter, int n, int d) {
        return append(letter, new Frac(n, d));
    }

    public final PolynomUnit append(String letter, Frac order) {
        if (null == letter || Frac.ZERO.equals(order)) {
            return this;
        }
        if (!units.containsKey(letter)) {
            units.put(letter, order);
        } else {
            Frac o = units.get(letter);
            o = o.add(order);
            if (Frac.ZERO.equals(o)) {
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

    public Frac getOrder() {
        return units.values().stream().reduce(new Frac(0), (f1, f2) -> f1.add(f2));
    }

    public PolynomUnit getComplementToNegative() {
        final PolynomUnit r = new PolynomUnit();
        units.forEach((l, o) -> {
            if (o.n() < 0) {
                r.append(l, -o.n(), o.d());
            }
        });
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
        final PolynomUnit other = (PolynomUnit) obj;
        return Objects.equals(units, other.units);
    }

    @Override
    public String toString() {
        return String.valueOf(units);
    }

    @Override
    public int compareTo(PolynomUnit o) {
        int r = getOrder().compareTo(o.getOrder());
        if (0 != r) {
            return -r;
        }
        return getSignature().compareTo(o.getSignature());
    }

    private String getSignature() {
        final StringBuilder sb = new StringBuilder();
        units.forEach((k, v) -> sb.append(k).append(v));
        return sb.toString();
    }

}
