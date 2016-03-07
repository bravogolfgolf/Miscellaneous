package pkg.monopoly;

import java.util.List;

public class RealEstate extends Property {

    private final int house1Rent;
    private final int house2Rent;
    private final int house3Rent;
    private final int house4Rent;
    private final int hotelRent;
    private int numberOfImprovements;

    public RealEstate(String description, String group, int price, int rent, int house1Rent, int house2Rent, int house3Rent, int house4Rent, int hotelRent) {
        super(description, group, price, rent);
        this.house1Rent = house1Rent;
        this.house2Rent = house2Rent;
        this.house3Rent = house3Rent;
        this.house4Rent = house4Rent;
        this.hotelRent = hotelRent;

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
    protected int calculateRentOwed(String sourceOfMove, SourceOfMoveMultiplier sourceOfMoveMultiplier) {
        List<Space> properties = getAllPropertiesInGroup();
        if (allPropertiesHaveSameOwner(properties))
            if (numberOfImprovements == 0)
                return getRent() * 2 * sourceOfMoveMultiplier.value();
            else if (numberOfImprovements == 1)
                return house1Rent * sourceOfMoveMultiplier.value();
            else if (numberOfImprovements == 2)
                return house2Rent * sourceOfMoveMultiplier.value();
            else if (numberOfImprovements == 3)
                return house3Rent * sourceOfMoveMultiplier.value();
            else if (numberOfImprovements == 4)
                return house4Rent * sourceOfMoveMultiplier.value();
            else if (numberOfImprovements == 5)
                return hotelRent * sourceOfMoveMultiplier.value();
        return getRent() * sourceOfMoveMultiplier.value();

    }
}

