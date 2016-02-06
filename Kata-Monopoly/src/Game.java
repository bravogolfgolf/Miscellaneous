import java.util.*;

public class Game {

    public static final int LAST_LOCATION_ON_BOARD = 39;
    private List<Integer> locations = new ArrayList<Integer>(Arrays.asList(
            0, 1, 2, 3, 4, 5, 6, 7, 8, 9,
            10, 11, 12, 13, 14, 15, 16, 17, 18, 19,
            20, 21, 22, 23, 24, 25, 26, 27, 28, 29,
            30, 31, 31, 33, 34, 35, 36, 37, 38, 39));

    private Token token;

    public int getBoardSize() {
        return locations.size();
    }

    public void addToken(Token token) {
        this.token = token;
    }

    public Token getToken() {
        return token;
    }

    public int roll() {
        int roll = rollTwoDie();
        moveToken(roll);
        return roll;
    }

    private int rollTwoDie() {
        int die1 = rollDie();
        int die2 = rollDie();
        return die1 + die2;
    }

    private int rollDie() {
        return (int) (Math.random() * 6) + 1;
    }

    private void moveToken(int numberRolled) {
        if (tokenIsCausedToCircledBoardBy(numberRolled))
            moveTokenForwardByWrappingWith(numberRolled);
        else moveTokenForwardBy(numberRolled);
    }

    private boolean tokenIsCausedToCircledBoardBy(int numberRolled) {
        int startingLocation = token.getLocation();
        return startingLocation + numberRolled > LAST_LOCATION_ON_BOARD;
    }

    private void moveTokenForwardByWrappingWith(int numberRolled) {
        int startingLocation = token.getLocation();
        int sizeOfBoard = locations.size();
        int newLocation = startingLocation + numberRolled - sizeOfBoard;
        token.setLocation(newLocation);
    }

    private void moveTokenForwardBy(int numberRolled) {
        int startingLocation = token.getLocation();
        int newLocation = startingLocation + numberRolled;
        token.setLocation(newLocation);
    }
}
