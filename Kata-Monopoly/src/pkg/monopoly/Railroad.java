package pkg.monopoly;

import java.util.List;

public class Railroad extends Property {

    public Railroad(String description, String group, int price, int rent) {
        super(description, group, price, rent);
    }

    @Override
    protected int calculateRentOwed(String sourceOfMove, SourceOfMoveMultiplier sourceOfMoveMultiplier) {
        List<Space> properties = getAllPropertiesInGroup();
        int exponent = getCountOfPropertiesInGroupWithSameOwner(properties) - 1;
        int ownershipMultiplier = (int) Math.pow(2, exponent);
        return getRent() * ownershipMultiplier * sourceOfMoveMultiplier.value();
    }

}
