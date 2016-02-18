package pkg.monopoly;

public class LuxuryTax extends Space {

    public LuxuryTax(String descrption) {
        super(descrption);
    }

    @Override
    public void landOn(Player player) {
        final int LUXURY_TAX_AMOUNT = -75;
        player.increaseCashBalanceBy(LUXURY_TAX_AMOUNT);
    }
}
