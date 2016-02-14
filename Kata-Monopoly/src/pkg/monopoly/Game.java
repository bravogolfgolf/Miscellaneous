package pkg.monopoly;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.*;

public class Game {

    public static final String HOW_MANY_PLAYERS = "How many player (2-8)?";
    public static final String INVALID_NUMBER_OF_PLAYERS = "Please select 2 to 8 players.";
    public static final String SELECT_TOKEN = "Select token for player %d.";
    public static final String INVALID_TOKEN_LETTER = "Please select a valid letter corresponding to one of the remaining tokens.";
    public static final int MINIMUM_NUMBER_OF_PLAYERS = 2;
    public static final int MAXIMUM_NUMBER_OF_PLAYERS = 8;
    private final BufferedReader reader;
    private final BufferedWriter writer;
    private List<MenuItems> tokenMenuItems = new ArrayList<MenuItems>(
            Arrays.asList(MenuItems.Boot, MenuItems.Car, MenuItems.Cat, MenuItems.Dog, MenuItems.Hat, MenuItems.Ship, MenuItems.Thimble, MenuItems.Wheelbarrow));
    private List<Player> players = new ArrayList<Player>();

    public Game(BufferedReader reader, BufferedWriter writer) {
        this.reader = reader;
        this.writer = writer;
    }

    public void run() throws IOException {
        gameSetup();

    }

    private void gameSetup() throws IOException {
        int numberOfPlayers = determineNumberOfPlayers();
        playersChooseTokens(numberOfPlayers);
        randomizeStartingOrder();
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

    private void playersChooseTokens(int numberOfPlayers) throws IOException {

        for (int playerNumber = 1; playerNumber <= numberOfPlayers; playerNumber++) {
            int tokenIndex;
            tokenIndex = getIndexOfTokenSelectedBy(playerNumber);
            assignTokenToPlayer(tokenIndex);
            removeTokenSoFollowingPlayerManyNotChooseIt(tokenIndex);
        }
    }

    private int getIndexOfTokenSelectedBy(int playerNumber) throws IOException {
        String line;
        String tokenLetter;
        int tokenIndex = -1;
        boolean unacceptableTokenLetterIsEntered = true;

        do {
            write(String.format(SELECT_TOKEN, playerNumber));
            writeRemainingTokens();
            line = reader.readLine();
            tokenLetter = line.toUpperCase();

            for (int counter = 0; counter < tokenMenuItems.size(); counter++) {
                if (tokenMenuItems.get(counter).getTokenLetter().equals(tokenLetter)) {
                    tokenIndex = counter;
                    unacceptableTokenLetterIsEntered = false;
                }
            }

            if (unacceptableTokenLetterIsEntered)
                write(INVALID_TOKEN_LETTER);

        } while (unacceptableTokenLetterIsEntered);
        return tokenIndex;
    }

    private void writeRemainingTokens() throws IOException {
        String commaSpace = ", ";
        String remainingTokens = tokenMenuItems.get(0).getMenuString();
        for (int index = 1; index < tokenMenuItems.size(); index++) {
            remainingTokens += commaSpace;
            remainingTokens += tokenMenuItems.get(index).getMenuString();
        }
        write(remainingTokens);
    }

    private void assignTokenToPlayer(int tokenIndex) {
        Token token = new Token(tokenMenuItems.get(tokenIndex).getDescription());
        players.add(new Player(token));
    }

    private void removeTokenSoFollowingPlayerManyNotChooseIt(int tokenIndex) {
        tokenMenuItems.remove(tokenIndex);
    }

    private void randomizeStartingOrder() {
        Collections.shuffle(players);
    }

    public int getNumberOfPlayers() {
        return players.size();
    }

    public Player getPlayer(int index) {
        return players.get(index);
    }

    private void write(String s) throws IOException {
        writer.write(s, 0, s.length());
        writer.flush();
    }
}
