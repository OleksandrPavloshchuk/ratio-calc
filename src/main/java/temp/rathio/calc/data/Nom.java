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
        return units.get(letter);
    }

    public void add(String letter, double order) {
        if (null == letter || 0 == order) {
            return;
        }
        double newOrder = units.computeIfAbsent(letter, l -> 0.0);
        newOrder += order;
        newOrder = Math.round(newOrder*100.0) / 100.0;
        if( 0==newOrder) {
            units.remove(letter);
        } else {
            units.put(letter, newOrder);
        }
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
