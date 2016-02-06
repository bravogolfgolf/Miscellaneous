import java.util.*;

public class Game {

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
        int die1 = (int)(Math.random()*6) + 1;
        int die2 = (int)(Math.random()*6) + 1;
        return die1 + die2;
    }

    private void moveToken(int number) {
        token.setLocation(token.getLocation() + number);
    }
}
