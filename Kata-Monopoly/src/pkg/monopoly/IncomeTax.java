package pkg.monopoly;

public class IncomeTax extends Space {

    public IncomeTax(String description) {
        setDescription(description);
    }

    @Override
    public void landOn(Player player) {
        final double TEN_PERCENT = .10;

        int tax;
        if (player.getCashBalance() <= 2000)
            tax = (int) (player.getCashBalance() * TEN_PERCENT);
        else tax = 200;
        player.increaseCashBalanceBy(-tax);
    }
}
