package pkg.monopoly;

import java.util.List;

public class RealEstate extends Property {

    private int numberOfImprovements;

    public RealEstate(String description, String group, int price, int rent) {
        super(description, group, price, rent);
    }

    public void addImprovements() {
        numberOfImprovements++;
    }

    public void removeImprovements() {
        numberOfImprovements--;
    }

    public int getImprovements() {
        return numberOfImprovements;
    }

    @Override
    protected int calculateRentOwed(String scourceOfMove) {
        List<Space> properties = getAllPropertiesInGroup();
        if (allPropertiesHaveSameOwner(properties))
            return rent * 2;
        return rent;
    }
}

