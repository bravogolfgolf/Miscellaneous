package pkg.monopoly;

public class RealEstate extends Property {

    public RealEstate(String description, String group, int price, int rent, int house1Rent, int house2Rent, int house3Rent, int house4Rent, int hotelRent) {
        super(description, group, price, rent, house2Rent, house1Rent, house3Rent, house4Rent, hotelRent);
    }

    @Override
    protected int calculateRentOwed(String sourceOfMove, SourceOfMoveMultiplier sourceOfMoveMultiplier, OwnershipMultiplier ownershipMultiplier) {
        if (getImprovements() == 1)
            return house1Rent * ownershipMultiplier.value() * sourceOfMoveMultiplier.value();
        else if (getImprovements() == 2)
            return house2Rent * ownershipMultiplier.value() * sourceOfMoveMultiplier.value();
        else if (getImprovements() == 3)
            return house3Rent * ownershipMultiplier.value() * sourceOfMoveMultiplier.value();
        else if (getImprovements() == 4)
            return house4Rent * ownershipMultiplier.value() * sourceOfMoveMultiplier.value();
        else if (getImprovements() == 5)
            return hotelRent * ownershipMultiplier.value() * sourceOfMoveMultiplier.value();
        return getRent() * ownershipMultiplier.value() * sourceOfMoveMultiplier.value();
    }
}

