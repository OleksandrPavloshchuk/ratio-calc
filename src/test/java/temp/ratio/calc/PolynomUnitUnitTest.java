package temp.ratio.calc;

import static junit.framework.Assert.*;
import org.junit.Test;

public class PolynomUnitUnitTest {

    @Test
    public void addZeroOrder() {
        final PolynomUnit actual = new PolynomUnit("a", 2)
                .append("a", 0)
                .append("b", 3)
                .append("c", 0);

        final PolynomUnit expected = new PolynomUnit("a", 2)
                .append("b", 3);

        assertEquals(expected, actual);
    }

    @Test
    public void add() {
        final PolynomUnit actual = new PolynomUnit("a", 7, 5)
                .append("a", 43, 10)
                .append("c", 2)
                .append("b", -33, 10)
                .append("b", 2);

        final PolynomUnit expected = new PolynomUnit("a", 57, 10)
                .append("b", -13, 10)
                .append("c", 2);

        assertEquals(expected, actual);
    }

    @Test
    public void zeroResult() {
        final PolynomUnit actual = new PolynomUnit("A", -32, 10)
                .append("A", 1, 5)
                .append("A", 3);

        PolynomUnit expected = new PolynomUnit();

        assertEquals(expected, actual);
    }

    @Test
    public void merge() {
        final PolynomUnit n1 = new PolynomUnit("a", -4)
                .append("b", 2);

        final PolynomUnit n2 = new PolynomUnit("b", 3)
                .append("c", 1, 2);

        PolynomUnit actual = n1.merge(n2);

        PolynomUnit expected = new PolynomUnit("a", -4)
                .append("b", 5)
                .append("c", 1, 2);

        assertEquals(expected, actual);
    }

}
