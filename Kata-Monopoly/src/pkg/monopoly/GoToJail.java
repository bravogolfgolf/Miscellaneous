package pkg.monopoly;

public class GoToJail extends Space {

    public GoToJail(String description) {
        setDescription(description);
    }

    public class GoToJailException extends Exception {
    }

    @Override
    public void landOn(Player player) throws GoToJailException {
        Space space = player.getSpace();
        player.setSpace(space.searchForSpaceByDescription("Just Visiting/Jail"));
        throw new GoToJailException();
    }
}
