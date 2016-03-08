package pkg.monopoly;

public class MoveForwardNext extends Card {
    private final String group;

    public MoveForwardNext( String cardText, String group) {
        setCardText(cardText);
        this.group = group;
    }

    @Override
    boolean isGetOutOfJailCard() {
        return false;
    }

    @Override
    void action(Player player)  {
        Space startingSpace = player.getSpace();
        Space endingSpace = startingSpace.searchForNextSpaceInGroup(group);
        String destination = endingSpace.getDescription();
        int numberOfSpacesToDestination = startingSpace.getNumberOfSpacesTo(destination);
        SourceOfMoveMultiplier sourceOfMoveMultiplier = endingSpace.getSourceOfMoveMultiplier();
        OwnershipMultiplier ownershipMultiplier = endingSpace.getOwnershipMultiplier();
        startingSpace.move(player,numberOfSpacesToDestination, "Card", sourceOfMoveMultiplier, ownershipMultiplier);
    }
}
