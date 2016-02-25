package pkg.monopoly;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IncomeTaxTest {

    private Space incomeTax;
    private Player player;

    @Before
    public void setUp() throws Exception {
        incomeTax = Space.create("IncomeTax","Income Tax");
        player = new Player("Cat");
    }

    @Test
    public void testLandOnIncomeTaxWithLessThanOrEqualTo2000InNetWorth() {
        final int AFTER_TAX_BALANCE = 1350;
        incomeTax.landOn(player, 0);
        assertEquals(AFTER_TAX_BALANCE, player.getCashBalance());

    }

    @Test
    public void testLandOnIncomeTaxWithGreaterThan2000InNetWorth() {
        final int AFTER_TAX_BALANCE = 1900;
        player.changeCashBalanceBy(600);
        incomeTax.landOn(player, 0);
        assertEquals(AFTER_TAX_BALANCE, player.getCashBalance());

    }
}
