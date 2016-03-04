package pkg.monopoly;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ChanceTest {

    private Player player;
    private Chance chance;

    @Before
    public void setUp() {
        player = new Player("Cat");
        chance = (Chance) Space.create("Chance", "Chance");
    }

    @After
    public void teardown() {
        player = null;
        chance = null;
    }

    @Test
    public void testLandOn() throws GoToJail.GoToJailException {
        List<Card> cards = new ArrayList<Card>();
        Card.clearCards();
        Card card = Card.create("Instruction", "GetOutOfJail");
        cards.add(card);
        Card.addChanceCards(cards);
        int expectedEndingBalance = player.getCashBalance();
        chance.landOn(player, "Roll");
        assertEquals(expectedEndingBalance, player.getCashBalance());
        assertTrue(player.getCard().equals(card));
    }

    @Test
    public void testPassBy() {
        List<Card> cards = new ArrayList<Card>();
        Card.clearCards();
        Card card = Card.create("Instruction", "GetOutOfJail");
        cards.add(card);
        Card.addChanceCards(cards);
        int expectedEndingBalance = player.getCashBalance();
        chance.passBy(player);
        assertEquals(expectedEndingBalance, player.getCashBalance());
    }
}
