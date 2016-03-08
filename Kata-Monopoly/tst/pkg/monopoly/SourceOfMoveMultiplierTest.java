package pkg.monopoly;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class SourceOfMoveMultiplierTest {

    @Test
    public void testSourceOfMove(){
        SourceOfMoveMultiplier som1 = new SourceOfMoveMultiplier();
        assertEquals(1,som1.value());
        assertTrue(som1.isDefault());

        SourceOfMoveMultiplier sm = new SourceOfMoveMultiplier(8);
        assertEquals(8,sm.value());
        assertFalse(sm.isDefault());
    }
}
