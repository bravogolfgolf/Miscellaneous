package pkg.monopoly;

import java.io.IOException;
import java.util.*;

public class Game {

    public Game(String spaceDefinitionFile) throws IOException {
        board = Space.load(spaceDefinitionFile);
        for (int i = 0; i < board.size() - 1; i++) {
            board.get(i).setNextSpace(board.get(i + 1));
        }
        board.get(board.size() - 1).setNextSpace(board.get(0));
    }

    public class InvalidPlayerCount extends Exception {
        public InvalidPlayerCount(String message) {
            super(message);
        }
    }

    public static final int MINIMUM_NUMBER_OF_PLAYERS = 2;
    public static final int MAXIMUM_NUMBER_OF_PLAYERS = 8;

    private Dice dice = new Dice();

    private List<Space> board;

    private List<Player> players = new ArrayList<Player>();
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

    public void setDice(Dice dice) {
        this.dice = dice;
    }

    public Dice getDice() {
        return dice;
    }

    public void start() throws InvalidPlayerCount {
        if (getNumberOfPlayers() < MINIMUM_NUMBER_OF_PLAYERS ||
                getNumberOfPlayers() > MAXIMUM_NUMBER_OF_PLAYERS)
            throw new InvalidPlayerCount(String.format("Number of Players: %d", getNumberOfPlayers()));
        play();
    }

    private void play() {
        for (Player player : players) {
            player.takeATurn(dice);
            player.manageProperties();
        }
    }
}
