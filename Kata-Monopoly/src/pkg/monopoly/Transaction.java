package pkg.monopoly;

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
        player.changeCashBalanceBy(amount);
    }
}
