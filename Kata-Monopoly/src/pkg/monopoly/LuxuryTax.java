package pkg.monopoly;

public class LuxuryTax extends Space {

    public LuxuryTax(String description) {
        setDescription(description);
    }

    @Override
    public void landOn(Player player, int rollValue) {
        final int LUXURY_TAX_AMOUNT = -75;
        player.changeCashBalanceBy(LUXURY_TAX_AMOUNT);
    }
}
