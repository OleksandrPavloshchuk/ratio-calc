package temp.ratio.calc;

import static junit.framework.Assert.assertEquals;
import org.junit.Test;
import static temp.ratio.calc.builder.PolynomUnitBuilder.build;

public class PolynomUnitTest {

    @Test
    public void mul1() {
        final PolynomUnit a = build("a");
        final PolynomUnit b = build("b");

        final Polynom p1 = new Polynom()
                .add(a, 1)
                .add(b, 1);

        final Polynom p2 = new Polynom()
                .add(a, 1)
                .add(b, -1);

        final Polynom actual = Polynom.mul(p1, p2);

        final Polynom expected = new Polynom()
                .add(build("b", 2), -1)
                .add(build("a", 2), 1);

        assertEquals(expected, actual);

    }

    @Test
    public void mul2() {
        final Polynom p = new Polynom()
                .add(build("a"), 1)
                .add(build("b"), 1)
                .add(build("c"), 1);

        Polynom actual = Polynom.mul(p, p);

        final PolynomUnit ab = build("a").append("b", 1);
        final PolynomUnit bc = build("b").append("c", 1);
        final PolynomUnit ac = build("c").append("a", 1);

        final Polynom expected = new Polynom()
                .add(build("a", 2), 1)
                .add(build("b", 2), 1)
                .add(build("c", 2), 1)
                .add(ab, 2)
                .add(bc, 2)
                .add(ac, 2);

       assertEquals(expected, actual);
    }

    @Test
    public void mul3() {
        final Polynom p1 = new Polynom()
                .add(build("a"), 1)
                .add(build("b"), -1);

        final PolynomUnit ab = build("a").append("b", 1);

        final Polynom p2 = new Polynom()
                .add(build("a", 2), 1)
                .add(build("b", 2), 1)
                .add(ab, 1);

        final Polynom actual = Polynom.mul(p1, p2);

        final Polynom expected = new Polynom()
                .add(build("a", 3), 1)
                .add(build("b", 3), -1);

        assertEquals(expected, actual);

    }

    @Test
    public void complementToNegative() {
        final Polynom p = new Polynom()
                .add(build("a", -1), 1)
                .add(build("c", -1), 1)
                .add(build("b", -1), 1);
        final Polynom[] c = p.getComplementToNegative();
        assertEquals(new Polynom()
            .add(build("a").append("b"), 1)
            .add(build("b").append("c"), 1)
            .add(build("c").append("a"), 1), c[0]);
        assertEquals(new Polynom()
            .add( build("a").append("b").append("c"), 1), c[1]);
        
    }


}
