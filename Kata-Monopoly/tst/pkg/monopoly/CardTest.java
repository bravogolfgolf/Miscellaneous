package pkg.monopoly;

import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CardTest {

    public static final int NUMBER_OF_CARDS_IN_DECK = 4;
    public static final int BOTTOM_CARD = 3;

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidCard1() {
        Card.create("Invalid", "Invalid", "Invalid");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidCard2() {
        Card.create("Invalid", "Invalid", "Invalid", "Invalid");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidCard3() {
        Card.create("Invalid", "Invalid", "Invalid", 1, "Invalid");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidCard4() {
        Card.create("Invalid", "Invalid", "Invalid", 1, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testLoadCardException() throws IOException {
        Card.load("Card_EXCEPTION.txt");
    }

    @Test
    public void testCardIsGetOutOfJailCard() {
        Card card = Card.create("CommunityChest", "Instruction", "GetOutOfJail");
        assertTrue(card.isGetOutOfJailCard());
        card = Card.create("CommunityChest", "Text", "MoveBack", "Text");
        assertFalse(card.isGetOutOfJailCard());
        card = Card.create("CommunityChest", "Text", "MoveForwardNext", "Text");
        assertFalse(card.isGetOutOfJailCard());
        card = Card.create("CommunityChest", "Text", "MoveForwardSpecific", "Text");
        assertFalse(card.isGetOutOfJailCard());
        card = Card.create("CommunityChest", "Text", "MoveJail", "Text");
        assertFalse(card.isGetOutOfJailCard());
        card = Card.create("CommunityChest", "Text", "Repairs", 0, 0);
        assertFalse(card.isGetOutOfJailCard());
        card = Card.create("CommunityChest", "Text", "Transaction", 0, "Text");
        assertFalse(card.isGetOutOfJailCard());
    }

    @Test
    public void testChestCardsAreNotAlwaysInSameOrder() throws IOException {

        boolean oneTwo = false;
        boolean twoOne = false;

        for (int i = 0; i < 100; i++) {
            Card.clearCards();
            List<Card> CommunityChestCards = Card.getCommunityChestCards();
            assertEquals(0, CommunityChestCards.size());

            List<Card> mimicOutputFromCardLoadMethod = new ArrayList<Card>();
            Card card1 = Card.create("CommunityChest", "Instruction1", "MoveForwardSpecific", "Go");
            Card card2 = Card.create("CommunityChest", "Instruction2", "Transaction", 100, "Bank");

            mimicOutputFromCardLoadMethod.add(card1);
            mimicOutputFromCardLoadMethod.add(card2);

            Card.addCommunityChestCards(mimicOutputFromCardLoadMethod);
            Card.randomizeCardOrder();
            CommunityChestCards = Card.getCommunityChestCards();
            assertEquals(2, CommunityChestCards.size());

            if (CommunityChestCards.get(0).equals(card1) && CommunityChestCards.get(1).equals(card2))
                oneTwo = true;

            if (CommunityChestCards.get(0).equals(card2) && CommunityChestCards.get(1).equals(card1))
                twoOne = true;

            if (oneTwo && twoOne)
                break;
        }
        assertTrue(oneTwo && twoOne);
    }

    @Test
    public void testDrawCommunityChestCard() throws IOException {

        List<Card> communityChestCards = Card.load("Chest_TEST.txt");
        Card.addCommunityChestCards(communityChestCards);

        Card expectedTopCard = Card.create("CommunityChest", "Instruction1", "MoveForwardSpecific", "Go");
        Card topCard = Card.drawCard("Community Chest");
        Card expectedBottomCard = Card.getCommunityChestCards().get(BOTTOM_CARD);

        assertEquals(NUMBER_OF_CARDS_IN_DECK, Card.getCommunityChestCards().size());
        assertTrue(expectedTopCard.equals(topCard));
        assertTrue(topCard.equals(expectedBottomCard));
    }

    @Test
    public void testDrawChanceCard() throws IOException {
        List<Card> chanceCards = Card.load("Chance_TEST.txt");
        Card.addChanceCards(chanceCards);

        Card expectedTopCard = Card.create("Chance", "Instruction1", "MoveForwardSpecific", "Go");
        Card topCard = Card.drawCard("Chance");
        Card expectedBottomCard = Card.getChanceCards().get(BOTTOM_CARD);

        assertEquals(NUMBER_OF_CARDS_IN_DECK, Card.getChanceCards().size());
        assertTrue(expectedTopCard.equals(topCard));
        assertTrue(topCard.equals(expectedBottomCard));
    }

    @Test
    public void testChanceCardsAreNotAlwaysInSameOrder() throws IOException {

        boolean oneTwo = false;
        boolean twoOne = false;

        for (int i = 0; i < 100; i++) {
            Card.clearCards();
            List<Card> ChanceCards = Card.getChanceCards();
            assertEquals(0, ChanceCards.size());

            List<Card> mimicOutputFromCardLoadMethod = new ArrayList<Card>();
            Card card1 = Card.create("Chance", "Instruction1", "MoveForwardSpecific", "Go");
            Card card2 = Card.create("Chance", "Instruction2", "Transaction", 100, "Bank");

            mimicOutputFromCardLoadMethod.add(card1);
            mimicOutputFromCardLoadMethod.add(card2);

            Card.addChanceCards(mimicOutputFromCardLoadMethod);
            Card.randomizeCardOrder();
            ChanceCards = Card.getChanceCards();
            assertEquals(2, ChanceCards.size());

            if (ChanceCards.get(0).equals(card1) && ChanceCards.get(1).equals(card2))
                oneTwo = true;

            if (ChanceCards.get(0).equals(card2) && ChanceCards.get(1).equals(card1))
                twoOne = true;

            if (oneTwo && twoOne)
                break;
        }
        assertTrue(oneTwo && twoOne);
    }

    @Test
    public void testReadOfCardDefinitionFile() throws IOException {
        final String filename = "Chest_TEST.txt";
        List<Card> expected = new ArrayList<Card>();
        List<Card> actual;
        expected.add(Card.create("CommunityChest", "Instruction1", "MoveForwardSpecific", "Go"));
        expected.add(Card.create("CommunityChest", "Instruction2", "Transaction", 100, "Bank"));
        expected.add(Card.create("CommunityChest", "Instruction2", "GetOutOfJail"));
        expected.add(Card.create("CommunityChest", "Instruction2", "Repairs", 40, 115));
        actual = Card.load(filename);
        assertEquals(expected.size(), actual.size());
        assertTrue(expected.equals(actual));
        for (int index = 0; index < expected.size(); index++) {
            assertTrue(expected.get(index).equals(actual.get(index)));
        }
    }

    @Test
    public void testHashcode() {
        MoveForwardSpecific move1 = (MoveForwardSpecific) Card.create("CommunityChest", "Instruction1", "MoveForwardSpecific", "Go");
        MoveForwardSpecific move2 = (MoveForwardSpecific) Card.create("CommunityChest", "Instruction1", "MoveForwardSpecific", "Go");
        assertEquals(move1.hashCode(), move2.hashCode());
    }
}
