package temp.ratio.calc;

import static junit.framework.Assert.*;
import org.junit.Test;

public class NomUnitTest {

    @Test
    public void addZeroOrder() {
        final Nom actual = new Nom("a", 2)
                .append("a", 0)
                .append("b", 3)
                .append("c", 0);

        final Nom expected = new Nom("a", 2)
                .append("b", 3);

        assertEquals(expected, actual);
    }

    @Test
    public void add() {
        final Nom actual = new Nom()
                .append("a", 1.4)
                .append("a", 4.3)
                .append("c", 2)
                .append("b", -3.3)
                .append("b", 2);

        final Nom expected = new Nom()
                .append("a", 5.7)
                .append("b", -1.3)
                .append("c", 2);

        assertEquals(expected, actual);
    }

    @Test
    public void zeroResult() {
        final Nom actual = new Nom()
                .append("A", -3.2)
                .append("A", 0.2)
                .append("A", 3);

        Nom expected = new Nom();

        assertEquals(expected, actual);
    }

    @Test
    public void merge() {
        final Nom n1 = new Nom("a", -4)
                .append("b", 2);

        final Nom n2 = new Nom("b", 3)
                .append("c", 0.5);

        Nom actual = n1.merge(n2);

        Nom expected = new Nom()
                .append("a", -4)
                .append("b", 5)
                .append("c", 0.5);

        assertEquals(expected, actual);
    }

}
