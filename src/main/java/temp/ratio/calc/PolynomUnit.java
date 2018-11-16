package temp.ratio.calc;

import java.util.Collection;
import temp.ratio.calc.builder.FracBuilder;

public interface PolynomUnit extends Comparable<PolynomUnit> {

    Collection<String> getLetters();

    Frac getOrder(String letter);

    PolynomUnit getComplementToNegative();

    PolynomUnit append(String letter, Frac order);

    default PolynomUnit append(String letter, int n, int d) {
        return append(letter, FracBuilder.build(n, d));
    }

    default PolynomUnit append(String letter, int n) {
        return append(letter, FracBuilder.build(n));
    }

    default PolynomUnit append(String letter) {
        return append(letter, FracBuilder.build(1));
    }

    default boolean isEmpty() {
        return getLetters().isEmpty();
    }

    default Frac getOrder() {
        return getLetters().stream()
            .map(l -> getOrder(l))
            .reduce(FracBuilder.build(0), (f1, f2) -> f1.add(f2));
    }

    default PolynomUnit append(PolynomUnit pu) {
        pu.getLetters().forEach(l -> append(l, pu.getOrder(l)));
        return this;
    }

}
