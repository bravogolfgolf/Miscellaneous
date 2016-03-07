package pkg.monopoly;

import java.util.List;

public class Railroad extends Property {

    public Railroad(String description, String group, int price, int rent) {
        super(description, group, price, rent);
    }

    @Override
    protected int calculateRentOwed(String sourceOfMove) {
        List<Space> properties = getAllPropertiesInGroup();
        int exponent = getCountOfPropertiesInGroupWithSameOwner(properties) - 1;
        int ownershipMultiplier = (int) Math.pow(2, exponent);
        if (sourceOfMove.equals("Card"))
            return getRent() * ownershipMultiplier * 2;
        else
            return getRent() * ownershipMultiplier;
    }

}
