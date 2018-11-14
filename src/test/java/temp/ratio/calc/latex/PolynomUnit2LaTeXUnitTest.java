package temp.ratio.calc.latex;

import junit.framework.Assert;
import org.junit.Test;
import temp.ratio.calc.PolynomUnit;

public class PolynomUnit2LaTeXUnitTest {

    @Test
    public void simple() {
        StringBuilder sb = new StringBuilder();
        new PolynomUnit2LaTeX(new PolynomUnit().append("a", 1)).render(sb);

        Assert.assertEquals("{a}", sb.toString());
    }

    @Test
    public void test1() {
        StringBuilder sb = new StringBuilder();
        new PolynomUnit2LaTeX(new PolynomUnit()
                .append("a", 2)
                .append("c", -2.5)
                .append("b", 1)).render(sb);

        Assert.assertEquals("{a}^{2}{b}{c}^{-2.5}", sb.toString());
    }

}
