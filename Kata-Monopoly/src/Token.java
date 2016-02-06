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
        int startingLocation = getLocation();
        return startingLocation + numberRolled > Game.LAST_LOCATION_ON_BOARD;
    }

    private void moveTokenForwardByWrappingWith(int numberRolled) {
        int startingLocation = getLocation();
        int sizeOfBoard = Game.SIZE_ON_BOARD;
        int newLocation = startingLocation + numberRolled - sizeOfBoard;
        setLocation(newLocation);
    }

    private void moveTokenForwardBy(int numberRolled) {
        int startingLocation = getLocation();
        int newLocation = startingLocation + numberRolled;
        setLocation(newLocation);
    }
}
