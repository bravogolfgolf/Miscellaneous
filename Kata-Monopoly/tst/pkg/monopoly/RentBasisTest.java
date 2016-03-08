package pkg.monopoly;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RentBasisTest {

    @Test
    public void testRentalBasis() {
        RentalBasis rb = new RentalBasis(10, 11, 12, 13, 14, 15);
        assertEquals(10, rb.get(0));
        assertEquals(11, rb.get(1));
        assertEquals(12, rb.get(2));
        assertEquals(13, rb.get(3));
        assertEquals(14, rb.get(4));
        assertEquals(15, rb.get(5));
    }
}
