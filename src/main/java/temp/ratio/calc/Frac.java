package temp.ratio.calc;

public interface Frac extends Comparable<Frac> {

    int n();

    int d();

    Frac mul(Frac a);

    Frac add(Frac a);

    @Override
    default public int compareTo(Frac o) {
        final Integer v1 = n() * o.d();
        final Integer v2 = o.n() * d();
        return v1.compareTo(v2);
    }

    default public boolean is0() {
        return n() == 0;
    }

    default public boolean is1() {
        return n() == 1 && d() == 1;
    }

}
