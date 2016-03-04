package pkg.monopoly;

public class Chance extends Space {
    public Chance(String description) {
        setDescription(description);
    }

    @Override
    public void landOn(Player player) throws GoToJail.GoToJailException {
        Card card = Card.drawChanceCard();
        card.action(player);
        if (card.isNotGetOfOfJailCard())
            Card.replaceChanceCard(card);
    }
}
