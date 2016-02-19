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

    @Override
    public void landOn(Player player) {
        if (!isMortgaged)
            if (owner == null) {
                this.owner = player;
                player.changeCashBalanceBy(-price);
            } else {
                player.changeCashBalanceBy(-rent);
                this.owner.changeCashBalanceBy(rent);
            }
    }

    public int unMortgageAmount() {
        return (int) (mortgageAmount() * 1.10);
    }

    public int mortgageAmount() {
        return price / 2;
    }
}

