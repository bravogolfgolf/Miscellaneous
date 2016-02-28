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
    private Game game;
    private Game gameTest;
    private Go go;
    private Jail jail;
    private Utility electric;


    @Before
    public void setUp() throws IOException {
        game = new Game("US");
        gameTest = new Game("TEST");
        go = (Go) game.getBoard().get(0);
        jail = (Jail) game.getBoard().get(10);
        electric = (Utility) game.getBoard().get(12);
    }

    @After
    public void tearDown() {
        game = null;
        gameTest = null;
        go = null;
        jail = null;
        electric = null;
    }

    private void addThisManyPlayers(int number) {
        for (int i = 0; i < number; i++) {
            Player player = new Player("Cat");
            game.addPlayer(player);
        }
    }

    @Test(expected = Game.InvalidPlayerCount.class)
    public void testGameThrowsExceptionWhenFewerThanTwoPlayers() throws Game.InvalidPlayerCount {
        addThisManyPlayers(1);
        game.start();
    }

    @Test
    public void testGameWithTwoPlayers() throws Game.InvalidPlayerCount, IOException {
        Game game = new Game("US");
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
        game.start();
    }

    @Test
    public void testPlayersAreNotAlwaysInSameOrder() throws IOException {

        boolean catBoot = false;
        boolean bootCat = false;

        for (int i = 0; i < 100; i++) {
            Game gameTest = new Game("TEST");
            Player catPlayer = new Player("Cat");
            Player dogPlayer = new Player("Dog");
            gameTest.addPlayer(catPlayer);
            gameTest.addPlayer(dogPlayer);
            gameTest.randomizePlayerOrder();
            assertEquals(EXPECTED_NUMBER_OF_PLAYERS, gameTest.getNumberOfPlayers());

            if (gameTest.getPlayer(0).equals(catPlayer) && gameTest.getPlayer(1).equals(dogPlayer))
                catBoot = true;

            if (gameTest.getPlayer(0).equals(dogPlayer) && gameTest.getPlayer(1).equals(catPlayer))
                bootCat = true;

            if (catBoot && bootCat)
                break;
        }
        assertTrue(catBoot && bootCat);
    }

    @Test
    public void testGameOfTwentyRoundsCountTurnsTaken() throws Game.InvalidPlayerCount, IOException {
        Dice dice = new Dice();
        for (int i = 0; i < 2; i++) {
            PlayerMockTurnCounter player = new PlayerMockTurnCounter();
            game.addPlayer(player);

        }
        for (int i = 0; i < 20; i++)
            game.play(dice);
        PlayerMockTurnCounter player1 = (PlayerMockTurnCounter) game.getPlayer(0);
        PlayerMockTurnCounter player2 = (PlayerMockTurnCounter) game.getPlayer(1);
        assertEquals(20, player1.turnsTaken);
        assertEquals(20, player2.turnsTaken);
    }

    @Test
    public void testPlayersAlternateOrder() throws Game.InvalidPlayerCount, IOException {
        Dice dice = new Dice();
        PlayerMockAlternateOrder player1 = new PlayerMockAlternateOrder();
        PlayerMockAlternateOrder player2 = new PlayerMockAlternateOrder();
        game.addPlayer(player1);
        game.addPlayer(player2);

        for (int i = 0; i < 20; i++)
            game.play(dice);

        for (int i = 0; i < 20; i++) {
            if (i % 2 == 0)
                assertTrue(player1.equals(PlayerMockAlternateOrder.order.get(i)));
            else
                assertTrue(player2.equals(PlayerMockAlternateOrder.order.get(i)));
        }
    }

    @Test
    public void testGameOfTenRoundsCountManageProperties() throws Game.InvalidPlayerCount, IOException {
        DiceMock dice = new DiceMock();
        setUpPlayerMockManagePropertiesCounter(game, go);
        for (int i = 0; i < 10; i++)
            game.play(dice);
        checkPropertiesManageCounts(game, 20, 20);
    }

    private void setUpPlayerMockManagePropertiesCounter(Game game, Space startingSpace) throws Game.InvalidPlayerCount {
        for (int i = 0; i < 2; i++) {
            PlayerMockManagePropertiesCounter player = new PlayerMockManagePropertiesCounter();
            game.addPlayer(player);
            player.setSpace(startingSpace);
        }
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
        setUpPlayerMockManagePropertiesCounter(game, go);
        game.play(dice);
        checkPropertiesManageCounts(game, 3, 2);
    }

    @Test
    public void testGameCountManagePropertiesWithDoublesRolledTwice() throws Game.InvalidPlayerCount, IOException {
        DiceMockRollsDoubleTwiceThenNot dice = new DiceMockRollsDoubleTwiceThenNot();
        setUpPlayerMockManagePropertiesCounter(game, go);
        game.play(dice);
        checkPropertiesManageCounts(game, 4, 2);
    }

    @Test
    public void testGameCountManagePropertiesWithDoublesRolledThreeTimes() throws Game.InvalidPlayerCount, IOException {
        DiceMockRollsDoubleThreeTimesInARow dice = new DiceMockRollsDoubleThreeTimesInARow();
        setUpPlayerMockManagePropertiesCounter(game, go);
        game.play(dice);
        checkPropertiesManageCounts(game, 3, 2);
    }

    @Test
    public void testInJailThreeRollsNoDoublesPays50() throws Game.InvalidPlayerCount {
        DiceMock dice = new DiceMock();
        PlayerMockManagePropertiesCounter player = new PlayerMockManagePropertiesCounter();
        player.setInJail(true);
        game.addPlayer(player);
        player.setSpace(jail);

        game.play(dice);
        assertEquals(2, player.manageProperties);
        assertEquals(1, player.getNumberOfRolls());
        assertTrue(jail.equals(player.getSpace()));
        assertTrue(player.isInJail());

        game.play(dice);
        assertEquals(4, player.manageProperties);
        assertEquals(2, player.getNumberOfRolls());
        assertTrue(jail.equals(player.getSpace()));
        assertTrue(player.isInJail());

        game.play(dice);
        assertEquals(6, player.manageProperties);
        assertEquals(0, player.getNumberOfRolls());
        assertTrue(electric.equals(player.getSpace()));
        assertFalse(player.isInJail());
    }

    @Test
    public void testInJailRollsDoubleMovesNoNextTurn() throws Game.InvalidPlayerCount {
        DiceMockRollsDoubleThreeTimesInARow dice = new DiceMockRollsDoubleThreeTimesInARow();
        setUpPlayerMockManagePropertiesCounter(game, go);

        PlayerMockManagePropertiesCounter player1 = (PlayerMockManagePropertiesCounter) game.getPlayer(0);
        PlayerMockManagePropertiesCounter player2 = (PlayerMockManagePropertiesCounter) game.getPlayer(1);
        player1.setSpace(jail);
        player1.setInJail(true);

        RealEstate virginiaAvenue = (RealEstate) game.getBoard().get(14);
        RealEstate marvinGardens = (RealEstate) game.getBoard().get(29);

        game.play(dice);

        checkPropertiesManageCounts(game, 2, 4);
        assertTrue(virginiaAvenue.equals(player1.getSpace()));
        assertEquals(0, player1.getNumberOfRolls());
        assertFalse(player1.isInJail());

        assertTrue(marvinGardens.equals(player2.getSpace()));
        assertEquals(0, player2.getNumberOfRolls());
        assertFalse(player2.isInJail());
    }

    @Test
    public void testInJailPays50RollsDoubleMovesAndNextTurn() throws Game.InvalidPlayerCount {
        DiceMockRollsDouble3sThenPlain4 dice = new DiceMockRollsDouble3sThenPlain4();
        setUpPlayerMockManagePropertiesCounter(game, go);
        PlayerMockManagePropertiesCounter player = (PlayerMockManagePropertiesCounter) game.getPlayer(0);
        player.setSpace(jail);
        player.setInJail(true);
        player.postBail();

        Other freeParking = (Other) game.getBoard().get(20);

        game.play(dice);
        assertEquals(3, player.manageProperties);
        assertTrue(freeParking.equals(player.getSpace()));
        assertEquals(0, player.getNumberOfRolls());
    }

    @Test
    public void testInJailRollsDoubleOnThirdRollMovesNoNextTurn() throws Game.InvalidPlayerCount {
        DiceMock dice = new DiceMock();
        setUpPlayerMockManagePropertiesCounter(game, go);
        PlayerMockManagePropertiesCounter player = (PlayerMockManagePropertiesCounter) game.getPlayer(0);
        player.setSpace(jail);
        player.setInJail(true);

        game.play(dice);

        assertEquals(2, player.manageProperties);
        assertEquals(1, player.getNumberOfRolls());
        assertTrue(jail.equals(player.getSpace()));
        assertTrue(player.isInJail());

        game.play(dice);

        assertEquals(4, player.manageProperties);
        assertEquals(2, player.getNumberOfRolls());
        assertTrue(jail.equals(player.getSpace()));
        assertTrue(player.isInJail());

        DiceMockRollsDouble3sThenPlain4 newDice = new DiceMockRollsDouble3sThenPlain4();
        RealEstate stJamesPlace = (RealEstate) game.getBoard().get(16);
        game.play(newDice);

        assertEquals(6, player.manageProperties);
        assertEquals(0, player.getNumberOfRolls());
        assertTrue(stJamesPlace.equals(player.getSpace()));
        assertFalse(player.isInJail());
    }

    @Test
    public void testCardsAreNotAlwaysInSameOrder() throws IOException {

        boolean oneTwo = false;
        boolean twoOne = false;

        for (int i = 0; i < 100; i++) {
            Game gameTest = new Game("TWO");
            Card card1 = Card.create("CommunityChest","Instruction1","Move","Go");
            Card card2 = Card.create("CommunityChest","Instruction2","Transaction",100,"Bank");
            gameTest.randomizeCardOrder();
            assertEquals(2, gameTest.getNumberOfChests());

            if (gameTest.getChest(0).equals(card1) && gameTest.getChest(1).equals(card2))
                oneTwo = true;

            if (gameTest.getChest(0).equals(card2) && gameTest.getChest(1).equals(card1))
                twoOne = true;

            if (oneTwo && twoOne)
                break;
        }
        assertTrue(oneTwo && twoOne);
    }

    @Test
    public void testCreateBoard() throws IOException {
        List<Space> expected = createExpected();
        List<Space> actual = gameTest.getBoard();
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
