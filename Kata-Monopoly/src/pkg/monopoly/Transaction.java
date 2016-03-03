package pkg.monopoly;

import java.util.ArrayList;
import java.util.List;

public class Transaction extends Card {
    private int amount = 0;
    private String recipient = "";

    public Transaction(String cardType, String cardText, int amount, String recipient) {
        setCardType(cardType);
        setCardText(cardText);
        setAmount(amount);
        setRecipient(recipient);
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    @Override
    public void action(Player player) throws GoToJail.GoToJailException {
        if (recipient.equals("Bank"))
            player.changeCashBalanceBy(amount);
        if (recipient.equals("Players")) {
            List<Player> otherPlayers = getAllOtherPlayersInGame(player);
            int multipleAmount = amount * otherPlayers.size();
            player.changeCashBalanceBy(multipleAmount);
            for (Player otherPlayer : otherPlayers) {
                otherPlayer.changeCashBalanceBy(-amount);
            }
        }
    }

    private List<Player> getAllOtherPlayersInGame(Player player) {
        List<Player> otherPlayers = new ArrayList<Player>();
        Player currentPlayer = player;
        Player nextPlayer = currentPlayer.getNextPlayer();
        while (!nextPlayer.equals(player)) {
            otherPlayers.add(nextPlayer);
            currentPlayer = nextPlayer;
            nextPlayer = currentPlayer.getNextPlayer();
        }
        return otherPlayers;
    }
}
