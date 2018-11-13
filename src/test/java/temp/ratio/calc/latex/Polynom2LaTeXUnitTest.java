package temp.ratio.calc.latex;

import junit.framework.Assert;
import org.junit.Test;
import temp.ratio.calc.Nom;
import temp.ratio.calc.Polynom;

public class Polynom2LaTeXUnitTest {

    @Test
    public void simple() {
        Nom n1 = new Nom();
        n1.append("a", 1);
        n1.append("b", 2);

        Nom n2 = new Nom();
        n2.append("b", 1);
        n2.append("a", 2);

        Polynom p = new Polynom();
        p.add(n1, 1);
        p.add(n2, -1);

        StringBuilder sb = new StringBuilder();
        new Polynom2LaTeX(p).render(sb);

        Assert.assertEquals("{a}{b}^{2}-{a}^{2}{b}", sb.toString());
    }

    
}
