package pkg.monopoly;

public class Player {
    private int cashBalance = 0;
    private Space space;

    public Player() {
        this.space = new Go("Go");
        this.cashBalance = 1500;
    }

    public Space getSpace() {
        return space;
    }

    public void setSpace(Space space) {
        this.space = space;
    }

    public int getCashBalance() {
        return cashBalance;
    }

    public void takeATurn(Dice dice) {
        dice.rollTwoDie();
        int numberRolled = dice.getTwoDieRollValue();
        space.move(this, numberRolled);
    }

    public void changeCashBalanceBy(int cash) {
        cashBalance += cash;
    }

}
