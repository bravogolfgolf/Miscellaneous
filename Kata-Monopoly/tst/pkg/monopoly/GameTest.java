package pkg.monopoly;

import org.junit.Before;
import org.junit.Test;

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
    public void testGameOfTwentyRounds() {
    }
}
