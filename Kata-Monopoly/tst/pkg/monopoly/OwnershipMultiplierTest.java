package pkg.monopoly;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class OwnershipMultiplierTest {

    @Test
    public void testOwnershipMultiplier() {
        OwnershipMultiplier om1 = new OwnershipMultiplier();
        assertEquals(1, om1.value());
        assertTrue(om1.isDefault());

        OwnershipMultiplier om = new OwnershipMultiplier(8);
        assertEquals(8, om.value());
        assertFalse(om.isDefault());
    }

}
