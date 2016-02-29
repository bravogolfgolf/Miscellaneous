package pkg.monopoly;

public class Keep extends Card {
    public Keep(String cardType, String cardText) {
        setCardType(cardType);
        setCardText(cardText);
    }

    @Override
    public void action(Player player) throws GoToJail.GoToJailException {
        player.addCard(this);
    }
}
