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
    public void teardown(){
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
        Card move = Card.create("CommunityChest","Advance to Go (Collect $200)","Move","Go");
        createCards(move);
        assertTrue(player.getSpace().equals(communityChest));
        int endingBalance = player.getCashBalance() + 200;
        communityChest.landOn(player);
        assertTrue(player.getSpace().equals(go));
        assertEquals(endingBalance,player.getCashBalance());
    }

    private void createCards(Card move) {
        List<Card> cards = new ArrayList<Card>();
        cards.add(move);
        Card.addCommunityChestCards(cards);
    }
}
