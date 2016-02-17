package pkg.monopoly;

import java.util.List;

public class Player {
    private int cashBalance = 0;
    private Space location;

    public Player() {
        this.location = new Go("Go");
        this.cashBalance = 1500;
    }

    public Space getLocation() {
        return location;
    }

    public void setLocation(Space location) {
        this.location = location;
    }

    public int getCashBalance() {
        return cashBalance;
    }

    public void takeATurn(Dice dice) {
        Board board = new Board();
        List<Space> navigationList;
        dice.rollTwoDie();
        int numberRolled = dice.getTwoDieRollValue();
        navigationList = board.getNavigationList(this);
        for (int i = 0; i <= numberRolled; i++) {
            setLocation(navigationList.get(i));
        }
    }

    public void increaseCashBalanceBy(int cash) {
        cashBalance += cash;
    }

}
