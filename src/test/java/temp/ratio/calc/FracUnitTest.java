package temp.ratio.calc;

import org.junit.Assert;
import org.junit.Test;

public class FracUnitTest {

    @Test
    public void mul() {
        Assert.assertEquals( new Frac(1, 12), new Frac(3,8).mul( new Frac(2,9)));
    }

    @Test
    public void add() {
        Assert.assertEquals( new Frac(545, 144), new Frac(8,36).add( new Frac(57,16)));
        Assert.assertEquals( new Frac(29, 28), new Frac(2,7).add( new Frac(6,8)));
    }

}
