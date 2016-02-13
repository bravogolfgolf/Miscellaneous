package pkg.monopoly;

public class Player {
    private String token = "";

    private int location;

    public Player(String token) {
        this.token = token;
        this.location = 0;
    }

    public String getTokenDescription() {
        return token;
    }

    public int getTokenLocation() {
        return location;
    }

    public void setTokenLocation(int location) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Player player = (Player) o;

        return location == player.location && token.equals(player.token);

    }
}
