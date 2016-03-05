package pkg.monopoly;

import java.util.List;

public class RealEstate extends Property {

    private final int house1rent;
    private final int house2rent;
    private final int house3rent;
    private final int house4rent;
    private final int hotelrent;
    private int numberOfImprovements;

    public RealEstate(String description, String group, int price, int rent, int house1Rent, int house2Rent, int house3Rent, int house4Rent, int hotelRent) {
        super(description, group, price, rent);
        this.house1rent = house1Rent;
        this.house2rent = house2Rent;
        this.house3rent = house3Rent;
        this.house4rent = house4Rent;
        this.hotelrent = hotelRent;

    }

    public void addImprovements() {
        // TODO add transaction
        numberOfImprovements++;
    }

    public void removeImprovements() {
        // TODO add transaction
        numberOfImprovements--;
    }

    public int getImprovements() {
        return numberOfImprovements;
    }

    @Override
    protected int calculateRentOwed(String scourceOfMove) {
        List<Space> properties = getAllPropertiesInGroup();
        if (allPropertiesHaveSameOwner(properties))
            if (numberOfImprovements == 0)
                return rent * 2;
            else if (numberOfImprovements == 1)
                return house1rent;
            else if (numberOfImprovements == 2)
                return house2rent;
            else if (numberOfImprovements == 3)
                return house3rent;
            else if (numberOfImprovements == 4)
                return house4rent;
            else if (numberOfImprovements == 5)
                return hotelrent;
        return rent;
    }
}

