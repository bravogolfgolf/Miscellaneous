package pkg.monopoly;

public class Utility extends Property {

    public Utility(String description, String group, int price) {
        super(description, group, price, 0, 0, 0, 0, 0, 0);
    }

    @Override
    protected int calculateRentOwed(SourceOfMoveMultiplier sourceOfMoveMultiplier, OwnershipMultiplier ownershipMultiplier) {
        return numberRolled * ownershipMultiplier.value() * sourceOfMoveMultiplier.value();
    }
}