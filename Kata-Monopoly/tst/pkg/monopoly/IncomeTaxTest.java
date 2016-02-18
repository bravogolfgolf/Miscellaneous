package pkg.monopoly;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IncomeTaxTest {

    @Test
    public void testLandOnIncomeTaxWithLessThanOrEqualTo2000InNetWorth() {
        final int AFTER_TAX_BALANCE = 1350;
        Space incomeTax = new IncomeTax("Income Tax");
        Player player = new Player();
        incomeTax.landOn(player);
        assertEquals(AFTER_TAX_BALANCE, player.getCashBalance());

    }

    @Test
    public void testLandOnIncomeTaxWithGreaterThan2000InNetWorth() {
        final int AFTER_TAX_BALANCE = 1900;
        Space incomeTax = new IncomeTax("Income Tax");
        Player player = new Player();
        player.increaseCashBalanceBy(600);
        incomeTax.landOn(player);
        assertEquals(AFTER_TAX_BALANCE, player.getCashBalance());

    }
}
