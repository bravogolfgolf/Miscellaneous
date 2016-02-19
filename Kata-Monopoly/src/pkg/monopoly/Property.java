package pkg.monopoly;

public class Property extends Space {

    private int price;
    private int rent;
    private Player owner;
    private boolean isMortgaged;

    public Property(String description) {
        super.setDescription(description);
    }

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

    public void setOwner(Player owner) {
        this.owner = owner;
    }

    public Player getOwner() {
        return owner;
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
        return (int) (mortgageAmount() * 1.10);
    }

    @Override
    public void landOn(Player player) {
        if (propertyIsNotMortgaged())
            if (propertyIsUnowned()) {
                buyProperty(player);
            } else {
                payRent(player);
            }
    }

    private boolean propertyIsNotMortgaged() {
        return !isMortgaged;
    }

    private boolean propertyIsUnowned() {
        return owner == null;
    }

    private void buyProperty(Player player) {
        this.owner = player;
        player.changeCashBalanceBy(-price);
    }

    private void payRent(Player player) {
        player.changeCashBalanceBy(-rent);
        this.owner.changeCashBalanceBy(rent);
    }
}

