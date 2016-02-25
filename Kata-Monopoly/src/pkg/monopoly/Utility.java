package pkg.monopoly;

import java.util.List;

public class Utility extends Property {

    public Utility(String description, String group, int price) {
        super(description, group, price, 0);
    }

    @Override
    protected int calculateRentOwed() {
        List<Space> properties = getAllPropertiesInGroup();
        if (allPropertiesHaveSameOwner(properties))
            return 0;
        return numberRolled * 4;
    }
}