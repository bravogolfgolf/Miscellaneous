package pkg.monopoly;

public class Player {
    private int cashBalance = 0;
    private Space space;
    private int doublesRolledInATurnCounter;

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
        dice.rollTwoDie();
        if (dice.rolledDouble()) {
            incrementDoublesRolledInATurnCounter();
            if (getNumberOfDoublesRolledInARoww() == 3) {
                setSpace(Space.create("Other", "Jail"));
                resetDoublesRolledInATurnCounter();
            } else {
                space.move(this, dice.getTwoDieRollValue());
                takeATurn(dice);
            }
        } else {
            space.move(this, dice.getTwoDieRollValue());
            resetDoublesRolledInATurnCounter();
        }
    }

    private void incrementDoublesRolledInATurnCounter() {
        doublesRolledInATurnCounter++;
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

    public void resetDoublesRolledInATurnCounter() {
        doublesRolledInATurnCounter = 0;
    }

    public int getNumberOfDoublesRolledInARoww() {
        return doublesRolledInATurnCounter;
    }
}
