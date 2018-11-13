package temp.ratio.calc;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Polynom {

    private final Map<Nom, Double> noms = new HashMap<>();

    public Collection<Nom> getNoms() {
        return noms.keySet();
    }

    public Double getValue(Nom n) {
        if (!noms.containsKey(n)) {
            return 0.0;
        }
        return noms.get(n);
    }

    public void add(Nom n, double value) {
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
    }

    public Polynom mul(Nom n, Double value) {
        final Polynom r = new Polynom();
        if (0 == value) {
            noms.clear();
            return r;
        }
        noms.forEach((k, v) -> {
            final Nom newKey = k.merge(n);
            r.noms.put(k, Util.adjust(value * v));
        });
        return r;
    }

}
