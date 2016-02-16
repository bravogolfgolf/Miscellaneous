package pkg.monopoly;

public class Player {
    public static final int GO = 0;
    private int cashBalance = 0;
    private Token token = null;
    private boolean salaryFlag = false;

    public Player(Token token) {
        this.token = token;
        this.cashBalance = 1500;
    }

    public String getTokenDescription() {
        return token.getDescription();
    }

    public int getTokenLocation() {
        return token.getLocation();
    }

    public void setTokenLocation(int location) {
        this.token.setLocation(location);
    }

    public int getCashBalance() {
        return cashBalance;
    }

    public void takeATurn(Dice dice) {
        dice.rollTwoDie();
        int numberRolled = dice.getTwoDieRollValue();
        determineHowToMoveTokenForwardBy(numberRolled);
    }

    private void determineHowToMoveTokenForwardBy(int numberRolled) {
        if (tokenIsCausedToCircledBoardBy(numberRolled))
            moveTokenForwardByWrappingWith(numberRolled);
        else moveTokenForwardBy(numberRolled);
    }

    private boolean tokenIsCausedToCircledBoardBy(int numberRolled) {
        return this.token.getLocation() + numberRolled > Board.LAST_LOCATION_ON_BOARD;
    }

    private void moveTokenForwardByWrappingWith(int numberRolled) {
        this.token.setLocation(this.token.getLocation() + numberRolled - Board.SIZE_ON_BOARD);
        setSalaryFlag();
    }

    private void setSalaryFlag() {
        salaryFlag = this.token.getLocation() != GO;
    }

    private void moveTokenForwardBy(int numberRolled) {
        this.token.setLocation(this.token.getLocation() + numberRolled);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Player player = (Player) o;

        return token != null ? token.equals(player.token) : player.token == null;

    }

    @Override
    public int hashCode() {
        return token != null ? token.hashCode() : 0;
    }

    public void increaseCashBalanceBy(int cash) {
        cashBalance += cash;
    }

    public boolean getSalaryFlag() {
        return salaryFlag;
    }

    public void setSalaryFlag(boolean salaryFlag) {
        this.salaryFlag = salaryFlag;
    }
}
