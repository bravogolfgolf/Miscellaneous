package pkg.monopoly;

public class Railroad extends Property {

    public Railroad(String description, String group, int price, int rent) {
        super(description, group, price, rent, 0, 0, 0, 0, 0);
    }

    @Override
    protected int calculateRentOwed(SourceOfMoveMultiplier sourceOfMoveMultiplier, OwnershipMultiplier ownershipMultiplier) {
        return getRent() * ownershipMultiplier.value() * sourceOfMoveMultiplier.value();
    }

}
