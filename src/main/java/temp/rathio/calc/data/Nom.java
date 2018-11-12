package temp.rathio.calc.data;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Nom {

    private final Map<String, Double> units = new HashMap<>();

    public Collection<String> getLetters() {
        return units.keySet();
    }

    public Double getOrder(String letter) {
        if (!units.containsKey(letter)) {
            return 0.0;
        }
        return units.get(letter);
    }

    public void add(String letter, double order) {
        if (null == letter || 0 == order) {
            return;
        }
        units.compute(letter, (l, o) -> {
            double r = null == o ? 0 : o;
            r += order;
            r = Math.round(r * 100.0) / 100.0;
            return 0 == r ? null : r;
        });
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
