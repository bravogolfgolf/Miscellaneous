package pkg.monopoly;

public class PlayerMockDoesNotPaySelfRent extends Player {
    public int changeCashBalanceBy = 0;

    public PlayerMockDoesNotPaySelfRent() {
        super("PlayerMockDoesNotPaySelfRent");
    }

    @Override
    public void transaction(int amount, String transactionType) {
        changeCashBalanceBy++;
    }
}
