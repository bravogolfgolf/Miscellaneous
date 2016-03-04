package pkg.monopoly;

public class MoveForwardSpecific extends Card {
    private String cardSpace;

    public MoveForwardSpecific(String cardType, String cardText, String space) {
        setCardType(cardType);
        setCardText(cardText);
        cardSpace = space;
    }

    @Override
    boolean isGetOutOfJailCard() {
        return false;
    }

    @Override
    public void action(Player player) throws GoToJail.GoToJailException {
        int numberOfSpacesToDestination = 0;
        Space originalSpace = player.getSpace();
        Space currentSpace = player.getSpace();
        Space nextSpace = currentSpace.getNextSpace();
        Space destinationSpace = Space.searchForSpace(player, cardSpace);
        while (!currentSpace.equals(destinationSpace)) {
            currentSpace = nextSpace;
            nextSpace = currentSpace.getNextSpace();
            numberOfSpacesToDestination++;
        }
        originalSpace.move(player, numberOfSpacesToDestination);
    }
}
