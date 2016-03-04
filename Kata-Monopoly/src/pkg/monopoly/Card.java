package pkg.monopoly;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Card {

    private String cardText;
    private static List<Card> communityChestCards = new ArrayList<Card>();
    private static List<Card> chanceCards = new ArrayList<Card>();

    public static Card create(String cardText, String classType, String space) {
        if (classType.equals("MoveForwardNext")) return new MoveForwardNext(cardText, space);
        if (classType.equals("MoveForwardSpecific")) return new MoveForwardSpecific(cardText, space);
        if (classType.equals("MoveJail")) return new MoveJail(cardText, space);
        throw new IllegalArgumentException();
    }

    public static Card create(String cardText, String classType, int amount, String recipient) {
        if (classType.equals("Transaction")) return new Transaction(cardText, amount, recipient);
        throw new IllegalArgumentException();
    }

    public static Card create(String cardText, String classType, int house, int hotel) {
        if (classType.equals("Repairs")) return new Repair(cardText, house, hotel);
        throw new IllegalArgumentException();
    }

    public static Card create(String cardText, String classType) {
        if (classType.equals("MoveBack")) return new MoveBack(cardText);
        if (classType.equals("GetOutOfJail")) return new GetOutOfJail(cardText);
        throw new IllegalArgumentException();
    }

    abstract boolean isGetOutOfJailCard();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Card card = (Card) o;

        return cardText.equals(card.cardText);

    }

    @Override
    public int hashCode() {
        return cardText.hashCode();
    }

    public void setCardText(String cardText) {
        this.cardText = cardText;
    }

    public static void addCommunityChestCards(List<Card> communityChestCards) {
        Card.communityChestCards = communityChestCards;
    }

    public static List<Card> getCommunityChestCards() {
        return communityChestCards;
    }

    public static void addChanceCards(List<Card> chanceCards) {
        Card.chanceCards = chanceCards;
    }

    public static List<Card> getChanceCards() {
        return chanceCards;
    }

    public static void randomizeCardOrder() {
        Collections.shuffle(communityChestCards);
        Collections.shuffle(chanceCards);
    }

    public static void clearCards() {
        communityChestCards.clear();
        chanceCards.clear();
    }

    static Card drawCard(String deck) {
        Card card = null;
        if (deck.equals("Community Chest")) {
            card = communityChestCards.remove(0);
            if (isNotGetOutOfJail(card))
                communityChestCards.add(card);
        }

        if (deck.equals("Chance")) {
            card = chanceCards.remove(0);
            if (isNotGetOutOfJail(card))
                chanceCards.add(card);
        }
        return card;
    }

    private static boolean isNotGetOutOfJail(Card card) {
        return !card.isGetOutOfJailCard();
    }

    abstract void action(Player player) throws GoToJail.GoToJailException;

    public static List<Card> load(String filename) throws IOException {
        List<String> content = Files.readAllLines(Paths.get(filename));
        List<Card> cards = new ArrayList<Card>();
        for (String line : content) {
            String[] tokens = line.split(";");
            if (tokens[1].equals("GetOutOfJail"))
                cards.add(Card.create(tokens[0], tokens[1]));
            else if (tokens[1].equals("MoveForwardSpecific"))
                cards.add(Card.create(tokens[0], tokens[1], tokens[2]));
            else if (tokens[1].equals("MoveForwardNext"))
                cards.add(Card.create(tokens[0], tokens[1], tokens[2]));
            else if (tokens[1].equals("MoveBack"))
                cards.add(Card.create(tokens[0], tokens[1]));
            else if (tokens[1].equals("MoveJail"))
                cards.add(Card.create(tokens[0], tokens[1], tokens[2]));
            else if (tokens[1].equals("Repairs"))
                cards.add(Card.create(tokens[0], tokens[1], Integer.parseInt(tokens[2]), Integer.parseInt(tokens[3])));
            else if (tokens[1].equals("Transaction"))
                cards.add(Card.create(tokens[0], tokens[1], Integer.parseInt(tokens[2]), tokens[3]));
            else throw new IllegalArgumentException();
        }
        return cards;
    }

}