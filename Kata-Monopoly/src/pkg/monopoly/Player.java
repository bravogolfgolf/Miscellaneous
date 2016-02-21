package pkg.monopoly;

public class Player {
    private int cashBalance = 0;
    private Space space;
    private int doublesRolledInATurnCounter;

    public Player() {
        this.space = new Go("Go");
        this.cashBalance = 1500;
    }

    public void setSpace(Space space) {
        this.space = space;
    }

    public Space getSpace() {
        return space;
    }

    public void changeCashBalanceBy(int cash) {
        cashBalance += cash;
    }

    public int getCashBalance() {
        return cashBalance;
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

    public void takeATurn(Dice dice) {
        dice.rollTwoDie();
        if (dice.rolledDouble())
            doubleRolled(dice);
        else
            doubleNotRolled(dice);
    }

    private void doubleRolled(Dice dice) {
        incrementDoublesRolledInATurnCounter();
        if (getNumberOfDoublesRolledInARoww() == 3)
            goToJail();
        else
            takeAnotherTurn(dice);
    }

    private void incrementDoublesRolledInATurnCounter() {
        doublesRolledInATurnCounter++;
    }

    public int getNumberOfDoublesRolledInARoww() {
        return doublesRolledInATurnCounter;
    }

    private void goToJail() {
        Space goToJail = space.searchForSpace(this, GoToJail.class.getSimpleName());
        goToJail.landOn(this);
        resetDoublesRolledInATurnCounter();
    }

    public void resetDoublesRolledInATurnCounter() {
        doublesRolledInATurnCounter = 0;
    }

    private void takeAnotherTurn(Dice dice) {
        space.move(this, dice.getTwoDieRollValue());
        takeATurn(dice);
    }

    private void doubleNotRolled(Dice dice) {
        space.move(this, dice.getTwoDieRollValue());
        resetDoublesRolledInATurnCounter();
    }
}
