package pkg.monopoly;

public class CommunityChest extends Space {
    public CommunityChest(String description) {
        setDescription(description);
    }

    @Override
    public void landOn(Player player) throws GoToJail.GoToJailException {
        Card card = Card.drawCommunityChestCard();
        card.action(player);
        if (card.isNotGetOfOfJailCard())
            Card.replaceCommunityChestCard(card);
    }

}
