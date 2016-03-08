package pkg.monopoly;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CommunityChestTest {

    private Player player;
    private CommunityChest communityChest;

    @Before
    public void setUp() {
        player = new Player("Cat");
        communityChest = (CommunityChest) Space.create("CommunityChest", "Community Chest");
    }

    @After
    public void teardown() {
        player = null;
        communityChest = null;
    }

    @Test
    public void testLandOn()  {
        List<Card> cards = new ArrayList<Card>();
        Card.clearCards();
        Card card = Card.create("Instruction", "GetOutOfJail");
        cards.add(card);
        Card.addCommunityChestCards(cards);
        int expectedEndingBalance = player.getCashBalance();
        communityChest.landOn(player, new SourceOfMoveMultiplier(), new OwnershipMultiplier());
        assertEquals(expectedEndingBalance, player.getCashBalance());
        assertTrue(player.getCard().equals(card));
    }

    @Test
    public void testPassBy() {
        List<Card> cards = new ArrayList<Card>();
        Card.clearCards();
        Card card = Card.create("Instruction", "GetOutOfJail");
        cards.add(card);
        Card.addCommunityChestCards(cards);
        int expectedEndingBalance = player.getCashBalance();
        communityChest.passBy(player);
        assertEquals(expectedEndingBalance, player.getCashBalance());
    }
}
