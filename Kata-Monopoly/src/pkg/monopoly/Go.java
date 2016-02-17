package pkg.monopoly;

public class Go extends Space {
    public Go(int id, String description) {
        super(id, description);
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
