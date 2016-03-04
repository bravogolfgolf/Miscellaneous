package pkg.monopoly;

public class MoveForwardSpecific extends Card {
    private String cardSpace;

    public MoveForwardSpecific(String cardType, String cardText, String space) {
        setCardType(cardType);
        setCardText(cardText);
        this.cardSpace = space;
    }

    @Override
    public void action(Player player) throws GoToJail.GoToJailException {
    }
}
