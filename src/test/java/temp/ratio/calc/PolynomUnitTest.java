package temp.ratio.calc;

import junit.framework.Assert;
import org.junit.Test;

public class PolynomUnitTest {

    @Test
    public void mul1() {
        final PolynomUnit a = new PolynomUnit("a");
        final PolynomUnit b = new PolynomUnit("b");

        final Polynom p1 = new Polynom()
                .add(a, 1)
                .add(b, 1);

        final Polynom p2 = new Polynom()
                .add(a, 1)
                .add(b, -1);

        final Polynom actual = Polynom.mul(p1, p2);

        final Polynom expected = new Polynom()
                .add(new PolynomUnit("b", 2), -1)
                .add(new PolynomUnit("a", 2), 1);

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void mul2() {
        final Polynom p = new Polynom()
                .add(new PolynomUnit("a"), 1)
                .add(new PolynomUnit("b"), 1)
                .add(new PolynomUnit("c"), 1);

        Polynom actual = Polynom.mul(p, p);

        final PolynomUnit ab = new PolynomUnit("a").append("b", 1);
        final PolynomUnit bc = new PolynomUnit("b").append("c", 1);
        final PolynomUnit ac = new PolynomUnit("c").append("a", 1);

        final Polynom expected = new Polynom()
                .add(new PolynomUnit("a", 2), 1)
                .add(new PolynomUnit("b", 2), 1)
                .add(new PolynomUnit("c", 2), 1)
                .add(ab, 2)
                .add(bc, 2)
                .add(ac, 2);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void mul3() {
        final Polynom p1 = new Polynom()
                .add(new PolynomUnit("a"), 1)
                .add(new PolynomUnit("b"), -1);

        final PolynomUnit ab = new PolynomUnit("a").append("b", 1);

        final Polynom p2 = new Polynom()
                .add(new PolynomUnit("a", 2), 1)
                .add(new PolynomUnit("b", 2), 1)
                .add(ab, 1);

        final Polynom actual = Polynom.mul(p1, p2);

        final Polynom expected = new Polynom()
                .add(new PolynomUnit("a", 3), 1)
                .add(new PolynomUnit("b", 3), -1);

        Assert.assertEquals(expected, actual);

    }

}
