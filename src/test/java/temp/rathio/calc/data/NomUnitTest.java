package temp.rathio.calc.data;

import junit.framework.Assert;
import org.junit.Test;

public class NomUnitTest {

    @Test
    public void addZeroOrder() {
        Nom actual = new Nom();
        actual.add("a", 2);
        actual.add( "a", 0);
        actual.add( "b", 3);
        actual.add( "c", 0);
        
        Nom expected = new Nom();
        expected.add( "a", 2);
        expected.add("b", 3);
        
        Assert.assertEquals( expected, actual);
    }
    
    @Test
    public void add() {
        Nom actual = new Nom();
        actual.add("a", 1.4);
        actual.add("a", 4.3);
        actual.add("c", 2);
        actual.add("b", -3.3);
        actual.add("b", 2);
        
        Nom expected = new Nom();
        expected.add("a", 5.7);
        expected.add("b", -1.3);
        expected.add("c", 2);
        
        Assert.assertEquals( expected, actual);
    }
    
    @Test
    public void addToZero() {
        Nom actual = new Nom();
        actual.add("A", -3.2);
        actual.add("A", 0.2);
        actual.add("A", 3);
        
        Nom expected = new Nom();
        
        Assert.assertEquals( expected, actual);
    }
    
}
