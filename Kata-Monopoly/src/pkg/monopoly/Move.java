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
}
