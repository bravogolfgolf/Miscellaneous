package pkg.monopoly;

import java.util.List;

public class Railroad extends Property {

    public Railroad(String description, String group, int price) {
        super(description, group, price);
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
