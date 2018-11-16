package temp.ratio.calc;

import static junit.framework.Assert.*;
import org.junit.Test;
import static temp.ratio.calc.builder.PolynomUnitBuilder.build;

public class PolynomUnitUnitTest {

    @Test
    public void addZeroOrder() {
        final PolynomUnit actual = build("a", 2)
            .append("a", 0)
            .append("b", 3)
            .append("c", 0);

        final PolynomUnit expected = build("a", 2)
            .append("b", 3);

        assertEquals(expected, actual);
    }

    @Test
    public void add() {
        final PolynomUnit actual = build("a", 7, 5)
            .append("a", 43, 10)
            .append("c", 2)
            .append("b", -33, 10)
            .append("b", 2);

        final PolynomUnit expected = build("a", 57, 10)
            .append("b", -13, 10)
            .append("c", 2);

        assertEquals(expected, actual);
    }

    @Test
    public void zeroResult() {
        final PolynomUnit actual = build("A", -32, 10)
            .append("A", 1, 5)
            .append("A", 3);

        PolynomUnit expected = build();

        assertEquals(expected, actual);
    }

    @Test
    public void merge() {
        final PolynomUnit n1 = build("a", -4)
            .append("b", 2);

        final PolynomUnit n2 = build("b", 3)
            .append("c", 1, 2);

        PolynomUnit actual = build().append(n1).append(n2);

        PolynomUnit expected = build("a", -4)
            .append("b", 5)
            .append("c", 1, 2);

        assertEquals(expected, actual);
    }

    @Test
    public void complementToNegative() {
        assertEquals(
            build("c", 1)
                .append("a", 2, 3),
            build("a", -2, 3)
                .append("b")
                .append("c", -1).getComplementToNegative());
    }

}
