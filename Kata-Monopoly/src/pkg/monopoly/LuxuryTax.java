package pkg.monopoly;

public class LuxuryTax extends Space {

    public LuxuryTax(String description) {
        setDescription(description);
    }

    @Override
    public void landOn(Player player, SourceOfMoveMultiplier sourceOfMoveMultiplier, OwnershipMultiplier ownershipMultiplier) {
        final int LUXURY_TAX_AMOUNT = -75;
        player.transaction(LUXURY_TAX_AMOUNT, "Cash");
    }
}
