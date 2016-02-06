import java.util.*;

public class Game {

    public static final int SIZE_ON_BOARD = 40;
    public static final int LAST_LOCATION_ON_BOARD = 39;
    public static final int MAXIMUM_NUMBER_OF_TOKENS = 8;
    private List<Integer> locations = new ArrayList<Integer>(Arrays.asList(
            0, 1, 2, 3, 4, 5, 6, 7, 8, 9,
            10, 11, 12, 13, 14, 15, 16, 17, 18, 19,
            20, 21, 22, 23, 24, 25, 26, 27, 28, 29,
            30, 31, 31, 33, 34, 35, 36, 37, 38, 39));

    private Set<Token> tokens = new LinkedHashSet<Token>(MAXIMUM_NUMBER_OF_TOKENS);

    public int getBoardSize() {
        return locations.size();
    }

    public void addToken(Token token) {
        this.tokens.add(token);
    }

    public int getNumberOfTokens() {
        return tokens.size();
    }
}
