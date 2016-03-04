package pkg.monopoly;

import java.util.List;

public class Transaction extends Card {
    private int amount = 0;
    private String recipient = "";

    public Transaction(String cardType, String cardText, int amount, String recipient) {
        setCardType(cardType);
        setCardText(cardText);
        this.amount = amount;
        this.recipient = recipient;
    }

    @Override
    boolean isGetOutOfJailCard() {
        return false;
    }

    @Override
    public void action(Player player) throws GoToJail.GoToJailException {
        if (recipient.equals("Bank"))
            player.changeCashBalanceBy(amount);
        if (recipient.equals("Players")) {
            List<Player> otherPlayers = player.getAllOtherPlayersInGame();
            int thisPlayersAmount = determineHowMuchThisPlayerCollectsOrPays(otherPlayers);
            player.changeCashBalanceBy(thisPlayersAmount);
            for (Player otherPlayer : otherPlayers) otherPlayer.changeCashBalanceBy(-amount);
        }
    }

    private int determineHowMuchThisPlayerCollectsOrPays(List<Player> otherPlayers) {
        return amount * otherPlayers.size();
    }

}
