package pkg.monopoly;

import java.util.*;

public class Game {

    public static final Die die = new Die();
    private List<Player> players = new ArrayList<Player>();

    public void addPlayer(Player player) {
        players.add(player);
    }

    public int getNumberOfPlayers() {
        return players.size();
    }
}
