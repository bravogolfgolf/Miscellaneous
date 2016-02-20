package pkg.monopoly;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GameTest {

    static final int EXPECTED_NUMBER_OF_PLAYERS = 2;
    private Game game;
    private Space start;
    private Space space1;
    private Space space2;

    @Before
    public void setUp() throws IOException {
        game = new Game("Spaces_TEST.txt");
        start = Space.create("Other", "Start");
        space1 = Space.create("Other", "Space1");
        space2 = Space.create("Other", "Space2");
        start.setNextSpace(space1);
        space1.setNextSpace(space2);
        space2.setNextSpace(start);
    }

    @After
    public void tearDown() {
        game = null;
        start = null;
        space1 = null;
        space2 = null;
    }

    private void addThisManyPlayers(int number) {
        for (int i = 0; i < number; i++) {
            Player player = new Player();
            player.setSpace(start);
            game.addPlayer(player);
        }
    }

    @Test(expected = Game.InvalidPlayerCount.class)
    public void testGameThrowsExceptionWhenFewerThanTwoPlayers() throws Game.InvalidPlayerCount {
        addThisManyPlayers(1);
        game.play();
    }

    @Test
    public void testGameWithTwoPlayers() throws Game.InvalidPlayerCount {
        addThisManyPlayers(2);
        game.play();
        assertEquals(EXPECTED_NUMBER_OF_PLAYERS, game.getNumberOfPlayers());
    }

    @Test(expected = Game.InvalidPlayerCount.class)
    public void testGameThrowsExceptionWhenMoreThanEightPlayers() throws Game.InvalidPlayerCount {
        addThisManyPlayers(9);
        game.play();
    }

    @Test
    public void testPlayersAreNotAlwaysInSameOrder() throws IOException {

        boolean catBoot = false;
        boolean bootCat = false;

        for (int i = 0; i < 100; i++) {
            Game game = new Game("Spaces_TEST.txt");
            Player catPlayer = new Player();
            Player bootPlayer = new Player();
            game.addPlayer(catPlayer);
            game.addPlayer(bootPlayer);
            game.randomizePlayerOrder();
            assertEquals(EXPECTED_NUMBER_OF_PLAYERS, game.getNumberOfPlayers());

            if (game.getPlayer(0).equals(catPlayer) && game.getPlayer(1).equals(bootPlayer))
                catBoot = true;

            if (game.getPlayer(0).equals(bootPlayer) && game.getPlayer(1).equals(catPlayer))
                bootCat = true;

            if (catBoot && bootCat)
                break;
        }
        assertTrue(catBoot && bootCat);
    }

    @Test
    public void testGameOfTwentyRounds() throws Game.InvalidPlayerCount {
        for (int i = 0; i < 2; i++) {
            PlayerMockTurnCounter player = new PlayerMockTurnCounter();
            game.addPlayer(player);
        }
        game.play();
        PlayerMockTurnCounter player1 = (PlayerMockTurnCounter) game.getPlayer(0);
        PlayerMockTurnCounter player2 = (PlayerMockTurnCounter) game.getPlayer(1);
        assertEquals(20, player1.turnsTaken);
        assertEquals(20, player2.turnsTaken);
        assertEquals(40, player1.manageProperties);
        assertEquals(40, player2.manageProperties);
    }

    @Test
    public void testPlayersAlternateOrder() throws Game.InvalidPlayerCount {
        PlayerMockAlternateOrder player1 = new PlayerMockAlternateOrder();
        PlayerMockAlternateOrder player2 = new PlayerMockAlternateOrder();
        game.addPlayer(player1);
        game.addPlayer(player2);
        game.play();
        for (int i = 0; i < 20; i++) {
            if (i % 2 == 0)
                assertTrue(game.getPlayer(0).equals(PlayerMockAlternateOrder.order.get(i)));
            else
                assertTrue(game.getPlayer(1).equals(PlayerMockAlternateOrder.order.get(i)));
        }
    }

    @Test
    public void testCreateBoard() throws IOException {
        List<Space> expected = createExpected();
        List<Space> actual = game.getBoard();
        assertEquals(expected.size(), actual.size());
        for (int i = 0; i < expected.size(); i++) {
            assertEquals(expected.get(i).getClass(), actual.get(i).getClass());
            assertEquals(expected.get(i).getDescription(), actual.get(i).getDescription());
            assertEquals(expected.get(i).getNextSpace().getClass(),
                    actual.get(i).getNextSpace().getClass());
            assertEquals(expected.get(i).getNextSpace().getDescription(),
                    actual.get(i).getNextSpace().getDescription());
        }
    }

    private List<Space> createExpected() {
        List<Space> expected = new ArrayList<Space>();
        Space first = Space.create("Other", "SpaceReadTest");
        Space second = Space.create("Other", "SpaceReadTest1");
        first.setNextSpace(second);
        second.setNextSpace(first);
        expected.add(first);
        expected.add(second);
        return expected;
    }

}
