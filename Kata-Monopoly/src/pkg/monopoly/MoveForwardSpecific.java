package pkg.monopoly;

public class MoveForwardSpecific extends Card {
    private final String destination;

    public MoveForwardSpecific( String cardText, String destination) {
        setCardText(cardText);
        this.destination = destination;
    }

    @Override
    boolean isGetOutOfJailCard() {
        return false;
    }

    @Override
    public void action(Player player)  {
        Space originalSpace = player.getSpace();
        int numberOfSpacesToDestination = originalSpace.getNumberOfSpacesTo(destination);
        originalSpace.move(player, numberOfSpacesToDestination, "Roll", new SourceOfMoveMultiplier());
    }

}
