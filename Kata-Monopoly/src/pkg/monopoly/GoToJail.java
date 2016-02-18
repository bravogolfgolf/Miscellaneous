package pkg.monopoly;

public class GoToJail extends Space {

    private Space jail = new Space("Jail");

    public GoToJail(String description) {
        super(description);
    }

    @Override
    public void landOn(Player player) {
        player.setSpace(jail);
    }
}
