package pkg.monopoly;

import java.util.*;

public class Game {

    public class InvalidPlayerCount extends Exception {

        public InvalidPlayerCount(String message) {
            super(message);
        }

    }

    public static final int MINIMUM_NUMBER_OF_PLAYERS = 2;
    public static final int MAXIMUM_NUMBER_OF_PLAYERS = 8;
    private Dice dice = new Dice();
    private List<Player> players = new ArrayList<Player>();

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

    public void play() throws InvalidPlayerCount {
        if (getNumberOfPlayers() < MINIMUM_NUMBER_OF_PLAYERS ||
                getNumberOfPlayers() > MAXIMUM_NUMBER_OF_PLAYERS)
            throw new InvalidPlayerCount(String.format("Number of Players: %d", getNumberOfPlayers()));

        for (int i = 0; i < 20; i++) {
            for (Player player : players) {
                player.manageProperties();
                player.takeATurn(dice);
                player.manageProperties();
            }
        }
    }
}
