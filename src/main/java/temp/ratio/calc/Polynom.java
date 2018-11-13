package temp.ratio.calc;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class Polynom {

    private final Map<Nom, Double> noms = new LinkedHashMap<>();

    public Collection<Nom> getNoms() {
        return noms.keySet();
    }

    public Double getValue(Nom n) {
        if (!noms.containsKey(n)) {
            return 0.0;
        }
        return noms.get(n);
    }

    public Polynom add(Nom n, double value) {
        if (0 != value) {
            if (!noms.containsKey(n)) {
                noms.put(n, value);
            } else {
                double v = noms.get(n);
                v += value;
                v = Util.adjust(v);
                if (0 == v) {
                    noms.remove(n);
                } else {
                    noms.put(n, v);
                }
            }
        }
        return this;
    }

    public Polynom mul(Nom n, Double value) {
        final Polynom r = new Polynom();
        if (0 == value) {
            noms.clear();
            return r;
        }
        noms.forEach((k, v) -> {
            final Nom newKey = k.merge(n);
            r.noms.put(newKey, Util.adjust(value * v));
        });
        return r;
    }

    public static Polynom add(Polynom p1, Polynom p2) {
        final Polynom r = new Polynom();
        p1.noms.forEach((k, v) -> r.add(k, v));
        p2.noms.forEach((k, v) -> r.add(k, v));
        return r;
    }

    public void add(Polynom p) {
        p.noms.forEach((k, v) -> add(k, v));
    }

    public static Polynom mul(Polynom p1, Polynom p2) {
        final Polynom r = new Polynom();
        p1.noms.forEach((n, v) -> r.add(p2.mul(n, v)));
        return r;
    }

    @Override
    public int hashCode() {
        return Objects.hash(noms);
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
        return Objects.equals(noms, other.noms);
    }

    @Override
    public String toString() {
        return String.valueOf(noms);
    }

}
