package temp.ratio.calc.builder;

import temp.ratio.calc.*;
import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

public final class PolynomUnitBuilder {

    private PolynomUnitBuilder() {

    }

    public static temp.ratio.calc.PolynomUnit build() {
        return new PolynomUnit();
    }

    public static temp.ratio.calc.PolynomUnit build(String letter) {
        return build().append(letter);
    }

    public static temp.ratio.calc.PolynomUnit build(String letter, int n) {
        return build().append(letter, n);
    }

    public static temp.ratio.calc.PolynomUnit build(String letter, int n, int d) {
        return build().append(letter, n, d);
    }

    public static temp.ratio.calc.PolynomUnit build(String letter, Frac order) {
        return build().append(letter, order);
    }

    private static final class PolynomUnit implements temp.ratio.calc.PolynomUnit {

        private final Map<String, Frac> units = new TreeMap<>();

        @Override
        public Collection<String> getLetters() {
            return units.keySet();
        }

        @Override
        public Frac getOrder(String letter) {
            if (!units.containsKey(letter)) {
                return FracBuilder.build(0);
            }
            return units.get(letter);
        }

        @Override
        public temp.ratio.calc.PolynomUnit getComplementToNegative() {
            final temp.ratio.calc.PolynomUnit r = new PolynomUnit();
            units.forEach((l, o) -> {
                if (o.n() < 0) {
                    r.append(l, -o.n(), o.d());
                }
            });
            return r;
        }

        @Override
        public int compareTo(temp.ratio.calc.PolynomUnit o) {
            int r = getOrder().compareTo(o.getOrder());
            if (0 != r) {
                return -r;
            }
            return toString().compareTo(o.toString());
        }

        @Override
        public temp.ratio.calc.PolynomUnit append(String letter, Frac order) {
            units.compute(letter, (l, o) -> o == null ? order : o.add(order));
            return this;
        }

        @Override
        public String toString() {
            return String.valueOf(units);
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
    }

}
