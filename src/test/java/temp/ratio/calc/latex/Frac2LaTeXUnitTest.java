package temp.ratio.calc.latex;

import junit.framework.Assert;
import org.junit.Test;
import temp.ratio.calc.Frac;

public class Frac2LaTeXUnitTest {

    @Test
    public void integers() {
        StringBuilder sb = new StringBuilder();
        new Frac2LaTeX( new Frac(-9)).render(sb);
        Assert.assertEquals("-9", sb.toString());
        sb.setLength(0);
        new Frac2LaTeX( new Frac(16,1)).render(sb);
        Assert.assertEquals("16", sb.toString());
        sb.setLength(0);
        new Frac2LaTeX( new Frac(6,-1)).render(sb);
        Assert.assertEquals("-6", sb.toString());
    }

    @Test
    public void usual() {
        StringBuilder sb = new StringBuilder();
        new Frac2LaTeX( new Frac(-15, 8)).render(sb);
        Assert.assertEquals("-\\frac{15}{8}", sb.toString());
        sb.setLength(0);
        new Frac2LaTeX( new Frac(7,98)).render(sb);
        Assert.assertEquals("\\frac{1}{14}", sb.toString());
    }

}
