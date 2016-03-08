package pkg.monopoly;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class SourceOfMoveMultiplierTest {

    @Test
    public void testSourceOfMove(){
        SourceOfMoveMultiplier som1 = new SourceOfMoveMultiplier();
        assertEquals(1,som1.value());
        SourceOfMoveMultiplier sm = new SourceOfMoveMultiplier(8);
        assertEquals(8,sm.value());
    }
}
