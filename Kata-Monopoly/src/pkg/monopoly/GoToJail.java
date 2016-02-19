package pkg.monopoly;

public class GoToJail extends Space {

    private Space jail = Space.create("Other", "Jail");

    public GoToJail(String description) {
        setDescription(description);
    }

    @Override
    public void landOn(Player player) {
        player.setSpace(jail);
    }
}
