package pkg.monopoly;

import java.util.List;

public class CommunityChest extends Space {
    public CommunityChest(String description) {
        setDescription(description);
    }

    @Override
    public void landOn(Player player) throws GoToJail.GoToJailException {
        drawCard(player);
    }

    private void drawCard(Player player) throws GoToJail.GoToJailException {
        List<Card> cards = Card.getCommunityChestCards();
        Card card = cards.get(0);
        card.action(player);
    }
}
