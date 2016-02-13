package pkg.monopoly;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Game {

    public static final String HOW_MANY_PLAYERS = "How many player (2-8)?";
    public static final String INVALID_NUMBER_OF_PLAYERS = "Please select 2 to 8 players.";
    private final BufferedReader reader;
    private final BufferedWriter writer;

    public Game(BufferedReader reader, BufferedWriter writer) {
        this.reader = reader;
        this.writer = writer;
    }

    public void run() throws IOException {
        determineNumberOfPlayers();
    }

    private void determineNumberOfPlayers() throws IOException {
        String line;
        int players;
        boolean unacceptableNumberOfPlayersEntered = true;

        do{
           write(HOW_MANY_PLAYERS);
           line = reader.readLine();
           players = Integer.parseInt(line);
           if (players >= 2 && players <= 8) {
               unacceptableNumberOfPlayersEntered = false;
           } else {
               write(INVALID_NUMBER_OF_PLAYERS);
           }
       }while(unacceptableNumberOfPlayersEntered);
    }

    private void write(String s) throws IOException {
        writer.write(s, 0, s.length());
        writer.flush();
    }

    public int getNumberOfPlayers() {
        return 0;
    }
}
