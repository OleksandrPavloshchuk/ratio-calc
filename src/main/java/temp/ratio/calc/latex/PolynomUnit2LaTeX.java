package temp.ratio.calc.latex;

import temp.ratio.calc.Frac;
import temp.ratio.calc.PolynomUnit;

public class PolynomUnit2LaTeX {

    private final PolynomUnit nom;

    public PolynomUnit2LaTeX(PolynomUnit nom) {
        this.nom = nom;
    }

    public void render(StringBuilder sb) {
        nom.getLetters().forEach(l -> {
            final Frac order = nom.getOrder(l);
            sb.append('{').append(l).append('}');
            if (!order.is1()) {
                sb.append("^{");
                new Frac2LaTeX(order).render(sb);
                sb.append('}');
            }
        });
    }

}
