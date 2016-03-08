package pkg.monopoly;

public class MoveJail extends Card {
    private final String destination;

    public MoveJail( String cardText, String destination) {
        setCardText(cardText);
        this.destination = destination;
    }

    @Override
    boolean isGetOutOfJailCard() {
        return false;
    }

    @Override
    void action(Player player) {
        Space space = player.getSpace();
        Space goToJail = space.searchForSpaceByDescription(destination);
        goToJail.landOn(player, "Roll", new SourceOfMoveMultiplier(), new OwnershipMultiplier());}
}
