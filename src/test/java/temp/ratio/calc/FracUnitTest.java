package temp.ratio.calc;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import static temp.ratio.calc.builder.FracBuilder.build;

public class FracUnitTest {

    @Test
    public void mul() {
        assertEquals(build(1, 12), build(3, 8).mul(build(2, 9)));
    }

    @Test
    public void add() {
        assertEquals(build(545, 144), build(8, 36).add(build(57, 16)));
        assertEquals(build(29, 28), build(2, 7).add(build(6, 8)));
    }

}
