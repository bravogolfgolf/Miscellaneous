package pkg.monopoly;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
public class NumberRolledMultiplierTest {

    @Test
    public void testNumberRolledMultiplier() {
        NumberRolledMultiplier nm1 = new NumberRolledMultiplier();
        assertEquals(1, nm1.value());
        assertTrue(nm1.isDefault());

        NumberRolledMultiplier nm16 = new NumberRolledMultiplier(16);
        assertEquals(16,nm16.value());
        assertFalse(nm16.isDefault());
    }
}
