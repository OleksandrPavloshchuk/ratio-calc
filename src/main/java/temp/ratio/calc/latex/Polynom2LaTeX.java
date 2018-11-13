package temp.ratio.calc.latex;

import temp.ratio.calc.Nom;
import temp.ratio.calc.Polynom;
import temp.ratio.calc.Util;

public class Polynom2LaTeX {

    private final Polynom polynom;

    public Polynom2LaTeX(Polynom polynom) {
        this.polynom = polynom;
    }

    public void render(StringBuilder sb) {
        boolean isFirst = true;
        for( final Nom n : polynom.getNoms() ) {
            final double v = polynom.getValue(n);
            if( isFirst ) {
                isFirst = false;
            } else if ( v>0 ) {
                sb.append('+');
            }
            if( v==-1) {
                sb.append('-');
            } else if (v!=1) {
                sb.append( Util.asString(v));
            }
            new Nom2LaTeX(n).render(sb);
        }
    }

}
