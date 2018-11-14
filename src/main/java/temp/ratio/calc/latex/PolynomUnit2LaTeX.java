package temp.ratio.calc.latex;

import temp.ratio.calc.PolynomUnit;
import temp.ratio.calc.Util;

public class PolynomUnit2LaTeX {

    private final PolynomUnit nom;

    public PolynomUnit2LaTeX(PolynomUnit nom) {
        this.nom = nom;
    }

    public void render(StringBuilder sb) {
        nom.getLetters().forEach(l -> {
            final double order = Util.adjust(nom.getOrder(l));
            sb.append('{').append(l).append('}');
            if (1 != order) {
                sb.append("^{").append(Util.asString(order)).append('}');
            }
        });
    }

}
