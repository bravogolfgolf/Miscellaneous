package pkg.monopoly;

public class MoveForwardSpecific extends Card {
    private String destination;

    public MoveForwardSpecific( String cardText, String destination) {
        setCardText(cardText);
        this.destination = destination;
    }

    @Override
    boolean isGetOutOfJailCard() {
        return false;
    }

    @Override
    public void action(Player player) throws GoToJail.GoToJailException {
        Space originalSpace = player.getSpace();
        int numberOfSpacesToDestination = originalSpace.getNumberOfSpacesTo(destination);
        originalSpace.move(player, numberOfSpacesToDestination, "Roll");
    }

}
