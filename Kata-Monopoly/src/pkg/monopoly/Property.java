package pkg.monopoly;

import java.util.ArrayList;
import java.util.List;

abstract class Property extends Space {

    public Property(String description, String group, int price, int rent) {
        setDescription(description);
        setGroup(group);
        setPrice(price);
        setRent(rent);
    }

    private int price;
    protected int rent;
    private boolean isMortgaged;
    private Player owner = Player.newBank();

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public void setRent(int rent) {
        this.rent = rent;
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

    @Override
    public void landOn(Player player, String sourceOfMove) {
        if (playerIsNotOwner(player))
            if (propertyIsUnowned())
                buyProperty(player);
            else if (propertyIsNotMortgaged()) {
                int rentOwed = calculateRentOwed(sourceOfMove);
                payRent(player, rentOwed);
            }
    }

    protected abstract int calculateRentOwed(String scourceOfMove);

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
