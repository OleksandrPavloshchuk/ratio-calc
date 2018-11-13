package temp.ratio.calc.latex;

import temp.ratio.calc.Nom;
import temp.ratio.calc.Util;

public class Nom2LaTeX {

    private final Nom nom;

    public Nom2LaTeX(Nom nom) {
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
