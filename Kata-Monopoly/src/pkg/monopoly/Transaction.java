package pkg.monopoly;

import java.util.List;

public class Transaction extends Card {
    private int amount = 0;
    private String recipient = "";

    public Transaction( String cardText, int amount, String recipient) {
        setCardText(cardText);
        this.amount = amount;
        this.recipient = recipient;
    }

    @Override
    boolean isGetOutOfJailCard() {
        return false;
    }

    @Override
    public void action(Player player)  {
        if (recipient.equals("Bank"))
            player.transaction(amount, "Cash");
        if (recipient.equals("Players")) {
            List<Player> otherPlayers = player.getAllOtherPlayersInGame();
            int thisPlayersAmount = determineHowMuchThisPlayerCollectsOrPays(otherPlayers);
            player.transaction(thisPlayersAmount, "Cash");
            for (Player otherPlayer : otherPlayers) otherPlayer.transaction(-amount, "Cash");
        }
    }

    private int determineHowMuchThisPlayerCollectsOrPays(List<Player> otherPlayers) {
        return amount * otherPlayers.size();
    }

}