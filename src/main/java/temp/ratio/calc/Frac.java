package temp.ratio.calc;

import java.util.Objects;

public class Frac implements Comparable<Frac> {

    public static final Frac ZERO = new Frac(0);
    public static final Frac ONE = new Frac(1);

    private final int n;
    private final int d;

    public Frac(int n) {
        this(n, 1);
    }

    public Frac(int n, int d) {
        if (0 == d) {
            throw new IllegalArgumentException("denominator is 0");
        }
        int td = d < 0 ? -d : d;
        int tn = d < 0 ? -n : n;
        final int g = gcd(Math.abs(tn), Math.abs(td));
        this.n = tn / g;
        this.d = td / g;
    }

    public int n() {
        return n;
    }

    public int d() {
        return d;
    }

    public Frac mul(Frac a) {
        return new Frac(n() * a.n(), d() * a.d());
    }

    public Frac add(Frac a) {
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

    private static final int gcd(int a, int b) {
        if (0 == b) {
            return a;
        }
        return gcd(b, a % b);
    }

    private static final int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }

    @Override
    public int compareTo(Frac o) {
        final Double v1 = ((double) n) / d;
        final Double v2 = ((double) o.n) / o.d;
        return v1.compareTo(v2);
    }

}
