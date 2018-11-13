package temp.ratio.calc.latex;

import junit.framework.Assert;
import org.junit.Test;
import temp.ratio.calc.Nom;

public class Nom2LaTeXUnitTest {

    @Test
    public void simple() {
        Nom n = new Nom();
        n.append("a", 1);
        StringBuilder sb = new StringBuilder();
        new Nom2LaTeX(n).render(sb);

        Assert.assertEquals("{a}", sb.toString());
    }

    @Test
    public void test1() {
        Nom n = new Nom();
        n.append("a", 2);
        n.append("c", -2.5);
        n.append("b", 1);
        StringBuilder sb = new StringBuilder();
        new Nom2LaTeX(n).render(sb);

        Assert.assertEquals("{a}^{2}{b}{c}^{-2.5}", sb.toString());
    }

    
}
