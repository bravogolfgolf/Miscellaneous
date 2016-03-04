package pkg.monopoly;

public class MoveJail extends Card {
    private String destination;

    public MoveJail(String cardType, String cardText, String destination) {
        setCardType(cardType);
        setCardText(cardText);
        this.destination = destination;
    }

    @Override
    boolean isGetOutOfJailCard() {
        return false;
    }

    @Override
    void action(Player player) throws GoToJail.GoToJailException {
        Space space = player.getSpace();
        Space goToJail = space.searchForSpaceByDescription(destination);
        goToJail.landOn(player);
    }
}
