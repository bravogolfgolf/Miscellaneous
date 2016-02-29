package pkg.monopoly;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CommunityChestTest {

    private Game game;
    private List<Space> board;
    private Go go;
    private CommunityChest communityChest;
    private Player player;

    @Before
    public void setUp() throws Exception {
        game = new Game("US");
        board = game.getBoard();
        go = (Go) board.get(0);
        communityChest = (CommunityChest) board.get(2);
        player = new Player("Cat");
        player.setSpace(communityChest);
    }

    @After
    public void teardown() {
        game = null;
        board = null;
        go = null;
        communityChest = null;
        player = null;

    }

    @Test
    public void testCreation() {
        assertEquals("Community Chest", communityChest.getDescription());
    }

    @Test
    public void testLandOnDrawsMoveCard() throws GoToJail.GoToJailException {
        Card.clearCards();
        Card move = Card.create("CommunityChest", "Advance to Go (Collect $200)", "Move", "Go");
        createCards(move);
        assertTrue(player.getSpace().equals(communityChest));
        int endingBalance = player.getCashBalance() + 200;
        assertEquals(1, Card.getCommunityChestCards().size());
        communityChest.landOn(player);
        assertTrue(player.getSpace().equals(go));
        assertEquals(endingBalance, player.getCashBalance());
        assertEquals(1, Card.getCommunityChestCards().size());
    }

    @Test
    public void testLandOnDrawsTransactionCardForBank() throws GoToJail.GoToJailException {
        Card.clearCards();
        Card transaction = Card.create("CommunityChest", "Bank error in your favor – Collect $200", "Transaction", 200, "Bank");
        createCards(transaction);
        assertTrue(player.getSpace().equals(communityChest));
        int endingBalance = player.getCashBalance() + 200;
        assertEquals(1, Card.getCommunityChestCards().size());
        communityChest.landOn(player);
        assertTrue(player.getSpace().equals(communityChest));
        assertEquals(endingBalance, player.getCashBalance());
        assertEquals(1, Card.getCommunityChestCards().size());
    }

    @Test
    public void testLandOnDrawsGetOutOfJailCard() throws GoToJail.GoToJailException {
        Card.clearCards();
        Card getOutOfJail = Card.create("CommunityChest", "Get out of Jail Free – This card may be kept until needed or sold", "Keep");
        createCards(getOutOfJail);
        assertTrue(player.getSpace().equals(communityChest));
        int endingBalance = player.getCashBalance();
        assertEquals(1, Card.getCommunityChestCards().size());
        communityChest.landOn(player);
        assertTrue(player.getSpace().equals(communityChest));
        assertEquals(endingBalance, player.getCashBalance());
        assertEquals(0, Card.getCommunityChestCards().size());
        assertTrue(getOutOfJail.equals(player.getCard()));
    }

    @Test
    public void testLandOnDrawsRepairsCard() throws GoToJail.GoToJailException {
        assertTrue(false);
        //TODO Start here in the moring
        // need to add building improvements to properties first
        Card.clearCards();
        Card repairs = Card.create("CommunityChest", "You are assessed for street repairs – $40 per house – $115 per hotel", "Repairs", 40, 115);
        createCards(repairs);
        assertTrue(player.getSpace().equals(communityChest));
        int endingBalance = player.getCashBalance();
        assertEquals(1, Card.getCommunityChestCards().size());
        communityChest.landOn(player);
        assertTrue(player.getSpace().equals(communityChest));
        assertEquals(endingBalance, player.getCashBalance());
        assertEquals(1, Card.getCommunityChestCards().size());
    }

    private void createCards(Card move) {
        List<Card> cards = new ArrayList<Card>();
        cards.add(move);
        Card.addCommunityChestCards(cards);
    }
}
