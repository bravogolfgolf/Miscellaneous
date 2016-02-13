package pkg.monopoly;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Game {

    public static final String HOW_MANY_PLAYERS = "How many player (2-8)?";
    public static final String INVALID_NUMBER_OF_PLAYERS = "Please select 2 to 8 players.";
    public static final int MINIMUM_NUMBER_OF_PLAYERS = 2;
    public static final int MAXIMUM_NUMBER_OF_PLAYERS = 8;
    private final BufferedReader reader;
    private final BufferedWriter writer;
    private int numberOfPlayers = 0;

    public Game(BufferedReader reader, BufferedWriter writer) {
        this.reader = reader;
        this.writer = writer;
    }

    public void run() throws IOException {
        setInitialNumberOfPlayers();

    }

    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    private void setInitialNumberOfPlayers() throws IOException {
        String line;
        int players;
        boolean unacceptableNumberOfPlayersEntered = true;

        do {
            write(HOW_MANY_PLAYERS);
            line = reader.readLine();
            players = Integer.parseInt(line);
            if (players >= MINIMUM_NUMBER_OF_PLAYERS && players <= MAXIMUM_NUMBER_OF_PLAYERS) {
                numberOfPlayers = players;
                unacceptableNumberOfPlayersEntered = false;
            } else {
                write(INVALID_NUMBER_OF_PLAYERS);
            }
        } while (unacceptableNumberOfPlayersEntered);



    }

    private void write(String s) throws IOException {
        writer.write(s, 0, s.length());
        writer.flush();
    }
}
