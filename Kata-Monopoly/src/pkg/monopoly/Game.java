package pkg.monopoly;

import java.io.IOException;
import java.util.*;

public class Game {


    public Game(String localization) throws IOException {
        String spacesFileName = String.format("Spaces_%s.txt",localization);
        board = Space.load(spacesFileName);
        for (int i = 0; i < board.size() - 1; i++) {
            board.get(i).setNextSpace(board.get(i + 1));
        }
        board.get(board.size() - 1).setNextSpace(board.get(0));

        String cardsFileName = String.format("Cards_%s.txt",localization);
        cards = Card.load(cardsFileName);
    }

    public class InvalidPlayerCount extends Exception {

        public InvalidPlayerCount(String message) {
            super(message);
        }

    }

    public static final int MINIMUM_NUMBER_OF_PLAYERS = 2;
    public static final int MAXIMUM_NUMBER_OF_PLAYERS = 8;

    private List<Space> board;
    private List<Card> cards;
    List<Player> players = new ArrayList<Player>();
    Dice dice = new Dice();

    public List<Space> getBoard() {
        return board;
    }

    public Card getCard(int index) {
        return cards.get(index);
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public Player getPlayer(int index) {
        return players.get(index);
    }

    public void setDice(Dice dice) {
        this.dice = dice;
    }

    public int getNumberOfPlayers() {
        return players.size();
    }

    public void randomizePlayerOrder() {
        Collections.shuffle(players);
    }

    public int getNumberOfCards() {
        return cards.size();
    }

    public void randomizeCardOrder() {
        Collections.shuffle(cards);
    }

    public void start() throws InvalidPlayerCount {
        if (getNumberOfPlayers() < MINIMUM_NUMBER_OF_PLAYERS ||
                getNumberOfPlayers() > MAXIMUM_NUMBER_OF_PLAYERS)
            throw new InvalidPlayerCount(String.format("Number of Players: %d", getNumberOfPlayers()));
        play(dice);
    }

    public void play(Dice dice) {
        for (Player player : players) {
            Boolean managePropertiesAtEndOfTurn = true;
            try {
                player.takeATurn(dice);
            } catch (GoToJail.GoToJailException e) {
                player.resetRollCounter();
                managePropertiesAtEndOfTurn = false;
            }
            if (managePropertiesAtEndOfTurn)
                player.manageProperties();
        }
    }
}
