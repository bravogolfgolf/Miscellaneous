package pkg.monopoly;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BasisTest {

    @Test
    public void testBasis(){
        Basis b1 = new Basis();
        assertEquals(1,b1.value());
        assertTrue(b1.isDefault());

        Basis b = new Basis(7);
        assertEquals(7,b.value());
        assertFalse(b.isDefault());
    }
}




