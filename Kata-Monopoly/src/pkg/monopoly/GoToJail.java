package pkg.monopoly;

public class GoToJail extends Space {

    public GoToJail(String description) {
        super.setDescription(description);
    }

    @Override
    public void landOn(Player player) {
        player.setSpace(searchForSpace(player, "Jail"));
    }
}
