package pkg.monopoly;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class OwnershipMultiplierTest {

    @Test
    public void testOwnershipMultiplier(){
        OwnershipMultiplier om1 = new OwnershipMultiplier();
        assertEquals(1,om1.value());
        OwnershipMultiplier om = new OwnershipMultiplier(8);
        assertEquals(8,om.value());
    }

}
