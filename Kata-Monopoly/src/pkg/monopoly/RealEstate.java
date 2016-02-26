package pkg.monopoly;

import java.util.List;

public class RealEstate extends Property {

    public RealEstate(String description, String group, int price, int rent) {
        super(description, group, price, rent);
    }

    @Override
    protected int calculateRentOwed() {
        List<Space> properties = getAllPropertiesInGroup();
        if (allPropertiesHaveSameOwner(properties))
            return rent * 2;
        return rent;
    }
}

