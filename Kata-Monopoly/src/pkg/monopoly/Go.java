package pkg.monopoly;

public class Go extends Space {

    public static final int SALARY = 200;

    public Go(String description) {
        setDescription(description);
    }

    @Override
    public void landOn(Player player, String sourceOfMove) {
        collectSalary(player);
    }

    @Override
    public void passBy(Player player) {
        collectSalary(player);
    }

    private void collectSalary(Player player) {
        player.changeCashBalanceBy(SALARY);
    }
}
