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
                .add(new PolynomUnit()
                        .append("a", 1)
                        .append("b", 2), 1)
                .add(new PolynomUnit()
                        .append("b", 1)
                        .append("a", 2), -1)).render(sb);

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

        Assert.assertEquals("{a}^{4}-4{a}^{3}{b}+6{a}^{2}{b}^{2}-4{a}{b}^{3}+{b}^{4}", sb.toString());
    }

    static Polynom p() {
        return new Polynom()
                .add(new PolynomUnit().append("a", 1), 1)
                .add(new PolynomUnit().append("b", 1), -1);
    }

}
