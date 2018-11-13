package temp.ratio.calc;

import junit.framework.Assert;
import org.junit.Test;

public class PolynomUnitTest {

    @Test
    public void mul1() {
        final Nom a = new Nom("a");
        final Nom b = new Nom("b");

        final Polynom p1 = new Polynom()
                .add(a, 1)
                .add(b, 1);

        final Polynom p2 = new Polynom()
                .add(a, 1)
                .add(b, -1);

        final Polynom actual = Polynom.mul(p1, p2);

        final Polynom expected = new Polynom()
                .add(new Nom("b", 2), -1)
                .add(new Nom("a", 2), 1);

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void mul2() {
        final Polynom p = new Polynom()
                .add(new Nom("a"), 1)
                .add(new Nom("b"), 1)
                .add(new Nom("c"), 1);

        Polynom actual = Polynom.mul(p, p);

        final Nom ab = new Nom("a").append("b", 1);
        final Nom bc = new Nom("b").append("c", 1);
        final Nom ac = new Nom("c").append("a", 1);

        final Polynom expected = new Polynom()
                .add(new Nom("a", 2), 1)
                .add(new Nom("b", 2), 1)
                .add(new Nom("c", 2), 1)
                .add(ab, 2)
                .add(bc, 2)
                .add(ac, 2);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void mul3() {
        final Polynom p1 = new Polynom()
                .add(new Nom("a"), 1)
                .add(new Nom("b"), -1);

        final Nom ab = new Nom("a").append("b", 1);

        final Polynom p2 = new Polynom()
                .add(new Nom("a", 2), 1)
                .add(new Nom("b", 2), 1)
                .add(ab, 1);

        final Polynom actual = Polynom.mul(p1, p2);

        final Polynom expected = new Polynom()
                .add(new Nom("a", 3), 1)
                .add(new Nom("b", 3), -1);

        Assert.assertEquals(expected, actual);

    }

}
