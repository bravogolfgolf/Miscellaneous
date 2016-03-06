package pkg.monopoly;

public class Chance extends Space {
    public Chance(String description) {
        setDescription(description);
    }

    @Override
    public void landOn(Player player, String sourceOfMove)  {
        Card card = Card.drawCard("Chance");
        card.action(player);
    }
}
