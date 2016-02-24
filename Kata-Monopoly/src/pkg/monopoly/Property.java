package pkg.monopoly;

import java.util.ArrayList;
import java.util.List;

abstract class Property extends Space {

    public Property(String description, String group) {
        setDescription(description);
        setGroup(group);
    }

    private int price;
    private Player owner = Player.newBank();
    private boolean isMortgaged;
    private int rent;

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
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

    public boolean isMortgaged() {
        return isMortgaged;
    }

    public void setIsMortgaged(boolean status) {
        isMortgaged = status;
    }

    public int mortgageAmount() {
        return price / 2;
    }

    public int unMortgageAmount() {
        return (int) -(mortgageAmount() * 1.10);
    }

    @Override
    public void landOn(Player player) {
        if (playerIsNotOwner(player))
            if (propertyIsUnowned())
                buyProperty(player);
            else if (propertyIsNotMortgaged())
                payRent(player);
    }

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
        this.owner = player;
        player.changeCashBalanceBy(-price);
    }

    public void setRent(int rent) {
        this.rent = rent;
    }

    public int getRent() {
        return rent;
    }

    private void payRent(Player player) {
        player.changeCashBalanceBy(-rent);
        this.owner.changeCashBalanceBy(rent);
    }

    public void mortgagedBy(Player player) {
        if (mortgageConditionsAreMeet(player)) {
            player.changeCashBalanceBy(mortgageAmount());
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
            player.changeCashBalanceBy(unMortgageAmount());
            setIsMortgaged(false);
        }
    }

    private boolean unMortgageConditionsAreMeet(Player player) {
        return isMortgaged() && propertyIsOwnedByPlayer(player);
    }
}
