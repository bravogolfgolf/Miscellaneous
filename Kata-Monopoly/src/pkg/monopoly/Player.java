package pkg.monopoly;

public class Player {
    private int cashBalance = 0;
    private Space space;

    public Player() {
        this.space = new Go("Go");
        this.cashBalance = 1500;
    }

    public Space getSpace() {
        return space;
    }

    public void setSpace(Space space) {
        this.space = space;
    }

    public int getCashBalance() {
        return cashBalance;
    }

    public void takeATurn(Dice dice) {
        Boolean rolledDoubles = dice.rollTwoDie();
        int numberRolled = dice.getTwoDieRollValue();
        space.move(this, numberRolled);
        if(rolledDoubles && dice.getNumberOfDoublesInARow() < 3){
            this.takeATurn(dice);
        }
    }

    public void changeCashBalanceBy(int cash) {
        cashBalance += cash;
    }

    public void manageProperties() {
    }

    public void mortgageProperty(Property property) {
        changeCashBalanceBy(property.mortgageAmount());
        property.setIsMortgaged(true);
    }

    public void unmortgageProperty(Property property) {
        changeCashBalanceBy(property.unMortgageAmount());
        property.setIsMortgaged(false);
    }
}
