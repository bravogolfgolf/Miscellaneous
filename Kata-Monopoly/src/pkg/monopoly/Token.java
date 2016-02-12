package pkg.monopoly;

public class Token {

    private String token = "";
    private int location;

    public Token(String token) {
        this.token = token;
        this.location = 0;
    }

    public String getTokenDescription() {
        return token;
    }

    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
    }

    public int roll() {
        int numberRolled = rollTwoDie();
        determineHowToMoveTokenForwardBy(numberRolled);
        return numberRolled;
    }

    private int rollTwoDie() {
        int die1 = rollDie();
        int die2 = rollDie();
        return die1 + die2;
    }

    private int rollDie() {
        return (int) (Math.random() * 6) + 1;
    }

    private void determineHowToMoveTokenForwardBy(int numberRolled) {
        if (tokenIsCausedToCircledBoardBy(numberRolled))
            moveTokenForwardByWrappingWith(numberRolled);
        else moveTokenForwardBy(numberRolled);
    }

    private boolean tokenIsCausedToCircledBoardBy(int numberRolled) {
        return location + numberRolled > Board.LAST_LOCATION_ON_BOARD;
    }

    private void moveTokenForwardByWrappingWith(int numberRolled) {
        location += numberRolled - Board.SIZE_ON_BOARD;
    }

    private void moveTokenForwardBy(int numberRolled) {
        location += numberRolled;
    }
}
