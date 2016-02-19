package pkg.monopoly;

public class PlayerMockCashBalanceCounter extends Player {
    public int changeCashBalanceBy = 0;

    @Override
    public void changeCashBalanceBy(int cash) {
        changeCashBalanceBy++;
    }
}
