package temp.ratio.calc.latex;

import temp.ratio.calc.Frac;

public class Frac2LaTeX {

    private final Frac f;

    public Frac2LaTeX(Frac f) {
        this.f = f;
    }

    public void render(StringBuilder sb) {
        final int n = f.n();
        final int d = f.d();
        if (1 == d) {
            sb.append(n);
            return;
        }
        int tn = n;
        if (n < 0) {
            sb.append('-');
            tn = -n;
        }
        sb.append("\\frac{").append(tn).append("}{").append(d).append("}");
    }
}
