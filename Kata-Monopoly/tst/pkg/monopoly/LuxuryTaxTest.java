package pkg.monopoly;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LuxuryTaxTest {


    @Test
    public void testLandOnLuxuryTaxAndCashDecreasesBy75(){
    final int AFTER_TAX_BALANCE = 1425;
        Space luxuryTax = Space.create("LuxuryTax","Luxury Tax");
        Player player = new Player("Cat");
        luxuryTax.landOn(player);
        assertEquals(AFTER_TAX_BALANCE, player.getCashBalance());
    }
}
