package pkg.monopoly;

import java.util.*;

public class Game {

    public static final int MINIMUM_NUMBER_OF_PLAYERS = 2;
    public static final int MAXIMUM_NUMBER_OF_PLAYERS = 8;

    public class InvalidPlayerCount extends Exception {

        public InvalidPlayerCount(String message) {
            super(message);
        }
    }

    public static final Die die = new Die();

    private List<Player> players = new ArrayList<Player>();

    public void play() throws InvalidPlayerCount {
        if (getNumberOfPlayers() < MINIMUM_NUMBER_OF_PLAYERS ||
                getNumberOfPlayers() > MAXIMUM_NUMBER_OF_PLAYERS)
            throw new InvalidPlayerCount(String.format("Number of Players: %d", getNumberOfPlayers()));
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public int getNumberOfPlayers() {
        return players.size();
    }
}
