package temp.ratio.calc.latex;

import junit.framework.Assert;
import org.junit.Test;
import temp.ratio.calc.PolynomUnit;
import temp.ratio.calc.Polynom;

public class Polynom2LaTeXUnitTest {

    @Test
    public void simple() {
        StringBuilder sb = new StringBuilder();
        new Polynom2LaTeX(new Polynom()
                .add(new PolynomUnit("a").append("b", 2), 1)
                .add(new PolynomUnit("b").append("a", 2), -1)).render(sb);

        Assert.assertEquals("{a}{b}^{2}-{a}^{2}{b}", sb.toString());
    }

    @Test
    public void newtonFormula() {
        Polynom p = p();
        for (int i = 1; i < 4; i++) {
            p = Polynom.mul(p, p());
        }
        StringBuilder sb = new StringBuilder();
        new Polynom2LaTeX(p).render(sb);

        Assert.assertEquals("-4{a}{b}^{3}+6{a}^{2}{b}^{2}-4{a}^{3}{b}+{a}^{4}+{b}^{4}", sb.toString());
    }

    @Test
    public void order2() {
        Polynom p1 = new Polynom()
            .add( new PolynomUnit(), -3)
            .add( new PolynomUnit("x"), 1);
        Polynom p2 = new Polynom()
            .add( new PolynomUnit(), -1)
            .add( new PolynomUnit("x"), 1);

        Polynom p = Polynom.mul(p2, p1);

        StringBuilder sb = new StringBuilder();
        new Polynom2LaTeX(p).render(sb);
        
        Assert.assertEquals("{x}^{2}-4{x}+3", sb.toString());
    }

    static Polynom p() {
        return new Polynom()
                .add(new PolynomUnit("a"), 1)
                .add(new PolynomUnit("b"), -1);
    }

}
