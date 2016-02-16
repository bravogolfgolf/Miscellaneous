package pkg.monopoly;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GameTest {

    static final int EXPECTED_NUMBER_OF_PLAYERS = 2;
    private Game game;

    @Before
    public void setUp() {
        game = new Game();
    }

    private void addThisManyPlayers(int number) {
        for (int i = 0; i < number; i++) {
            Token token = new Token("");
            Player player = new Player(token);
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
    public void testPlayersAreNotAlwaysInSameOrder() {

        boolean catBoot = false;
        boolean bootCat = false;

        for (int i = 0; i < 100; i++) {
            Game game = new Game();
            Token cat = new Token("Cat");
            Token boot = new Token("Boot");
            Player catPlayer = new Player(cat);
            Player bootPlayer = new Player(boot);
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

        class PlayerMockTurnCounter extends Player {

            public int turnsTaken = 0;

            public PlayerMockTurnCounter(Token token) {
                super(token);
            }

            @Override
            public void takeATurn(Dice die) {
                turnsTaken++;
            }

        }

        for (int i = 0; i < 2; i++) {
            Token token = new Token("");
            PlayerMockTurnCounter player = new PlayerMockTurnCounter(token);
            game.addPlayer(player);
        }
        game.play();
        PlayerMockTurnCounter player1 = (PlayerMockTurnCounter) game.getPlayer(0);
        PlayerMockTurnCounter player2 = (PlayerMockTurnCounter) game.getPlayer(1);
        assertEquals(20, player1.turnsTaken);
        assertEquals(20, player2.turnsTaken);
    }

    @Test
    public void testPlayersAlternateOrder() throws Game.InvalidPlayerCount {
        Token boot = new Token("Boot");
        Token cat = new Token("Cat");
        PlayerMockAlternateOrder player1 = new PlayerMockAlternateOrder(boot);
        PlayerMockAlternateOrder player2 = new PlayerMockAlternateOrder(cat);
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
    public void testPlayerWhoPassesGoGetsPaid200() {

        class GameMockPlayerPassesGo extends Game {

            public GameMockPlayerPassesGo() {
                super();
            }

            List<Player> players = new ArrayList<Player>();
            Dice dice = new Dice();
            Board board = new Board();

            public void addPlayer(Player player) {
                players.add(player);
            }

            @Override
            public void play() {
                for (Player player : players) {
                    player.takeATurn(dice);
                    if (playerPassedGo(player)) {
                        Space space = board.getSpace(GO);
                        space.action(player);
                    }

                }
            }

            private boolean playerPassedGo(Player player) {
                return player.getSalaryFlag();
            }

        }

        GameMockPlayerPassesGo gameMock = new GameMockPlayerPassesGo();
        Player player = new Player(new Token("Boot"));
        player.setTokenLocation(Board.LAST_LOCATION_ON_BOARD);
        gameMock.addPlayer(player);
        gameMock.play();
        assertEquals(1700, player.getCashBalance());
    }
}
