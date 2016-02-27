package pkg.monopoly;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class GameTest {

    static final int EXPECTED_NUMBER_OF_PLAYERS = 2;
    private Game gameMock;
    private Game game;
    private Space start;
    private Space space1;
    private Space space2;
    private Go go;
    private Jail jail;
    private Utility electric;


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
        go = (Go) game.getBoard().get(0);
        jail = (Jail) game.getBoard().get(10);
        electric = (Utility) game.getBoard().get(12);
    }

    @After
    public void tearDown() {
        gameMock = null;
        game = null;
        start = null;
        space1 = null;
        space2 = null;
        go = null;
        jail = null;
        electric = null;
    }

    private void addThisManyPlayers(int number) {
        for (int i = 0; i < number; i++) {
            Player player = new Player("Cat");
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
            Player player = new Player("Cat");
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
            Player catPlayer = new Player("Cat");
            Player dogPlayer = new Player("Dog");
            game.addPlayer(catPlayer);
            game.addPlayer(dogPlayer);
            game.randomizePlayerOrder();
            assertEquals(EXPECTED_NUMBER_OF_PLAYERS, game.getNumberOfPlayers());

            if (game.getPlayer(0).equals(catPlayer) && game.getPlayer(1).equals(dogPlayer))
                catBoot = true;

            if (game.getPlayer(0).equals(dogPlayer) && game.getPlayer(1).equals(catPlayer))
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
    public void testGameOfTwentyRoundsCountManageProperties() throws Game.InvalidPlayerCount, IOException {
        DiceMock dice = new DiceMock();
        setUpPlayerMockManagePropertiesCounter(gameMock, dice, start);
        checkPropertiesManageCounts(gameMock, 40, 40);
    }

    private void setUpPlayerMockManagePropertiesCounter(Game game, Dice dice, Space startingSpace) throws Game.InvalidPlayerCount {
        for (int i = 0; i < 2; i++) {
            PlayerMockManagePropertiesCounter player = new PlayerMockManagePropertiesCounter();
            game.addPlayer(player);
            player.setSpace(startingSpace);
        }
        game.setDice(dice);
        game.start();
    }

    private void checkPropertiesManageCounts(Game game, int player1Expected, int player2Expected) {
        PlayerMockManagePropertiesCounter player1 = (PlayerMockManagePropertiesCounter) game.getPlayer(0);
        PlayerMockManagePropertiesCounter player2 = (PlayerMockManagePropertiesCounter) game.getPlayer(1);
        assertEquals(player1Expected, player1.manageProperties);
        assertEquals(player2Expected, player2.manageProperties);
    }

    @Test
    public void testGameCountManagePropertiesWithDoublesRolled() throws Game.InvalidPlayerCount, IOException {
        DiceMockRollsDouble3sThenPlain4 dice = new DiceMockRollsDouble3sThenPlain4();
        setUpPlayerMockManagePropertiesCounter(game, dice, go);
        checkPropertiesManageCounts(game, 3, 2);
    }

    @Test
    public void testGameCountManagePropertiesWithDoublesRolledTwice() throws Game.InvalidPlayerCount, IOException {
        DiceMockRollsDoubleTwiceThenNot dice = new DiceMockRollsDoubleTwiceThenNot();
        setUpPlayerMockManagePropertiesCounter(game, dice, go);
        checkPropertiesManageCounts(game, 4, 2);
    }

    @Test
    public void testGameCountManagePropertiesWithDoublesRolledThreeTimes() throws Game.InvalidPlayerCount, IOException {
        DiceMockRollsDoubleThreeTimesInARow dice = new DiceMockRollsDoubleThreeTimesInARow();
        setUpPlayerMockManagePropertiesCounter(game, dice, go);
        checkPropertiesManageCounts(game, 3, 2);
    }

    @Test
    public void testGameCountManagePropertiesThreeRollsNoDoublesPay50() throws Game.InvalidPlayerCount {
        DiceMock dice = new DiceMock();
        PlayerMockManagePropertiesCounter player = new PlayerMockManagePropertiesCounter();
        int endingBalance = player.getCashBalance();
        player.setInJail(true);
        game.addPlayer(player);
        player.setSpace(jail);

        game.setDice(dice);
        game.play(dice);
        assertEquals(2, player.manageProperties);
        assertEquals(1, player.getNumberOfRolls());
        assertTrue(jail.equals(player.getSpace()));
        assertEquals(endingBalance, player.getCashBalance());
        assertTrue(player.isInJail());

        game.play(dice);
        assertEquals(4, player.manageProperties);
        assertEquals(2, player.getNumberOfRolls());
        assertTrue(jail.equals(player.getSpace()));
        assertEquals(endingBalance, player.getCashBalance());
        assertTrue(player.isInJail());

        endingBalance = endingBalance - 50;
        assertTrue(electric.getOwner().isBank());
        endingBalance = endingBalance - 150;

        game.play(dice);
        assertEquals(6, player.manageProperties);
        assertEquals(0, player.getNumberOfRolls());
        assertTrue(electric.equals(player.getSpace()));
        assertTrue(player.equals(electric.getOwner()));
        assertEquals(endingBalance, player.getCashBalance());
        assertFalse(player.isInJail());
    }

    @Test
    public void testGameCountManagePropertiesRollDoubleMoveNoNextTurn() throws Game.InvalidPlayerCount {
        DiceMockRollsDoubleThreeTimesInARow dice = new DiceMockRollsDoubleThreeTimesInARow();
        PlayerMockManagePropertiesCounter player1 = new PlayerMockManagePropertiesCounter();
        PlayerMockManagePropertiesCounter player2 = new PlayerMockManagePropertiesCounter();
        int player1endingBalance = player1.getCashBalance();
        int player2endingBalance = player2.getCashBalance();
        game.addPlayer(player1);
        game.addPlayer(player2);
        player1.setSpace(jail);
        player1.setInJail(true);
        player2.setSpace(go);

        RealEstate virginiaAvenue = (RealEstate) game.getBoard().get(14);
        assertTrue(virginiaAvenue.getOwner().isBank());
        player1endingBalance = player1endingBalance - 160;

        RealEstate stJamesPlace = (RealEstate) game.getBoard().get(16);
        assertTrue(stJamesPlace.getOwner().isBank());
        player2endingBalance = player2endingBalance - 180;

        RealEstate marvinGardens = (RealEstate) game.getBoard().get(29);
        assertTrue(marvinGardens.getOwner().isBank());
        player2endingBalance = player2endingBalance - 280;

        game.setDice(dice);
        game.start();

        checkPropertiesManageCounts(game, 2, 4);
        assertTrue(virginiaAvenue.equals(player1.getSpace()));
        assertTrue(player1.equals(virginiaAvenue.getOwner()));
        assertEquals(player1endingBalance, player1.getCashBalance());
        assertEquals(0,player1.getNumberOfRolls());
        assertFalse(player1.isInJail());

        assertTrue(marvinGardens.equals(player2.getSpace()));
        assertTrue(player2.equals(stJamesPlace.getOwner()));
        assertTrue(player2.equals(marvinGardens.getOwner()));
        assertEquals(player2endingBalance, player2.getCashBalance());
        assertEquals(0,player2.getNumberOfRolls());
        assertFalse(player2.isInJail());
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
        Space second = Space.create("RealEstate", "Description", "Group", 78, 3);
        first.setNextSpace(second);
        second.setNextSpace(first);
        expected.add(first);
        expected.add(second);
        return expected;
    }

    @Test
    public void testCreateActualBoard() throws IOException {
        int goCount = 0;
        int otherCount = 0;
        int jailCount = 0;
        int goToJailCount = 0;
        int incomeTaxCount = 0;
        int luxuryTaxCount = 0;
        int realEstateCount = 0;
        int brownGroupCount = 0;
        int lightBlueGroupCount = 0;
        int purpleGroupCount = 0;
        int orangeGroupCount = 0;
        int redGroupCount = 0;
        int yellowGroupCount = 0;
        int greenGroupCount = 0;
        int blueGroupCount = 0;
        int railroadCount = 0;
        int utilityCount = 0;
        List<Space> board = game.getBoard();
        assertTrue(board.size() == 40);
        for (Space space : board) {
            String classType = space.getClass().getSimpleName();
            if (classType.equals("Go")) goCount++;
            if (classType.equals("Other")) otherCount++;
            if (classType.equals("Jail")) jailCount++;
            if (classType.equals("GoToJail")) goToJailCount++;
            if (classType.equals("IncomeTax")) incomeTaxCount++;
            if (classType.equals("LuxuryTax")) luxuryTaxCount++;
            if (classType.equals("Railroad")) railroadCount++;
            if (classType.equals("Utility")) utilityCount++;
            if (classType.equals("RealEstate")) {
                realEstateCount++;
                String group = space.getGroup();
                if (group.equals("Brown")) brownGroupCount++;
                if (group.equals("Light Blue")) lightBlueGroupCount++;
                if (group.equals("Purple")) purpleGroupCount++;
                if (group.equals("Orange")) orangeGroupCount++;
                if (group.equals("Red")) redGroupCount++;
                if (group.equals("Yellow")) yellowGroupCount++;
                if (group.equals("Green")) greenGroupCount++;
                if (group.equals("Blue")) blueGroupCount++;
            }
        }
        assertEquals(1, goCount);
        assertEquals(7, otherCount);
        assertEquals(1, jailCount);
        assertEquals(1, goToJailCount);
        assertEquals(1, incomeTaxCount);
        assertEquals(1, luxuryTaxCount);
        assertEquals(4, railroadCount);
        assertEquals(2, utilityCount);

        assertEquals(22, realEstateCount);
        assertEquals(2, brownGroupCount);
        assertEquals(3, lightBlueGroupCount);
        assertEquals(3, purpleGroupCount);
        assertEquals(3, orangeGroupCount);
        assertEquals(3, redGroupCount);
        assertEquals(3, yellowGroupCount);
        assertEquals(3, greenGroupCount);
        assertEquals(2, blueGroupCount);

    }
}
