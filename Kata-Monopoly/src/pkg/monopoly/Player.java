package pkg.monopoly;

public class Player {
    private final String description;
    private int cashBalance = 0;
    private Space space;
    private int rollCounter = 0;
    private boolean inJail = false;

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

    public boolean isInJail() {
        return inJail;
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
        if (getNumberOfRolls() == 3) {
            if (inJail) {
                releasedFromJail();
                space.move(this, dice.getTwoDieRollValue());
            } else
                goToJail();
        } else {
            if (inJail) {
                releasedFromJail();
                space.move(this, dice.getTwoDieRollValue());
            } else {
                space.move(this, dice.getTwoDieRollValue());
                takeATurn(dice);
            }
        }
    }

    private void releasedFromJail() {
        setInJail(false);
        resetRollCounter();
    }

    private void incrementDoublesRolledInATurnCounter() {
        rollCounter++;
    }

    public int getNumberOfRolls() {
        return rollCounter;
    }

    private void goToJail() throws GoToJail.GoToJailException {
        Space goToJail = space.searchForSpace(this, GoToJail.class.getSimpleName());
        goToJail.landOn(this);
    }

    public void resetRollCounter() {
        rollCounter = 0;
    }

    private void doubleNotRolled(Dice dice) throws GoToJail.GoToJailException {
        if (isInJail()) {
            if (rollCounter == 2) {
                postBail();
                space.move(this, dice.getTwoDieRollValue());
            } else {
                rollCounter++;
            }
        } else {
            space.move(this, dice.getTwoDieRollValue());
            resetRollCounter();
        }
    }

    public void postBail() {
        changeCashBalanceBy(-50);
        releasedFromJail();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Player player = (Player) o;

        return cashBalance == player.cashBalance && rollCounter == player.rollCounter && description.equals(player.description) && (space != null ? space.equals(player.space) : player.space == null);

    }

    @Override
    public int hashCode() {
        int result = description.hashCode();
        result = 31 * result + cashBalance;
        result = 31 * result + (space != null ? space.hashCode() : 0);
        result = 31 * result + rollCounter;
        return result;
    }

    public void setInJail(boolean inJail) {
        this.inJail = inJail;
    }
}
