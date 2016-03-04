package pkg.monopoly;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MoveForwardSpecificTest {

    private Game game;
    private List<Space> board;
    private Player player;
    private Space communityChestSpace;
    private Space go;

    @Before
    public void setUp() throws Exception {
        game = new Game("US");
        board = game.getBoard();
        player = new Player("Cat");
        go = board.get(0);
        communityChestSpace = board.get(2);
    }

    @Test
    public void testCreation() {
        MoveForwardSpecific communityChestCard = (MoveForwardSpecific) Card.create("CommunityChest", "Advance to Go (Collect $200)", "MoveForwardSpecific", "Go");
        assertTrue(communityChestCard.getCardText().equals("Advance to Go (Collect $200)"));
        assertTrue(communityChestCard.getCardSpace().equals("Go"));
    }

    @Ignore
    public void testCardAction() throws IOException, GoToJail.GoToJailException {
        MoveForwardSpecific communityChestCard = (MoveForwardSpecific) Card.create("CommunityChest", "Advance to Go (Collect $200)", "MoveForwardSpecific", "Go");
        player.setSpace(communityChestSpace);
        int endingBalance = player.getCashBalance() + 200;
        assertTrue(player.getSpace().equals(communityChestSpace));
        communityChestCard.action(player);
        assertTrue(player.getSpace().equals(go));
        assertEquals(endingBalance,player.getCashBalance());

    }
}
