package pkg.monopoly;

public class GetOutOfJail extends Card {
    public GetOutOfJail( String cardText) {
        setCardText(cardText);
    }

    @Override
    boolean isGetOutOfJailCard() {
        return true;
    }

    @Override
    public void action(Player player) throws GoToJail.GoToJailException {
        player.addCard(this);
    }
}
