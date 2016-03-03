package pkg.monopoly;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CardActionTest {

    private Game game;
    private List<Space> board;
    private Go go;
    private CommunityChest communityChest;
    private Player player1;
    private RealEstate mediterranean;
    private RealEstate baltic;
    private Chance chance;

    @Before
    public void setUp() throws Exception {
        game = new Game("US");
        board = game.getBoard();
        go = (Go) board.get(0);
        communityChest = (CommunityChest) board.get(2);
        chance = (Chance) board.get(36);
        player1 = new Player("Cat");
        player1.setSpace(communityChest);
        mediterranean = (RealEstate) board.get(1);
        baltic = (RealEstate) board.get(3);
    }

    @After
    public void teardown() {
        game = null;
        board = null;
        go = null;
        communityChest = null;
        player1 = null;
        mediterranean = null;
        baltic = null;
    }

    @Test
    public void testCreation() {
        assertEquals("Community Chest", communityChest.getDescription());
        assertEquals("Chance", chance.getDescription());
    }

    @Test
    public void testLandOnDrawsMoveCard() throws GoToJail.GoToJailException {
        Card.clearCards();
        Card move = Card.create("CommunityChest", "Advance to Go (Collect $200)", "Move", "Go");
        createCards(move);
        assertTrue(player1.getSpace().equals(communityChest));
        int endingBalance = player1.getCashBalance() + 200;
        assertEquals(1, Card.getCommunityChestCards().size());
        communityChest.landOn(player1);
        assertTrue(player1.getSpace().equals(go));
        assertEquals(endingBalance, player1.getCashBalance());
        assertEquals(1, Card.getCommunityChestCards().size());
    }

    @Test
    public void testLandOnDrawsTransactionCardForBank() throws GoToJail.GoToJailException {
        Card.clearCards();
        Card transaction = Card.create("CommunityChest", "Bank error in your favor – Collect $200", "Transaction", 200, "Bank");
        createCards(transaction);
        assertTrue(player1.getSpace().equals(communityChest));
        int endingBalance = player1.getCashBalance() + 200;
        assertEquals(1, Card.getCommunityChestCards().size());
        communityChest.landOn(player1);
        assertTrue(player1.getSpace().equals(communityChest));
        assertEquals(endingBalance, player1.getCashBalance());
        assertEquals(1, Card.getCommunityChestCards().size());
    }

    @Test
    public void testLandOnDrawsGetOutOfJailCard() throws GoToJail.GoToJailException {
        Card.clearCards();
        Card getOutOfJail = Card.create("CommunityChest", "Get out of Jail Free – This card may be kept until needed or sold", "Keep");
        createCards(getOutOfJail);
        assertTrue(player1.getSpace().equals(communityChest));
        int endingBalance = player1.getCashBalance();
        assertEquals(1, Card.getCommunityChestCards().size());
        communityChest.landOn(player1);
        assertTrue(player1.getSpace().equals(communityChest));
        assertEquals(endingBalance, player1.getCashBalance());
        assertEquals(0, Card.getCommunityChestCards().size());
        assertTrue(getOutOfJail.equals(player1.getCard()));
    }

    @Test
    public void testLandOnDrawsRepairsCard() throws GoToJail.GoToJailException {
        Card.clearCards();
        Card repairs = Card.create("CommunityChest", "You are assessed for street repairs – $40 per house – $115 per hotel", "Repairs", 40, 115);
        createCards(repairs);
        assertEquals(1, Card.getCommunityChestCards().size());

        int endingBalance = player1.getCashBalance() - ((40 * 4) + 115);
        assertTrue(player1.getSpace().equals(communityChest));
        mediterranean.setOwner(player1);
        baltic.setOwner(player1);
        addFourHouses(mediterranean);
        addHotel(baltic);
        communityChest.landOn(player1);
        assertTrue(player1.getSpace().equals(communityChest));
        assertEquals(endingBalance, player1.getCashBalance());
        assertEquals(1, Card.getCommunityChestCards().size());
    }

    private void addHotel(RealEstate realEstate) {
        realEstate.addImprovements();
        realEstate.addImprovements();
        realEstate.addImprovements();
        realEstate.addImprovements();
        realEstate.addImprovements();
    }

    private void addFourHouses(RealEstate realEstate) {
        realEstate.addImprovements();
        realEstate.addImprovements();
        realEstate.addImprovements();
        realEstate.addImprovements();
    }

    @Test (expected = GoToJail.GoToJailException.class)
    public void testLandOnDrawsGotToJailCard() throws GoToJail.GoToJailException {
        Card.clearCards();
        Card goToJail = Card.create("CommunityChest", "Go to Jail – Go directly to jail – Do not pass Go – Do not collect $200", "Move", "GoToJail");
        createCards(goToJail);
        assertEquals(1, Card.getCommunityChestCards().size());
        assertTrue(player1.getSpace().equals(communityChest));
        communityChest.landOn(player1);
    }

    @Test
    public void testLandOnDrawsTransactionCardForPlayers() throws GoToJail.GoToJailException {
        Player player2 = new Player("Dog");
        Player player3 = new Player("Ship");

        player1.setNextPlayer(player2);
        player2.setNextPlayer(player3);
        player3.setNextPlayer(player1);

        game.addPlayer(player1);
        game.addPlayer(player2);
        game.addPlayer(player3);

        Card.clearCards();
        Card transaction = Card.create("CommunityChest", "Grand Opera Night – Collect $50 from every player for opening night seats", "Transaction", 50, "Players");
        createCards(transaction);

        assertTrue(player1.getSpace().equals(communityChest));
        int player1EndingBalance = player1.getCashBalance() + 100;
        int player2EndingBalance = player2.getCashBalance() - 50;
        int player3EndingBalance = player3.getCashBalance() - 50;
        assertEquals(1, Card.getCommunityChestCards().size());

        communityChest.landOn(player1);
        assertTrue(player1.getSpace().equals(communityChest));
        assertEquals(player1EndingBalance, player1.getCashBalance());
        assertEquals(player2EndingBalance, player2.getCashBalance());
        assertEquals(player3EndingBalance, player3.getCashBalance());
        assertEquals(1, Card.getCommunityChestCards().size());
    }

    private void createCards(Card move) {
        List<Card> cards = new ArrayList<Card>();
        cards.add(move);
        Card.addCommunityChestCards(cards);
    }
}
