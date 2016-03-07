package pkg.monopoly;

public class GoToJail extends Space {

    public GoToJail(String description) {
        setDescription(description);
    }

    public class GoToJailException extends RuntimeException {
    }

    @Override
    public void landOn(Player player, String sourceOfMove, SourceOfMoveMultiplier sourceOfMoveMultiplier){
        throw new GoToJailException();
    }
}
