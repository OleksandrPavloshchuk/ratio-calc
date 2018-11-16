package temp.ratio.calc.builder;

import java.util.Objects;

public final class FracBuilder {

    private FracBuilder() {

    }

    public static temp.ratio.calc.Frac build(int n, int d) {
        return new Frac(n, d);
    }

    public static temp.ratio.calc.Frac build(int n) {
        return build(n, 1);
    }

    private static final int gcd(int a, int b) {
        if (0 == b) {
            return a;
        }
        return gcd(b, a % b);
    }

    private static final int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }

    private static class Frac implements temp.ratio.calc.Frac {

        private final int n;
        private final int d;

        private Frac(int n, int d) {
            if (0 == d) {
                throw new IllegalArgumentException("denominator is 0");
            }
            int td = d < 0 ? -d : d;
            int tn = d < 0 ? -n : n;
            final int g = gcd(Math.abs(tn), Math.abs(td));
            this.n = tn / g;
            this.d = td / g;
        }

        @Override
        public int n() {
            return n;
        }

        @Override
        public int d() {
            return d;
        }

        @Override
        public temp.ratio.calc.Frac mul(temp.ratio.calc.Frac a) {
            return new Frac(n() * a.n(), d() * a.d());
        }

        @Override
        public temp.ratio.calc.Frac add(temp.ratio.calc.Frac a) {
            final int td = lcm(d(), a.d());
            final int tn = (td * n()) / d();
            final int tna = (td * a.n()) / a.d();
            return new Frac(tn + tna, td);
        }

        @Override
        public String toString() {
            final String s = String.valueOf(n);
            if (1 == d) {
                return s;
            }
            return s + "/" + d;
        }

        @Override
        public int hashCode() {
            return Objects.hash(n, d);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            final Frac other = (Frac) obj;
            return Objects.equals(n, other.n) && Objects.equals(d, other.d);
        }

    }

}
