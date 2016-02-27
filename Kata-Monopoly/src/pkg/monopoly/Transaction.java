package pkg.monopoly;

public class Transaction extends Card {
    private String amount;
    private String recipient;

    public Transaction(String cardType, String cardText, String amount, String recipient) {
        setCardType(cardType);
        setCardText(cardText);
        setAmount(amount);
        setRecipient(recipient);
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }
}
