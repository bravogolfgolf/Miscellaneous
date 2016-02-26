package pkg.monopoly;

public class Player {
    private final String description;
    private int cashBalance = 0;
    private Space space;
    private int doublesRolledInATurnCounter;

    public Player(String description) {
        this.description = description;
        this.space = new Go("Go");
        this.cashBalance = 1500;
    }

    public static Player newBank() {
        return new BankPlayer("Bank");
    }

    public boolean isBank() {
        return false;
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

    public void takeATurn(Dice dice) throws GoToJail.GoToJailException {
        manageProperties();
        dice.rollTwoDie();
        if (dice.rolledDouble())
            doubleRolled(dice);
        else
            doubleNotRolled(dice);
    }

    private void doubleRolled(Dice dice) throws GoToJail.GoToJailException {
        incrementDoublesRolledInATurnCounter();
        if (getNumberOfDoublesRolledInARoww() == 3) {
            goToJail();
        } else {
            space.move(this, dice.getTwoDieRollValue());
            takeATurn(dice);
        }
    }

    private void incrementDoublesRolledInATurnCounter() {
        doublesRolledInATurnCounter++;
    }

    public int getNumberOfDoublesRolledInARoww() {
        return doublesRolledInATurnCounter;
    }

    private void goToJail() throws GoToJail.GoToJailException {
        Space goToJail = space.searchForSpace(this, GoToJail.class.getSimpleName());
        goToJail.landOn(this);}

    public void resetDoublesRolledInATurnCounter() {
        doublesRolledInATurnCounter = 0;
    }

    private void doubleNotRolled(Dice dice) throws GoToJail.GoToJailException {
        space.move(this, dice.getTwoDieRollValue());
        resetDoublesRolledInATurnCounter();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Player player = (Player) o;

        return cashBalance == player.cashBalance && doublesRolledInATurnCounter == player.doublesRolledInATurnCounter && description.equals(player.description) && (space != null ? space.equals(player.space) : player.space == null);

    }

    @Override
    public int hashCode() {
        int result = description.hashCode();
        result = 31 * result + cashBalance;
        result = 31 * result + (space != null ? space.hashCode() : 0);
        result = 31 * result + doublesRolledInATurnCounter;
        return result;
    }
}
