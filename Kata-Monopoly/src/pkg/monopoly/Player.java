package pkg.monopoly;

public class Player {
    private int cashBalance = 0;
    private Token token = null;

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

}
