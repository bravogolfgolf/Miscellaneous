package pkg.monopoly;

public class Move extends Card {
    private String cardSpace;

    public Move(String cardType, String cardText, String space) {
        setCardType(cardType);
        setCardText(cardText);
        setCardSpace(space);
    }

    public void setCardSpace(String cardSpace) {
        this.cardSpace = cardSpace;
    }

    public String getCardSpace() {
        return cardSpace;
    }

    public void action(Player player) throws GoToJail.GoToJailException {
        Space space = Space.searchForSpace(player, cardSpace);
        player.setSpace(space);
        space.landOn(player);
    }
}
