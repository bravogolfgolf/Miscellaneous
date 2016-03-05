package pkg.monopoly;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private final String description;
    private int cashBalance = 0;
    private int netWorth = 0;
    private Space space;
    private int rollCounter = 0;
    private boolean inJail = false;
    private final List<Card> getOutOfJailCards = new ArrayList<Card>();
    private Player nextPlayer;

    public Player(String description) {
        this.description = description;
        transaction(1500, "Cash");
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
        return new BankPlayer();
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

    public void transaction(int amount, String transactionType) {
        if (transactionType.equals("Cash")) {
            cashBalance += amount;
            netWorth += amount;
        } else if (transactionType.equals("Purchase")) {
            transaction(amount,"Cash");
            netWorth -= (amount / 2);
        } else if (transactionType.equals("Mortgage")) {
            cashBalance += amount;
        } else if (transactionType.equals("Un-mortgage")) {
            transaction(amount,"Cash");
            netWorth-= ((amount / 11) * 10);
        }
    }

    public int getCashBalance() {
        return cashBalance;
    }

    public int getNetWorth() {
        return netWorth;
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
        // TODO If beginning of turn and player is in jail -- add ability to use card (if player has one) or post bail and move
        // TODO Add ability to buy or sell improvement
        // TODO Add ability to mortgage or un-mortgage property
        // TODO Add ability to trade
    }

    private void doubleRolled(Dice dice) throws GoToJail.GoToJailException {
        incrementDoublesRolledInATurnCounter();
        if (getNumberOfRolls() == 3) {
            if (inJail) {
                releasedFromJail();
                space.move(this, dice.getTwoDieRollValue(), "Roll");
            } else
                goToJail();
        } else {
            if (inJail) {
                releasedFromJail();
                space.move(this, dice.getTwoDieRollValue(), "Roll");
            } else {
                space.move(this, dice.getTwoDieRollValue(), "Roll");
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
        goToJail.landOn(this, "Roll");}

    private void doubleNotRolled(Dice dice) throws GoToJail.GoToJailException {
        if (isInJail()) {
            if (rollCounter == 2) {
                postBail();
                space.move(this, dice.getTwoDieRollValue(), "Roll");
            } else {
                rollCounter++;
            }
        } else {
            space.move(this, dice.getTwoDieRollValue(), "Roll");
            resetRollCounter();
        }
    }

    public void postBail() {
        transaction(-50, "Cash");
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
