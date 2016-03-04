package pkg.monopoly;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private final String description;
    private int cashBalance = 0;
    private Space space;
    private int rollCounter = 0;
    private boolean inJail = false;
    private List<Card> getOutOfJailCards = new ArrayList<Card>();
    private Player nextPlayer;

    public Player(String description) {
        this.description = description;
        this.cashBalance = 1500;
    }

    public String getDescription() {
        return description;
    }

    public void setNextPlayer(Player player) {
        this.nextPlayer = player;
    }

    public Player getNextPlayer() {
        return nextPlayer;
    }

    public List<Player> getAllOtherPlayersInGame() {
        List<Player> otherPlayers = new ArrayList<Player>();
        Player currentPlayer = this;
        Player nextPlayer = currentPlayer.getNextPlayer();
        while (!nextPlayer.equals(this)) {
            otherPlayers.add(nextPlayer);
            currentPlayer = nextPlayer;
            nextPlayer = currentPlayer.getNextPlayer();
        }
        return otherPlayers;
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

    public void addCard(Card getOutOfJail) {
        getOutOfJailCards.add(getOutOfJail);
    }

    public Card getCard() {
        return getOutOfJailCards.remove(0);
    }

    public void setInJail(boolean inJail) {
        this.inJail = inJail;
    }

    public boolean isInJail() {
        return inJail;
    }

    public void takeATurn(Dice dice) throws GoToJail.GoToJailException {
        manageProperties();
        dice.rollTwoDie();
        if (dice.rolledDouble())
            doubleRolled(dice);
        else
            doubleNotRolled(dice);
    }

    public void manageProperties() {
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

    private void incrementDoublesRolledInATurnCounter() {
        rollCounter++;
    }

    public int getNumberOfRolls() {
        return rollCounter;
    }

    private void releasedFromJail() {
        setInJail(false);
        resetRollCounter();
    }

    private void goToJail() throws GoToJail.GoToJailException {
        Space goToJail = space.searchForSpaceByDescription("Go to Jail");
        goToJail.landOn(this);}

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

    public void resetRollCounter() {
        rollCounter = 0;
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
}
