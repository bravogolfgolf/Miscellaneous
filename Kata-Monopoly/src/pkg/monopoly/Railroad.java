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
        int rentMultiplier = (int) Math.pow(2, exponent);
        if (sourceOfMove.equals("Card"))
            return getRent() * rentMultiplier * 2;
        else
            return getRent() * rentMultiplier;
    }

    public int getCountOfPropertiesInGroupWithSameOwner(List<Space> properties) {
        Player thisOwner = this.getOwner();
        int ownerCount = 0;
        for (Space space : properties) {
            Property property = (Property) space;
            if (property.getOwner().equals(thisOwner))
                ownerCount++;
        }
        return ownerCount;
    }

}
