package pkg.monopoly;

import java.util.List;

public class RealEstate extends Property {

    public RealEstate(String description, String group) {
        super(description, group);
    }

    public boolean allPropertiesHaveSameOwner(List<Space> properties) {
        Property firstProperty = (Property) properties.get(0);
        Player first = firstProperty.getOwner();
        for (int i = 1; i < properties.size(); i++) {
            Property next = (Property) properties.get(i);
            if (!next.getOwner().equals(first))
                return false;
        }
        return true;
    }
}

