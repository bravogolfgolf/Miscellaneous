package pkg.monopoly;

public class CommunityChest extends Space {
    public CommunityChest(String description) {
        setDescription(description);
    }

    @Override
    public void landOn(Player player, String sourceOfMove) throws GoToJail.GoToJailException {
        Card card = Card.drawCard("Community Chest");
        card.action(player);
    }

}
