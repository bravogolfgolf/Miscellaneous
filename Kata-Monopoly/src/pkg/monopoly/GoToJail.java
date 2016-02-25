package pkg.monopoly;

public class GoToJail extends Space {

    public GoToJail(String description) {
        setDescription(description);
    }

    @Override
    public void landOn(Player player, int rollValue) {
        player.setSpace(searchForSpace(player, Jail.class.getSimpleName()));
    }
}
