package temp.ratio.calc;

import junit.framework.Assert;
import org.junit.Test;

public class PolynomUnitTest {

    @Test
    public void mul1() {
        final Nom a = new Nom();
        a.append("a", 1);
        final Nom b = new Nom();
        b.append("b", 1);

        final Polynom p1 = new Polynom();
        p1.add(a, 1);
        p1.add(b, 1);

        final Polynom p2 = new Polynom();
        p2.add(a, 1);
        p2.add(b, -1);

        final Polynom actual = Polynom.mul(p1, p2);

        final Nom a2 = new Nom();
        a2.append("a", 2);
        final Nom b2 = new Nom();
        b2.append("b", 2);

        final Polynom expected = new Polynom();
        expected.add(b2, -1);
        expected.add(a2, 1);

        Assert.assertEquals(expected, actual);

        
    }

    @Test
    public void mul2() {
        final Nom a = new Nom();
        a.append("a", 1);
        final Nom b = new Nom();
        b.append("b", 1);
        final Nom c = new Nom();
        c.append("c", 1);

        final Polynom p = new Polynom();
        p.add(a, 1);
        p.add(b, 1);
        p.add(c, 1);

        Polynom actual = Polynom.mul(p, p);

        final Nom a2 = new Nom();
        a2.append("a", 2);
        final Nom b2 = new Nom();
        b2.append("b", 2);
        final Nom c2 = new Nom();
        c2.append("c", 2);

        final Nom ab = new Nom();
        ab.append("a", 1);
        ab.append("b", 1);

        final Nom bc = new Nom();
        bc.append("b", 1);
        bc.append("c", 1);

        final Nom ac = new Nom();
        ac.append("a", 1);
        ac.append("c", 1);

        final Polynom expected = new Polynom();
        expected.add(a2, 1);
        expected.add(b2, 1);
        expected.add(c2, 1);
        expected.add(ab, 2);
        expected.add(bc, 2);
        expected.add(ac, 2);


        Assert.assertEquals(expected, actual);


    }
    
}
