package pkg.monopoly;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class SourceOfMoveMultiplierTest {

    @Test
    public void testSourceOfMove(){
        SourceOfMoveMultiplier som1 = new SourceOfMoveMultiplier();
        assertEquals(1,som1.value());
        SourceOfMoveMultiplier som2 = new SourceOfMoveMultiplier2();
        assertEquals(2,som2.value());
        SourceOfMoveMultiplier som10 = new SourceOfMoveMultiplier10();
        assertEquals(10,som10.value());
    }
}
