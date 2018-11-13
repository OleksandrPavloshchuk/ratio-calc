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

    @Test
    public void newtonFormula() {
        Polynom p = p();
        for( int i=1; i<4; i++ ) {
            p = Polynom.mul(p, p());
        }
        StringBuilder sb = new StringBuilder();
        new Polynom2LaTeX(p).render(sb);

        Assert.assertEquals("{a}^{4}-4{a}^{3}{b}+6{a}^{2}{b}^{2}-4{a}{b}^{3}+{b}^{4}", sb.toString());
    }

    static Polynom p() {
        Nom a = new Nom();
        a.append("a", 1);

        Nom b = new Nom();
        b.append("b", 1);

        Polynom p = new Polynom();
        p.add(a, 1);
        p.add(b, -1);
        return p;
    }

    
}
