package pkg.monopoly;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IncomeTaxTest {

    private IncomeTax incomeTax;
    private Player player;

    @Before
    public void setUp() {
        incomeTax = (IncomeTax) Space.create("IncomeTax","Income Tax");
        player = new Player("Cat");
    }

    @Test
    public void testLandOnIncomeTaxWithLessThanOrEqualTo2000InNetWorth() {
        final int AFTER_TAX_BALANCE = 1350;
        incomeTax.landOn(player, new SourceOfMoveMultiplier(), new OwnershipMultiplier());
        assertEquals(AFTER_TAX_BALANCE, player.getCashBalance());
        assertEquals(AFTER_TAX_BALANCE, player.getNetWorth());

    }

    @Test
    public void testLandOnIncomeTaxWithGreaterThan2000InNetWorth() {
        final int AFTER_TAX_BALANCE = 1900;
        player.transaction(600, "Cash");
        incomeTax.landOn(player, new SourceOfMoveMultiplier(), new OwnershipMultiplier());
        assertEquals(AFTER_TAX_BALANCE, player.getCashBalance());
        assertEquals(AFTER_TAX_BALANCE, player.getNetWorth());

    }
}
