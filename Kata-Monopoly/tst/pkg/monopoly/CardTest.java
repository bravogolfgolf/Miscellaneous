package pkg.monopoly;

import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CardTest {

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

    @Test
    public void testChestCardsAreNotAlwaysInSameOrder() throws IOException {

        boolean oneTwo = false;
        boolean twoOne = false;

        for (int i = 0; i < 100; i++) {
            Card.clearCards();
            List<Card> cards = Card.getCards();
            assertEquals(0, cards.size());
            Card card1 = Card.create("CommunityChest", "Instruction1", "Move", "Go");
            Card card2 = Card.create("CommunityChest", "Instruction2", "Transaction", 100, "Bank");
            Card.addCard(card1);
            Card.addCard(card2);
            Card.randomizeCardOrder();
            cards = Card.getCards();
            assertEquals(2, cards.size());

            if (cards.get(0).equals(card1) && cards.get(1).equals(card2))
                oneTwo = true;

            if (cards.get(0).equals(card2) && cards.get(1).equals(card1))
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
        expected.add(Card.create("CommunityChest", "Instruction1", "Move", "Go"));
        expected.add(Card.create("CommunityChest", "Instruction2", "Transaction", 100, "Bank"));
        expected.add(Card.create("CommunityChest", "Instruction2", "Keep"));
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
        Move move1 = (Move) Card.create("CommunityChest", "Instruction1", "Move", "Go");
        Move move2 = (Move) Card.create("CommunityChest", "Instruction1", "Move", "Go");
        assertEquals(move1.hashCode(), move2.hashCode());
    }
}
