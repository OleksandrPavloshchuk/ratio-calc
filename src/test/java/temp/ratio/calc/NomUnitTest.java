package temp.ratio.calc;

import temp.ratio.calc.Nom;
import static junit.framework.Assert.*;
import org.junit.Test;

public class NomUnitTest {

    @Test
    public void addZeroOrder() {
        Nom actual = new Nom();
        actual.append("a", 2);
        actual.append( "a", 0);
        actual.append( "b", 3);
        actual.append( "c", 0);
        
        Nom expected = new Nom();
        expected.append( "a", 2);
        expected.append("b", 3);
        
        assertEquals( expected, actual);
    }
    
    @Test
    public void add() {
        Nom actual = new Nom();
        actual.append("a", 1.4);
        actual.append("a", 4.3);
        actual.append("c", 2);
        actual.append("b", -3.3);
        actual.append("b", 2);
        
        Nom expected = new Nom();
        expected.append("a", 5.7);
        expected.append("b", -1.3);
        expected.append("c", 2);
        
        assertEquals( expected, actual);
    }
    
    @Test
    public void zeroResult() {
        Nom actual = new Nom();
        actual.append("A", -3.2);
        actual.append("A", 0.2);
        actual.append("A", 3);
        
        Nom expected = new Nom();
        
        assertEquals( expected, actual);
    }

    @Test
    public void merge() {
        Nom n1 = new Nom();
        n1.append("a", -4);
        n1.append("b", 2);

        Nom n2 = new Nom();
        n2.append("b", 3);
        n2.append("c", 0.5);

        Nom actual = n1.merge(n2);

        Nom expected = new Nom();
        expected.append("a", -4);
        expected.append("b", 5);
        expected.append("c", 0.5);

        assertEquals( expected, actual);
    }

    
}
