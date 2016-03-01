package pkg.monopoly;

import java.util.List;

public class RealEstate extends Property {

    private int numberOfImprovments;

    public RealEstate(String description, String group, int price, int rent) {
        super(description, group, price, rent);
    }

    public void addImprovements() {
        numberOfImprovments++;
    }

    public void removeImprovements() {
        numberOfImprovments--;
    }

    public int getImprovements() {
        return numberOfImprovments;
    }

    @Override
    protected int calculateRentOwed() {
        List<Space> properties = getAllPropertiesInGroup();
        if (allPropertiesHaveSameOwner(properties))
            return rent * 2;
        return rent;
    }
}

