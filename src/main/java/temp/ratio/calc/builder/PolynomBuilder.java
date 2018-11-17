package temp.ratio.calc.builder;

import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;
import temp.ratio.calc.PolynomUnit;
import temp.ratio.calc.Util;

public final class PolynomBuilder {

    private PolynomBuilder() {

    }

    public static temp.ratio.calc.Polynom build() {
        return new Polynom();
    }

    private static class Polynom implements temp.ratio.calc.Polynom {

        private final Map<PolynomUnit, Double> units = new TreeMap<>();

        private Polynom() {

        }

        @Override
        public Collection<PolynomUnit> getUnits() {
            return units.keySet();
        }

        @Override
        public double getValue(PolynomUnit n) {
            if (!units.containsKey(n)) {
                return 0.0;
            }
            return units.get(n);
        }

        @Override
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

        @Override
        public temp.ratio.calc.Polynom mul(PolynomUnit n, double value) {
            final Polynom r = new Polynom();
            if (0 == value) {
                units.clear();
                return r;
            }
            units.forEach((k, v) -> {
                PolynomUnit newKey = PolynomUnitBuilder.build().append(k).append(n);
                r.units.put(newKey, Util.adjust(value * v));
            });
            return r;
        }

        @Override
        public temp.ratio.calc.Polynom mul(temp.ratio.calc.Polynom p) {
            final Polynom r = new Polynom();
            this.units.forEach((n, v) -> r.add(p.mul(n, v)));
            return r;
        }

        @Override
        public temp.ratio.calc.Polynom[] getComplementToNegative() {
            final temp.ratio.calc.Polynom[] r = new Polynom[2];
            r[0] = new Polynom();
            r[0].add(this);
            r[1] = new Polynom();

            PolynomUnit ucTotal = PolynomUnitBuilder.build();
            for (final PolynomUnit u : units.keySet()) {
                final PolynomUnit uc = u.getComplementToNegative();
                ucTotal = ucTotal.append(uc);
                r[0] = r[0].mul(uc, 1d);
            }
            r[1].add(ucTotal, 1);
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

}
