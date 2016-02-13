package pkg.monopoly;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.*;

public class Game {

    public static final String HOW_MANY_PLAYERS = "How many player (2-8)?";
    public static final String INVALID_NUMBER_OF_PLAYERS = "Please select 2 to 8 players.";
    public static final String SELECT_TOKEN = "Select token for player %d.";
    public static final int MINIMUM_NUMBER_OF_PLAYERS = 2;
    public static final int MAXIMUM_NUMBER_OF_PLAYERS = 8;
    private final BufferedReader reader;
    private final BufferedWriter writer;
    private List<Token> tokens = new ArrayList<Token>(
            Arrays.asList(Token.Boot,Token.Car,Token.Cat,Token.Dog,Token.Hat,Token.Ship,Token.Thimble,Token.Wheelbarrow));
    private Set<Player> players = new HashSet<Player>();

    public Game(BufferedReader reader, BufferedWriter writer) {
        this.reader = reader;
        this.writer = writer;
    }

    public void run() throws IOException {
        setInitialNumberOfPlayers();

    }

    private void setInitialNumberOfPlayers() throws IOException {
        int numberOfPlayers = determineNumberOfPlayers();
        randomlyAssignTokensToPlayers(numberOfPlayers);
    }

    private int determineNumberOfPlayers() throws IOException {
        String line;
        int numberOfPlayers;
        boolean unacceptableNumberOfPlayersEntered = true;

        do {
            write(HOW_MANY_PLAYERS);
            line = reader.readLine();
            numberOfPlayers = Integer.parseInt(line);
            if (numberOfPlayers >= MINIMUM_NUMBER_OF_PLAYERS && numberOfPlayers <= MAXIMUM_NUMBER_OF_PLAYERS) {
                unacceptableNumberOfPlayersEntered = false;
            } else {
                write(INVALID_NUMBER_OF_PLAYERS);
            }
        } while (unacceptableNumberOfPlayersEntered);
        return numberOfPlayers;
    }

    private void write(String s) throws IOException {
        writer.write(s, 0, s.length());
        writer.flush();
    }

    private void randomlyAssignTokensToPlayers(int numberOfPlayers) {
        for (int counter = 0; counter < numberOfPlayers; counter++) {

            int randomNumber = (int) (Math.random() * tokens.size());
            Player player = new Player(tokens.get(randomNumber).getDescription());
            tokens.remove(randomNumber);
            players.add(player);
        }
    }

    public int getNumberOfPlayers() {
        return players.size();
    }
}
