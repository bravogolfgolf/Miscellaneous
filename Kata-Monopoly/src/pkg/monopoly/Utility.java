package pkg.monopoly;

public class Utility extends Property {

    public Utility(String description, String group, int price) {
        super(description, group, price, 1, 1, 1, 1, 1, 1);
    }

    @Override
    protected int calculateRentOwed(Basis basis, OwnershipMultiplier ownershipMultiplier, SourceOfMoveMultiplier sourceOfMoveMultiplier) {
        return numberRolled * basis.value() * ownershipMultiplier.value() * sourceOfMoveMultiplier.value();
    }
}