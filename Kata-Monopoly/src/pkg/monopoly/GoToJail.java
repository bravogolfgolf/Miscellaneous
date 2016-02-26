package pkg.monopoly;

public class GoToJail extends Space {

    public GoToJail(String description) {
        setDescription(description);
    }

    public class GoToJailException extends Exception {
    }

    @Override
    public void landOn(Player player) throws GoToJailException {
        player.setSpace(searchForSpace(player, Jail.class.getSimpleName()));
        throw new GoToJailException();
    }
}
