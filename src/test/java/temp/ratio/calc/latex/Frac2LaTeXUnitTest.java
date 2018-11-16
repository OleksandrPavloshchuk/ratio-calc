package temp.ratio.calc.latex;

import static junit.framework.Assert.assertEquals;
import org.junit.Test;

import static temp.ratio.calc.builder.FracBuilder.build;

public class Frac2LaTeXUnitTest {

    @Test
    public void integers() {
        StringBuilder sb = new StringBuilder();
        new Frac2LaTeX( build(-9)).render(sb);
        assertEquals("-9", sb.toString());
        sb.setLength(0);
        new Frac2LaTeX( build(16,1)).render(sb);
        assertEquals("16", sb.toString());
        sb.setLength(0);
        new Frac2LaTeX( build(6,-1)).render(sb);
        assertEquals("-6", sb.toString());
    }

    @Test
    public void usual() {
        StringBuilder sb = new StringBuilder();
        new Frac2LaTeX( build(-15, 8)).render(sb);
        assertEquals("-\\frac{15}{8}", sb.toString());
        sb.setLength(0);
        new Frac2LaTeX( build(7,98)).render(sb);
        assertEquals("\\frac{1}{14}", sb.toString());
    }

}
