package temp.ratio.calc;

public class Util {

    static public double adjust(Double d) {
        return Math.round(d * 100.0) / 100.0;
    }

    static public String asString(double d) {
        double r = adjust(d);
        if( r==Math.ceil(r) ) {
            return String.format("%d", (int) r);
        } else {
            String s = String.format("%g", d);
            int n = s.indexOf(".");
            if( n>0 ) {
                while( s.charAt(s.length()-1)=='0' ) {
                    s = s.substring(0, s.length()-1);
                }
                if( s.charAt(s.length()-1)=='.') {
                    s = s.substring(0, s.length()-1);
                }
            }
            return s;
        }
    }
}
