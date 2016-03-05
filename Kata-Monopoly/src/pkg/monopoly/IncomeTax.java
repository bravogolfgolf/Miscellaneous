package pkg.monopoly;

public class IncomeTax extends Space {

    public IncomeTax(String description) {
        setDescription(description);
    }

    @Override
    public void landOn(Player player, String sourceOfMove) {
        final double TEN_PERCENT = .10;

        int tax;
        if (player.getNetWorth() <= 2000)
            tax = (int) (player.getNetWorth() * TEN_PERCENT);
        else tax = 200;
        player.transaction(-tax, "Cash");
    }
}
