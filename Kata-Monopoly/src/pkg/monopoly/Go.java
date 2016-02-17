package pkg.monopoly;

public class Go extends Space {

    public Go(String description) {
        super(description);
    }

    @Override
    public void landOn(Player player) {
        player.increaseCashBalanceBy(200);
    }

    @Override
    public void passBy(Player player) {
        landOn(player);
    }
}
