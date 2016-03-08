package pkg.monopoly;

import java.util.ArrayList;
import java.util.List;

abstract class Property extends Space {

    protected final int house1Rent;
    protected final int house2Rent;
    protected final int house3Rent;
    protected final int house4Rent;
    protected final int hotelRent;
    protected int numberOfImprovements;

    public Property(String description, String group, int price, int rent, int house2Rent, int house1Rent, int house3Rent, int house4Rent, int hotelRent) {
        setDescription(description);
        setGroup(group);
        this.price = price;
        this.rent = rent;
        this.house2Rent = house2Rent;
        this.house1Rent = house1Rent;
        this.house3Rent = house3Rent;
        this.house4Rent = house4Rent;
        this.hotelRent = hotelRent;
    }

    private final int price;
    private final int rent;
    private boolean isMortgaged;
    private Player owner = Player.newBank();

    public int getPrice() {
        return price;
    }

    public int getRent() {
        return rent;
    }

    public void setIsMortgaged(boolean status) {
        isMortgaged = status;
    }

    public boolean isMortgaged() {
        return isMortgaged;
    }

    public int mortgageAmount() {
        return price / 2;
    }

    public int unMortgageAmount() {
        return (int) -(mortgageAmount() * 1.10);
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }

    public Player getOwner() {
        return owner;
    }

    public List<Space> getAllPropertiesInGroup() {
        List<Space> properties = new ArrayList<Space>();
        properties.add(this);
        String group = this.getGroup();
        Space startingSpace = this;
        Space currentSpace = this;
        Space nextSpace = currentSpace.getNextSpace();
        while (!nextSpace.equals(startingSpace)) {
            if (nextSpace.getGroup().equals(group))
                properties.add(nextSpace);
            currentSpace = nextSpace;
            nextSpace = currentSpace.getNextSpace();
        }
        return properties;
    }

    public boolean allPropertiesHaveSameOwner(List<Space> properties) {
        Player thisOwner = this.getOwner();
        for (int i = 1; i < properties.size(); i++) {
            Property next = (Property) properties.get(i);
            if (!next.getOwner().equals(thisOwner))
                return false;
        }
        return true;
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

    @Override
    public void landOn(Player player, String sourceOfMove, SourceOfMoveMultiplier sourceOfMoveMultiplier, OwnershipMultiplier ownershipMultiplier) {
        if (playerIsNotOwner(player))
            if (propertyIsUnowned())
                // TODO Add ability to buy property or auction
                buyProperty(player);
            else if (propertyIsNotMortgaged()) {
                if (ownershipMultiplier.isDefault())
                    ownershipMultiplier = overwriteOwnershipMultiplier();
                int rentOwed = calculateRentOwed(sourceOfMove, sourceOfMoveMultiplier, ownershipMultiplier);
                payRent(player, rentOwed);
            }
    }

    private OwnershipMultiplier overwriteOwnershipMultiplier() {
        List<Space> propertiesInGroup = getAllPropertiesInGroup();
        if (isRailroad()) {
            int exponent = getCountOfPropertiesInGroupWithSameOwner(propertiesInGroup) - 1;
            int ownershipMultiplier = (int) Math.pow(2, exponent);
            return new OwnershipMultiplier(ownershipMultiplier);
        }

        if (isUtility())
            if (allPropertiesHaveSameOwner(propertiesInGroup))
                return new OwnershipMultiplier(10);
            else
                return new OwnershipMultiplier(4);

        if (allPropertiesHaveSameOwner(propertiesInGroup) && isUnimproved())
            return new OwnershipMultiplier(2);

        return new OwnershipMultiplier();
    }

    private boolean isUnimproved() {
        return numberOfImprovements == 0;
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

    protected abstract int calculateRentOwed(String sourceOfMove, SourceOfMoveMultiplier sourceOfMoveMultiplier, OwnershipMultiplier ownershipMultiplier);

    private boolean playerIsNotOwner(Player player) {
        return !player.equals(this.getOwner());
    }

    private boolean propertyIsUnowned() {
        return owner.isBank();
    }

    private boolean propertyIsNotMortgaged() {
        return !isMortgaged;
    }

    private void buyProperty(Player player) {
        player.transaction(-price, "Purchase");
        this.owner = player;
    }

    private void payRent(Player player, int rentOwed) {
        player.transaction(-rentOwed, "Cash");
        this.owner.transaction(rentOwed, "Cash");
    }

    public void mortgagedBy(Player player) {
        if (mortgageConditionsAreMeet(player)) {
            player.transaction(mortgageAmount(), "Mortgage");
            setIsMortgaged(true);
        }
    }

    private boolean mortgageConditionsAreMeet(Player player) {
        return propertyIsNotMortgaged() && propertyIsOwnedByPlayer(player);
    }

    private boolean propertyIsOwnedByPlayer(Player player) {
        return getOwner().equals(player);
    }

    public void unMortgageBy(Player player) {
        if (unMortgageConditionsAreMeet(player)) {
            player.transaction(unMortgageAmount(), "Un-mortgage");
            setIsMortgaged(false);
        }
    }

    private boolean unMortgageConditionsAreMeet(Player player) {
        return isMortgaged() && propertyIsOwnedByPlayer(player);
    }
}
