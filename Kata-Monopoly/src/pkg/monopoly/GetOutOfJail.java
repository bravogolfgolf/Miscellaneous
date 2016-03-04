package pkg.monopoly;

public class GetOutOfJail extends Card {
    public GetOutOfJail(String cardType, String cardText) {
        setCardType(cardType);
        setCardText(cardText);
    }

    @Override
    public void action(Player player) throws GoToJail.GoToJailException {
        player.addCard(this);
    }
}
