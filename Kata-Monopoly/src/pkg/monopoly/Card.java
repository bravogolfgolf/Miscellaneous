package pkg.monopoly;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Card {

    private String cardType;
    private String cardText;

    public static Card create(String cardType, String cardText, String classType, String space) {
        if (classType.equals("Move")) return new Move(cardType, cardText, space);
        throw new IllegalArgumentException();
    }

    public static Card create(String cardType, String cardText, String classType, int amount, String recipient) {
        if (classType.equals("Transaction")) return new Transaction(cardType, cardText, amount, recipient);
        throw new IllegalArgumentException();
    }

    public static Card create(String cardType, String cardText, String classType, int house, int hotel) {
        if (classType.equals("Repairs")) return new Repair(cardType, cardText, house, hotel);
        throw new IllegalArgumentException();
    }

    public static Card create(String cardType, String cardText, String classType) {
        if (classType.equals("Keep")) return new Keep(cardType, cardText);
        throw new IllegalArgumentException();
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public void setCardText(String cardText) {
        this.cardText = cardText;
    }

    public static List<Card> load(String filename) throws IOException {
        List<String> content = Files.readAllLines(Paths.get(filename));
        List<Card> cards = new ArrayList<Card>();
        for (String line : content) {
            String[] tokens = line.split(";");
            if (tokens[2].equals("Keep"))
                cards.add(Card.create(tokens[0], tokens[1], tokens[2]));
            if (tokens[2].equals("Move"))
                cards.add(Card.create(tokens[0], tokens[1], tokens[2], tokens[3]));
            if (tokens[2].equals("Repairs"))
                cards.add(Card.create(tokens[0], tokens[1], tokens[2], Integer.parseInt(tokens[3]), Integer.parseInt(tokens[4])));
            if (tokens[2].equals("Transaction"))
                cards.add(Card.create(tokens[0], tokens[1], tokens[2], Integer.parseInt(tokens[3]), tokens[4]));
        }
        return cards;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Card card = (Card) o;

        return cardType.equals(card.cardType) && cardText.equals(card.cardText);

    }

    @Override
    public int hashCode() {
        int result = cardType.hashCode();
        result = 31 * result + cardText.hashCode();
        return result;
    }
}

