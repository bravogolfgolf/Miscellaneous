package pkg.monopoly;

public class RealEstate extends Property {

    public RealEstate(String description, String group, int price, int rent, int house1Rent, int house2Rent, int house3Rent, int house4Rent, int hotelRent) {
        super(description, group, price, rent, house1Rent, house2Rent, house3Rent, house4Rent, hotelRent);
    }

    @Override
    protected int calculateRentOwed(Basis basis, OwnershipMultiplier ownershipMultiplier, SourceOfMoveMultiplier sourceOfMoveMultiplier) {
        return basis.value() * ownershipMultiplier.value() * sourceOfMoveMultiplier.value();
    }
}

