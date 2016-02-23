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
    private Game gameMock;
    private Game game;
    private Space start;
    private Space space1;
    private Space space2;

    @Before
    public void setUp() throws IOException {
        gameMock = new GameMockPlay20Rounds("Spaces_TEST.txt");
        game = new Game("Spaces_US.txt");
        start = Space.create("Other", "Start");
        space1 = Space.create("Other", "Space1");
        space2 = Space.create("Other", "Space2");
        start.setNextSpace(space1);
        space1.setNextSpace(space2);
        space2.setNextSpace(start);
    }

    @After
    public void tearDown() {
        gameMock = null;
        game = null;
        start = null;
        space1 = null;
        space2 = null;
    }

    private void addThisManyPlayers(int number) {
        for (int i = 0; i < number; i++) {
            Player player = new Player();
            player.setSpace(start);
            gameMock.addPlayer(player);
        }
    }

    @Test(expected = Game.InvalidPlayerCount.class)
    public void testGameThrowsExceptionWhenFewerThanTwoPlayers() throws Game.InvalidPlayerCount {
        addThisManyPlayers(1);
        gameMock.start();
    }

    @Test
    public void testGameWithTwoPlayers() throws Game.InvalidPlayerCount, IOException {
        Game game = new Game("Spaces_US.txt");
        for (int i = 0; i < 2; i++) {
            Player player = new Player();
            player.setSpace(game.getBoard().get(0));
            game.addPlayer(player);
        }
        game.start();
        assertEquals(EXPECTED_NUMBER_OF_PLAYERS, game.getNumberOfPlayers());
    }

    @Test(expected = Game.InvalidPlayerCount.class)
    public void testGameThrowsExceptionWhenMoreThanEightPlayers() throws Game.InvalidPlayerCount {
        addThisManyPlayers(9);
        gameMock.start();
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
    public void testGameOfTwentyRoundsCountTurnsTaken() throws Game.InvalidPlayerCount, IOException {
        for (int i = 0; i < 2; i++) {
            PlayerMockTurnCounter player = new PlayerMockTurnCounter();
            gameMock.addPlayer(player);

        }
        gameMock.start();
        PlayerMockTurnCounter player1 = (PlayerMockTurnCounter) gameMock.getPlayer(0);
        PlayerMockTurnCounter player2 = (PlayerMockTurnCounter) gameMock.getPlayer(1);
        assertEquals(20, player1.turnsTaken);
        assertEquals(20, player2.turnsTaken);
    }

    @Test
    public void testGameOfTwentyRoundsCountManageProperties() throws Game.InvalidPlayerCount, IOException {
        DiceMock dice = new DiceMock();
        for (int i = 0; i < 2; i++) {
            PlayerMockManagePropertiesCounter player = new PlayerMockManagePropertiesCounter();
            gameMock.addPlayer(player);
            player.setSpace(start);
        }
        gameMock.setDice(dice);
        gameMock.start();
        PlayerMockManagePropertiesCounter player1 = (PlayerMockManagePropertiesCounter) gameMock.getPlayer(0);
        PlayerMockManagePropertiesCounter player2 = (PlayerMockManagePropertiesCounter) gameMock.getPlayer(1);
        assertEquals(40, player1.manageProperties);
        assertEquals(40, player2.manageProperties);
    }

    @Test
    public void testGameCountManagePropertiesWithDoublesRolled() throws Game.InvalidPlayerCount, IOException {
        DiceMockRollsDouble3sThenPlain4 dice = new DiceMockRollsDouble3sThenPlain4();
        for (int i = 0; i < 2; i++) {
            PlayerMockManagePropertiesCounter player = new PlayerMockManagePropertiesCounter();
            game.addPlayer(player);
            player.setSpace(start);
        }
        game.setDice(dice);
        game.start();
        PlayerMockManagePropertiesCounter player1 = (PlayerMockManagePropertiesCounter) game.getPlayer(0);
        PlayerMockManagePropertiesCounter player2 = (PlayerMockManagePropertiesCounter) game.getPlayer(1);
        assertEquals(3, player1.manageProperties);
        assertEquals(2, player2.manageProperties);
    }

    @Test
    public void testGameCountManagePropertiesWithDoublesRolledTwice() throws Game.InvalidPlayerCount, IOException {
        DiceMockRollsDoubleTwiceThenNot dice = new DiceMockRollsDoubleTwiceThenNot();
        for (int i = 0; i < 2; i++) {
            PlayerMockManagePropertiesCounter player = new PlayerMockManagePropertiesCounter();
            game.addPlayer(player);
            player.setSpace(game.getBoard().get(0));
        }
        game.setDice(dice);
        game.start();
        PlayerMockManagePropertiesCounter player1 = (PlayerMockManagePropertiesCounter) game.getPlayer(0);
        PlayerMockManagePropertiesCounter player2 = (PlayerMockManagePropertiesCounter) game.getPlayer(1);
        assertEquals(4, player1.manageProperties);
        assertEquals(2, player2.manageProperties);
    }

    @Test
    public void testGameCountManagePropertiesWithDoublesRolledThreeTimes() throws Game.InvalidPlayerCount, IOException {
        DiceMockRollsDoubleThreeTimesInARow dice = new DiceMockRollsDoubleThreeTimesInARow();
        for (int i = 0; i < 2; i++) {
            PlayerMockManagePropertiesCounter player = new PlayerMockManagePropertiesCounter();
            game.addPlayer(player);
            player.setSpace(game.getBoard().get(0));
        }
        game.setDice(dice);
        game.start();
        PlayerMockManagePropertiesCounter player1 = (PlayerMockManagePropertiesCounter) game.getPlayer(0);
        PlayerMockManagePropertiesCounter player2 = (PlayerMockManagePropertiesCounter) game.getPlayer(1);
        assertEquals(4, player1.manageProperties);
        assertEquals(2, player2.manageProperties);
    }

    @Test
    public void testPlayersAlternateOrder() throws Game.InvalidPlayerCount, IOException {
        PlayerMockAlternateOrder player1 = new PlayerMockAlternateOrder();
        PlayerMockAlternateOrder player2 = new PlayerMockAlternateOrder();
        gameMock.addPlayer(player1);
        gameMock.addPlayer(player2);
        gameMock.start();
        for (int i = 0; i < 20; i++) {
            if (i % 2 == 0)
                assertTrue(gameMock.getPlayer(0).equals(PlayerMockAlternateOrder.order.get(i)));
            else
                assertTrue(gameMock.getPlayer(1).equals(PlayerMockAlternateOrder.order.get(i)));
        }
    }

    @Test
    public void testCreateBoard() throws IOException {
        List<Space> expected = createExpected();
        List<Space> actual = gameMock.getBoard();
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
        Space first = Space.create("Other", "Description");
        Space second = Space.create("Property", "Description", "Group");
        first.setNextSpace(second);
        second.setNextSpace(first);
        expected.add(first);
        expected.add(second);
        return expected;
    }

    @Test
    public void testCreateActualBoard() throws IOException {
        int goCount = 0;
        int propertyCount = 0;
        int otherCount = 0;
        int jailCount = 0;
        int goToJailCount = 0;
        int incomeTaxCount = 0;
        int luxuryTaxCount = 0;
        List<Space> board = game.getBoard();
        assertTrue(board.size() == 40);
        for (Space space : board) {
            String classType = space.getClass().getSimpleName();
            if (classType.equals("Go")) goCount++;
            if (classType.equals("Property")) propertyCount++;
            if (classType.equals("Other")) otherCount++;
            if (classType.equals("Jail")) jailCount++;
            if (classType.equals("GoToJail")) goToJailCount++;
            if (classType.equals("IncomeTax")) incomeTaxCount++;
            if (classType.equals("LuxuryTax")) luxuryTaxCount++;
        }
        assertEquals(1, goCount);
        assertEquals(28, propertyCount);
        assertEquals(7, otherCount);
        assertEquals(1, jailCount);
        assertEquals(1, goToJailCount);
        assertEquals(1, incomeTaxCount);
        assertEquals(1, luxuryTaxCount);
    }

}
