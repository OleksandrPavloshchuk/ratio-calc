package temp.ratio.calc;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Nom {

    private final Map<String, Double> units = new HashMap<>();

    public Nom() {

    }

    public Nom(Nom src) {
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

    public void append(String letter, double order) {
        if (null == letter || 0 == order) {
            return;
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
    }

    public Nom merge(Nom n) {
        final Nom r = new Nom();
        n.units.forEach((k, v) -> r.append(k, v));
        this.units.forEach((k, v) -> r.append(k, v));
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
        final Nom other = (Nom) obj;
        return Objects.equals(units, other.units);
    }

    @Override
    public String toString() {
        return String.valueOf(units);
    }

}
