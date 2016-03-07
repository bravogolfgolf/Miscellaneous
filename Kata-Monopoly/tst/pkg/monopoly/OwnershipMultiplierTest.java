package pkg.monopoly;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class OwnershipMultiplierTest {

    @Test
    public void testOwnershipMultiplier(){
        OwnershipMultiplier om1 = new OwnershipMultiplier();
        assertEquals(1,om1.value());
        OwnershipMultiplier om4 = new OwnershipMultiplier4();
        assertEquals(4,om4.value());
        OwnershipMultiplier om10 = new OwnershipMultiplier10();
        assertEquals(10,om10.value());

    }

}
