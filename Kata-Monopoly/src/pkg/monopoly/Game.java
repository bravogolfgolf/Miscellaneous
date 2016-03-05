package pkg.monopoly;

import java.io.IOException;
import java.util.*;

public class Game {

    public Game(String localization) throws IOException {
        String spacesFileName = String.format("Spaces_%s.txt", localization);
        board = Space.load(spacesFileName);
        for (int i = 0; i < board.size() - 1; i++) {
            board.get(i).setNextSpace(board.get(i + 1));
        }
        board.get(board.size() - 1).setNextSpace(board.get(0));
        Card.addCommunityChestCards(Card.load(String.format("Chest_%s.txt", localization)));
        Card.addChanceCards(Card.load(String.format("Chance_%s.txt", localization)));
    }

    public class InvalidPlayerCount extends Exception {

        public InvalidPlayerCount(String message) {
            super(message);
        }

    }

    public static final int MINIMUM_NUMBER_OF_PLAYERS = 2;
    public static final int MAXIMUM_NUMBER_OF_PLAYERS = 8;
    private List<Space> board;
    List<Player> players = new ArrayList<Player>();
    Dice dice = new Dice();

    public List<Space> getBoard() {
        return board;
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public Player getPlayer(int index) {
        return players.get(index);
    }

    public int getNumberOfPlayers() {
        return players.size();
    }

    public void randomizePlayerOrder() {
        Collections.shuffle(players);
    }

    public void start() throws InvalidPlayerCount {
        if (getNumberOfPlayers() < MINIMUM_NUMBER_OF_PLAYERS ||
                getNumberOfPlayers() > MAXIMUM_NUMBER_OF_PLAYERS)
            throw new InvalidPlayerCount(String.format("Number of Players: %d", getNumberOfPlayers()));
        randomizePlayerOrder();
        Card.randomizeCardOrder();
        play(dice);
    }

    public void play(Dice dice) {
        for (Player player : players) {
            Boolean managePropertiesAtEndOfTurn = true;
            try {
                player.takeATurn(dice);
            } catch (GoToJail.GoToJailException e) {
                Space space = player.getSpace();
                player.setSpace(space.searchForSpaceByDescription("Just Visiting/Jail"));
                player.setInJail(true);
                player.resetRollCounter();
                managePropertiesAtEndOfTurn = false;
            }
            if (managePropertiesAtEndOfTurn)
                player.manageProperties();
        }
    }
}
