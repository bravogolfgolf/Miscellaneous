package pkg.monopoly;

import com.sun.tools.javac.parser.Tokens;

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
            Arrays.asList(Token.Boot, Token.Car, Token.Cat, Token.Dog, Token.Hat, Token.Ship, Token.Thimble, Token.Wheelbarrow));
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

    private void randomlyAssignTokensToPlayers(int numberOfPlayers) throws IOException {
        String tokenLetter;
        for (int playerNumber = 1; playerNumber <= numberOfPlayers; playerNumber++) {
            write(String.format(SELECT_TOKEN, playerNumber));
            writeRemainingTokens();

            tokenLetter = reader.readLine();
            for (int counter = 0; counter < tokens.size(); counter++) {
                if (tokens.get(counter).getTokenLetter().equals(tokenLetter.toUpperCase())) {
                    String description = tokens.get(counter).getDescription();
                    players.add(new Player(description));
                    tokens.remove(counter);
                }
            }

        }
    }

    private void writeRemainingTokens() throws IOException {
        String commaSpace = ", ";
        String remainingTokens = tokens.get(0).getMenuString();
        for (int index = 1; index < tokens.size(); index++) {
            remainingTokens += commaSpace;
            remainingTokens += tokens.get(index).getMenuString();
        }
        write(remainingTokens);
    }

    public int getNumberOfPlayers() {
        return players.size();
    }
}
